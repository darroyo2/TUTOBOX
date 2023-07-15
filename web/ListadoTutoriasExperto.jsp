<%@page import="dao.TutoriaDao"%>
<%@page import="entity.Tutoria"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tutorias del experto</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-2">
            <div class="row mb-2">
                <div class="col-10">
                    <h1 style="margin-top: 10px"></h1>
                </div>
                <div class="col-2">
                    <a style="margin-top: 10px" href="EliminarTutoriaServlet?accion=atras" class="btn btn-dark btn_add_tutoria">Regresar</a>
                </div>
            </div>
            <div class="card">
                <div class="card-header">
                    Lista de Tutorías del Experto
                </div>
                <div class="card-body">
                    <div class="list-group">
                        <%
                            int idEstudiante = Integer.parseInt(String.valueOf(session.getAttribute("UsuarioCodigo")));
                            int idTutor = 4;
                                    //Integer.parseInt(String.valueOf(session.getAttribute("IdTutor")
                             List<Tutoria> tutorias = TutoriaDao.obtnerListaTutoriasDisponibles(idTutor);
                            for (Tutoria tutoria : tutorias) { // Iterar sobre la lista de tutorias
                                int id = tutoria.getId();
                                String tema = tutoria.getTema();
                                String fecha = tutoria.getFecha();
                                String horaIn = tutoria.getHoraIni();
                                String horaFn = tutoria.getHoraFin();
                        %>

                        <div class="row mt-3">
                            <div class="col-10">
                                    <h5 class="mb-1">Tema: <%= tema%></h5>
                                    <p class="mb-1">Fecha: <%= fecha%></p>
                                    <p class="mb-1">Hora de Inicio: <%= horaIn%></p>
                                    <p class="mb-1">Hora de Fin: <%= horaFn%></p>
                                </a> 
                            </div>
                            <div class="col-2">
                                <a class="btn btn btn-secondary btn_add_tutoria" href="InscripcionTutoriaServlet?accion=inscribir&id=<%= id%>&<%=idEstudiante%>" role="button">Registrarme</a>
                            </div>
                        </div>
                        <% } // Fin del bucle for %>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>




