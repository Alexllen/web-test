package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.User;
import org.service.CommentService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tool.UserContext;

public class AddComment extends HttpServlet {
	private CommentService comservice;
	public void setComservice(CommentService comservice) {
		this.comservice = comservice;
	}
	public AddComment() {
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
			int topicid=Integer.parseInt(request.getParameter("topicid"));
			String content=request.getParameter("content");
			System.out.println("The Comment content:"+content);
			if(content!=null&&comservice.Init(topicid, user.getId(), content))
				response.sendRedirect("ShowTopic.do?topicid="+topicid);
			else{
				request.setAttribute("errormsg", "抱歉评论失败");
				request.getRequestDispatcher("404.jsp").forward(request,
						response);
			}
			UserContext.destroy();
		}
		else{
			request.setAttribute("errormsg", "抱歉请先登录后评论");
			request.getRequestDispatcher("404.jsp").forward(request,
					response);
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig servletConfig) throws ServletException {
		// Put your code here
		ServletContext servletContext = servletConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.configureBean(this, "AddComment");
	}

}
