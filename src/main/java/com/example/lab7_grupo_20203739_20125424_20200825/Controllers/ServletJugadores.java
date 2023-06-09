package com.example.lab7_grupo_20203739_20125424_20200825.Controllers;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos.JugadoresDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletJugadores", value = "/ServletJugadores")
public class ServletJugadores extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        RequestDispatcher view;
        JugadoresDao jugadoresDao = new JugadoresDao();

        switch(action){
            case"listar":
                request.setAttribute("listaJugadores", jugadoresDao.listarJugadores());
                view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
