package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.Comment;
import org.bean.Topic;
import org.bean.User;
import org.service.CommentService;
import org.service.TopicService;
import org.service.UserService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tool.UserContext;

public class ShowTopic extends HttpServlet {
	private TopicService tpservice;
	private CommentService comservice;
	private UserService uservice;
	public void setTpservice(TopicService tpservice) {
		this.tpservice = tpservice;
	}
	public void setComservice(CommentService comservice) {
		this.comservice = comservice;
	}
	public void setUservice(UserService uservice) {
		this.uservice = uservice;
	}
	public ShowTopic() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = UserContext.getCurrentUser();
		if (user != null) {
			request.setAttribute("name", user.getUsername());
			if (user.getPicture() != null)
				request.setAttribute("pichead", user.getPicture());
			else
				request.setAttribute("pichead", "user-head.jpg");
			UserContext.destroy();
		}
		int topicid=Integer.parseInt(request.getParameter("topicid"));
		Topic tp=tpservice.getTopic(topicid);
		user=uservice.isUser(tp.getTopicsUserId());
		if(user!=null){
			request.setAttribute("Uid",request.getParameter("topicid"));
			request.setAttribute("Uname", user.getUsername());
			request.setAttribute("Upicture",(user.getPicture()!=null)
					?user.getPicture():"user-head.jpg");
			request.setAttribute("TpTitle", tp.getTitle());
			request.setAttribute("TpContent",tp.getContent());
			request.setAttribute("Utime", tp.getTopicTime().toString());
		}
		Map<Integer,ArrayList<String>> cmap=new TreeMap<Integer,ArrayList<String>>();
		Set<Comment> coms=tp.getComments();
		if(coms!=null){
			Iterator<Comment> it = coms.iterator();
			while(it.hasNext()){
				Comment com=it.next();
				User cuser=uservice.isUser(com.getCommentsUserId());
				if(cuser!=null){
					String name=cuser.getUsername();
					String picture=cuser.getPicture();
					String content=com.getContent();
					String ctime=com.getCommentTime().toString();
					ArrayList<String> temp=new ArrayList<String>();
					temp.add(name);temp.add((picture!=null)?picture:"user-head.jpg");
					temp.add(content);temp.add(ctime);
					cmap.put(com.getFloor(),temp);
				}
			}
			request.setAttribute("Ucomment", cmap);
		}
		request.getRequestDispatcher("/ShowTopic.jsp").forward(request, response);
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		// Put your code here
		ServletContext servletContext = servletConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.configureBean(this, "ShowTopic");
	}

}
