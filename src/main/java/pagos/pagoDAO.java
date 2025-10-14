/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexion.conexionDB;
/**
 *
 * @author ferca
 */
public class pagoDAO {

    // Listar pagos
    public List<pago> listar() {
        List<pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pagos";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                pago p = new pago();
                p.setIdPago(rs.getInt("id_pago"));
                p.setIdUsuario(rs.getInt("id_usuario"));
                p.setFechaPago(rs.getDate("fecha_pago"));
                p.setCantidad(rs.getDouble("cantidad"));
                p.setMedioPago(rs.getString("medio_pago"));
                p.setEstado(rs.getString("estado"));
                lista.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Agregar pago
    public boolean agregar(pago p) {
        String sql = "INSERT INTO pagos(id_usuario, fecha_pago, cantidad, medio_pago, estado) VALUES(?, ?, ?, ?, ?)";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getIdUsuario());
            ps.setDate(2, new java.sql.Date(p.getFechaPago().getTime()));
            ps.setDouble(3, p.getCantidad());
            ps.setString(4, p.getMedioPago());
            ps.setString(5, p.getEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Editar pago
    public boolean editar(pago p) {
        String sql = "UPDATE pagos SET id_usuario=?, fecha_pago=?, cantidad=?, medio_pago=?, estado=? WHERE id_pago=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, p.getIdUsuario());
            ps.setDate(2, new java.sql.Date(p.getFechaPago().getTime()));
            ps.setDouble(3, p.getCantidad());
            ps.setString(4, p.getMedioPago());
            ps.setString(5, p.getEstado());
            ps.setInt(6, p.getIdPago());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Eliminar pago
    public boolean eliminar(int id) {
        String sql = "DELETE FROM pagos WHERE id_pago=?";
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

    // Buscar pago por ID
    public pago buscarPorId(int id) {
        pago p = null;
        String sql = "SELECT * FROM pagos WHERE id_pago=?";
        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new pago();
                    p.setIdPago(rs.getInt("id_pago"));
                    p.setIdUsuario(rs.getInt("id_usuario"));
                    p.setFechaPago(rs.getDate("fecha_pago"));
                    p.setCantidad(rs.getDouble("cantidad"));
                    p.setMedioPago(rs.getString("medio_pago"));
                    p.setEstado(rs.getString("estado"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
