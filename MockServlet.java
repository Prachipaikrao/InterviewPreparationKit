import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MockServlet")
public class MockServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String answer1 = request.getParameter("a1"); // JDBC
        String answer2 = request.getParameter("a2"); // OOP
        String answer3 = request.getParameter("a3"); // Priority

        int score = 0;

        out.println("<html><body style='font-family:Arial; background:#f9f9f9;'>");
        out.println("<h2>Mock Test Results</h2>");
        out.println("<hr>");

        // Q1
        if(answer1 != null && answer1.trim().equalsIgnoreCase("java database connectivity")) {
            out.println("<p>Q1 ✅ Correct: " + answer1 + "</p>");
            score++;
        } else {
            out.println("<p>Q1 ❌ Incorrect: " + answer1 + "</p>");
        }

        // Q2
        if(answer2 != null && answer2.trim().equalsIgnoreCase("false")) {
            out.println("<p>Q2 ✅ Correct: " + answer2 + "</p>");
            score++;
        } else {
            out.println("<p>Q2 ❌ Incorrect: " + answer2 + "</p>");
        }

        // Q3
        if(answer3 != null && answer3.trim().equals("10")) {
            out.println("<p>Q3 ✅ Correct: " + answer3 + "</p>");
            score++;
        } else {
            out.println("<p>Q3 ❌ Incorrect: " + answer3 + "</p>");
        }

        // Final Score
        out.println("<hr>");
        out.println("<h3>Total Marks: " + score + "/3</h3>");

        // Marks page link
        out.println("<form action='Marks.html'>");
        out.println("<input type='submit' value='Add Your Marks' style='padding:10px 20px; font-size:16px;'>");
        out.println("</form>");

        out.println("</body></html>");
    }
}
