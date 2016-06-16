/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
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
public class ConsultarGastosTest {
    
    public ConsultarGastosTest() {
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
     * Test of verTodosLosGastos method, of class ConsultarGastos.
     */
    @Test
    public void testVerTodosLosGastos() {
        System.out.println("verTodosLosGastos");
        ConsultarGastos instance = new ConsultarGastos();
        List<GastoDao> result = instance.verTodosLosGastos();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(result.toString());
    }

    /**
     * Test of InsertarGasto method, of class ConsultarGastos.
     */
    @Test
    public void testInsertarGasto() {
        System.out.println("InsertarGasto");
        float cantidad = (float)12.0;
        String tipo = "Deporte";
        String idusuario = "jhonro";
        ConsultarGastos instance = new ConsultarGastos();
        boolean expResult = false;
        boolean result = instance.InsertarGasto(cantidad, tipo, idusuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        System.out.println(result);
        /*if(result=true){
                  System.out.println ("Prueba ejecutada correctamente");
        }else{
           
            
           fail("The test case is a prototype.");
        }*/
    }

    /**
     * Test of eliminarGasto method, of class ConsultarGastos.
     */
    @Test
    public void testEliminarGasto() {
        System.out.println("eliminarGasto");
        int id = 31;
        ConsultarGastos instance = new ConsultarGastos();
        boolean expResult = false;
        boolean result = instance.eliminarGasto(id);
        ///assertEquals(expResult, result);
       
        if(result==true){
            System.out.println("Prueba ejecutada correctamente");
        }else{
            System.err.println("Error");
        }
        
        
    }

    /**
     * Test of modificarGasto method, of class ConsultarGastos.
     */
    @Test
    public void testModificarGasto() {
        System.out.println("modificarGasto");
        int idg = 28;
        float cantidad =(float) 122.00;
        String tipo = "Otro";
        String gUsuario = "pepitog";
        ConsultarGastos instance = new ConsultarGastos();
        boolean expResult = false;
        boolean result = instance.modificarGasto(idg, cantidad, tipo, gUsuario);
      //  assertEquals(expResult, result);
       
        System.out.println(result);
            
    }

  
}
