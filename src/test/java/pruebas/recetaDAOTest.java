/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import recetas.receta;
import recetas.recetaDAO;
import java.util.List;
/**
 *
 * @author ferca
 */
public class recetaDAOTest {

    private static recetaDAO dao;

    @BeforeAll
    static void setUp() {
        dao = new recetaDAO();
        System.out.println("✅ Iniciando pruebas para recetaDAO...");
    }

    @Test
    void testAgregar() {
        receta r = new receta();
        r.setNombre("Ensalada de frutas");
        r.setDescripcion("Mezcla saludable de frutas frescas");
        r.setCalorias(250);
        r.setGramos(200);

        boolean resultado = dao.agregar(r);
        assertTrue(resultado, "❌ Error al agregar la receta");
        System.out.println("✅ Receta agregada correctamente");
    }

    @Test
    void testListar() {
        List<receta> lista = dao.listar();
        assertNotNull(lista, "❌ La lista de recetas es null");
        assertTrue(lista.size() > 0, "❌ No se encontraron recetas registradas");
        System.out.println("✅ Listado de recetas obtenido (" + lista.size() + ")");
    }

    @Test
    void testBuscarPorId() {
        // ⚠️ Usa un ID que sepas que existe en tu tabla recetas
        receta r = dao.buscarPorId(4);
        assertNotNull(r, "❌ No se encontró la receta con ID 4");
        System.out.println("✅ Receta encontrada: " + r.getNombre());
    }

    @Test
    void testEditar() {
        // ⚠️ Usa un ID existente
        receta r = dao.buscarPorId(4);
        assertNotNull(r, "❌ No se encontró la receta para editar");

        r.setDescripcion("Descripción actualizada desde test");
        boolean resultado = dao.editar(r);
        assertTrue(resultado, "❌ Error al editar la receta");
        System.out.println("✅ Receta editada correctamente");
    }

    @Test
    void testEliminar() {
        // ⚠️ Crea una receta temporal para eliminar
        receta r = new receta();
        r.setNombre("Receta temporal para eliminar");
        r.setDescripcion("Prueba temporal");
        r.setCalorias(120);
        r.setGramos(80);
        dao.agregar(r);

        // Tomar el último registro insertado
        List<receta> lista = dao.listar();
        int ultimoId = lista.get(lista.size() - 1).getIdReceta();

        boolean resultado = dao.eliminar(ultimoId);
        assertTrue(resultado, "❌ Error al eliminar la receta");
        System.out.println("✅ Receta eliminada correctamente");
    }
}