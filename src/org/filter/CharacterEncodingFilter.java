package org.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {  
	  
    protected String encoding = null;  
    protected String resType = null;  
    protected FilterConfig filterConfig = null;  
    protected boolean ignore = true;  
  
    @Override  
    public void destroy() {  
        // �������ȫ�ֱ�����ֵ,��Ϊnull  
        this.encoding = null;  
        this.filterConfig = null;  
        this.resType = null;  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain filterChain) throws IOException, ServletException {  
        // ��web.xml�еõ����������ַ����  
        if (ignore || (request.getCharacterEncoding() == null)) {  
            if (encoding != null) {  
                request.setCharacterEncoding(encoding);  
                response.setCharacterEncoding(encoding);  
                response.setContentType(resType);  
            }  
  
        }  
        filterChain.doFilter(request, response);  
    }  
  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
        this.filterConfig = filterConfig;  
        this.encoding = filterConfig.getInitParameter("encoding");  
        this.resType = filterConfig.getInitParameter("resType") == null ? "text/html; charset=utf-8"  
                : filterConfig.getInitParameter("resType");  
        String value = filterConfig.getInitParameter("ignore");  
        if (value == null)  
            this.ignore = true;  
        else if (value.equalsIgnoreCase("true"))  
            this.ignore = true;  
        else  
            this.ignore = false;  
    }  
  
}  