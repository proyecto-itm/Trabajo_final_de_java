
package com.java.projecto.modelos;

public class ServicioModelo {
    private int codigo;
    private String descripcion;
    private double valorUnitario;

    public ServicioModelo(int codigo, String descripcion, double valorUnitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }



}
