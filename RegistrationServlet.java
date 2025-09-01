

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				

				String user=request.getParameter("user");
		         String pass=request.getParameter("password");
				String address=request.getParameter("address");
				String city=request.getParameter("city");
		         String country=request.getParameter("country");
				String no=request.getParameter("no");

				 try {

					 Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");

		                PreparedStatement ps = con.prepareStatement("insert into signup1 values(?,?,?,?,?,?)");



			            ps.setString(1, user);

			            ps.setString(2, pass);
			            ps.setString(3, address);
			            

			            ps.setString(4, city);
			            ps.setString(5, country);
			            ps.setString(6, no);
			  
			            int i = ps.executeUpdate();
		                out.print(i+"You are sucessfully registered");
		                
		                if(i>0)
		                {
		                	RequestDispatcher dispatcher=request.getRequestDispatcher("Login.html");
		                	dispatcher.forward(request,response);
		                }

			                con.close();

			        }

				 catch(Exception e) {

			            System.out.print(e);

			        }

				
					
		out.close();
	}

}
