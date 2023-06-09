package com.example.lab7_grupo_20203739_20125424_20200825.Controllers;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos.JugadoresDao;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos.SeleccionesDao;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "ServletJugadores", value = "/jugadores")
public class ServletJugadores extends HttpServlet {
    @Override
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

    private Jugador setJugadorData(HttpServletRequest request) {
        Jugador jugador = new Jugador();
        jugador.setNombre(request.getParameter("nombre"));
        jugador.setEdad(Integer.parseInt(request.getParameter("edad")));
        jugador.setPosicion(request.getParameter("posicion"));
        jugador.setClub(request.getParameter("club"));

        Seleccion seleccion = new Seleccion();
        seleccion.setIdSeleccion(Integer.parseInt(request.getParameter("idSeleccion")));
        jugador.setSeleccion(seleccion);

        return jugador;
    }
}
