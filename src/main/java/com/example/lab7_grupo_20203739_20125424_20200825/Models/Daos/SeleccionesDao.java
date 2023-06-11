package com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Estadio;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionesDao extends BaseDao {
    public ArrayList<Seleccion> listarSelecciones() {

        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        String sql = "SELECT s.idSeleccion AS 'ID', s.nombre AS 'Nombre', s.tecnico AS 'Técnico', e.nombre AS 'Estadio',\n" +
                "(SELECT CONCAT(sl.nombre, ' vs ', sv.nombre) FROM lab7.partido p INNER JOIN lab7.seleccion sl ON p.seleccionLocal = sl.idSeleccion INNER JOIN lab7.seleccion sv ON p.seleccionVisitante = sv.idSeleccion WHERE p.fecha = (SELECT MIN(p.fecha) FROM lab7.partido p WHERE s.idSeleccion IN (p.seleccionLocal, p.seleccionVisitante) AND p.fecha IS NOT NULL)) AS 'Primer partido equipos'\n" +
                "FROM lab7.seleccion s\n" +
                "INNER JOIN lab7.estadio e ON s.estadio_idEstadio = e.idEstadio";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Seleccion seleccion = fetchSeleccionData(rs);
                listaSelecciones.add(seleccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaSelecciones;
    }
    public Seleccion obtenerSeleccion(int seleccionId) {

        Seleccion seleccion = null;

        String sql = "SELECT s.idSeleccion AS 'ID', s.nombre AS 'Nombre', s.tecnico AS 'Técnico', e.nombre AS 'Estadio',\n" +
                "(SELECT CONCAT(sl.nombre, ' vs ', sv.nombre) FROM lab7.partido p INNER JOIN lab7.seleccion sl ON p.seleccionLocal = sl.idSeleccion INNER JOIN lab7.seleccion sv ON p.seleccionVisitante = sv.idSeleccion WHERE p.fecha = (SELECT MIN(p.fecha) FROM lab7.partido p WHERE s.idSeleccion IN (p.seleccionLocal, p.seleccionVisitante) AND p.fecha IS NOT NULL)) AS 'Primer partido equipos'\n" +
                "FROM lab7.seleccion s\n" +
                "INNER JOIN lab7.estadio e ON s.estadio_idEstadio = e.idEstadio\n" +
                "WHERE s.idSeleccion = ?;";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, seleccionId);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    seleccion = fetchSeleccionData(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return seleccion;
    }
    public void guardarSeleccion(Seleccion seleccion) {

        String sql = "INSERT INTO lab7.seleccion (nombre, tecnico, estadio_idEstadio) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setSeleccionData(seleccion, pstmt);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void borrarSeleccion(int seleccionId) {

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM lab7.seleccion WHERE (idSeleccion = ?)")) {

            pstmt.setInt(1, seleccionId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private Seleccion fetchSeleccionData(ResultSet rs) throws SQLException {
        Seleccion seleccion = new Seleccion();
        seleccion.setIdSeleccion(rs.getInt(1));
        seleccion.setNombre(rs.getString(2));
        seleccion.setTecnico(rs.getString(3));

        Estadio estadio = new Estadio();
        estadio.setNombre(rs.getString(4));

        if (estadio.getNombre() != null) {
            seleccion.setEstadio(estadio);
        }

        seleccion.setPrimerPartido(rs.getString(5));

        return seleccion;
    }
    private void setSeleccionData(Seleccion seleccion, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, seleccion.getNombre());
        pstmt.setString(2, seleccion.getTecnico());
        pstmt.setInt(3, seleccion.getIdSeleccion());
    }

}
