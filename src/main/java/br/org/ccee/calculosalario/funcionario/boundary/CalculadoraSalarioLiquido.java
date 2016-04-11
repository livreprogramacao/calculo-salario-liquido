package br.org.ccee.calculosalario.funcionario.boundary;

import br.org.ccee.boundary.Calculadora;
import br.org.ccee.calculosalario.desconto.entity.Desconto;
import br.org.ccee.calculosalario.funcionario.control.FuncionarioDAO;
import br.org.ccee.calculosalario.funcionario.entity.Funcionario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author tux
 */
public class CalculadoraSalarioLiquido implements Calculadora {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public CalculadoraSalarioLiquido() {
        funcionarios = criarFuncionarios();
    }

    private List<Funcionario> criarFuncionarios() {

        Funcionario funcionarioJoaoDaSilva, funcionarioMariaDaSilva, funcionarioJesusDaSilva, funcionarioMartaDaSilva, funcionarioMateusDaSilva;
        funcionarioJoaoDaSilva = new Funcionario(1, "MalcomX");
        funcionarioMariaDaSilva = new Funcionario(2, "Maria da Silva");
        funcionarioJesusDaSilva = new Funcionario(3, "Jesus da Silva");
        funcionarioMartaDaSilva = new Funcionario(4, "Marta da Silva");
        funcionarioMateusDaSilva = new Funcionario(4, "Mateus da Silva");

        Set<Desconto> descontos = new HashSet<>(10);
        descontos.addAll(Arrays.asList(
                new Desconto(funcionarioJoaoDaSilva.getId_cliente(), 16L, 400.00)
        ));
        funcionarioJoaoDaSilva.setDescontos(descontos);

        descontos = new HashSet<>(10);
        descontos.addAll(Arrays.asList(
                new Desconto(funcionarioMariaDaSilva.getId_cliente(), 1L, 88.00)
        ));
        funcionarioMariaDaSilva.setDescontos(descontos);

        descontos = new HashSet<>(10);
        descontos.addAll(Arrays.asList(
                new Desconto(funcionarioMariaDaSilva.getId_cliente(), 1L, 188.00)
        ));
        funcionarioMariaDaSilva.setDescontos(descontos);

        descontos = new HashSet<>(10);
        descontos.addAll(Arrays.asList(
                new Desconto(funcionarioJesusDaSilva.getId_cliente(), 1L, 288.00)
        ));
        funcionarioJesusDaSilva.setDescontos(descontos);

        descontos = new HashSet<>(10);
        descontos.addAll(Arrays.asList(
                new Desconto(funcionarioMartaDaSilva.getId_cliente(), 1L, 388.00)
        ));
        funcionarioMartaDaSilva.setDescontos(descontos);

        funcionarios.add(funcionarioJoaoDaSilva);
        funcionarios.add(funcionarioMariaDaSilva);
        funcionarios.add(funcionarioJesusDaSilva);
        funcionarios.add(funcionarioMartaDaSilva);
        funcionarios.add(funcionarioMateusDaSilva);

        Collections.shuffle(funcionarios);

        return funcionarios;
    }

    public void calcular() {
        funcionarios.forEach((Funcionario f) -> {
            FuncionarioDAO funcionarioDao = new FuncionarioDAO();
            f.setDescontos(funcionarioDao.buscarDescontos(f));
        });

        ordenar();
        listar();
    }

    private void listar() {
        funcionarios.forEach(f -> System.out.println(f));
    }

    private void ordenar() {
        funcionarios.sort((f1, f2) -> Double.compare(f2.getSalarioLiquido(), f1.getSalarioLiquido()));
    }

}
