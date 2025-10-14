/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
/**
 *
 * @author ferca
 */
@Suite
@SelectClasses({
    conexionDBTest.class,
    usuarioDAOTest.class,
    pagoDAOTest.class,
    recetaDAOTest.class,
    rutinaDAOTest.class,
    socializarDAOTest.class
})
public class AllTest {
    // No necesita código dentro
}