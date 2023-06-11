<%@page import="dao.TipoUsuarioDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.TipoUsuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:::Registro del Sistema:::</title>
        <link rel="stylesheet" href="Recursos/Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Recursos/CSSPropio/newcss.css"/>
        <script src="Recursos/Bootstrap/js/bootstrap.min.js"></script>
        <script src="Recursos/JsPropio/ValidaJS.js"></script>
    </head>
    <body>
        <%
            List<TipoUsuario> tiposUsuario = new ArrayList<>(); 
            tiposUsuario = TipoUsuarioDAO.listarTiposUsuario();
        %>
        
        <div class="header">
            <strong>Seguridad del Sistema</strong>
        </div>

    <div class="center-container">
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div>
                    <center><img src="Recursos/img/logo2.jpg" alt="imagen" style="width: 300px; height: 220px;"></center>
                </div>
                &nbsp;
                <form name="formulario" method="post" id="formulario" action="RegistroServlet">
                    <div class="form-group">
                        <label for="nombres">Nombres:</label>
                        <input type="text" placeholder="Nombres" name="nombres" id="nombres" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos</label>
                        <input type="text" placeholder="Apellidos" name="apellidos" id="apellidos" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo:</label>
                        <input type="text" placeholder="Correo" name="correo" id="correo" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="clave">Contraseña:</label>
                        <input type="password" placeholder="Contraseña" name="clave" id="clave" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="rol">Rol:</label><br>
                        <select class="form-control" name="idTipoUsuario" id="">
                                    <option value="-1">Seleccione Tipo</option>
                                    <%                                        for (TipoUsuario c : tiposUsuario) {
                                    %>
                                    <option value="<%= c.getIdTipoUsuario()%>"><%= c.getDescripcion()%></option>
                                    <%
                                        }
                                    %>
                        </select>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary w-100" type="button" onclick="ValidaRegistro()">Registrarse</button>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary w-100" type="button" onclick="Volver()">Volver</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>





    <div class="footer">
        <strong>Universidad de Lima - Grupo 5</strong>
    </div> 



</body>
</html>