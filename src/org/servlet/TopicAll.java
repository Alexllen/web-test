package org.servlet;

import java.io.IOException;
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

import org.service.TypeService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tool.UserContext;
import org.bean.*;

public class TopicAll extends HttpServlet {
	int typeid=0;
	private static final long serialVersionUID = 1L;
	private TypeService tpservice;
	public void setTpservice(TypeService tpservice) {
		this.tpservice = tpservice;
	}
	public TopicAll() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		typeid=Integer.parseInt(request.getParameter("typeid"));
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
		Type type=tpservice.getById(typeid);
		Set<Topic> topics=type.getTopics();
		Map<Integer,String> mapmain=new TreeMap<Integer,String>();
		Map<Integer,String> times=new TreeMap<Integer,String>();
		Map<Integer,Integer> counts=new TreeMap<Integer,Integer>();
		if(topics!=null){ 
			Iterator<Topic> it = topics.iterator();
		while (it.hasNext()) {
			Topic tp=it.next();
			mapmain.put(tp.getId(), tp.getTitle());
			times.put(tp.getId(),tp.getTopicTime().toString());
			counts.put(tp.getId(), (tp.getCommentCount()!=null)?tp.getCommentCount():0);
			}
		}
		request.setAttribute("Typeid", String.valueOf(type.getId()));
		request.setAttribute("Typename", type.getName());
		request.setAttribute("count",String.valueOf(type.getCounttopics()));
		request.setAttribute("Topicmain", mapmain);
		request.setAttribute("counts", counts);
		request.setAttribute("times", times);
		request.getRequestDispatcher("/Topics.jsp").forward(request, response);
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		ServletContext servletContext = servletConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.configureBean(this, "TopicAll");
	}

}
