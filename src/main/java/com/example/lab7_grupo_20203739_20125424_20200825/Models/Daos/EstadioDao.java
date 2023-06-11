package com.example.lab7_grupo_20203739_20125424_20200825.Models.Daos;

import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Estadio;
import com.example.lab7_grupo_20203739_20125424_20200825.Models.beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class EstadioDao extends BaseDao {
    public ArrayList<Estadio> listarEstadios() {

        ArrayList<Estadio> listaestadios = new ArrayList<>();

        String sql = "SELECT * FROM lab7.estadio";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estadio estadio = fetchEstadioData(rs);
                listaestadios.add(estadio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaestadios;
    }

    /*
    public Seleccion obtenerSeleccion(int employeeId) {

        Employee employee = null;

        String sql = "select * FROM EMPLOYEES e \n" +
                "inner join jobs j on e.job_id = j.job_id\n" +
                "left join departments d on e.department_id = d.department_id \n" +
                "left join employees m on e.manager_id = m.employee_id\n" +
                "where e.employee_id = ? \n" +
                "order by e.employee_id";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    employee = fetchEmployeeData(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employee;
    }

    public void guardarSeleccion(Seleccion seleccion) {

        String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            setEmployeeData(employee, pstmt);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarSeleccion(Seleccion seleccion) {

        String sql = "UPDATE employees "
                + "SET first_name = ?, "
                + "last_name = ?, "
                + "email = ?, "
                + "phone_number = ?, "
                + "hire_date = ?, "
                + "job_id = ?, "
                + "salary = ?, "
                + "commission_pct = ?, "
                + "manager_id = ?, "
                + "department_id = ? "
                + "WHERE employee_id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            setEmployeeData(employee, pstmt);
            pstmt.setInt(11, employee.getEmployeeId());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void borrarSeleccion(int employeeId) {

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM employees WHERE employee_id = ?")) {

            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   */

    private Estadio fetchEstadioData(ResultSet rs) throws SQLException {
        Estadio estadio = new Estadio();
        estadio.setIdEstadio(rs.getInt(1));
        estadio.setNombre(rs.getString(2));
        estadio.setProvincia(rs.getString(3));
        estadio.setClub(rs.getString(3));

        return estadio;
    }


}
