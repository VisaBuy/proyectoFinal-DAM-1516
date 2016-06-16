/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhon
 */
public class ConsultasUsuariosTest {
    
    public ConsultasUsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of autenticacion method, of class ConsultasUsuarios.
     */
    @Test
    public void testAutenticacion() {
        System.out.println("autenticacion");
        String nombre = "jhonro";
        String pass = "1991";
        ConsultasUsuarios instance = new ConsultasUsuarios();
        boolean expResult = true;
        boolean result = instance.autenticacion(nombre, pass);
         assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(result);
    }

    /**
     * Test of registroUsuario method, of class ConsultasUsuarios.
     */
    @Test
    public void testRegistroUsuario() {
        System.out.println("registroUsuario");
        String nom = "Jhonar";
        String ape = "Perea";
        float suel = (float) 368;
        String usu = "jhonrp";
        String contra = "1234";
        ConsultasUsuarios instance = new ConsultasUsuarios();
        boolean expResult = true;
        boolean result = instance.registroUsuario(nom, ape, suel, usu, contra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result);
    }
    
}
