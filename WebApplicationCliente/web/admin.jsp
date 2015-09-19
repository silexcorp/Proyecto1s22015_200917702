<%-- 
    Document   : admin
    Created on : Sep 18, 2015, 6:04:45 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            @import 'estilo/estilo.css';
        </style>
    </head>
    <body>
        <a style="color:white; font-style:inherit ;">
            <p><h1 align="center">Bienvendio <%=session.getAttribute("user")%></h1>
        </a>
        
        
        <div id="option"> 
                <p>Logout</p> 
                <a href="end.jsp">
                    Logout?
                <% session.removeAttribute("user");
                    response.sendRedirect("index.jsp");
                %>
                </a>
                 
                
        </div>
    </body>
</html>
