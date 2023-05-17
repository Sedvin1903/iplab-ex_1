/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfr;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.System.*;

/**
 *
 * @author frsed
 */
@WebService(serviceName = "jfw")
public class jfw  extends HttpServlet {

    /**
     * This is a sample web service operation
     * 
     */
    @WebMethod(operationName = "fetch")
     public String[][] fetch() {                 //@WebParam(name = "name") String txt
         
         String[][] str = new String[4][4];
        HttpServletResponse response = null;
       String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3307/movies";

        // Database credentials
        String USER = "root";
        String PASS = "";

        String title = "Database Result";

        System.out.println(title);
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM shows;";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println(" <style> th, td { ");
            System.out.println("padding-top: 10px;");
            System.out.println(" padding-bottom: 20px;");
            System.out.println("padding-left: 30px;");
            System.out.println("padding-right: 40px;");
            System.out.println("} </style><center><div><table border = 1 >");
            System.out.println("<tr><td> Title </td>'");
            System.out.println("<td> Year </td>");
            System.out.println("<td> Country of Origin </td>");
            System.out.println("<td> Comment </td></tr>");
 
            
            int i = 0;
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String Title = rs.getString("Title");
                String year = rs.getString("year");
                String co = rs.getString("co");
                String comment = rs.getString("comment");

                // Display values
                System.out.println("<tr> <td>" + Title + " </td>");
                System.out.println("<td>" + year + "</td>");
                System.out.println("<td>" + co + "</td>");
                System.out.println("<td >" + comment + "</td>");
                System.out.println(
                        "<td > ");
                System.out.println("</td></tr> ");
                int j = 0;
                
                str[i][j] = Title;
                str[i][j+1] = year;
                str[i][j+2] = co;
                str[i][j+3] = comment;
                i++;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
        return str;
    }

       
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}

    
