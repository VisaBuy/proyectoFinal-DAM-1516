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
        <!--CSS-->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--JS-->
        <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        <script src="bootstrap/js/control.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width; initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function myFunction(id) {
                var txt;
                var r = confirm("¿Desea eliminar el gasto?");
                if (r == true) {
                    location.href = "eliminar?identificadorDeGasto=" + id;
                }

            }
        </script>
        <title>Gastos</title>
    </head>
    <body>
        <jsp:useBean id="os" class="controlador.ConsultarGastos"/>
        <!--Desplegable de usuario con la opción de 'Cerrar sesión'-->
        <div class="center-block">                                        
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><% out.println(usu);%>
                    <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a href="cerrar">Cerrar sesión</a></li>
                </ul>
            </div>
            <!--Fin desplegable-->
            <form action="inserta" method="POST" class="form-horizontal">
                <!-- Cantidad-->
                <div class="form-group">
                    <label class="control-label col-xs-3">Cantidad:</label>
                    <div class="col-xs-5">
                        <input type="number"  step="any"  name="cantidad"class="form-control" placeholder="Ejem: 50.32" required>
                    </div>
                </div>
                <!--Fin Cantidad-->
              
                <div class="form-group">
                    <label class="control-label col-xs-3"><!--Idusuario:--></label>
                    <div class="col-xs-5">
                        <input type="text" name="gUsuario" style="display:none" class="form-control" value="<% out.println(usu);%>"  >
                    </div>
                </div>
                <!--Seleccionar tipo-->
                <div class="form-group">
                    <label class="control-label col-xs-3">Tipo:</label>
                    <div class="col-xs-5">
                        <select class="form-control" id="sel1" name="tipo" required>
                            <!--Lista de tipos de gastos.-->
                            <option>Comida</option>
                            <option>Deporte</option>
                            <option>Electrónica</option>
                            <option>Gasolina</option>
                            <option>Ocio</option>
                            <option>Otro</option>
                            <option>Transporte</option>
                        </select>
                    </div>
                </div>
                <!--Fin de selecionar tipo-->
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
                            <th>Usuario</th>
                            <th>Acciones</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>            
                            <!-- Recorro las lista que genera la consulta para mostrarla en filas en la web-->        
                            <c:forEach var="gast" items="${os.verTodosLosGastos()}">
                            <tr> 
                                <td><c:out value="${gast.getCantidad()}€"></c:out></td>
                                <td><c:out value="${gast.getTipo()}"></c:out></td>
                                <td><c:out value="${gast.getFecha()}"></c:out></td>
                                <td><c:out value="${gast.getIdusuario()}"></c:out></td>

                                    <td> 
                                        <!--Botones para realizar acciones con cada registro. data-target="#eliminarModal" data-toggle="modal"-->
                                        <a type="button" onclick="myFunction(${gast.getIdgasto()})" class="btn btn-danger btn-sm"   >Eliminar</a> 
                                    <a type="button"  class="btn btn-default btn-sm active" href="modificarGasto.jsp?idg='${gast.getIdgasto()}'&cant='${gast.getCantidad()}'&tip=${gast.getTipo()}&usu=${gast.getIdusuario()}">Modificar</a>

                                    <div class="modal fade" id="eliminarModal" role="dialog">

                                        <div class="modal-dialog">

                                            <!--Contenido de la ventana modal-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Eliminar datos.</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>¿<% out.println(usu);%>, desea eliminar el gasto? </p>
                                                </div>
                                                <div class="modal-footer">

                                                    <a type="button" class="btn btn-default btn-sm" data-dismiss="modal">No</a>
                                                    <a href="eliminar?identificadorDeGasto=${gast.getIdgasto()}" class="btn btn-danger btn-sm active"   >Sí</a>

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
        </div> 
    </body>
</html>
