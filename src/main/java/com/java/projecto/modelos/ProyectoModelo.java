
package com.java.projecto.modelos;


public class ProyectoModelo extends ServicioModelo {
    private int codigoProyecto;
    private String fecha_inicio;
    private String descripcionProyecto;
    private int id_disenador;
    private int id_supervisor;
    private int id_cliente;

    public ProyectoModelo(int codigoServicio, String descripcionServicio, 
            double valor_unitario, int codigoProyecto, String fecha_inicio, 
            String descripcionProyecto, int id_disenador,int id_supervisor,int id_cliente) {
        super(codigoServicio, descripcionServicio, valor_unitario);
        this.codigoProyecto = codigoProyecto;
        this.fecha_inicio = fecha_inicio;
        this.descripcionProyecto = descripcionProyecto;
        this.id_disenador = id_disenador;
        this.id_supervisor = id_supervisor;
        this.id_cliente = id_cliente;
    }
    
   

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public int getId_disenador() {
        return id_disenador;
    }

    public void setId_disenador(int id_disenador) {
        this.id_disenador = id_disenador;
    }

    public int getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(int id_supervisor) {
        this.id_supervisor = id_supervisor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
}
