<%-- 
    Document   : index
    Created on : Sep 17, 2015, 1:34:50 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style type="text/css" media="screen">
            @import 'estilo/estilo.css';
        </style>
    </head><br><br><br><br><br><br><br>
    <body>
    <HR noshade size="2" width="50%" align="center">
    <%-- start web service invocation <hr/> --%>
    <%
        java.lang.String result = "";
        java.lang.String user = "";
        java.lang.String pass = "";
    try {
	login.Login_Service service = new login.Login_Service();
	login.Login port = service.getLoginPort();
	 // TODO initialize WS operation arguments here
	user = request.getParameter("user");
	pass = request.getParameter("pass");
	// TODO process result here
	result = port.loginUser(user, pass);
	//out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    if((user != null) & (pass!= null)){
        if(result.equals("admin")){
            session.setAttribute("user", user);
            response.sendRedirect("admin.jsp");
        }else if(result.equals("user")){
            session.setAttribute("user", user);
            response.sendRedirect("user.jsp");
            out.println("<a style=\"color:white; font-style:inherit ;\"><p><h1 align=\"center\">Usuario invitado</h1></a>");
        }else{
            out.println("<a style=\"color:white; font-style:inherit ;\"><p><h1 align=\"center\">Usuario no disponible</h1></a>");
        }
    }else{    
    %>

            <a style="color:white;">
                    <h1 align="center">Inicie Sesión</h1>
            </a>
            <form id="form" name="form" action="index.jsp" method="post">
                 
                <div id="block">
                        <label id="user" for="name">p</label>
                        <input type="text" name="user" id="user" placeholder="Username" required/>
                        <label id="pass" for="pass">k</label>
                        <input type="password" name="pass" id="pass" placeholder="Password" required />
                        <input type="submit" id="submit" name="submit" value="a"/>
                </div>
            </form>
            <div id="option"> 
                <p>Sign in</p> 
                <a href="index.jsp">forgot?</a>
            </div>
    <% } %>
    
    <HR noshade size="2" width="50%" align="center">
        
    <%-- end web service invocation <hr/> --%>
    </body>
</html>
