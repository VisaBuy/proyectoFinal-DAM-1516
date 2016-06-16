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
public class GastoDaoTest {
    
    public GastoDaoTest() {
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
     * Test of getTipo method, of class GastoDao.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        GastoDao instance = null;
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class GastoDao.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        GastoDao instance = null;
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class GastoDao.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        GastoDao instance = null;
        String expResult = "";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class GastoDao.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "";
        GastoDao instance = null;
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdusuario method, of class GastoDao.
     */
    @Test
    public void testGetIdusuario() {
        System.out.println("getIdusuario");
        GastoDao instance = null;
        String expResult = "";
        String result = instance.getIdusuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdusuario method, of class GastoDao.
     */
    @Test
    public void testSetIdusuario() {
        System.out.println("setIdusuario");
        String idusuario = "";
        GastoDao instance = null;
        instance.setIdusuario(idusuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class GastoDao.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        GastoDao instance = null;
        float expResult = 0.0F;
        float result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class GastoDao.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        float cantidad = 0.0F;
        GastoDao instance = null;
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdgasto method, of class GastoDao.
     */
    @Test
    public void testGetIdgasto() {
        System.out.println("getIdgasto");
        GastoDao instance = null;
        int expResult = 0;
        int result = instance.getIdgasto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdgasto method, of class GastoDao.
     */
    @Test
    public void testSetIdgasto() {
        System.out.println("setIdgasto");
        int idgasto = 0;
        GastoDao instance = null;
        instance.setIdgasto(idgasto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
