import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class login2 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response) { 
        try{  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        //Getting the value from the hidden field  
        String n=request.getParameter("uname");  
        
        out.print("<body style = 'background-color: rgb(240, 201, 150);'>");
        out.print("<center>"); 
        out.print("<img src='https://images.unsplash.com/photo-1549032305-e816fabf0dd2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80' heigth='600' width='600'> </center>");
        out.print("<br><br>  <center> <p style = 'color: rgb(90, 44, 255); font-size: 1cm; align:center '> Bye <mt1 style = 'color: crimson;'>".concat(n)+"</mt1>  <center></p>"); 
        out.close();  
                }
        catch(Exception e)
        {System.out.println(e);}  
}
      
}  