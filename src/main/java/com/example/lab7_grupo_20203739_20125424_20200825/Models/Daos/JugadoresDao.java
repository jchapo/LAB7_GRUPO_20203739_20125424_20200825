package com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Jugador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadoresDao  extends BaseDao{
    public ArrayList<Jugador> listaJugadores() {

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql = "select * FROM EMPLOYEES e " +
                "inner join jobs j on e.job_id = j.job_id " +
                "left join departments d on e.department_id = d.department_id " +
                "left join employees m on e.manager_id = m.employee_id " +
                "order by e.employee_id";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = fetchEmployeeData(rs);
                listaEmpleados.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaEmpleados;
    }

}
