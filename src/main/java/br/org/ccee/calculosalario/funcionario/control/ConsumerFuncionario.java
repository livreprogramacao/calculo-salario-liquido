/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ccee.calculosalario.funcionario.control;

import br.org.ccee.calculosalario.funcionario.entity.Funcionario;
import java.util.function.Consumer;

/**
 *
 * @author user
 */
public class ConsumerFuncionario implements Consumer<Funcionario> {

    @Override
    public void accept(Funcionario funcionario) {
        double salarioLiquido = funcionario.getVl_salario_bruto() - somarDescontos(funcionario.getId_cliente());
        funcionario.setVl_salario_bruto(salarioLiquido);
    }

    private double somarDescontos(long id_cliente) {
        return 10.00;
    }

}
