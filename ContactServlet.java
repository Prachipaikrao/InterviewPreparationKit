

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
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				

				String email=request.getParameter("email");
		         String area=request.getParameter("area");
				String phone=request.getParameter("phone");
				String address=request.getParameter("address");
		

				 try {

					 Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");

		                PreparedStatement ps = con.prepareStatement("insert into contact values(?,?,?,?)");



			            ps.setString(1, email);

			            ps.setString(2, area);
			            ps.setString(3, phone);
			            

			            ps.setString(4, address);
			          
			            int i = ps.executeUpdate();
		                out.print(i+"You are sucessfully registered");
		                
		                if(i>0)
		                {
		                	RequestDispatcher dispatcher=request.getRequestDispatcher("Home.html");
		                	dispatcher.forward(request,response);
		                }

			                con.close();

			        }

				 catch(Exception e) {

			            System.out.print(e);

			        }
	}

}
