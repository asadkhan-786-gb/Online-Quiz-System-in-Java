package oes.controller;
// Importing lib
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// Importing other Java files
import oes.db.Admins;
import oes.model.AdminsDao;
@WebServlet("/oes.controller.ValidateAdmin")
public class ValidateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public ValidateAdmin() {
        super();
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		

		
		Admins ad = new Admins(); // Creating object
		ad.setUsername(username);
		ad.setPassword(password);
		
	    boolean status = AdminsDao.doValidate(ad);
	    
	    if(status)
	    {
	    
	    	//Logged in  as admin do something (pending)
	    	 HttpSession session = request.getSession();
			 session.setAttribute("username", ad.getUsername());
			 response.sendRedirect("AdminPanel.jsp");
	    }
	    else
	    {
	    	String msg2 = "Invalid Username or Password";
	    	response.sendRedirect("AdminLogin.jsp?msg2="+msg2);
	    }
		
		
	}

}
