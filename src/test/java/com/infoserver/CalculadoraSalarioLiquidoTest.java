/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoserver;

import br.org.ccee.calculosalario.desconto.entity.Desconto;
import br.org.ccee.calculosalario.funcionario.boundary.CalculadoraSalarioLiquido;
import br.org.ccee.calculosalario.funcionario.entity.Funcionario;
import static br.org.ccee.calculosalario.funcionario.entity.Funcionario.SALARIO_MINIMO_NACIONAL_2015;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tux
 */
public class CalculadoraSalarioLiquidoTest {

    private Funcionario funcionarioJoaoDaSilva, funcionarioMariaDaSilva, funcionarioJesusDaSilva, funcionarioMartaDaSilva;
    private Set<Funcionario> funcionarios;
    private HashSet<Desconto> descontos;
    private CalculadoraSalarioLiquido calculadora;
    private List<Funcionario> listaEsperada;

    @Before
    public void setUp() {
        funcionarioJoaoDaSilva = new Funcionario(1, "Joao da Silva", SALARIO_MINIMO_NACIONAL_2015);
        funcionarioMariaDaSilva = new Funcionario(2, "Maria da Silva", SALARIO_MINIMO_NACIONAL_2015);
        funcionarioJesusDaSilva = new Funcionario(3, "Jesus da Silva", SALARIO_MINIMO_NACIONAL_2015);
        funcionarioMartaDaSilva = new Funcionario(4, "Marta da Silva", SALARIO_MINIMO_NACIONAL_2015);

        descontos = new HashSet<>(10);
        descontos.addAll(Arrays.asList(
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 10L, 78.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 11L, 79.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 12L, 70.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 13L, 76.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 14L, 37.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 15L, 17.88),
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 16L, 57.88)
        ));
        funcionarioJoaoDaSilva.setDescontos(descontos);

        funcionarios = new HashSet<>(1);
        funcionarios.addAll(Arrays.asList(funcionarioJoaoDaSilva));

        calculadora = new CalculadoraSalarioLiquido();

        this.listaEsperada = new ArrayList<>(10);
    }

    @Test
    public void testFuncionarioTemDescontos() {
        assertNotNull("A lista de descontos do clientes tem que estar preenchida", funcionarioJoaoDaSilva.getDescontos());
        assertEquals("A lista foi criada com sete elementos.", 7, funcionarioJoaoDaSilva.getDescontos().size());

//        System.out.println("Lista os descontos dos funcionarios existentes.");
//        for (Funcionario funcionario : funcionarios) {
//            System.out.println("Funcionario: " + funcionario);
//            for (Desconto desconto : funcionario.getDescontos()) {
//                System.out.println("Tem este desconto: " + desconto);
//            }
//        }
    }

    @Test
    public void testCalcularSalárioLiquidoParaFuncionarioCategoriaUmSalarioMinimoNacional() {

        assertNotNull("A lista de funcionarios tem que estar preechida!", funcionarios);

//        System.out.println("Lista os funcionarios existentes.");
//        for (Funcionario funcionario : funcionarios) {
//            System.out.println("Funcionario: " + funcionario);
//        }
    }

    @Test
    public void testListarFuncionariosOrdenadoPorSalárioLíquidoDecrescenteDoMaiorParaMenor() {
        listaEsperada.clear();
        listaEsperada.add(funcionarioMariaDaSilva);
        listaEsperada.add(funcionarioMartaDaSilva);
        listaEsperada.add(funcionarioJesusDaSilva);
        listaEsperada.add(funcionarioJoaoDaSilva);
        System.out.println("\n===================> listaEsperada");
        for (Funcionario funcionario : listaEsperada) {
            System.out.println(
                    "Funcionario: " + funcionario.getNm_cliente()
                    + ", salario liquido: " + funcionario.getSalarioLiquido());
        }

        System.out.println("\n===================> listaFuncionariosOrdenadoPorSalárioLíquidoDecrescenteDoMaiorParaMenor");
        List<Funcionario> listaFuncionariosOrdenadoPorSalárioLíquidoDecrescenteDoMaiorParaMenor = calculadora.executa();
        for (Funcionario funcionario : listaFuncionariosOrdenadoPorSalárioLíquidoDecrescenteDoMaiorParaMenor) {
            System.out.println(
                    "Funcionario: " + funcionario.getNm_cliente()
                    + ", salario liquido: " + funcionario.getSalarioLiquido());
        }

        assertEquals("Verifica se a lista ordenda esta correta com o cenário: apresentar a relação ordenada por salário líquido de modo decrescente",
                listaEsperada,
                listaFuncionariosOrdenadoPorSalárioLíquidoDecrescenteDoMaiorParaMenor);

    }
}
