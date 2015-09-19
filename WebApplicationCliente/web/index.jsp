<%-- 
    Document   : index
    Created on : Sep 18, 2015, 6:42:09 PM
    Author     : Alexander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesion</title>
        <style>
            @import 'estilo/estilo.css';
        </style>
    </head>
    <body>
        <br><br><br><br><br><br><br>
        <HR noshade size="2" width="50%" align="center">
        
        
        
        
        
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
        
        
        
        
        
        <HR noshade size="2" width="50%" align="center">
    </body>
</html>
