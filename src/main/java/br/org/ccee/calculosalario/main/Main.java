package br.org.ccee.calculosalario.main;

import br.org.ccee.calculosalario.funcionario.boundary.ListarSalarioDecrescente;

/**
 * Teste de Java
 *
 * Desenvolva o sistema para cálculo do salário liquido (salário líquido =
 * salário bruto – (soma dos descontos)) dos funcionários, o sistema deve
 * apresentar a relação ordenada por salário líquido de modo decrescente.
 *
 * <p>
 * Observações:
 *
 * <ul>
 * <li>Não utilizar frameworks de persistência;
 * <li>Utilizar somente as funcionalidades do JDBC e do JSE(Java Standard
 * Edition);
 * <li>Este sistema roda em JSE, ou seja, não roda em servidores de aplicações
 * (Jboss, Tomcat, WebSphere, etc);
 * <li>Utilize conceitos de Orientação a Objetos (Beans) e a API do Java para
 * realizar as operações necessárias;
 * <li>As tabelas estão preenchidas e não há necessidade de desenvolver
 * funcionalidades para carga dos dados;
 * <li>O Cálculo do valor líquido não poderá ser resolvido pela query do banco
 * de dados;
 * <li>Lembre-se que você está desenvolvendo um sistema orientado a objetos.
 * </ul>
 *
 * @author Fábio Santos Almeida - livre.programacao@gmail.com
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ListarSalarioDecrescente().listar();
    }

}
