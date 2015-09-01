package com.infoserver;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tux
 */
class CalculadoraSalarioLiquido {

    private Set<Funcionario> funcionarios;

    public CalculadoraSalarioLiquido() {
    }

    public void executa() {
        funcionarios = listarFuncionariosOrdenadoPorSalárioLíquidoDecrescente(new HashSet<Funcionario>(10));
    }

    /**
     * Desenvolva um metodo para cálculo do salário liquido dos funcionários.
     * <p>
     * (salário líquido = salário bruto – (soma dos descontos)).
     * <p>
     * O metodo deve apresentar a relação ordenada por salário líquido de modo
     * decrescente.
     *
     */
    public Set<Funcionario> listarFuncionariosOrdenadoPorSalárioLíquidoDecrescente(Set<Funcionario> c) {
        return c;
    }

}
 