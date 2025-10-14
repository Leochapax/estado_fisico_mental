/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rutinas;

/**
 *
 * @author ferca
 */
public class rutina {
    private int idRutina;
    private String nombre;
    private String descripcion;
    private String nivel_dificultad;
    private String tipo;

    // Getters y Setters
    public int getIdRutina() { return idRutina; }
    public void setIdRutina(int idRutina) { this.idRutina = idRutina; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getNivelDificultad() { return nivel_dificultad; }
    public void setNivelDificultad(String nivel_dificultad) { this.nivel_dificultad = nivel_dificultad; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}