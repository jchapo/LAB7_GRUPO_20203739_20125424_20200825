<%@page import="com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion"%>
<%@ page import="com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Estadio" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaEstadios" type="java.util.ArrayList<com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Estadio>" scope="request"/>

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
            <form method="POST" action="selecciones?action=guardar" class="col-md-6 col-lg-6">
                <h2 class='mb-3'>Nueva Seleccion</h2>
                <hr>
                <div class="mb-3">
                    <label for="nombre_seleccion">Nombre de selección</label>
                    <input type="text" class="form-control form-control-sm" name="nombre_seleccion" id="nombre_seleccion">
                </div>
                <div class="mb-3">
                    <label for="tecnico">Técnico</label>
                    <input type="text" class="form-control form-control-sm" name="tecnico" id="tecnico">
                </div>
                <div class="mb-3">
                    <label for="estadio">Estadio </label>
                    <select class="form-select" name="estadioId">
                        <option value="0">Seleccione estadio</option>
                        <% for (Estadio estadio : listaEstadios) { %>
                        <option value="<%=estadio.getIdEstadio()%>"><%=estadio.getNombre()%></option>
                        <% } %>
                    </select>
                </div>
                <a href="<%= request.getContextPath()%>/selecciones" class="btn btn-danger">Cancelar</a>
                <input type="submit" value="Guardar" class="btn btn-primary"/>
            </form>
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
