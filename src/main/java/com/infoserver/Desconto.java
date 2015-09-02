package com.infoserver;

/**
 *
 * @author tux
 */
public class Desconto {

    public Desconto() {
    }

    public Desconto(long id_cliente, long id_desconto, double vl_desconto) {
        this.id_cliente = id_cliente;
        this.id_desconto = id_desconto;
        this.vl_desconto = vl_desconto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (this.id_desconto ^ (this.id_desconto >>> 32));
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
        final Desconto other = (Desconto) obj;
        if (this.id_desconto != other.id_desconto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Desconto{" + "id_desconto=" + id_desconto + ", id_cliente=" + id_cliente + ", vl_desconto=" + vl_desconto + '}';
    }

    private long id_desconto;

    /**
     * Get the value of id_desconto
     *
     * @return the value of id_desconto
     */
    public long getId_desconto() {
        return id_desconto;
    }

    /**
     * Set the value of id_desconto
     *
     * @param id_desconto new value of id_desconto
     */
    public void setId_desconto(long id_desconto) {
        this.id_desconto = id_desconto;
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

    private double vl_desconto;

    /**
     * Get the value of vl_desconto
     *
     * @return the value of vl_desconto
     */
    public double getVl_desconto() {
        return vl_desconto;
    }

    /**
     * Set the value of vl_desconto
     *
     * @param vl_desconto new value of vl_desconto
     */
    public void setVl_desconto(double vl_desconto) {
        this.vl_desconto = vl_desconto;
    }

}
