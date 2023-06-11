package com.example.lab7_grupo_20203739_20125424_20200825.Controllers;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos.EstadioDao;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos.SeleccionesDao;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Estadio;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletSeleccion", value = "/selecciones")
public class ServletSeleccion extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        RequestDispatcher view;
        SeleccionesDao seleccionesdao = new SeleccionesDao();
        EstadioDao estadioDao = new EstadioDao();

        switch (action) {
            case "listar":
                request.setAttribute("listaSelecciones", seleccionesdao.listarSelecciones());
                view = request.getRequestDispatcher("selecciones.jsp");
                view.forward(request, response);
                break;
            case "agregar":
                request.setAttribute("listaEstadios", estadioDao.listarEstadios());
                view = request.getRequestDispatcher("agregarSeleccion.jsp");
                view.forward(request, response);
                break;

            /*case "editar":
                if (request.getParameter("id") != null) {
                    String employeeIdString = request.getParameter("id");
                    int employeeId = 0;
                    try {
                        employeeId = Integer.parseInt(employeeIdString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("EmployeeServlet");
                    }

                    Employee emp = employeeDao.obtenerEmpleado(employeeId);

                    if (emp != null) {
                        request.setAttribute("empleado", emp);
                        request.setAttribute("listaEmpleados",employeeDao.listarEmpleados());
                        request.setAttribute("listaTrabajos",jobDao.obtenerListaTrabajos());
                        request.setAttribute("listaDepartamentos",departmentDao.lista());
                        view = request.getRequestDispatcher("employees/formularioEditar.jsp");
                        view.forward(request, response);
                    } else {
                        response.sendRedirect("EmployeeServlet");
                    }

                } else {
                    response.sendRedirect("EmployeeServlet");
                }

                break;*/
            case "borrar":
                if (request.getParameter("id") != null) {
                    String seleccionIdString = request.getParameter("id");
                    int seleccionId = 0;
                    try {
                        seleccionId = Integer.parseInt(seleccionIdString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("selecciones");
                    }

                    Seleccion seleccion = seleccionesdao.obtenerSeleccion(seleccionId);

                    if (seleccion != null) {
                        seleccionesdao.borrarSeleccion(seleccionId);
                    }
                }

                response.sendRedirect("selecciones");
                break;
            }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        SeleccionesDao seleccionesdao = new SeleccionesDao();
        Seleccion seleccion = setSeleccionData(request);

        switch (action) {
            case "guardar":
                seleccionesdao.guardarSeleccion(seleccion);
                response.sendRedirect("selecciones");
                break;
        }

    }

    private Seleccion setSeleccionData(HttpServletRequest request) {
        Seleccion seleccion = new Seleccion();
        seleccion.setNombre(request.getParameter("nombre_seleccion"));
        seleccion.setTecnico(request.getParameter("tecnico"));
        seleccion.setIdSeleccion(Integer.parseInt(request.getParameter("estadioId")));
        return seleccion;
    }

}
