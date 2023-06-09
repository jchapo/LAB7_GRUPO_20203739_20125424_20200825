
<%@page import="com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaJugadores" type="java.util.ArrayList<com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador>" scope="request"/>

<!DOCTYPE html>
<html>
<head>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
          crossorigin="anonymous"></script>

  <title>FUTBOL</title>
</head>
<body>
<div class='container'>
  <h1 class='mb-3'>Clasificatorias Sudamericanas Mundial 2026</h1>
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item" ><a href="<%=request.getContextPath()%>/jugadores">Jugadores</a></li>
      <li class="breadcrumb-item active"><a href="<%=request.getContextPath()%>/ServletSeleccion">Selecciones</a></li>
    </ol>
  </nav>
  <a href="<%= request.getContextPath()%>/jugadores?action=agregar" class="btn btn-primary mb-4">
    Agregar nuevo jugador</a>
  <table class="table">
    <thead>
    <tr>
      <th>#</th>
      <th>Jugador</th>
      <th>Edad</th>
      <th>Posicion</th>
      <th>Club</th>
      <th>Seleccion</th>
    </tr>
    </thead>
    <tbody>
      <% for (Jugador jug : listaJugadores) { %>
      <tr>
        <td><%= jug.getIdJugador()%>
        </td>
        <td><%= jug.getNombre()%>
        </td>
        <td><%= jug.getEdad()%>
        </td>
        <td><%= jug.getPosicion()%>
        </td>
        <td><%= jug.getClub()%>
        </td>
        <td><%= jug.getSeleccion().getNombre()%>
      </tr>
      <% } %>
    </tbody>
  </table>
</div>

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
