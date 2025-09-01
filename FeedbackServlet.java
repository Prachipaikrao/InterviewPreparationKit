

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
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				

				String idea=request.getParameter("idea");
		    
				String sugession=request.getParameter("suggestion");
				String newidea=request.getParameter("newidea");
		

				 try {

					 Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","pass");

		                PreparedStatement ps = con.prepareStatement("insert into Feedback values(?,?,?)");



			            ps.setString(1,idea);

			            ps.setString(2,sugession);
			            ps.setString(3,newidea);
			            

			
			          
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
