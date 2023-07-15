<%@page import="dao.UsuarioDao"%>
<%@page import="entity.Usuario"%>
<%@page import="dao.TutoriaDao"%>
<%@page import="entity.Tutoria"%>
<%@page import="dao.CursoDao"%>
<%@page import="entity.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.guardarPublicacionServlet"%>
<%@page import="dao.PublicacionDao"%>
<%@page import="entity.Publicacion"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>:::Bienvenido al Sistema:::</title>
    <link rel="stylesheet" href="Recursos/Bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="Recursos/CSSPropio/newcss.css"/>
    <script src="Recursos/Bootstrap/js/bootstrap.min.js"></script>
    <script src="Recursos/JsPropio/ValidaJS.js"></script>
    <style>
        .card {
            margin-bottom: 20px;
        }
        .btn.btn-primary {
            margin-bottom: 20px;
            width: 100%;
        }
    </style>
</head>
<body>  
    <div class="header">
        <center><b>Bienvenido</b></center>
    </div>

    <div class="container-fluid">
        <div class="row" style="margin-top: 100px;">
            <div class="col-2" style="align-content: center;">
                <div style="border: 1px solid black; padding: 10px;">
                    <%  int idExperto = Integer.parseInt(String.valueOf(request.getSession().getAttribute("idExpertoAux")));%>
                    <center><strong><p class="text-dark">Datos del Profesor:</p></strong></center>
                    <center><b>Nombre: <%= UsuarioDao.obtenerNombrePorUsuarioId(idExperto) %> </b></center>
                    <center><b>Apellido: <%= UsuarioDao.obtenerApellidoPorUsuarioId(idExperto)%></b></center>
                    <center><b>Rol: <%= String.join(", ", (List<String>) UsuarioDao.obtenerNombreRolesUsuario(idExperto))%></b></center>
                </div>
                &nbsp;
                <center>
                    <div class="col-12">
                        <button class="btn btn-primary" onclick="redireccionar('EnviarMensaje.jsp')">Enviar Mensaje</button>
                    </div>
                    <div class="col-12">
                        <button class="btn btn-primary" onclick="redireccionar('ListadoTutoriasExperto.jsp')">Consultar Tutorías</button>
                    </div>
                </center>
            </div>
            <div class="col-10">
                <% List<Publicacion> publicaciones = PublicacionDao.obtenerListaPublicaciones(idExperto);
                %>

                <div class="container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Documento</th>
                                <th>Publicacion</th>
                                <th>Descripcion</th>
                                <th>Tipo de Curso</th>
                                <th>Fecha de Publicacion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Publicacion publicacion : publicaciones) { %>
                                <tr>
                                    <td><%= guardarPublicacionServlet.obtenerNombreArchivo(publicacion.getTitulo()) %></td>
                                    <td><%= publicacion.getTitulo()%></td>
                                    <td><%= publicacion.getCuerpo() %></td>
                                    <td><%= CursoDao.NombreCurso(publicacion.getIdCurso())%></td>
                                    <td><%= publicacion.getFecha() %></td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="footer">
        <strong></strong>
    </div>
</body>
</html>

