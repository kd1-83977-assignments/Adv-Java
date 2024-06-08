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
		
		HttpSession session =req.getSession();
		User user =(User) session.getAttribute("curuser");
		String userRole= user.getRole();
		
		List<Candidate> list = new ArrayList<Candidate>();
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		if (userRole.equals("admin")) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Candidates</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Voting List</h3>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Party</th><th>Votes</th></tr>");

            for (Candidate candidate : list) {
                out.println("<tr>");
                out.println("<td>" + candidate.getId() + "</td>");
                out.println("<td>" + candidate.getName() + "</td>");
                out.println("<td>" + candidate.getParty() + "</td>");
                out.println("<td>" + candidate.getVotes() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Access Denied</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>You do not have permission to view this page.</h3>");
            out.println("</body>");
            out.println("</html>");
        
		}
		
	}
	
}
