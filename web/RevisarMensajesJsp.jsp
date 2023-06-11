

<%@page import="dao.UsuarioDao"%>
<%@page import="dao.MensajeDao"%>
<%@page import="entity.Mensaje"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bandeja de entrada</title>
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
                    Bandeja de entrada
                </div>
                <div class="card-body">
                    <div class="list-group">
                        <%
                            List<Mensaje> mensajes = MensajeDao.obtenerMensajePorId(Integer.parseInt(String.valueOf(session.getAttribute("UsuarioCodigo")))); // Llamada a la función obtenerMensajes() para obtener la lista de mensajes

                            for (Mensaje mensaje : mensajes) { // Iterar sobre la lista de mensajes
                                int id = mensaje.getId();
                                String asunto = mensaje.getAsunto();
                                String contenido = mensaje.getContenido();
                                String fecha = mensaje.getFecha();
                                int idEmisor = mensaje.getIdEmisor();
                                String nombre=UsuarioDao.obtenerNombrePorUsuarioId(idEmisor);
                        %>

                        <div class="row mt-3">
                            <div class="col-10">
                                <a href="mensaje.jsp?id=<%= id%>" class="list-group-item list-group-item-action">
                                    <h5 class="mb-1"><%= asunto%></h5>
                                    <p class="mb-1"><%= contenido%></p>
                                    <p class="mb-1"><%= nombre%></p>
                                    <small class="text-muted"><%= fecha%></small>
                                </a> 
                            </div>
                            <div class="col-2">
                                <button class="btn btn-secondary">Responder</button>
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




