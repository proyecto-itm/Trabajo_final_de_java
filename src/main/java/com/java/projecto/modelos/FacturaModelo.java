package com.java.projecto.modelos;

public class FacturaModelo  {
    private int numeroFactura;
    private ProyectoModelo proyecto;
    private static int contadorFacturas = 1; // Contador para generar números consecutivos

    public FacturaModelo(ProyectoModelo proyecto) {
        this.numeroFactura = contadorFacturas++;
        this.proyecto = proyecto;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public ProyectoModelo getProyecto() {
        return proyecto;
    }

    public void mostrarDetalle() {
        System.out.println("Factura N°: " + numeroFactura);
        System.out.println("Proyecto ID: " + proyecto.getCodigo());
        System.out.println("Cliente ID: " + proyecto.getIdCliente());
        System.out.println("Servicios:");
        for (ServicioModelo servicio : proyecto.getServicios()) {
            if (servicio != null) {
                System.out.println("- " + servicio.getDescripcion() + ": $" + servicio.getValorUnitario());
            }
        }
        System.out.println("Subtotal: $" + proyecto.calcularSubtotal());
        System.out.println("IVA: $" + proyecto.calcularIVA());
        System.out.println("Total: $" + proyecto.calcularTotal());
    }
}