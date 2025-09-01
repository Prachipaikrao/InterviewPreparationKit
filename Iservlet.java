

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Iservlet
 */
@WebServlet("/Iservlet")
public class Iservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Name = request.getParameter("name");
		String position=request.getParameter("position");
	 int  marks=Integer.parseInt(request.getParameter("marks"));
		
		if(marks==3)
		{
			out.print("<form action='Certificate1.html'> ");
		    out.print("<input type='submit' value ='Get your certificate'>" );
		    
		    out.print("</form>");	
		}
		else
		{
			out.print("TRY HARD");
			out.print("<form action='Home.html'> ");
		    out.print("<input type='submit' value ='Retry'>" );
		    out.print("</form>");
		}
			
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
			PreparedStatement ps=con.prepareStatement(" insert into FinalMarksOfInterview values(?,?,?) ");
		
			ps.setString(1,Name);
			ps.setString(2, position);
			ps.setInt(3, marks);
			
			int i=ps.executeUpdate();
			out.print(i+"Thank You For Your Response");

	        con.close();
		}
		
		
		catch(Exception e)
		{
			out.print(e);
		}
		
	}

}
