<%@page import="dao.TutoriaDao"%>
<%@page import="entity.Tutoria"%>
<%@page import="dao.CursoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Recursos/Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Recursos/CSSPropio/crearTutoria.css"/>
        <link rel="stylesheet" href="Recursos/CSSPropio/newcss.css"/>
        <script src="Recursos/Bootstrap/js/bootstrap.min.js"></script>
        <script src="Recursos/JsPropio/ValidaJS.js"></script>        
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Curso> cursos = new ArrayList<>(); // Llamada a la función obtenerMensajes() para obtener la lista de mensajes
            cursos = CursoDao.listarCursos();

            List<Tutoria> tutorias = new ArrayList<>();
            tutorias = TutoriaDao.obtenerListaTutorias(Integer.parseInt(String.valueOf(session.getAttribute("UsuarioCodigo"))));
        %>
        <div class="header">
            <center><b>Bienvenido</b></center>
        </div>
        <div class="container">
            <h1>CREACION DE TUTORIAS</h1>
            <div class="row border border-dark mt-3">
                <div class="col-9 mt-2">
                    <div class="row mb-2">
                        <div class="col-4">
                            <label for="">Tema</label>
                        </div>
                        <div class="col-8">
                            <input class="form-control" type="text">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <label for="">Fecha</label>
                        </div>
                        <div class="col-8">
                            <input class="form-control" type="text">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <label for="">Hora Inicio</label>
                        </div>
                        <div class="col-8">
                            <input class="form-control" type="text">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <label for="">Hora Fin</label>
                        </div>
                        <div class="col-8">
                            <input class="form-control" type="text">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-4">
                            <label for="">Curso</label>
                        </div>
                        <div class="col-8">
                            <select class="form-select" name="idCurso" id="">
                                <option value="-1">Seleccione Curso</option>
                                <%
                                    for (Curso c : cursos) {
                                %>
                                <option value="<%= c.getIdCurso()%>"><%= c.getNombre()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-3 mt-2">
                    <a href="/cliente" class="btn btn-dark btn_add_tutoria">Agregar</a>
                </div>
            </div>
            <h2 class="mt-2">Tutorias Creadas</h2>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Tema</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Hora Fin</th>
                        <th scope="col">Hora Fin</th>
                        <th scope="col">Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Tutoria t : tutorias) {
                    %>
                    <tr>
                        <th scope="row"><%= t.getId() %></th>
                        <td><%= t.getTema() %></td>
                        <td><%= t.getFecha() %></td>
                        <td><%= t.getIdCurso() %></td>
                        <td><%= t.getHoraIni() %></td>
                        <td><%= t.getHoraFin() %></td>
                        <td><a class="btn btn btn-secondary btn_add_tutoria" href="#" role="button">Eliminar</a></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <div class="footer">
            <strong>Universidad de Lima - Grupo 5</strong>
        </div>
    </body>
</html>
