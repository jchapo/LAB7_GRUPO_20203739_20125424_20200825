
<%@page import="com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaSelecciones" type="java.util.ArrayList<com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion>" scope="request"/>

<!DOCTYPE html>
<html>
<head>
  <jsp:include page="/includes/bootstrap_header.jsp"/>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
          crossorigin="anonymous"></script>

  <title>FUTBOL</title>
  <link rel="icon" href="/LAB7_GRUPO_20203739_20125424_20200825_war_exploded/assets/images/ball.png" type="image/x-icon">

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
      <li class="breadcrumb-item active"><a href="<%=request.getContextPath()%>/selecciones" class="active">Selecciones</a></li>
    </ol>
  </nav>
  <a href="<%= request.getContextPath()%>/selecciones?action=agregar" class="btn btn-primary mb-4">
    Agregar nueva selección</a>
  <table class="table text-white">
    <thead>
    <tr>
      <th>ID</th>
      <th>Nombre de selección</th>
      <th>Técnico de selección</th>
      <th>Estadio</th>
      <th>Primer partido</th>
      <th>
      </th>
    </tr>
    </thead>
    <tbody>
    <%
      for (Seleccion s : listaSelecciones) {
    %>
    <tr>
      <td><%=s.getIdSeleccion()%>
      </td>
      <td><%=s.getNombre()%>
      </td>
      <td><%=s.getTecnico()%>
      </td>
      <td><%=s.getEstadio().getNombre()%>
      </td>
      <td><%=s.getPrimerPartido()%>
      </td>
      <td>
        <a class="btn btn-danger"
           href="<%=request.getContextPath()%>/selecciones?action=borrar&id=<%=s.getIdSeleccion()%>">
          <i class="bi bi-trash3"></i>
        </a>
      </td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
</div>
<jsp:include page="/includes/bootstrap_footer.jsp"/>
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
