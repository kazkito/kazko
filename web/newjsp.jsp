<%-- 
    Document   : newjsp
    Created on : 27/05/2014, 04:27:55 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar archivo</title>
    </head>
    <body>
        <h1>Cargar archivo</h1>
        <h2>Usando commons-fileupload</h2>
        <form method="POST" 
              action="${pageContext.servletContext.contextPath}/CargarArchivoServlet" 
              enctype="multipart/form-data">
            <label for="inputFile">Seleccione un archivo</label>
            <input type="file" name="inputFile" id="inputFile" value="" />
            <button>Cargar</button>
        </form>
    </body>
</html>
