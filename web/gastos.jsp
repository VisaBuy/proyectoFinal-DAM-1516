<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(false);
    String usu = (String) sesion.getAttribute("usuario");
    if (usu.equals("")) {
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="bootstrap/js/control.js"></script>

        <meta name="viewport" content="width=device-width; initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gastos</title>
    </head>
    <body>
        <jsp:useBean id="os" class="controlador.ConsultarGastos"/>
        <div>
            <h1><% out.println(usu); %></h1><br>
            <a href="index.jsp"> ${session.invalidate()} cerrar</a> 

        </div>
        <form action="inserta" method="POST" class="form-horizontal">
            <!-- nombre-->
            <div class="form-group">
                <label class="control-label col-xs-3">Cantidad:</label>
                <div class="col-xs-5">
                    <input type="number"  step="any"  name="cantidad"class="form-control" placeholder="Ejem: 50.32" required>
                </div>
            </div>
            <!--Fin nombre-->
            <!--Apellido-->
            <div class="form-group">
                <label class="control-label col-xs-3">Tipo:</label>
                <div class="col-xs-5">
                    <input type="text" name="tipo" class="form-control" placeholder="Ejem: Deporte" required >
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Idusuario:</label>
                <div class="col-xs-5">
                    <input type="number" name="idusuario" class="form-control" placeholder="Ejem: 1" required >
                </div>
            </div>

            <!--Enviar o limpiar-->
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <input type="submit" class="btn btn-primary" value="Ingresar">
                    <input type="reset" class="btn btn-default" value="Borrar">

                </div>
            </div>
        </form>
        <!-- Fin de formulario-->
        <!--Tabla  de gastos-->
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <!--      <th>Id</th>-->
                        <th>Cantidad</th>
                        <th>Tipo</th>
                        <th>Fecha</th>
                        <th>IdUsuario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>            
                        <!-- Recorro las lista que genera la consulta para mostrarla en filas en la web-->        
                        <c:forEach var="gast" items="${os.verTodosLosGastos()}">
                        <tr> 
                            <td><c:out value="${gast.cantidad}€"></c:out></td>
                            <td><c:out value="${gast.tipo}"></c:out></td>
                            <td><c:out value="${gast.fecha}"></c:out></td>
                            <td><c:out value="${gast.idusuario}"></c:out></td>
                                <td> 
                                    <!--Botones para realizar acciones con cada registro.-->
                                    <a  href="modificarGasto.jsp?tip='${gast.tipo}'&cant='${gast.cantidad}'&usu='${gast.idusuario}'&id='${gast.idgasto}'" class="btn btn-default btn-sm active" role="button">Modificar</a>
                                <a type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModal">Eliminar</a> 

                                <div class="modal fade" id="myModal" role="dialog">
                                    <div class="modal-dialog">

                                        <!--Cpntenido de la ventana modal-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Eliminar datos.</h4>
                                            </div>
                                            <div class="modal-body">
                                                <p><% out.println(usu);%>, desea eliminar el gasto? </p>
                                            </div>
                                            <div class="modal-footer">
                                                <a type="button" class="btn btn-default" data-dismiss="modal">Cancelar</a>
                                                <a  href="eliminar?identificadorDeGasto=${gast.idgasto}" class="btn btn-danger btn-sm active" role="button"  >Eliminar</a>
                                            </div>
                                        </div><!-- Fin del contenido modal-->

                                    </div>
                                </div> 

                            </td>
                        </tr>      
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!--Script's -->

    </body>
</html>
