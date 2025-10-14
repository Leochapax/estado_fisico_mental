/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socializar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexion.conexionDB;

/**
 *
 * @author ferca
 */
public class socializarDAO {

    // Listar todas las conexiones
    public List<socializar> listar() {
        List<socializar> lista = new ArrayList<>();
        String sql = "SELECT * FROM socializar";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                socializar s = new socializar();
                s.setIdSocializar(rs.getInt("id_socializar"));
                s.setIdUsuario1(rs.getInt("id_usuario1"));
                s.setIdUsuario2(rs.getInt("id_usuario2"));
                lista.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Agregar conexión
    public boolean agregar(socializar s) {
        String sql = "INSERT INTO socializar(id_usuario1, id_usuario2) VALUES(?, ?)";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getIdUsuario1());
            ps.setInt(2, s.getIdUsuario2());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Editar conexión
    public boolean editar(socializar s) {
        String sql = "UPDATE socializar SET id_usuario1=?, id_usuario2=? WHERE id_socializar=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getIdUsuario1());
            ps.setInt(2, s.getIdUsuario2());
            ps.setInt(3, s.getIdSocializar());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Eliminar conexión
    public boolean eliminar(int id) {
        String sql = "DELETE FROM socializar WHERE id_socializar=?";
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

    // Buscar por ID
    public socializar buscarPorId(int id) {
        socializar s = null;
        String sql = "SELECT * FROM socializar WHERE id_socializar=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    s = new socializar();
                    s.setIdSocializar(rs.getInt("id_socializar"));
                    s.setIdUsuario1(rs.getInt("id_usuario1"));
                    s.setIdUsuario2(rs.getInt("id_usuario2"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
