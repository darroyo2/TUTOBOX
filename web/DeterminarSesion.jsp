<%@page import="javax.servlet.http.HttpSession"%>
<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("UsuarioNombre")!= null)
    { // si la sesion existe
    }
    else
    {
        response.sendRedirect("LogUsuario.html");
    }   
%>