package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

/**
 * Servlet implementation class ListLeagueServlet
 */
@WebServlet({ "/ListLeagueServlet", "/list_leagues.view" })
public class ListLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<League> leagueList=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLeagueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request,response);
	
	}
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out=response.getWriter();

leagueList=(List<League>)getServletContext().getAttribute("leaguelist");

String pageTitle="Ducks soccer league:List leagues";


//leagueList=new ArrayList<League>();
//leagueList.add(new League("world cup",2019,"summer"));
//leagueList.add(new League("summer volley",2019,"winter"));
out.println("<html><head><title>The list of leagues</title></head><body><table border=1>");
out.println("<tr><th>title</th><th>season</th><th>season</th></tr>");
for(League l:leagueList) {
	out.println("<tr><td>"+l.getTitle()+"</td>"+" "+"<td>"+l.getSeason()+"</td>"+" "+"<td>"+l.getYear()+"</td></tr>");
	
}
out.println("</table></body></html>");


}
}