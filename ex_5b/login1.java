import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class login1 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response){  
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        
        String n=request.getParameter("userName");  
        out.print("<html> ");
        out.println("<head> <link rel='stylesheet' href='sty.css'> </head>");
        out.print("<body style = 'background-color: rgb(240, 201, 150);'>");
        out.print(" <mt>  Cricket Kit Collection  </mt>  ") ;          
        out.print("<br><hr>");
         out.print("<p style = 'color: rgb(60, 136, 126);'>");
        out.print("Welcome to the world of cricket and its essential kit. Whether you're a seasoned player or a beginner, we have everything you need to get started or take your game to the next level.&nbsp;Our collection consists of high-quality equipment that is designed to meet the demands of cricket players at all levels of the sport.");
        out.print("</p>");
        out.print("<p style = 'color: rgb(90, 44, 255); font-size: 0.5cm; '> Welcome <mt1 style = 'color: crimson;'>".concat(n)+"</mt1></p>");
       // out.print("<p style = 'color: rgb(60, 136, 126);'> "+"</p>");
      //  out.print("Welcome <p style = 'color: rgb(60, 136, 126);'> '"+n+"'</p>"); 
      //  out.print("</p>");
       
          
        //creating form that have invisible textfield  
        out.print("<form action='login2'>");  
        out.print("<input type='hidden' name='uname' value='"+n+"'>");  
        out.print("<input type='submit' value='go'>");  
        out.print("</form> ");  
        out.close();  
  
                }catch(Exception e){System.out.println(e);}  
    }  
  
}  