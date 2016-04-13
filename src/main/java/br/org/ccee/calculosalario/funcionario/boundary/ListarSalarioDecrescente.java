package br.org.ccee.calculosalario.funcionario.boundary;

import br.org.ccee.boundary.Calculadora;
import br.org.ccee.calculosalario.desconto.entity.Desconto;
import br.org.ccee.calculosalario.funcionario.entity.Funcionario;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tux
 */
public class ListarSalarioDecrescente {

    private final Calculadora calculadoraDescontos = new CalculadoraDesconto();
    private List<Funcionario> funcionarios;

    public ListarSalarioDecrescente() {
        funcionarios = buscarFuncionarios();
        ordenar(funcionarios);
    }

    public void listar() {
        funcionarios.forEach(f -> System.out.println(f));
    }

    private void calcularSalarioLiquido() {
        for (Funcionario funcionario : funcionarios) {
            double[] valores = funcionario
                    .getDescontos()
                    .stream()
                    .mapToDouble(f -> f.getVl_desconto())
                    .toArray();
            double salarioLiquido = funcionario.getVl_salario_bruto() - calculadoraDescontos.calcular(valores);
        }
    }

    private void ordenar(List<Funcionario> funcionarios) {
        funcionarios.sort((f1, f2) -> Double.compare(f2.getSalarioLiquido(), f1.getSalarioLiquido()));
    }

    private List<Funcionario> buscarFuncionarios() {

        List<Funcionario> funcionarios = new LinkedList<>();

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

}
