package com.java.projecto;

import com.java.projecto.modelos.ClienteModelo;
import com.java.projecto.modelos.DisenoModelo;

import java.util.Scanner;

public class Disenador {

    private static final int MAX_ELEMENTOS = 50;
    static DisenoModelo[] listadisenadores = new DisenoModelo[MAX_ELEMENTOS];
    private static Scanner scanner = new Scanner(System.in);
    private static int totalDisenador = 0;

    public void Inicio() {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarNuevoDisenador();
                    break;
                case 2:
                    mostrarListaDisenadores();
                    break;
                case 3:
                    calcularSalarioDisenadores();
                    break;
                case 4:
                    disenadorConMasProyectos();
                    break;
                case 5:
                    mostrarCantidadPorNivel();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\n Menu de diseñador");
        System.out.println("1. Ingresar nuevo diseñador");
        System.out.println("2. Mostrar lista de diseñadores");
        System.out.println("3. Calcular salario de diseñadores");
        System.out.println("4. Diseñador con más proyectos");
        System.out.println("5. Cantidad de diseñadores por nivel");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void ingresarNuevoDisenador() {

        System.out.print("Ingrese la identificación: ");
        int id = scanner.nextInt();
        scanner.nextLine();


        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();


        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();


        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();


        System.out.print("Ingrese la fecha de nacimiento (DD/MM/AAAA): ");
        String fecha = scanner.nextLine();


        System.out.print("Ingrese el sexo (M/F): ");
        String sexo = scanner.nextLine();


        System.out.print("Ingrese el nivel (junior, master, senior): ");
        String nivel = scanner.nextLine();


        System.out.print("Ingrese el número de proyectos desarrollados: ");
        int numeroProyecto = scanner.nextInt();


        System.out.print("Ingrese el número de horas trabajadas: ");
        int horasTrabajadas = scanner.nextInt();
        scanner.nextLine();

        listadisenadores[totalDisenador++] = new DisenoModelo(id, nombre, apellido, direccion, telefono, fecha, sexo, nivel, numeroProyecto, horasTrabajadas);

        if (totalDisenador <= listadisenadores.length - 1) {
            totalDisenador = totalDisenador + 1;
        }


        System.out.println("Diseñador ingresado correctamente.");
    }


    private static void mostrarListaDisenadores() {
        for (DisenoModelo d : listadisenadores) {
            System.out.println(d.mostrarInformacion());
        }
    }

    // Calcular y mostrar salario
    private static void calcularSalarioDisenadores() {
        System.out.println("Ingrese el valor por hora de los diseñadores:");
        double valorHora = scanner.nextDouble();

        for (DisenoModelo d : listadisenadores) {
            double salario = d.calcularSalario(valorHora);
            System.out.println(d.getNombre() + " " + d.getApellido() + " - Salario: " + salario);
        }
    }

    // Diseñador con más proyectos
    private static void disenadorConMasProyectos() {
        if (totalDisenador == 0) {
            System.out.println("No hay diseñadores registrados.");
            return;
        }

        DisenoModelo maxProyectosDisenador = listadisenadores[0];

        for (DisenoModelo d : listadisenadores) {
            if (d.getNumero_proyecto() > maxProyectosDisenador.getNumero_proyecto()) {
                maxProyectosDisenador = d;
            }
        }

        System.out.println("El diseñador con más proyectos es:");
        System.out.println("Nombre: " + maxProyectosDisenador.getNombre() + " " + maxProyectosDisenador.getApellido());
        System.out.println("Número de proyectos: " + maxProyectosDisenador.getNumero_proyecto());
    }

    // Mostrar cantidad por nivel
    private static void mostrarCantidadPorNivel() {
        // Contar diseñadores por nivel (junior, máster, senior)
        int juniorCount = 0;
        int masterCount = 0;
        int seniorCount = 0;

        // Contar los diseñadores según su nivel
        for (DisenoModelo d : listadisenadores) {
            switch (d.getNivel().toLowerCase()) {
                case "junior":
                    juniorCount++;
                    break;
                case "master":
                    masterCount++;
                    break;
                case "senior":
                    seniorCount++;
                    break;
                default:
                    System.out.println("Nivel desconocido para diseñador con ID: " + d.getIdentificacion());
            }
        }

        // Mostrar resultados
        System.out.println("Cantidad de diseñadores por nivel:");
        System.out.println("Junior: " + juniorCount);
        System.out.println("Máster: " + masterCount);
        System.out.println("Senior: " + seniorCount);
    }


    public static DisenoModelo[] getListaDiseno() {
        return listadisenadores;
    }

    public void setAgregarProyecto(int identificacion) {
        int numero_proyecto;

        for (DisenoModelo listaDisenador : listadisenadores) {
            if (listaDisenador != null) {
                if (listaDisenador.getIdentificacion() == identificacion) {
                    numero_proyecto = listaDisenador.getNumero_proyecto() + 1;
                    listaDisenador.setNumero_proyecto(numero_proyecto);
                }
            }
        }
    }
}
