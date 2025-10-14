/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import usuario.usuario;
import usuario.usuarioDAO;
import java.util.List;
/**
 *
 * @author ferca
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class usuarioDAOTest {

    private static usuarioDAO dao;
    private static int idGenerado;

    @BeforeAll
    public static void inicializar() {
        dao = new usuarioDAO();
        System.out.println("✅ Iniciando pruebas para usuarioDAO...");
    }

    @Test
    @Order(1)
    public void testAgregar() {
        usuario u = new usuario();
        u.setNombre("Prueba Usuario");
        u.setEmail("prueba@test.com");
        u.setPassword("1234");
        u.setEdad(25);
        u.setSexo("Femenino");
        u.setObjetivoFisico("Tonificar");

        boolean resultado = dao.agregar(u);
        assertTrue(resultado, "❌ Error al agregar usuario");

        // Verificamos si realmente se insertó (buscando el último ID)
        List<usuario> lista = dao.listar();
        assertFalse(lista.isEmpty(), "❌ Lista vacía tras agregar usuario");

        idGenerado = lista.get(lista.size() - 1).getIdUsuario();
        System.out.println("✅ Usuario agregado con ID: " + idGenerado);
    }

    @Test
    @Order(2)
    public void testBuscarPorId() {
        usuario u = dao.buscarPorId(idGenerado);
        assertNotNull(u, "❌ No se encontró el usuario");
        System.out.println("✅ Usuario encontrado: " + u.getNombre());
    }

    @Test
    @Order(3)
    public void testEditar() {
        usuario u = dao.buscarPorId(idGenerado);
        assertNotNull(u, "❌ No se encontró el usuario para editar");

        u.setNombre("Usuario Editado");
        boolean resultado = dao.editar(u);
        assertTrue(resultado, "❌ No se pudo editar el usuario");

        usuario editado = dao.buscarPorId(idGenerado);
        assertEquals("Usuario Editado", editado.getNombre(), "❌ El nombre no se actualizó correctamente");
        System.out.println("✅ Usuario editado correctamente.");
    }

    @Test
    @Order(4)
    public void testListar() {
        List<usuario> lista = dao.listar();
        assertNotNull(lista, "❌ La lista es nula");
        assertTrue(lista.size() > 0, "❌ No hay usuarios en la base de datos");
        System.out.println("✅ Listado de usuarios obtenido (" + lista.size() + ")");
    }

    @Test
    @Order(5)
    public void testEliminar() {
        boolean resultado = dao.eliminar(idGenerado);
        assertTrue(resultado, "❌ No se pudo eliminar el usuario");

        usuario u = dao.buscarPorId(idGenerado);
        assertNull(u, "❌ El usuario no se eliminó correctamente");
        System.out.println("✅ Usuario eliminado correctamente.");
    }
}