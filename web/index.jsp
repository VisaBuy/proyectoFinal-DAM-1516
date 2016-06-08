
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesion</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
         <link href="bootstrap/css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <!-- Formulario de inicio de sesion-->
      <fieldset>
          <form action="login" method="POST" class="form-signin">
                <label>Usuario:</label><br> 
                <input type="text" name="user"required class="form-control" ><br> 
                <label>Contraseña:</label><br> 
                <input type="password" name="pass"required  class="form-control"><br>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Entrar">
            </form>
          </fieldset>
        <!-- Fin del formulario-->
        <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>
