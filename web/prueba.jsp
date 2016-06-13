<%-- 
    Document   : prueba
    Created on : 13-jun-2016, 18:53:56
    Author     : jhon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
         <link href="bootstrap/css/estilos.css" rel="stylesheet">
         <!--Scripts -->
         <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
 
<div class="container">
  <h2>Modal Example</h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <a type="button" class="btn btn-default" data-dismiss="modal">Cancelar</a>
           <a  href="eliminar?identificadorDeGasto=${gast.idgasto}" class="btn btn-danger btn-sm active" role="button"  data-dismiss="modal">Eliminar</a>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
        
        <!--Scripts -->
         <script src="bootstrap/js/jquery-2.2.4.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>
