package com.infoserver;

import java.util.Set;

/**
 *
 * @author tux
 */
class Funcionario {

    public static final double SALARIO_MINIMO_NACIONAL_2015 = 788.00;

    public Funcionario() {
    }

    public Funcionario(long id_cliente, String nm_cliente, double vl_salario_bruto, Set<Desconto> descontos) {
        this.id_cliente = id_cliente;
        this.nm_cliente = nm_cliente;
        this.vl_salario_bruto = vl_salario_bruto;
        this.descontos = descontos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.id_cliente ^ (this.id_cliente >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id_cliente=" + id_cliente + ", nm_cliente=" + nm_cliente + ", vl_salario_bruto=" + vl_salario_bruto + ", descontos=" + descontos + '}';
    }

    private long id_cliente;

    /**
     * Get the value of id_cliente
     *
     * @return the value of id_cliente
     */
    public long getId_cliente() {
        return id_cliente;
    }

    /**
     * Set the value of id_cliente
     *
     * @param id_cliente new value of id_cliente
     */
    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    private String nm_cliente;

    /**
     * Get the value of nm_cliente
     *
     * @return the value of nm_cliente
     */
    public String getNm_cliente() {
        return nm_cliente;
    }

    /**
     * Set the value of nm_cliente
     *
     * @param nm_cliente new value of nm_cliente
     */
    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    private double vl_salario_bruto;

    /**
     * Get the value of vl_salario_bruto
     *
     * @return the value of vl_salario_bruto
     */
    public double getVl_salario_bruto() {
        return vl_salario_bruto;
    }

    /**
     * Set the value of vl_salario_bruto
     *
     * @param vl_salario_bruto new value of vl_salario_bruto
     */
    public void setVl_salario_bruto(double vl_salario_bruto) {
        this.vl_salario_bruto = vl_salario_bruto;
    }

    private double salarioLiquido;

    /**
     * Get the value of salarioLiquido
     *
     * @return the value of salarioLiquido
     */
    public double getSalarioLiquido() {
        
        double totalDescontos = 0;
        
        if (this.descontos != null && !this.descontos.isEmpty()) {
            for (Desconto desconto : descontos) {
                totalDescontos += desconto.getVl_desconto();
            }
        }
        
        salarioLiquido = getSalarioLiquido() - totalDescontos;
        
        return salarioLiquido;
    }

    /**
     * Set the value of salarioLiquido
     *
     * @param salarioLiquido new value of salarioLiquido
     */
    private final void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    private Set<Desconto> descontos;

    /**
     * Get the value of descontos
     *
     * @return the value of descontos
     */
    public Set<Desconto> getDescontos() {
        return descontos;
    }

    /**
     * Set the value of descontos
     *
     * @param descontos new value of descontos
     */
    public void setDescontos(Set<Desconto> descontos) {
        this.descontos = descontos;
    }

}
