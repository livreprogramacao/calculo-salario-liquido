/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ccee.calculosalario.funcionario.boundary;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class ListarSalarioDecrescenteTest {
    
    public ListarSalarioDecrescenteTest() {
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
     * Test of calcular method, of class ListarSalarioDecrescente.
     */
    @Test
    public void testCalcular() {
        System.out.println("calcular");
        ListarSalarioDecrescente instance = new ListarSalarioDecrescente();
        instance.calcular();
    }
    
}
