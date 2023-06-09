package com.example.lab7_grupo_20203739_20125424_20200825.Controllers;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos.JugadoresDao;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos.SeleccionesDao;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletSeleccion", value = "/seleccion")
public class ServletSeleccion extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RequestDispatcher view;
        JugadoresDao jugadoresDao = new JugadoresDao();
        SeleccionesDao seleccionesDao = new SeleccionesDao();

        switch(action){
            case"listar":
                request.setAttribute("listaJugadores", jugadoresDao.listarJugadores());
                view = request.getRequestDispatcher("jugadores.jsp");
                view.forward(request, response);
                break;

            case "agregar":

                request.setAttribute("listaSelecciones",seleccionesDao.listarSelecciones());
                view = request.getRequestDispatcher("crearJugadores.jsp");
                view.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");

        JugadoresDao jugadoresDao = new JugadoresDao();
        Jugador jugador = setJugadorData(request);

        switch (action) {
            case "guardar":
                jugadoresDao.guardarJugador(jugador);

                response.sendRedirect("ServletJugadores");
                break;
        }

    }

}
