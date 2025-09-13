/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

/**
 *
 * @author ferca
 */
public class usuario {
    private int idUsuario;
    private String nombre;
    private String email;
    private String password;
    private int edad;
    private String sexo;
    private String objetivoFisico;

    // Constructor vacío
    public usuario() {
    }

    // Constructor con parámetros
    public usuario(int idUsuario, String nombre, String email, String password, int edad, String sexo, String objetivoFisico) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.edad = edad;
        this.sexo = sexo;
        this.objetivoFisico = objetivoFisico;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObjetivoFisico() {
        return objetivoFisico;
    }

    public void setObjetivoFisico(String objetivoFisico) {
        this.objetivoFisico = objetivoFisico;
    }
}