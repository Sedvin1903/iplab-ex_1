
// Import required java libraries
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class ass2 extends HttpServlet {

    // { {311120104054,"Jesed",1}
    // ,{311120104095,"Ramu",3},{311120104085,"Santosh",2},{3111201040,"HEMAN",6},
    // {311120104068,"Heswin",4} , {311120104092,"Somu",5} }

    class student {

        long regno;
        String name;
        int rank;
        // and many more fields ...
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        student alt[] = new student[6];
        alt[0] = new student();
        alt[0].regno = 31120104 * 1000 + 54;
        alt[0].name = "Jesed";
        alt[0].rank = 1;

        alt[1] = new student();
        alt[1].regno = 31120104 * 1000 + 95;
        alt[1].name = "Ramu";
        alt[1].rank = 3;

        alt[2] = new student();
        alt[2].regno = 31120104 * 1000 + 45;
        alt[2].name = "Santosh";
        alt[2].rank = 2;

        alt[3] = new student();
        alt[3].regno = 31120104 * 1000 + 65;
        alt[3].name = "Heman";
        alt[3].rank = 6;

        alt[4] = new student();
        alt[4].regno = 31120104 * 1000 + 78;
        alt[4].name = "Heswin";
        alt[4].rank = 4;

        alt[5] = new student();
        alt[5].regno = 31120104 * 1000 + 92;
        alt[5].name = "Somu";
        alt[5].rank = 5;

        // Set response content type
        response.setContentType("text/html");

        String opt = request.getParameter("regno");
        long REGNO = Long.valueOf(opt);

        int index = 0;

        for (int i = 0; i < alt.length; i++) {
            if ((alt[i].regno) == REGNO) {
                index = i;
            }
        }

        String NAME = alt[index].name;
        int RANK = alt[index].rank;

        // Actual logic goes here.
        PrintWriter out = response.getWriter();

        out.println("<h3>" + REGNO + " <br> " + "NAME : " + NAME + "\n RANK : " + RANK + "</h3>");

    }

    public void destroy() {
        // do nothing.
    }

}
