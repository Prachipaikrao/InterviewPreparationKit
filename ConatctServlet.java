import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/ConatctServlet")   // ✅ Corrected spelling
public class ConatctServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String area = request.getParameter("area");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "hr", "pass");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO contact(email, area, phone, address) VALUES (?,?,?,?)");

            ps.setString(1, email);
            ps.setString(2, area);
            ps.setString(3, phone);
            ps.setString(4, address);

            int i = ps.executeUpdate();

            if (i > 0) {
                // ✅ Pass success message via request attribute
                request.setAttribute("message", "You are successfully registered!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Home.html");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("message", "Registration failed!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Contact.html");
                dispatcher.forward(request, response);
            }

            con.close();
        } catch (Exception e) {
            request.setAttribute("message", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("Contact.html");
            dispatcher.forward(request, response);
        }
    }
}
