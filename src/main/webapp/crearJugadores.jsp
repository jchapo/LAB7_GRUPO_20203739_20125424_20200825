<%--
  Created by IntelliJ IDEA.
  User: djcll
  Date: 9/06/2023
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>

<%@page import="com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaSelecciones" type="java.util.ArrayList<com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion>" scope="request"/>

<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>

    <title>Nuevo Jugador</title>
</head>
<body>
<div class='container'>
    <form method="POST" action="ServletJugadores?action=guardar" class="col-md-6 col-lg-6">
        <h1 class='mb-3'>Nuevo jugador</h1>
        <hr>
        <div class="mb-3">
            <label for="nombre">Nombre Completo</label>
            <input type="text" class="form-control form-control-sm" name="nombre" id="nombre">
        </div>
        <div class="mb-3">
            <label for="edad">Edad</label>
            <input type="text" class="form-control form-control-sm" name="edad" id="edad">
        </div>
        <div class="mb-3">
            <label for="posicion">Posicion</label>
            <input type="text" class="form-control form-control-sm" name="posicion" id="posicion">
        </div>
        <div class="mb-3">
            <label for="club">Club</label>
            <input type="text" class="form-control form-control-sm" name="club" id="club">
        </div>

        <div class="mb-3">
            <label for="idSeleccion">Seleccion</label>
            <select class="form-select" name="idSeleccion">
                <% for (Seleccion seleccion : listaSelecciones) { %>
                <option value="<%=seleccion.getIdSeleccion()%>">
                    <%=seleccion.getNombre()%>
                </option>
                <% } %>
            </select>
        </div>

        <a href="<%= request.getContextPath()%>/ServletJugadores" class="btn btn-danger">Cancelar</a>
        <input type="submit" value="Guardar" class="btn btn-primary"/>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0
.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min
.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/p
opper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.
min.js"></script>
</html>
</html>

