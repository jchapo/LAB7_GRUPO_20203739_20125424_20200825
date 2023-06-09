package com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadoresDao  extends BaseDao{
    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> listarJugadores = new ArrayList<>();
        // Query listo
        String sql = "SELECT j.idJugador, j.nombre, j.edad, j.posicion, j.club, s.nombre  FROM jugador j\n" +
                "inner join seleccion s on j.sn_idSeleccion =s.idSeleccion;";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(rs.getInt(1)); //Números de la tabla selección
                seleccion.setNombre(rs.getString(2));
                jugador.setSeleccion(seleccion);

                listarJugadores.add(jugador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listarJugadores;
    }

}
