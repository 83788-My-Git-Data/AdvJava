package com.sunbeam.servlets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

//@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Candidate> list = new ArrayList<Candidate>();
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			list=candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
			// TODO: handle exception
		}
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
				out.println("<head>");
				out.println("<title>Candidates</title>");
				out.println("</head>");
				out.println("<body>");
//				out.println("<h3>Online Voting</h3>");
				
				ServletContext app = this.getServletContext();
						String appTitle = app.getInitParameter("AppTitle");
						out.printf("<h3>%s</h3>", appTitle);
				
				String userName = "";
						Cookie[] arr = req.getCookies();
						if(arr != null) {
							for (Cookie c : arr) {
								if(c.getName().equals("uname")) {
									userName = c.getValue();
									break;
								}
							}
						}
						out.printf("Hello, %s<hr/>\n", userName);
						
						ServletContext ctx=this.getServletContext();
						String message =(String) ctx.getAttribute("announcement");
						if(message!=null)
							out.printf("Announcement: %s <br/><br/> \n",message);
						
				out.println("<form method='post' action='vote'>");
				for(Candidate c:list)
				{
					out.printf("<input type='radio' name='candidate' value='%d'/> %s(%s) </br> \n", c.getId(), c.getName(),c.getParty());
				}
					out.println("<input type='submit' value='Vote'/>");		
					out.println("</form>");
							out.println("</body>");
							out.println("</html>");
				
				out.println("</body>");
		
	}

}
