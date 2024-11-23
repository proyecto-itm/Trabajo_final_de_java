
package com.java.projecto.modelos;

public class Servicio {
    private int codigoServicio;
    private String descripcionServicio;
    private double valor_unitario;
    
    public Servicio(int codigoServicio, String descripcionServicio ,
            double valor_unitario){
        this.codigoServicio =codigoServicio;
        this.descripcionServicio =descripcionServicio;
        this.valor_unitario =valor_unitario;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
    
    
}
