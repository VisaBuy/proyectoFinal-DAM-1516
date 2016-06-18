

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width; initial-scale=1.0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--<link href="bootstrap/css/estilos.css" rel="stylesheet"> -->
        <title>Registrar Usuario</title>
    </head>
    <body>
        
        <form action="registro" method="POST" class="form-horizontal">
                    <h1>Formulario de registro</h1>
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
            <!-- Fin Apellido -->

            <!-- Sueldo -->
            <div class="form-group">
                <label class="control-label col-xs-3">Sueldo:</label>
                <div class="col-xs-3">
                    <input type="number" name="sueldo" step="any" class="form-control" aria-label="Amount (to the nearest dollar)">
                </div>
            </div>
            <!-- Fin sueldo-->
            <!--Usuario -->
            <div class="form-group">
                <label class="control-label col-xs-3">Usuario:</label>
                <div class="col-xs-5">
                    <input type="text"  name="usuario"class="form-control" placeholder="Usuario">
                </div>
            </div>
            <!--Fin usuario-->
          <!--Contraseña-->
            <div class="form-group">
                <label class="control-label col-xs-3">Contraseña:</label>
                <div class="col-xs-5">
                    <input type="password" name="contrasena" class="form-control" id="inputPassword" placeholder="Contraseña" required>
                </div>
            </div>
          <!--Fin de contraseña-->
          <!--Contraseña-->
            <div class="form-group">
                <label class="control-label col-xs-3">Confirmar contraseña:</label>
                <div class="col-xs-5">
                    <input type="password"  class="form-control" id="inputPassword" placeholder="Contraseña" required>
                </div>
            </div>
          <!--Fin de contraseña-->
                    
          <!--Enviar o limpiar-->
            <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <input type="submit" class="btn btn-primary" value="Registrar">
            <input type="reset" class="btn btn-default" value="Limpiar">
        </div>
        </div>
            <!--Fin de registrar y limpiar-->
            <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        </form>
    </body>
</html>
