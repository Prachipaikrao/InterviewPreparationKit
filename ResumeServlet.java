import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><head><style>"
                + "body { font-family: Arial, sans-serif; margin:0; padding:0; }"
                + ".navbar { overflow: hidden; background-color: white; }"
                + ".navbar a { float: left; display: block; color: #f2f2f2; text-align: center; padding: 14px 20px; text-decoration: none; font-size: 17px; }"
                + ".navbar a:hover { background-color: #ddd; color: black; }"
                + ".container { display: flex; font-size:18px; margin:30px; }"
                + ".item { background: #e3f2fd; padding:20px; margin:10px; flex:1; border-radius:10px; }"
                + "h2 { color: #003366; }"
                + "</style></head><body>");

        // --- Navbar ---
        out.print("<div class='navbar'>"
                + "<a href='Home1.html'>Home</a>"
                + "<a href='About.html'>About</a>"
               
                + "<a href='Contact.html'>Contact</a>"
                + "<a href='FeedBack.html'>Feedback</a>"
                + "</div>");

        // Basic info
        String Name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Skills
        String skill1 = request.getParameter("skill1");
        String skill2 = request.getParameter("skill2");
        String skill3 = request.getParameter("skill3");

        String skillLanguage1 = request.getParameter("skillLanguage1");
        String skillLanguage2 = request.getParameter("skillLanguage2");
        String skillLanguage3 = request.getParameter("skillLanguage3");

        // Languages
        String LanguagesKnown = request.getParameter("LanguagesKnown");
        String LanguagesKnown1 = request.getParameter("LanguagesKnown1");

        // Strengths & Weakness
        String Strength1 = request.getParameter("Strength1");
        String Strength2 = request.getParameter("Strength2");

        String Weakness1 = request.getParameter("Weakness1");
        String Weakness2 = request.getParameter("Weakness2");

        // Goals
        String LongTermGoal1 = request.getParameter("LongTermGoal1");
        String LongTermGoal2 = request.getParameter("LongTermGoal2");

        String ShortTermGoal1 = request.getParameter("ShortTermGoal1");
        String ShortTermGoal2 = request.getParameter("ShortTermGoal2");

        // Certification
        String Certification1 = request.getParameter("Certification1");
        String Certification2 = request.getParameter("Certification2");

        // Education + Projects
        String edu = request.getParameter("edu");
        String edu1 = request.getParameter("edu1");
        String project1 = request.getParameter("project1");
        String project2 = request.getParameter("project2");
        String project3 = request.getParameter("project3");

        String Summary = request.getParameter("Summary");

        // Output HTML
        out.print("<html><head><style>"
                + ".container { display: flex; font-size:18px; margin:30px; }"
                + ".item { background: #e3f2fd; padding:20px; margin:10px; flex:1; border-radius:10px; }"
                + "h2 { color: #003366; }"
                + "</style></head><body>");

        out.print("<h1 style='text-align:center; font-size:50px;'>Resume</h1>");

        out.print("<div class='container'>");

        // Left Column
        out.print("<div class='item'>");
        out.print("<h2>Personal Info</h2>");
        out.print("<p><b>Name:</b> " + Name + "</p>");
        out.print("<p><b>Email:</b> " + email + "</p>");
        out.print("<p><b>Phone:</b> " + phone + "</p>");

        out.print("<h2>Skills</h2>");
        out.print("<ul><li>" + skill1 + "</li><li>" + skill2 + "</li><li>" + skill3 + "</li></ul>");

        out.print("<h2>Programming Languages</h2>");
        out.print("<ul><li>" + skillLanguage1 + "</li><li>" + skillLanguage2 + "</li><li>" + skillLanguage3 + "</li></ul>");

        out.print("<h2>Languages Known</h2>");
        out.print("<ul><li>" + LanguagesKnown + "</li><li>" + LanguagesKnown1 + "</li></ul>");

        out.print("<h2>Summary</h2><p>" + Summary + "</p>");
        out.print("</div>");

        // Right Column
        out.print("<div class='item'>");
        out.print("<h2>Education</h2>");
        out.print("<ul><li>" + edu + "</li><li>" + edu1 + "</li></ul>");

        out.print("<h2>Projects</h2>");
        out.print("<ul><li>" + project1 + "</li><li>" + project2 + "</li><li>" + project3 + "</li></ul>");

        out.print("<h2>Strengths</h2>");
        out.print("<ul><li>" + Strength1 + "</li><li>" + Strength2 + "</li></ul>");

        out.print("<h2>Weaknesses</h2>");
        out.print("<ul><li>" + Weakness1 + "</li><li>" + Weakness2 + "</li></ul>");

        out.print("<h2>Goals</h2>");
        out.print("<p><b>Long Term:</b> " + LongTermGoal1 + ", " + LongTermGoal2 + "</p>");
        out.print("<p><b>Short Term:</b> " + ShortTermGoal1 + ", " + ShortTermGoal2 + "</p>");

        out.print("<h2>Certifications</h2>");
        out.print("<ul><li>" + Certification1 + "</li><li>" + Certification2 + "</li></ul>");

        out.print("</div></div></body></html>");
        
    }
}
