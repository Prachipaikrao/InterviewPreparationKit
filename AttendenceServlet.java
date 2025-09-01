

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
 * Servlet implementation class AttendenceServlet
 */
@WebServlet("/AttendenceServlet")
public class AttendenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter out=response.getWriter();

		out.print("<!DOCTYPE html>\r\n"

				+ "<html lang=\"en\">\r\n"

				+ "<head>\r\n"

				+ "   <meta charset=\"UTF-8\">\r\n"

				+ "   <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"

				+ "   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"

				+ "  \r\n"

				+ "</head>\r\n"

				+ "<body>\r\n"

				+ "\r\n"

				+ "    <form action=\"Atts\" method=\"post\">\r\n"

				+ "    \r\n"

		

				+ "  </select>\r\n"

				+ "  <input type=\"text\" name=\"n2\">\r\n"

				+ "  <select name=\"att2\">\r\n"

				+ "    <option value=\"present\">present</option>\r\n"

				+ "    <option value=\"absent\">absent</option>\r\n"

				+ "\r\n"

				+ "</select>\r\n"

				+ "<input type=\"submit\" value=\"go\">\r\n"

				+ "\r\n"

				+ "    </form>\r\n"

				+ "</body>\r\n"

				+ "</html>");

		

		

		

	 

		String s2=request.getParameter("att2");

		String n1=request.getParameter("n1");

		String n2=request.getParameter("n2");

		

		try{  

			Class.forName("oracle.jdbc.driver.OracleDriver");  

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");  

			  

			PreparedStatement ps=con.prepareStatement("insert into att1 values(?,?)");  

			ps.setString(1, n2);

			ps.setString(2,s2);  

		

			          

			int j=ps.executeUpdate();  

			if(j>0)  

			{

				out.print("inserted");

				

			}

			          

			}catch (Exception e2) {System.out.println(e2);}  

	
		       out.close();
	}

}
