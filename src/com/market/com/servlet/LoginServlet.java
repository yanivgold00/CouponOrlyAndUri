package com.market.com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.tomcat.jni.User;

import com.market.com.service.UserCon;


/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("unused")
@WebServlet("/loginsrv")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession httpSession = request.getSession();
			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			
			UserCon p = new UserCon(username,pass);
			System.out.println(p+":"+p.getNum());
			if(p.isLogin()){
				request.setAttribute("user", p);
				httpSession.setAttribute("loginfail", false);
				//do smothing
				
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
				rd.forward(request, response);
			}
			else{
//				return to login page
				httpSession.setAttribute("loginfail", true);
				response.sendRedirect("login.jsp");
			}
	}

}

