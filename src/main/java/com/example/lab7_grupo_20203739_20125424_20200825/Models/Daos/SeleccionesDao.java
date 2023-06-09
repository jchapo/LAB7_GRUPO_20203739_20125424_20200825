package com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionesDao extends BaseDao {
    public ArrayList<Seleccion> listarSelecciones() {

        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from seleccion")) {

            while (rs.next()) {
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                listaSelecciones.add(seleccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return listaSelecciones;
    }


}
