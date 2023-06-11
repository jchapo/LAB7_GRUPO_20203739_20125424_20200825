package com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadoresDao  extends BaseDao{
    public ArrayList<Jugador> listarJugadores() {

        ArrayList<Jugador> listarJugadores = new ArrayList<>();
        // Query listo
        String sql = "SELECT * FROM jugador j\n" +
                "inner join seleccion s on j.sn_idSeleccion = s.idSeleccion\n" +
                "order by j.idJugador;";

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

                seleccion.setIdSeleccion(rs.getInt(7));
                seleccion.setNombre(rs.getString(8));
                jugador.setSeleccion(seleccion);

                listarJugadores.add(jugador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listarJugadores;
    }
    public void guardarJugador(Jugador jugador) {

        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, jugador.getNombre());
            pstmt.setInt(2, jugador.getEdad());
            pstmt.setString(3, jugador.getPosicion());
            pstmt.setString(4, jugador.getClub());
            pstmt.setInt(5, jugador.getSeleccion().getIdSeleccion());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
