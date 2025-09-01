

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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		    String UserName=request.getParameter("user");
		String password=request.getParameter("password");
		
		
		
		
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");
			PreparedStatement stmt=con.prepareStatement("update registration set  UserName=? where password=? ");
			stmt.setString(1,UserName);
			stmt.setString(2,password);
			
			
	
			int i=stmt.executeUpdate();
			out.println(i+"records updated");
			
			out.print("successfull");
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.print("Do You Want To Delete ? ");		
		out.print("<form action='DeleteServlet'> ");
	    out.print("<input type='submit' value ='view'>" );
	    out.print("</form>");
		
		out.close();
		
	}

}
