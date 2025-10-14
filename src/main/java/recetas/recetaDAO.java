/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recetas;

/**
 *
 * @author ferca
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexion.conexionDB; // Usa tu clase de conexión

public class recetaDAO {

    public List<receta> listar() {
        List<receta> lista = new ArrayList<>();
        String sql = "SELECT * FROM recetas";
        
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                receta r = new receta();
                r.setIdReceta(rs.getInt("id_receta"));
                r.setNombre(rs.getString("nombre"));
                r.setDescripcion(rs.getString("descripcion"));
                r.setCalorias(rs.getInt("calorias"));
                r.setGramos(rs.getInt("gramos"));
                lista.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean agregar(receta r) {
        String sql = "INSERT INTO recetas(nombre, descripcion, calorias, gramos) VALUES(?, ?, ?, ?)";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.setInt(3, r.getCalorias());
            ps.setInt(4, r.getGramos());
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editar(receta r) {
        String sql = "UPDATE recetas SET nombre=?, descripcion=?, calorias=?, gramos=? WHERE id_receta=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, r.getNombre());
            ps.setString(2, r.getDescripcion());
            ps.setInt(3, r.getCalorias());
            ps.setInt(4, r.getGramos());
            ps.setInt(5, r.getIdReceta());
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM recetas WHERE id_receta=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public receta buscarPorId(int id) {
        receta r = null;
        String sql = "SELECT * FROM recetas WHERE id_receta=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    r = new receta();
                    r.setIdReceta(rs.getInt("id_receta"));
                    r.setNombre(rs.getString("nombre"));
                    r.setDescripcion(rs.getString("descripcion"));
                    r.setCalorias(rs.getInt("calorias"));
                    r.setGramos(rs.getInt("gramos"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}