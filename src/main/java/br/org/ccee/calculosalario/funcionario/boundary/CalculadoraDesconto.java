package br.org.ccee.calculosalario.funcionario.boundary;

import br.org.ccee.boundary.Calculadora;

/**
 *
 * @author user
 */
public class CalculadoraDesconto implements Calculadora {

    @Override
    public double calcular(double[] valores) {
        double total = 0;
        for (int i = 0; i < valores.length; i++) {
            total += valores[i];
        }
        return total;
    }

}
