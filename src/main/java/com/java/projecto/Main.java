package com.java.projecto;

import java.util.Scanner;

public class Main {
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();
        Cliente cliente = new Cliente();
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
                    // Llamar al módulo de diseñadores
                    break;
                case 2:
                    // Llamar al módulo de supervisores
                    break;
                case 3:
                    cliente.iniciar(scanner);
                    break;
                case 4:
                    // Llamar al módulo de proyectos
                    break;
                case 5:
                    factura.Inciar();
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
