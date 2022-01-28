package oes.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import oes.db.Questions;
import oes.model.QuestionsDao;

/**
 * implementation class QuestionInsert
 */
@WebServlet("/oes.controller.QuestionInsert")
public class QuestionInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String question = request.getParameter("Question");
		String a = request.getParameter("option1");
		String b = request.getParameter("option2");
		String c = request.getParameter("option3");
		String d = request.getParameter("option4");
		String answer = request.getParameter("answer");
		
		Questions q = new Questions();
		q.setA(a);
		q.setB(b);
		q.setC(c);
		q.setD(d);
		q.setAnswer(answer);
		q.setQuestion(question);
		
		boolean status = QuestionsDao.insertQuestion(q);
		
		if(status)
		{
			String msg1 = "Question Added";
	    	response.sendRedirect("AddQuestion.jsp?msg1="+msg1);
		}
		else
		{
			String msg2 = "Question not Added";
	    	response.sendRedirect("AddQuestion.jsp?msg2="+msg2);
		}
		
		
		
	
	}

}