package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLeagueViewServlet
 */
@WebServlet(
		urlPatterns = { 
				"/AddLeagueViewServlet", 
				"/add_league.view"
		}, 
		initParams = { 
				@WebInitParam(name = "season_list", value = "select,summer,winter,autumn")
		})
public class AddLeagueViewServlet extends HttpServlet {
	private String seasonList=null;
	private String[] seasonArr;
	@Override
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		seasonList=config.getInitParameter("season_list");
		seasonArr=seasonList.split(",");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();
List<String> l=(List <String>) request.getAttribute("ERROR");
if(l!=null) {
	out.println("<font color='red'>please correct the error(s)</font></br>");
	for(String str:l) {
		out.println("<font color='red'>"+str+"</font></br>");
	}
	
}
out.println("<form action='add_league.do' method='post'>");
out.println("year<input type='text' name='year'></br>");
out.println("Season<select name='season'>");
for(String s:seasonArr) {
	out.println("<option value="+s+">"+s+"</option>");
	
}
out.println("</select></br>");
out.println("Title<input type='text' name='title'>");
out.println("<input type='submit' value='add_league'></form>");
}
}