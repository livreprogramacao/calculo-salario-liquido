/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infoserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    rs.getDouble("vl_salario_bruto"),
                    null
            );

            String selectFuncionarioDesconto = "select id_desconto, vl_desconto from Desconto where id_cliente = :id_cliente";
            PreparedStatement pstm1 = getConn().prepareStatement(selectFuncionarioDesconto);
            ResultSet rs1 = pstm1.executeQuery();

            List<Desconto> descontos = new ArrayList<>();
            while (rs1.next()) {
                Desconto d = new Desconto(
                        funcionario.getId_cliente(),
                        rs1.getInt("id_desconto"),
                        rs1.getDouble("vl_desconto")
                );
            }
            funcionario.setDescontos(descontos);
            funcionarios.add(funcionario);
        }

        return funcionarios;
    }

    private Connection getConn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
