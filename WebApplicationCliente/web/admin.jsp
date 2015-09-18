<%-- 
    Document   : admin
    Created on : Sep 17, 2015, 1:35:04 PM
    Author     : Alexander
--%>

<%@page import="struct.Arbolavl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" media="screen">
            @import 'estilo/estilo.css';
        </style>
    </head>
    <body>
        <a style="color:white; font-style:inherit ;">
            <p><h1 align="center">Bienvendio <%=session.getAttribute("user")%></h1>
        </a>
        <form action="admin.jsp" method="POST">
            <%-- start web service invocation --%><hr/>
            <%
            Arbolavl lista_admin = null;
            try {
                struct.STRUCTS_Service service = new struct.STRUCTS_Service();
                struct.STRUCTS port = service.getSTRUCTSPort();
                // TODO process result here
                struct.Listadoble result = port.getAdmin();
                out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            
            if(result.)
            %>
            <%-- end web service invocation --%><hr/>

        </form>
        
        
        
        
        <div id="option"> 
                <p>Logout</p> 
                <a href="end.jsp">Logout?</a>
        </div>
    </body>
</html>
