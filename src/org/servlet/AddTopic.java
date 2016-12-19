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
import org.service.TopicService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tool.UserContext;

public class AddTopic extends HttpServlet {
	private TopicService tpservice;

	public void setTpservice(TopicService tpservice) {
		this.tpservice = tpservice;
	}

	public AddTopic() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = UserContext.getCurrentUser();
		if (user != null) {
			String typestr = request.getParameter("Typeid");
			if (typestr != null) {
				int typeid = Integer.parseInt(typestr);
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				if (title != null && content != null
						&& tpservice.Init(user.getId(), typeid, title, content)) {
					response.sendRedirect("TopicAll.do?typeid=" + typeid);
				} else {
					request.setAttribute("errormsg", "传参出错");
					request.getRequestDispatcher("404.jsp").forward(request,
							response);
				}
			} else {
				request.setAttribute("errormsg", "抱歉发帖失败");
				request.getRequestDispatcher("404.jsp").forward(request,
						response);
			}
			UserContext.destroy();
		} else {
			request.setAttribute("errormsg", "抱歉请先登录后发帖");
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		// Put your code here
		ServletContext servletContext = servletConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.configureBean(this, "AddTopic");
	}

}
