/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagos;

import java.util.Date;
/**
 *
 * @author ferca
 */
public class pago {
    private int idPago;
    private int idUsuario;
    private Date fecha_pago;
    private double cantidad;
    private String medio_pago;
    private String estado;

    // Getters y Setters
    public int getIdPago() {
        return idPago;
    }
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPago() {
        return fecha_pago;
    }
    public void setFechaPago(Date fechaPago) {
        this.fecha_pago = fechaPago;
    }

    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedioPago() {
        return medio_pago;
    }
    public void setMedioPago(String medioPago) {
        this.medio_pago = medioPago;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
