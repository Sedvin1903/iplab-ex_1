
//  Print Array element by getting index 

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ass1 extends HttpServlet {

    private int arr[] = { 12, 57, 38, 69, 57, 48, 25, 65, 35, 25 };
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();

        String opt = request.getParameter("arr");
        int i = Integer.parseInt(opt);
        int ele = arr[i];

        out.println("<h3>" + "Index of the elelment selected  is : " + opt + "</h3>");

        out.println("<br>" + "<h2>" + "Element at index " + opt + " [ arr [" + opt + "] ]:" + ele + "</h2>");
    }

    public void destroy() {
        // do nothing.
    }
}
