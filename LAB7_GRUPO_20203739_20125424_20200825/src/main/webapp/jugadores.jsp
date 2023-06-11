
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
<body class="bg-dark text-white">
<div class='container'class="bg-primary text-white">
  <div class="d-flex align-items-center">
    <h1 class="mb-3">Clasificatorias Sudamericanas Mundial 2026</h1>
    <a href="<%=request.getContextPath()%>/ServletJugadores" class="logo ml-auto">
      <img src="/LAB7_GRUPO_20203739_20125424_20200825_war_exploded/assets/images/mundial_2026.png" alt="" style="width: 300px;">
    </a>
  </div>
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item" ><a href="<%=request.getContextPath()%>/ServletJugadores">Jugadores</a></li>
      <li class="breadcrumb-item active"><a href="<%=request.getContextPath()%>/selecciones">Selecciones</a></li>
    </ol>
  </nav>
  <a href="<%= request.getContextPath()%>/ServletJugadores?action=agregar" class="btn btn-primary mb-4">
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
      <% int i=1; %>
      <% for (Jugador jug : listaJugadores) { %>
      <tr>
        <td><%= i%>
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
            <% i=i+1; %>
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
