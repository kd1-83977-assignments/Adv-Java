package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

public class ResultSetServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session =req.getSession();
//		User user =(User) session.getAttribute("curuser");
//		String userRole= user.getRole();
//		
		
		List<Candidate> list = new ArrayList<Candidate>();
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Candidates</title>");
            out.println("</head>");
            out.println("<body>");
    		out.println("<table border='1'>");
    		out.println("<thead>");
    		out.println("<th>Id</th>");
    		out.println("<th>Name</th>");
    		out.println("<th>Party</th>");
    		out.println("<th>Votes</th>");
    		out.println("<th>Action</th>");
    		out.println("</thead>");
    		out.println("<tbody>");
    		for (Candidate c : list) {
    			out.println("<tr>");
    			out.printf("<td>%d</td>\n", c.getId());
    			out.printf("<td>%s</td>\n", c.getName());
    			out.printf("<td>%s</td>\n", c.getParty());
    			out.printf("<td>%d</td>\n", c.getVotes());
    			out.printf("<td><a href='editcand?id=%d'><img width='24' height='24' src='images/edit.png'/></a><a href='delcand?id=%d'><img width='24' height='24' src='images/delete.png'/></a></td>\n", c.getId(),c.getId());
    			out.println("</tr>");
    		}
    		out.println("</tbody>");
    		out.println("</table>");
    		
    		String msg=(String) req.getAttribute("message");
    		if(msg != null)
    			out.println("</br></br>" + msg + "</br></br>");
    		out.println("<br/><a href='announcement.html'>Announcement</a></br>");
    		out.println("<a href='logout'>Sign Out</a>");
    		out.println("</body>");
            out.println("</html>");	
	}
}
