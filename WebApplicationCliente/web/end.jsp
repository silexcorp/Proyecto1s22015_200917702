<%-- 
    Document   : end
    Created on : Sep 17, 2015, 1:38:06 PM
    Author     : Alexander
--%>


        <% session.removeAttribute("user");
           response.sendRedirect("index.jsp");
        %>