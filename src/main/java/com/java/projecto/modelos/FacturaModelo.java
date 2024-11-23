package com.java.projecto.modelos;

public class FacturaModelo extends ProyectoModelo {
    private int contador_factura;
    private int factura;   

    public FacturaModelo(int codigoServicio, String descripcionServicio, 
            double valor_unitario, int codigoProyecto, String fecha_inicio, 
            String descripcionProyecto, int id_disenador, int id_supervisor, 
            int id_cliente,int contador_factura,int factura) {
        super(codigoServicio, descripcionServicio, valor_unitario, 
                codigoProyecto, fecha_inicio, descripcionProyecto, 
                id_disenador, id_supervisor, id_cliente);
        
        this.contador_factura =contador_factura;
        this.factura = factura;
    }

    public int getContador_factura() {
        return contador_factura;
    }

    public void setContador_factura(int contador_factura) {
        this.contador_factura = contador_factura;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }
    
    
    
}
