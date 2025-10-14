/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import rutinas.rutina;
import rutinas.rutinaDAO;
import java.util.List;
/**
 *
 * @author ferca
 */
public class rutinaDAOTest {

    private static rutinaDAO dao;

    @BeforeAll
    static void setUp() {
        dao = new rutinaDAO();
        System.out.println("✅ Iniciando pruebas para rutinaDAO...");
    }

    @Test
    void testAgregar() {
        rutina r = new rutina();
        r.setNombre("Rutina de prueba");
        r.setDescripcion("Entrenamiento de cuerpo completo");
        r.setNivelDificultad("Intermedio");
        r.setTipo("Fuerza");

        boolean resultado = dao.agregar(r);
        assertTrue(resultado, "❌ Error al agregar la rutina");
        System.out.println("✅ Rutina agregada correctamente");
    }

    @Test
    void testListar() {
        List<rutina> lista = dao.listar();
        assertNotNull(lista, "❌ La lista de rutinas es null");
        assertTrue(lista.size() > 0, "❌ No se encontraron rutinas registradas");
        System.out.println("✅ Se listaron " + lista.size() + " rutinas");
    }

    @Test
    void testBuscarPorId() {
        rutina r = dao.buscarPorId(1); // Asegúrate de tener una rutina con ID=1 en la base
        assertNotNull(r, "❌ No se encontró la rutina con ID=1");
        System.out.println("✅ Rutina encontrada: " + r.getNombre());
    }

    @Test
    void testEditar() {
        rutina r = dao.buscarPorId(1);
        assertNotNull(r, "❌ No se encontró la rutina para editar");

        r.setDescripcion("Descripción actualizada de prueba");
        boolean resultado = dao.editar(r);
        assertTrue(resultado, "❌ Error al editar la rutina");
        System.out.println("✅ Rutina editada correctamente");
    }

    @Test
    void testEliminar() {
        rutina temp = new rutina();
        temp.setNombre("Rutina temporal");
        temp.setDescripcion("Prueba de eliminación temporal");
        temp.setNivelDificultad("Intermedio");
        temp.setTipo("Cardio");
        dao.agregar(temp);

        List<rutina> lista = dao.listar();
        int ultimoId = lista.get(lista.size() - 1).getIdRutina();

        boolean resultado = dao.eliminar(ultimoId);
        assertTrue(resultado, "❌ Error al eliminar la rutina");
        System.out.println("✅ Rutina eliminada correctamente");
    }
}