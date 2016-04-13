package br.org.ccee.calculosalario.funcionario.boundary;

import br.org.ccee.boundary.Calculadora;
import java.util.stream.DoubleStream;

/**
 *
 * @author user
 */
public class CalculadoraDesconto implements Calculadora {

    @Override
    public double calcular(DoubleStream valores) {
        return valores.sum();
    }

}
