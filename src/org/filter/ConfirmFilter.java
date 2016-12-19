package org.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.bean.User;
import org.service.UserService;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.tool.UserContext;

/**
 * Servlet Filter implementation class ConfirmFilter
 */
@WebFilter("*.do")
public class ConfirmFilter implements Filter {
	private UserService userservice;

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	/**
	 * Default constructor.
	 */
	public ConfirmFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();
		String id = null, passwd = null;
		if (cookies != null && cookies.length != 0)
			for (Cookie c : cookies) {
				if (c.getName().equals("id"))
					id = c.getValue();
				if (c.getName().equals("passwd"))
					passwd = c.getValue();
			}
		if (id != null && passwd != null
				&& userservice.vaildateMD5(Integer.parseInt(id), passwd)) {
			User user = userservice.isUser(Integer.parseInt(id));
			try {
				UserContext userct = new UserContext(user);
			} finally {
			}
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext servletContext = fConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		autowireCapableBeanFactory.configureBean(this, "ConfirmFilter");
	}

}
