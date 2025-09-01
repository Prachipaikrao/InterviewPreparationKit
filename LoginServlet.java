

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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
			String user = request.getParameter("user");

	        String pass = request.getParameter("password");

	        
	        PrintWriter out = response.getWriter();
	        

	        // Check if the username and password are valid

	        boolean isValidUser = validateUser(user, pass);
	        
		

	        

	        // Prepare response

	      

	     

	        

	        // If user is valid, allow login

	        if(isValidUser) {

	            out.println("<h2>Login Successful!</h2>");
	            response.sendRedirect("Home.html?sucess=true");

	        } else {

	            // If user is not valid, display an error message

	            out.println("<h2>Invalid username or password. Please try again.</h2>");

	        }

	    }

	    

	    // Method to validate user credentials

	    private boolean validateUser(String user, String pass) {

	        boolean isValidUser = false;

	        Connection conn = null;

	        PreparedStatement stmt = null;

	        ResultSet rs = null;

	        

	        try {

	            // Establish connection to the database

	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "pass");

	            

	            // Prepare SQL query

	            String sql = ("SELECT * FROM signup1 WHERE UserName = ? AND Password= ?");

	            stmt = conn.prepareStatement(sql);

	            stmt.setString(1, user);

	            stmt.setString(2, pass);

	            

	            // Execute query

	            rs = stmt.executeQuery();

	            

	            // Check if any rows are returned

	            if(rs.next()) {

	                isValidUser = true;

	            }
	            
	            

	        } catch (SQLException e) {

	            e.printStackTrace();

	        } 

	        finally {

	            // Close resources

	            try {

	                if(rs != null) rs.close();

	                if(stmt != null) stmt.close();

	                if(conn != null) conn.close();

	            } catch (SQLException e) {

	                e.printStackTrace();

	            }
	            
	        }
	        return isValidUser;
	        
	}

}
