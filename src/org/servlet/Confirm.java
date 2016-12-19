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

public class Confirm extends HttpServlet {
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
	public Confirm() {
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
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action==null){
			request.setAttribute("errormsg", "������ݳ���");
			request.getRequestDispatcher("404.jsp").forward(request,
					response);
		}
		else if (action.equals("confirmlogin")) {// ��¼��C
			int id =Integer.parseInt(request.getParameter("id"));
			String passwd = request.getParameter("password");
			if (passwd != null && userservice.vaildate(id, passwd)) {
				Cookie c1=new Cookie("id",String.valueOf(id));
				Cookie c2=new Cookie("passwd",CreateMD5.getMd5(passwd));
				c1.setMaxAge(3600);c2.setMaxAge(3600);
				c1.setPath("/MyForum/");c2.setPath("/MyForum/");
				response.addCookie(c1);response.addCookie(c2);
				out.write("success");out.flush();
			}
			else {out.write("fail");out.flush();}
		} 
		else if (action.equals("confirmregister")) {// ע����C
			String id = request.getParameter("id");
			System.out.println(id);
			System.out.println(Integer.parseInt(id));
			if (id != null && userservice.isUser1(Integer.parseInt(id))) {
				out.write("fail");out.flush();
				System.out.println("fail");
			} 
			else if (id != null) {out.write("success");out.flush();
			System.out.println("success");} 
			else {out.write("fail");out.flush();}
		}
		else{out.write("actionerror");out.flush();}
		out.close(); 
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init(ServletConfig servletConfig) throws ServletException { 
	    ServletContext servletContext = servletConfig.getServletContext(); 
	    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
	    AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory(); 
	    autowireCapableBeanFactory.configureBean(this, "Confirm"); 
	} 

}
