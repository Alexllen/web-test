package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.UserService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tool.CreateMD5;

public class DoRegister extends HttpServlet {
	private UserService userservice;
	public void setUserservice(UserService userservice){
		this.userservice=userservice;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DoRegister() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		if (ids != null && !userservice.isUser1(id)) {
			String name=request.getParameter("name");
			String passwd=request.getParameter("password");
			if(userservice.Register(id, passwd, name)!=null){
				Cookie c1=new Cookie("id",ids);
				Cookie c2=new Cookie("passwd",CreateMD5.getMd5(passwd));
				c1.setMaxAge(3600);c2.setMaxAge(3600);
				response.addCookie(c1);response.addCookie(c2);
				c1.setPath("/MyForum/");c2.setPath("/MyForum/");
				response.sendRedirect("Main.do");
			}
			else{
				request.setAttribute("errormsg", "注册过程出错");
				request.getRequestDispatcher("404.jsp").forward(request,
						response);
			}
		} else{
			request.setAttribute("errormsg", "注册验证出错");
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
	    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
	    AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory(); 
	    autowireCapableBeanFactory.configureBean(this, "DoRegister");
	}

}
