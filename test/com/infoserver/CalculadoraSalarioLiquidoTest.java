/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoserver;

import static com.infoserver.Funcionario.SALARIO_MINIMO_NACIONAL_2015;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author tux
 */
public class CalculadoraSalarioLiquidoTest {

    private Funcionario funcionarioJoaoDaSilva, funcionarioMariaDaSilva, funcionarioJesusDaSilva, funcionarioMartaDaSilva;
    private Set<Funcionario> funcionarios;
    private HashSet<Desconto> descontos;
    private CalculadoraSalarioLiquido calculadora;
    private Set<Funcionario> listaEsperada = new HashSet<>(10);

    @Before
    public void setUp() {
        funcionarioJoaoDaSilva = new Funcionario(1, "Joao da Silva", SALARIO_MINIMO_NACIONAL_2015, null);
        funcionarioMariaDaSilva = new Funcionario(1, "Maria da Silva", SALARIO_MINIMO_NACIONAL_2015, null);
        funcionarioJesusDaSilva = new Funcionario(1, "Jesus da Silva", SALARIO_MINIMO_NACIONAL_2015, null);
        funcionarioMartaDaSilva = new Funcionario(1, "Marta da Silva", SALARIO_MINIMO_NACIONAL_2015, null);

        descontos = new HashSet<>(10);
        descontos.addAll(Arrays.asList(
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 10L, 7.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 11L, 7.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 12L, 7.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 13L, 7.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 14L, 7.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 15L, 7.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 16L, 7.88)
        ));
        funcionarioJoaoDaSilva.setDescontos(descontos);

        funcionarios = new HashSet<>(1);
        funcionarios.addAll(Arrays.asList(funcionarioJoaoDaSilva));

        calculadora = new CalculadoraSalarioLiquido();

        this.listaEsperada = new HashSet<>(10);
    }

    @Test
    public void testFuncionarioTemDescontos() {
        assertNotNull("A lista de descontos do clientes tem que estar preenchida", funcionarioJoaoDaSilva.getDescontos());
        assertEquals("A lista foi criada com sete elementos.", 7, funcionarioJoaoDaSilva.getDescontos().size());

        System.out.println("Lista os descontos dos funcionarios existentes.");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Funcionario: " + funcionario);
            for (Desconto desconto : funcionario.getDescontos()) {
                System.out.println("Tem este desconto: " + desconto);
            }
        }
    }

    @Test
    public void testCalcularSalárioLiquidoParaFuncionarioCategoriaUmSalarioMinimoNacional() {

        assertNotNull("A lista de funcionarios tem que estar preechida!", funcionarios);

        System.out.println("Lista os funcionarios existentes.");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Funcionario: " + funcionario);
        }
    }

    @Test
    public void testListarFuncionariosOrdenadoPorSalárioLíquidoDecrescente() {
        listaEsperada.clear();
        listaEsperada.addAll(Arrays.asList(funcionarioJoaoDaSilva, funcionarioMariaDaSilva, funcionarioJesusDaSilva, funcionarioMartaDaSilva));
        for (Funcionario funcionario : listaEsperada) {
            System.out.println("Funcionario: " + funcionario.getNm_cliente() + ", salario liquido: " + funcionario.getSalarioLiquido());
        }
        
        funcionarios.clear();
        funcionarios.addAll(Arrays.asList(funcionarioJoaoDaSilva, funcionarioMariaDaSilva, funcionarioJesusDaSilva, funcionarioMartaDaSilva));
        for (Funcionario funcionario : listaEsperadaro) {
            System.out.println("Funcionario: " + funcionario.getNm_cliente() + ", salario liquido: " + funcionario.getSalarioLiquido());
        }
        
        Set<Funcionario> retorno = calculadora.listarFuncionariosOrdenadoPorSalárioLíquidoDecrescente(funcionarios);
        
        assertEquals("Verifica se a lista ordenda esta correta com o cenário: apresentar a relação ordenada por salário líquido de modo decrescente", listaEsperada, retorno);

    }
}
