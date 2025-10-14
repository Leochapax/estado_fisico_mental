/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import conexion.conexionDB;
import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ferca
 */
public class conexionDBTest {

    @Test
    public void testConexion() {
        try (Connection conn = conexionDB.getConnection()) {
            assertNotNull(conn, "La conexión no debe ser nula");
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (Exception e) {
            fail("❌ Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}