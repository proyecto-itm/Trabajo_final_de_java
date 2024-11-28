package com.java.projecto;

import com.java.projecto.modelos.ClienteModelo;
import com.java.projecto.modelos.FacturaModelo;
import com.java.projecto.modelos.ProyectoModelo;

import java.util.Scanner;

public class Factura {
    private static final int MAX_ELEMENTOS = 50;
    private ProyectoModelo[] proyectos; // Lista de proyectos existentes
    private FacturaModelo[] facturas = new FacturaModelo[MAX_ELEMENTOS];         // Lista de facturas generadas
    private int totalFacturas = 0;      // Contador de facturas generadas
    Scanner scanner = new Scanner(System.in);
    public Factura(ProyectoModelo[] proyectos ) {
        this.proyectos = proyectos;

    }

    public void Inicio() {
        while (true) {
            System.out.println("\n--- Menú de Facturas ---");
            System.out.println("1. Generar factura para un proyecto");
            System.out.println("2. Generar facturas para todos los proyectos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarFacturaIndividual();
                    break;
                case 2:
                    generarFacturasParaTodos();
                    break;
                case 3:
                    System.out.println("Saliendo del menú de facturas...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void generarFacturaIndividual() {
        ;
        int codigoProyecto = (int) (Math.random() * 100) +1;

        ProyectoModelo proyecto = buscarProyecto(codigoProyecto);

        if (proyecto == null) {
            System.out.println("El proyecto no existe. Intente de nuevo.");
            return;
        }

        if (totalFacturas < facturas.length) {
            FacturaModelo nuevaFactura = new FacturaModelo(proyecto);
            facturas[totalFacturas++] = nuevaFactura;
            System.out.println("Factura generada exitosamente:");
            nuevaFactura.mostrarDetalle();
        } else {
            System.out.println("No se pueden generar más facturas. Capacidad máxima alcanzada.");
        }
    }

    private void generarFacturasParaTodos() {
        for (ProyectoModelo proyecto : proyectos) {
            if (proyecto != null && !facturaYaGenerada(proyecto.getCodigo())) {
                if (totalFacturas < facturas.length) {
                    facturas[totalFacturas++] = new FacturaModelo(proyecto);
                } else {
                    System.out.println("No se pueden generar más facturas. Capacidad máxima alcanzada.");
                    return;
                }
            }
        }
        System.out.println("Facturas generadas para todos los proyectos.");
    }

    private boolean facturaYaGenerada(int codigoProyecto) {
        for (int i = 0; i < totalFacturas; i++) {
            if (facturas[i].getProyecto().getCodigo() == codigoProyecto) {
                return true;
            }
        }
        return false;
    }



    private ProyectoModelo buscarProyecto(int codigo) {
        for (ProyectoModelo proyecto : proyectos) {
            if (proyecto != null && proyecto.getCodigo() == codigo) {
                return proyecto;
            }
        }
        return null;
    }

}