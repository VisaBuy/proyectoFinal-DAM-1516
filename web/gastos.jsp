<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
HttpSession sesion = request.getSession(false);
String usu = (String) sesion.getAttribute("usuario");
if(usu.equals("")){
    response.sendRedirect("index.jsp");
}

%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width; initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gastos</title>
    </head>
    <body>
        <jsp:useBean id="os" class="controlador.ConsultarGastos"/>
        <div>
            <h1><% out.println(usu); %></h1>
        
        <form action="registro" method="POST" class="form-inline">
            <!-- nombre-->
            <div class="form-group">
                <label class="control-label col-xs-3">Nombre:</label>
                <div class="col-xs-5">
                    <input type="text"  name="nombre"class="form-control" placeholder="Nombre">
                </div>
            </div>
            <!--Fin nombre-->
            <!--Apellido-->
            <div class="form-group">
                <label class="control-label col-xs-3">Apellido:</label>
                <div class="col-xs-5">
                    <input type="text" name="apellido" class="form-control" placeholder="Apellido">
                </div>
            </div>
        </div>
        
             <!--Tabla  de gastos-->
            <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Cantidad</th>
                  <th>Tipo</th>
                  <th>Fecha</th>
                  <th>IdUsuario</th>
                </tr>
              </thead>
               <tbody>
                <tr>            
                <!-- Recorro las lista que genera la consulta para mostrarla en filas en la web-->        
               <c:forEach var="gast" items="${os.verTodosLosGastos()}">
                    <tr> 
                            <td><c:out value="${gast.idgasto}"></c:out></td>
                          <td><c:out value="${gast.cantidad}€"></c:out></td>
                          <td><c:out value="${gast.tipo}"></c:out></td>
                          <td><c:out value="${gast.fecha}"></c:out></td>
                          <td><c:out value="${gast.idusuario}"></c:out></td>
                     </tr>      
                   
               </c:forEach>
               </tbody>
            </table>
          </div>
        <!--Scripts -->
        <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>
