<%-- 
    Document   : modificarGasto
    Created on : 11-jun-2016, 11:43:10
    Author     : jhon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <title>Modificar gasto</title>
    </head>
    <body>
          <form action="modificar" method="POST" class="form-horizontal">
              <!--Identificador del gasto-->
              <div class="form-group">
                <label class="control-label col-xs-3">ID gasto:</label>
                <div class="col-xs-5">
                    <input type="number"  step="any"  name="idgasto" class="form-control"  required value=${param.id}>
                </div>
            </div>
              
              <!-- Cantidad-->
            <div class="form-group">
                <label class="control-label col-xs-3">Cantidad:</label>
                <div class="col-xs-5">
                    <input type="number"  step="any"  name="cantidad"class="form-control" placeholder="Ejem: 50.32" required
                           value=${param.cant}>
                </div>
            </div>
            <!--Fin Cantidad-->
            <!--Apellido-->
            <div class="form-group">
                <label class="control-label col-xs-3">Tipo:</label>
                <div class="col-xs-5">
                    <input type="text" name="tipo" class="form-control" placeholder="Ejem: Deporte" required value=${param.tip}>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Idusuario:</label>
                <div class="col-xs-5">
                    <input type="number" name="idusuario" class="form-control" placeholder="Ejem: 1" required value=${param.usu}>
                </div>
            </div>
            
              <!--Enviar o limpiar-->
            <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input type="submit" class="btn btn-primary" value="Modificar">
           <a href="gastos.jsp" class="btn btn-danger btn-sm active" role="button">Volver</a>
            
        </div>
        </div>
              <font color="green"><c:out value="Gasto insertado correctamente"/></font>
        </form>
    </body>
    <script src="bootstrap/js/bootstrap.js"></script>
</html>
