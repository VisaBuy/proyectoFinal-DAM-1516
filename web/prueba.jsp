<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/estilos.css" rel="stylesheet">
      <!-- Scripts
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script> -->
        
        <script>
            
           function validarPasswd(){
            var p1 = document.getElementsByName("contrasena").value;
            var p2 = document.getElementsByName("contrasena2").value;
            
            var espacios = false;
            var cont = 0;

            while (!espacios && (cont < p1.length)) {
              if (p1.charAt(cont) == " ")
                espacios = true;
              cont++;
            }

            if (espacios) {
              alert ("La contraseña no puede contener espacios en blanco");
              return false;
            }
            
    }

        </script>

        
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-horizontal" onSubmit="validarPasswd()">
            <div class="form-group">
                <label class="control-label col-xs-3">Contraseña:</label>
                <div class="col-xs-3">
                    <input type="password" name="contrasena" class="form-control" id="inputPassword" placeholder="Contraseña" required>
                </div>
            </div>
             <!--Fin usuario-->
             <!--Contraseña-->
               <div class="form-group">
                <label class="control-label col-xs-3">Contraseña2:</label>
                <div class="col-xs-3">
                    <input type="password" name="contrasena2" class="form-control" id="inputPassword2" placeholder="Contraseña" required>
                </div>
            </div>
             <div class="form-group">
                                <div class="col-xs-offset-3 col-xs-9">
                                    <input type="submit" class="btn btn-primary btn-sm" value="Modificar">
                                    <a type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancelar</a>

                                </div>
                 </div>
        </form>
    </body>
</html>
