/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoserver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tux
 */
public class CalculadoraSalarioLiquidoTest {
    
    public CalculadoraSalarioLiquidoTest() {
    }

    @Test
    public void testCalcularSalárioLiquidoParaFuncionarioCategoriaUmSalarioMinimoNacional() {
        Set<Desconto> descontos = new HashSet<>(10);
        Funcionario funcionarioJoaoDaSilva = new Funcionario(1, "Joao da Silva", 788.00, descontos);
        Set<Funcionario> funcionarios = new HashSet<>(1);
        funcionarios.addAll(Arrays.asList(funcionarioJoaoDaSilva));
        assertNotNull("A lista de funcionarios tem que estar preechida!", funcionarios);
        
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Funcionario: " + funcionario);
        }
    }
    
}
