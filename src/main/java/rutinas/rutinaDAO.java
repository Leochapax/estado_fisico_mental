/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rutinas;

/**
 *
 * @author ferca
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexion.conexionDB;

public class rutinaDAO {

    public List<rutina> listar() {
        List<rutina> lista = new ArrayList<>();
        String sql = "SELECT * FROM rutinas";

        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                rutina r = new rutina();
                r.setIdRutina(rs.getInt("id_rutina"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setNivelDificultad(rs.getString("nivel_dificultad"));
                r.setTipo(rs.getString("tipo"));
                lista.add(r);
            }

        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

    public boolean agregar(rutina r) {
        String sql = "INSERT INTO rutinas(nombre, descripcion, nivel_dificultad, tipo) VALUES(?, ?, ?, ?)";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.setString(3, r.getNivelDificultad());
            ps.setString(4, r.getTipo());
            ps.executeUpdate();
            return true;

        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return false;
    }

    public boolean editar(rutina r) {
        String sql = "UPDATE rutinas SET nombre=?, descripcion=?, nivel_dificultad=?, tipo=? WHERE id_rutina=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.setString(3, r.getNivelDificultad());
            ps.setString(4, r.getTipo());
            ps.setInt(5, r.getIdRutina());
            ps.executeUpdate();
            return true;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM rutinas WHERE id_rutina=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public rutina buscarPorId(int id) {
        rutina r = null;
        String sql = "SELECT * FROM rutinas WHERE id_rutina=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    r = new rutina();
                    r.setIdRutina(rs.getInt("id_rutina"));
                    r.setNombre(rs.getString("nombre"));
                    r.setDescripcion(rs.getString("descripcion"));
                    r.setNivelDificultad(rs.getString("nivel_dificultad"));
                    r.setTipo(rs.getString("tipo"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return r;
    }
}