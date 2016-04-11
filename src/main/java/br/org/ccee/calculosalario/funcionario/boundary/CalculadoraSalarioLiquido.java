package br.org.ccee.calculosalario.funcionario.boundary;

import br.org.ccee.calculosalario.desconto.entity.Desconto;
import br.org.ccee.calculosalario.funcionario.entity.Funcionario;
import static br.org.ccee.calculosalario.funcionario.entity.Funcionario.SALARIO_MINIMO_NACIONAL_2015;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tux
 */
public class CalculadoraSalarioLiquido {

    /**
     *
     * @return
     */
    public List<Funcionario> executa() {
        Funcionario funcionarioJoaoDaSilva, funcionarioMariaDaSilva, funcionarioJesusDaSilva, funcionarioMartaDaSilva, funcionarioMateusDaSilva;
        funcionarioJoaoDaSilva = new Funcionario(1, "MalcomX", SALARIO_MINIMO_NACIONAL_2015, null);
        funcionarioMariaDaSilva = new Funcionario(2, "Maria da Silva", SALARIO_MINIMO_NACIONAL_2015, null);
        funcionarioJesusDaSilva = new Funcionario(3, "Jesus da Silva", SALARIO_MINIMO_NACIONAL_2015, null);
        funcionarioMartaDaSilva = new Funcionario(4, "Marta da Silva", SALARIO_MINIMO_NACIONAL_2015, null);
        funcionarioMateusDaSilva = new Funcionario(4, "Mateus da Silva", SALARIO_MINIMO_NACIONAL_2015, null);

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

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionarioJoaoDaSilva);
        funcionarios.add(funcionarioMariaDaSilva);
        funcionarios.add(funcionarioJesusDaSilva);
        funcionarios.add(funcionarioMartaDaSilva);
        funcionarios.add(funcionarioMateusDaSilva);
        Collections.shuffle(funcionarios);

        return ordernar(funcionarios);
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
    private List<Funcionario> ordernar(List<Funcionario> c) {

        if (c == null || c.isEmpty()) {
            return c;
        }

        Comparator comparator = new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario f1, Funcionario f2) {
                Double d2 = f2.getSalarioLiquido();
                return d2.compareTo(f1.getSalarioLiquido());
            }
        };

        Collections.sort(c, comparator);

        return c;
    }

}
