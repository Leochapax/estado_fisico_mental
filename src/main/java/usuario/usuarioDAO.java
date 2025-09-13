/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import conexion.conexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Listar todos los usuarios
    public List<usuario> listar() {
        List<usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            con = conexionDB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario u = new usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setEdad(rs.getInt("edad"));
                u.setSexo(rs.getString("sexo"));
                u.setObjetivoFisico(rs.getString("objetivo_fisico"));
                lista.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Buscar usuario por ID
    public usuario buscarPorId(int id) {
        usuario u = null;
        String sql = "SELECT * FROM usuario WHERE id_usuario=?";
        try {
            con = conexionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                u = new usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setEdad(rs.getInt("edad"));
                u.setSexo(rs.getString("sexo"));
                u.setObjetivoFisico(rs.getString("objetivo_fisico"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    // Agregar usuario
    public boolean agregar(usuario u) {
        String sql = "INSERT INTO usuario(nombre, email, password, edad, sexo, objetivo_fisico) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = conexionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getEdad());
            ps.setString(5, u.getSexo());
            ps.setString(6, u.getObjetivoFisico());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Editar usuario
    public boolean editar(usuario u) {
        String sql = "UPDATE usuario SET nombre=?, email=?, password=?, edad=?, sexo=?, objetivo_fisico=? WHERE id_usuario=?";
        try {
            con = conexionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getEdad());
            ps.setString(5, u.getSexo());
            ps.setString(6, u.getObjetivoFisico());
            ps.setInt(7, u.getIdUsuario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar usuario
    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario=?";
        try {
            con = conexionDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
