/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import socializar.socializar;
import socializar.socializarDAO;
import java.util.List;
/**
 *
 * @author ferca
 */
public class socializarDAOTest {

    private static socializarDAO dao;

    @BeforeAll
    static void setUp() {
        dao = new socializarDAO();
        System.out.println("✅ Iniciando pruebas para socializarDAO...");
    }

    @Test
    void testAgregar() {
        socializar s = new socializar();
        s.setIdUsuario1(1); // Asegúrate de que existan usuarios con estos IDs
        s.setIdUsuario2(2);

        boolean resultado = dao.agregar(s);
        assertTrue(resultado, "❌ Error al agregar la conexión social");
        System.out.println("✅ Conexión social agregada correctamente");
    }

    @Test
    void testListar() {
        List<socializar> lista = dao.listar();
        assertNotNull(lista, "❌ La lista de conexiones sociales es null");
        assertTrue(lista.size() > 0, "❌ No se encontraron registros en socializar");
        System.out.println("✅ Se listaron " + lista.size() + " conexiones sociales");
    }

    @Test
    void testBuscarPorId() {
        socializar s = dao.buscarPorId(1); // Asegúrate de tener un registro con ID=1
        assertNotNull(s, "❌ No se encontró la conexión social con ID=1");
        System.out.println("✅ Conexión social encontrada entre usuarios: " + s.getIdUsuario1() + " y " + s.getIdUsuario2());
    }

    @Test
    void testEditar() {
        socializar s = dao.buscarPorId(1);
        assertNotNull(s, "❌ No se encontró la conexión social para editar");

        s.setIdUsuario2(3); // cambia por otro usuario existente
        boolean resultado = dao.editar(s);
        assertTrue(resultado, "❌ Error al editar la conexión social");
        System.out.println("✅ Conexión social editada correctamente");
    }

    @Test
    void testEliminar() {
        socializar temp = new socializar();
        temp.setIdUsuario1(1);
        temp.setIdUsuario2(2);
        dao.agregar(temp);

        List<socializar> lista = dao.listar();
        int ultimoId = lista.get(lista.size() - 1).getIdSocializar();

        boolean resultado = dao.eliminar(ultimoId);
        assertTrue(resultado, "❌ Error al eliminar la conexión social");
        System.out.println("✅ Conexión social eliminada correctamente");
    }
}
