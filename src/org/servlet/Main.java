package org.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bean.User;
import org.service.CategoryService;
import org.service.TypeService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tool.UserContext;

public class Main extends HttpServlet {
	private CategoryService cgservice;
	private TypeService tpservice;

	public void setCgservice(CategoryService cgservice) {
		this.cgservice = cgservice;
	}

	public void setTpservice(TypeService tpservice) {
		this.tpservice = tpservice;
	}

	private static final long serialVersionUID = 1L;

	public Main() {
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
		Map<Integer, String> map;
		map = cgservice.get();
		if (map != null) {
			request.setAttribute("cgmap", map);
			ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
			Map<Integer, String> tymap;
			for (int i = 0; i < list.size(); i++) {
				tymap = tpservice.getByCId(list.get(i));
				if (tymap != null)
					request.setAttribute("tymap" + list.get(i), tymap);
			}
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		// Put your code here
		ServletContext servletContext = servletConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.configureBean(this, "Main");
	}

}
