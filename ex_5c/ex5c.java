import java.io.*;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ex5c extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        String title = "Today Visitor's Score";
        // This method executes whenever the servlet is hit
        // increment hitCount
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String date = myDateObj.format(myFormatObj);

        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");
            out.print("<html> ");
            out.println("<head> <link rel='stylesheet' href='sty.css'> </head>");
            out.print("<body style = 'background-color: rgb(240, 201, 150);'>");
            out.print(" <mt>  Cricket Kit Collection  </mt>  ");
            out.print("<br><hr>");
            out.print("<p style = 'color: rgb(60, 136, 126);'>");
            out.print(
                    "Welcome to the world of cricket and its essential kit. Whether you're a seasoned player or a beginner, we have everything you need to get started or take your game to the next level.&nbsp;Our collection consists of high-quality equipment that is designed to meet the demands of cricket players at all levels of the sport.");
            out.print("</p>");
            out.print(
                    "<p style = 'color: rgb(90, 44, 255); font-size: 0.7cm; '> Welcome <mt1 style = 'color: crimson;'>"
                            .concat(n) + "</mt1></p>");
            hitCount++;
            out.println("<h1 style='color: rgb(139, 0, 0);'align = \"center\">" + title + "</h1>\n\n");

            out.println("<h2 style='color: rgb(90, 44, 255);' align = \"center\">" + hitCount + "</h2>\n");
            out.println("<p style = 'color: rgb(0, 110, 96);' align = \"center\">"
                    + "Logged on : ".concat(date) + "</h2>\n");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void destroy() {
        // This is optional step but if you like you
        hitCount = 0;
    }
}