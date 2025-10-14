/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import pagos.pago;
import pagos.pagoDAO;
import java.util.Date;
import java.util.List;
/**
 *
 * @author ferca
 */
public class pagoDAOTest {

    private static pagoDAO dao;

    @BeforeAll
    static void setUp() {
        dao = new pagoDAO();
        System.out.println("✅ Iniciando pruebas para pagoDAO...");
    }

    @Test
    void testAgregar() {
        pago p = new pago();
        p.setIdUsuario(1); // ⚠️ Asegúrate de que el usuario con id=1 exista en tu tabla usuario
        p.setFechaPago(new Date()); // Fecha actual
        p.setCantidad(100000.0);
        p.setMedioPago("Tarjeta");
        p.setEstado("Pagado");

        boolean resultado = dao.agregar(p);
        assertTrue(resultado, "❌ Error al agregar el pago");
    }

    @Test
    void testListar() {
        List<pago> lista = dao.listar();
        assertNotNull(lista, "❌ La lista de pagos es null");
        assertTrue(lista.size() > 0, "❌ No se encontraron pagos registrados");
        System.out.println("✅ Listado de pagos obtenido (" + lista.size() + ")");
    }

    @Test
    void testBuscarPorId() {
        pago p = dao.buscarPorId(1); // ⚠️ Usa un ID que exista en tu tabla pagos
        assertNotNull(p, "❌ No se encontró el pago con ID 1");
        System.out.println("✅ Pago encontrado: " + p.getMedioPago());
    }

    @Test
    void testEditar() {
        pago p = dao.buscarPorId(1);
        assertNotNull(p, "❌ No se encontró el pago para editar");

        p.setCantidad(p.getCantidad() + 5000);
        boolean resultado = dao.editar(p);
        assertTrue(resultado, "❌ Error al editar el pago");
        System.out.println("✅ Pago editado correctamente");
    }

    @Test
    void testEliminar() {
        // ⚠️ Asegúrate de crear un pago temporal para eliminar
        pago p = new pago();
        p.setIdUsuario(1);
        p.setFechaPago(new Date());
        p.setCantidad(50000.0);
        p.setMedioPago("Efectivo");
        p.setEstado("Pendiente");
        dao.agregar(p);

        // Eliminar el último pago insertado (puedes cambiarlo si tu tabla no tiene autoincremento)
        List<pago> lista = dao.listar();
        int ultimoId = lista.get(lista.size() - 1).getIdPago();

        boolean resultado = dao.eliminar(ultimoId);
        assertTrue(resultado, "❌ Error al eliminar el pago");
        System.out.println("✅ Pago eliminado correctamente");
    }
}
