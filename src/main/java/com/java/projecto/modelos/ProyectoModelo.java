
package com.java.projecto.modelos;


public class ProyectoModelo  {
    private int codigo;
    private String fechaInicio;
    private String descripcion;
    private int idDisenador;
    private int idSupervisor;
    private int idCliente;
    private ServicioModelo[] servicios;
    private int totalServicios = 0;
    private static final double IVA = 0.19;

    public ProyectoModelo(int codigo, String fechaInicio, String descripcion, int idDisenador, int idSupervisor,
                          int idCliente, int cantidadServicio) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
        this.idDisenador = idDisenador;
        this.idSupervisor = idSupervisor;
        this.idCliente = idCliente;
        this.servicios = new ServicioModelo[cantidadServicio];
    }



    public void agregarServicio(ServicioModelo servicio) {
        if (totalServicios < servicios.length) {
            servicios[totalServicios++] = servicio;
        } else {
            System.out.println("No se pueden agregar más servicios.");
        }
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < totalServicios; i++) {
            subtotal += servicios[i].getValorUnitario();
        }
        return subtotal;
    }

    public double calcularIVA() {
        return calcularSubtotal() * IVA;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    public int getTotalServicios() {
        return totalServicios;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdDisenador() {
        return idDisenador;
    }

    public void setIdDisenador(int idDisenador) {
        this.idDisenador = idDisenador;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ServicioModelo[] getServicios() {
        return servicios;
    }

    public void setServicios(ServicioModelo[] servicios) {
        this.servicios = servicios;
    }

    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }
}
