package br.org.ccee.calculosalario.funcionario.control;

import br.org.ccee.calculosalario.desconto.entity.Desconto;
import br.org.ccee.calculosalario.funcionario.entity.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tux
 */
public class FuncionarioDAO {

    public List<Funcionario> listarFuncionarios() throws SQLException, ClassNotFoundException {
        String selectFuncionario = "select id_cliente, nm_cliente, vl_salario_bruto from Funcionario";
        PreparedStatement pstm = getConn().prepareStatement(selectFuncionario);
        ResultSet rs = pstm.executeQuery();

        List<Funcionario> funcionarios = new ArrayList<>();
        while (rs.next()) {
            Funcionario funcionario = new Funcionario(
                    rs.getInt("id_cliente"),
                    rs.getString("nm_cliente"),
                    rs.getDouble("vl_salario_bruto")
            );

            String selectFuncionarioDesconto = "select id_desconto, vl_desconto from Desconto where id_cliente = ?";
            PreparedStatement pstm1 = getConn().prepareStatement(selectFuncionarioDesconto);
            pstm.setLong(1, funcionario.getId_cliente());
            ResultSet rs1 = pstm1.executeQuery();

            Set<Desconto> descontos = new HashSet<>();
            while (rs1.next()) {
                Desconto desconto = new Desconto(
                        funcionario.getId_cliente(),
                        rs1.getInt("id_desconto"),
                        rs1.getDouble("vl_desconto")
                );
                descontos.add(desconto);
            }
            funcionario.setDescontos(descontos);
            funcionarios.add(funcionario);
        }

        return funcionarios;
    }

    private Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/jsf_curso", "root", "root");
    }

}
