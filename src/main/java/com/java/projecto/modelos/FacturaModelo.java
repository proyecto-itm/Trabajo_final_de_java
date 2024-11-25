package com.java.projecto.modelos;

public class FacturaModelo extends ProyectoModelo {
    private int contador_factura;
    private int factura;   
    private ProyectoModelo[] proyecto;
    public FacturaModelo(int contador_factura,int factura,int cantidad_proyecto) {

        this.contador_factura =contador_factura;
        this.factura = factura;
        this.proyecto =new ProyectoModelo[cantidad_proyecto];
    }


    public int getContador_factura() {
        return contador_factura;
    }

    public void setContador_factura(int contador_factura) {
        this.contador_factura = contador_factura;
    }

    public ProyectoModelo[] getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoModelo[] proyecto) {
        this.proyecto = proyecto;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }
}
