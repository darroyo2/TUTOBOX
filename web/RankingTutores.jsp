
<%@page import="dao.RankingDao"%>
<%@page import="entity.Ranking"%>
<%@page import="dao.CursoDao"%>
<%@page import="entity.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
        <title>Document</title>
    </head>

    <body class="container">
        <%
            List<Curso> cursos = new ArrayList<>(); // Llamada a la función obtenerMensajes() para obtener la lista de mensajes
            cursos = CursoDao.listarCursos();
            
            System.out.println("hola 2");
            System.out.println(request.getSession().getAttribute("idCursoAux"));
            List<Ranking> ranking = new ArrayList<>(); // Llamada a la función obtenerMensajes() para obtener la lista de mensajes
            ranking = RankingDao.listarCursos(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idCursoAux"))));

        %>

        <form action="RankingTutoresServlet" class="mt-3">
            <div class="row g-3 align-items-center">
                <div class="col-auto">
                    <label for="inputPassword6" class="col-form-label">Contraseña</label>
                </div>
                <div class="col-auto">
                    <select class="form-select" name="idCurso" id="">
                        <option value="-1">Seleccione Curso</option>
                        <%for (Curso c : cursos) {
                        %>
                        <option value="<%= c.getIdCurso()%>"><%= c.getNombre()%></option>
                        <%
                            }
                        %>
                    </select>
                </div>
                <div class="col-auto">
                    <button type="submit" name="accion" value="buscar" class="btn btn-dark btn_add_tutoria">Buscar</button>
                </div>
            </div>

        </form>

        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre Curso</th>
                    <th scope="col">Nombre de Usuario</th>
                    <th scope="col">Cant tutorias</th>
                    <th scope="col">Promedio</th>
                    <th scope="col">Accion</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Ranking r : ranking) {
                %>
                <tr>
                    <td>1</td>
                    <td><%= r.getNombreCurso()%></td>
                    <td><%= r.getNombreUsuarioExperto()%></td>
                    <td><%= r.getTotalTutorias()%></td>
                    <td><%= r.getPromedio()%></td>
                    <td><a class="btn btn btn-secondary btn_add_tutoria" href="RankingTutoresServlet?accion=verPerfil&id=<%= r.getIdUsuarioExperto()%>" role="button">Ver Perfil</a></td>
                </tr>
                 <%
                     }
                %>
            </tbody>
        </table>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
            integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
            integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
    crossorigin="anonymous"></script>

</html>