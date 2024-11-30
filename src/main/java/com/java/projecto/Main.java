package com.java.projecto;

import com.java.projecto.modelos.ProyectoModelo;

import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura;
        Cliente cliente = new Cliente();
        Proyecto proyecto = new Proyecto();
        ProyectoModelo[] listaProyecto = new ProyectoModelo[50];
        Disenador disenador = new Disenador();
        Supervisor supervisor = new Supervisor();
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Diseñadores");
            System.out.println("2. Supervisores");
            System.out.println("3. Clientes");
            System.out.println("4. Proyectos");
            System.out.println("5. Facturas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    disenador.Inicio();
                    break;
                case 2:
                    supervisor.menu();
                    break;
                case 3:
                    cliente.iniciar();
                    break;
                case 4:
                    listaProyecto = proyecto.Inicio();
                    break;
                case 5:
                    factura = new Factura(listaProyecto);
                    factura.Inicio();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }    
}
