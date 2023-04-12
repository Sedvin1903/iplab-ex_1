<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
	<title>Shopping Website</title>
</head>
<body>
<%
    Connection conn = null;
    Statement stmt = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/movies", "root", "");
        if (conn != null) {
            out.println("<h1> Amazon Online Shop</h1>");
        }
        stmt = conn.createStatement();

        // Update the contact information of the customer with the given name
        String sql = "Select * from shops";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            // Retrieve by column name
            String id = rs.getString("id");
            String item = rs.getString("item");
            String price = rs.getString("price");
            // Display values
            out.println("<p id="+id+"> ID: " + id + "<br>");
            out.println("Item Name: " + item + "<br>");
            out.println("Price: " + price + " $&emsp;&emsp;&emsp;");
            out.println("<button onclick='AddItem(\"" + id + "\",event,\"" + price + "\")'>ADD ITEM</button></p>");        }
        out.println("&emsp;&emsp;<a href='shop.html'>View Cart</a>");
        rs.close();
        // Clean-up environment
        stmt.close();
        conn.close();
    } catch (Exception e) {
        out.print("Error connecting to DB - Error:" + e);
    }
%>
<script>

    function AddItem(id,event,price)
    {
        console.log(id);
        console.log(price);
        alert("Item added to Cart");
        if(sessionStorage.getItem(id))
        {
            var count = Number(JSON.parse(sessionStorage.getItem(id)).count);
            count++;
            var arr = {price: price,count : count};
            window.sessionStorage.setItem(id,JSON.stringify(arr));

        }
        else
        {
            var arr = {price: price,count :1};
            window.sessionStorage.setItem(id,JSON.stringify(arr));
        }
    }
</script>
</body>
</html>
