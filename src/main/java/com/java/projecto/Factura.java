package com.java.projecto;

import com.java.projecto.modelos.ClienteModelo;

import java.util.Scanner;

public class Factura {

    private Cliente clientes = new Cliente();
    private ClienteModelo[] lista = clientes.getListaClientes();
    private Scanner scanner = new Scanner(System.in);

    public void Inciar(){
        int opcion =  0 ;
        do{
            this.Menu();
            do{
                if(scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                }
            }while (!scanner.hasNextInt());
            switch (opcion) {
                case 1:
                    this.GenerarFactura();
                    break;
                case 2:
                    this.GenerarTodasFacturas();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }while (opcion !=3);

    }


    private void Menu(){
        System.out.println("\n--- Menú Factura ---");
        System.out.println("1. Diseñadores");
        System.out.println("2. Supervisores");
        System.out.println("3. Clientes");
        System.out.print("Seleccione una opción: ");
    }


    private void GenerarFactura(){

    }

    private void GenerarTodasFacturas(){

    }

}
