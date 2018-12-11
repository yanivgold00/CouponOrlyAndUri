package com.market.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.market.com.service.CouponGroup;

/**
 * Servlet implementation class AddGroup
 */
@WebServlet("/addgrouptodb")
public class AddGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		try{
		String strgnum = request.getParameter("groupnum");
		String strgname = request.getParameter("groupname");
		int num = Integer.parseInt(strgnum);
		CouponGroup couponGroup = new CouponGroup(num, strgname);
		System.out.println(couponGroup);
		couponGroup.save();
		httpSession.setAttribute("message", "Update Sussced ");
		response.sendRedirect("addGroup.jsp");
		}catch (Exception e) {
			httpSession.setAttribute("message", "Update failed "+e.getMessage());
			
			response.sendRedirect("index.jsp");
		}
	}

}
