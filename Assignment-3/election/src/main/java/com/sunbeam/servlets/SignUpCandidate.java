package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;

import com.sunbeam.pojos.User;


@WebServlet("/signup")
public class SignUpCandidate extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u=null;
		try(UserDao candDao = new UserDaoImpl()){
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		resp.setContentType("text/html");
		PrintWriter out =resp.getWriter();
		
		out.println("<html>");
				out.println("<head>");
				out.println("<title>Add User</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h3>Online Voting</h3>");
				out.println("<form method='post' action='signup'>");
				//out.printf("Id: <input type='text' name='id' value=''/><br/><br/>\n");
				out.printf("firstName: <input type='text' name='fname' value=''/><br/><br/>\n");
				out.printf("lastName: <input type='text' name='lname' value=''/><br/><br/>\n");
				out.printf("Date: <input type='date' name='date' value=''/><br/><br/>\n");
				out.printf("Email: <input type='text' name='email' value=''/><br/><br/>\n");
				out.printf("Password: <input type='password' name='password' value=''/><br/><br/>\n");
				out.printf("Re-Entry Password: <input type='password' name='' value=''/><br/><br/>\n");
				out.println("<input type='submit' value='Insert User'/>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname= req.getParameter("fname");
		
		String lname= req.getParameter("lname");
		String dateStr= req.getParameter("date");
		
		Date sqlDate = Date.valueOf(dateStr);
		
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		
		User u = new User(fname,lname,email,password,sqlDate,0,"voter");
		try(UserDao userDao= new UserDaoImpl()){
			int count = userDao.addUser(u);
			String msg= "Candidates Edited: "+count;
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
			
			//resp.sendRedirect("result");
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	
	}
	

}
