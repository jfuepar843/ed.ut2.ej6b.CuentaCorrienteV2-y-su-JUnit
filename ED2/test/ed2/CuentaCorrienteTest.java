/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class CuentaCorrienteTest {

    private CuentaCorriente cuentaPrueba;
    private static CuentaCorriente cuentaDestino;

    public CuentaCorrienteTest() {
        cuentaDestino = new CuentaCorriente("CuentaDestino", 2000);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cuentaPrueba = new CuentaCorriente("CuentaPrueba", 1000);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of ingresa method, of class CuentaCorriente.
     */
    @Test
    public void testIngresa() {
        System.out.println("ingresa");
        double i = 200;
        CuentaCorriente instance = new CuentaCorriente(300);
        double si = instance.getSaldo();
        instance.ingresa(i);
        double sf = instance.getSaldo();
        assertTrue(sf == si + i);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIngresa2() {
        System.out.println("ingresa");
        double i = -200;
        CuentaCorriente instance = new CuentaCorriente(300);
        double si = instance.getSaldo();
        try {
            instance.ingresa(i);
            System.out.println("No Pasa");
        } catch (Exception e) {
            System.out.println(e);
            double sf = instance.getSaldo();
            assertTrue(sf == si);
        }
        double sf = instance.getSaldo();
        assertTrue(sf == si);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of tranferir method, of class CuentaCorriente.
     */
    @Test
    public void testTranferir() {
        System.out.println("tranferir");
        double cantidad = 200;
        double saldoInicialCuentaOrigen = cuentaPrueba.getSaldo();
        double saldoInicialCuentaDestino = cuentaDestino.getSaldo();
        cuentaPrueba.tranferir(cuentaDestino, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertTrue((cuentaPrueba.getSaldo() == saldoInicialCuentaOrigen - cantidad) && (cuentaDestino.getSaldo() == saldoInicialCuentaDestino + cantidad));

    }

    @Test
    public void testTransferenciaCantidadNegativa() {
        System.out.println("transferenciaCantidadNegativa");
        double cantidad = -50;
        double saldoInicialOrigen = cuentaPrueba.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        try {
            cuentaPrueba.tranferir(cuentaDestino, cantidad);
            System.out.println("No Pasa");
        } catch (Exception e) {
            System.out.println(e);
            double saldoFinalOrigen = cuentaPrueba.getSaldo();
            double saldoFinalDestino = cuentaDestino.getSaldo();
            assertTrue(saldoFinalOrigen == saldoInicialOrigen && saldoFinalDestino == saldoInicialDestino);
        }
    }

    @Test
    public void testTransferenciaSaldoInsuficiente() {
        System.out.println("transferenciaSaldoInsuficiente");
        double cantidad = 500;
        double saldoInicialOrigen = cuentaPrueba.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        try {
            cuentaPrueba.tranferir(cuentaDestino, cantidad);
            System.out.println("No Pasa");
        } catch (Exception e) {
            System.out.println(e);
            double saldoFinalOrigen = cuentaPrueba.getSaldo();
            double saldoFinalDestino = cuentaDestino.getSaldo();
            assertTrue(saldoFinalOrigen == saldoInicialOrigen && saldoFinalDestino == saldoInicialDestino);
        }
    }

    @Test
    public void testTransferenciaCantidadCero() {
        System.out.println("transferenciaCantidadCero");
        double cantidad = 0;
        double saldoInicialOrigen = cuentaPrueba.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        cuentaPrueba.tranferir(cuentaDestino, cantidad);
        double saldoFinalOrigen = cuentaPrueba.getSaldo();
        double saldoFinalDestino = cuentaDestino.getSaldo();
        assertTrue(saldoFinalOrigen == saldoInicialOrigen && saldoFinalDestino == saldoInicialDestino);
    }

    @Test
    public void testDepositoCantidadCero() {
        System.out.println("depositoCantidadCero");
        double cantidad = 0;
        CuentaCorriente instancia = new CuentaCorriente(300);
        double saldoInicial = instancia.getSaldo();
        instancia.ingresa(cantidad);
        double saldoFinal = instancia.getSaldo();
        assertTrue(saldoFinal == saldoInicial);
    }

}
