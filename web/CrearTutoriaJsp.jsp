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
                            <select class="form-select" name="idrol" id="">
                                <option value="-1">Seleccione Curso</option>
                                <option value="opcion 1">opcion 1</option>
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
                    <tr>
                        <th scope="row">1</th>
                        <td>Programacion Movil</td>
                        <td>2023-08-23</td>
                        <td>Ingenieria</td>
                        <td>4:00</td>
                        <td>6:00</td>
                        <td><a class="btn btn btn-secondary btn_add_tutoria" href="#" role="button">Eliminar</a></td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Programacion Orientado Objetos</td>
                        <td>2023-10-12</td>
                        <td>Ingenieria</td>
                        <td>12:00</td>
                        <td>2:00</td>
                        <td><a class="btn btn btn-secondary btn_add_tutoria" href="#" role="button">Eliminar</a></td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Ecuaciones Diferenciales</td>
                        <td>2023-12-23</td>
                        <td>Calculo</td>
                        <td>15:00</td>
                        <td>18:00</td>
                        <td><a class="btn btn btn-secondary btn_add_tutoria" href="#" role="button">Eliminar</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="footer">
            <strong>Universidad de Lima - Grupo 5</strong>
        </div>
    </body>
</html>
