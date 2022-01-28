package oes.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
 
//printing msg method 

/**
 * implementation class LogoutStudent
 */
@WebServlet("/oes.controller.LogoutStudent")
public class LogoutStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutStudent() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 session.invalidate();
		 String msg1 = "Logged out successfully";
		 response.sendRedirect("StudentLogin.jsp?msg1="+msg1);
	}



}
