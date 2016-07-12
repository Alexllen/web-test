package servlet;
import javax.servlet.http.*;
import java.net.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.*;
import com.po.*;
/**
 * Servlet implementation class DologinServlet
 */
@WebServlet("/DologinServlet")
public class DologinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DologinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String isUse[] = request.getParameterValues("IsUseCookie");
		if (isUse != null && isUse.length > 0) {
			String id = URLEncoder.encode(request.getParameter("id"),
					"utf-8");
			String password = URLEncoder.encode(
					request.getParameter("password"), "utf-8");
			Cookie Id = new Cookie("Id", id);
			Cookie Password = new Cookie("Password", password);
			Id.setMaxAge(60 * 60 * 24 * 10);
			Password.setMaxAge(60 * 60 * 24 * 10);
			response.addCookie(Id);
			response.addCookie(Password);
		}
		else{
			Cookie cookies[]=request.getCookies();
			if(cookies!=null&&cookies.length>0){
				for(Cookie c: cookies)
					if(c.getName().equals("Id")||c.getName().equals("Password")){
						c.setMaxAge(0);response.addCookie(c);
					}
			}
		}
		User loginuser=new User();
		userDao userdao=new userDao();
		loginuser.setId(request.getParameter("id"));
		loginuser.setPassword(request.getParameter("password"));
		if(userdao.isUser(loginuser)){
			userdao.update(loginuser,request.getRemoteAddr());
			request.setAttribute("username", loginuser.getUsername());
			request.setAttribute("lastdate", loginuser.getLastdate());
			request.setAttribute("lastip", loginuser.getLastip());
			request.getRequestDispatcher("login_success.jsp").forward(
					request, response);
		}
		else
			response.sendRedirect("login_failure.jsp");
	}

}
