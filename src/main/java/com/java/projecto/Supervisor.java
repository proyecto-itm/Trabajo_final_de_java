package com.java.projecto;

import com.java.projecto.modelos.DisenoModelo;
import com.java.projecto.modelos.SupervisorModelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Supervisor {
    private SupervisorModelo[] listaSupervisores = new SupervisorModelo[50];
    private int contadorSupervisores = 0; // Controla cuántos supervisores hay en el arreglo

    // Método para ingresar un nuevo supervisor
    public void ingresarSupervisor() {
        if (contadorSupervisores >= listaSupervisores.length) {
            System.out.println("No se pueden agregar más supervisores. Capacidad máxima alcanzada.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la identificación del supervisor: ");
        int identificacion = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea restante

        // Verificar si la identificación ya existe
        for (int i = 0; i < contadorSupervisores; i++) {
            if (listaSupervisores[i].getIdentificacion() == identificacion) {
                System.out.println("Ya existe un supervisor con esta identificación.");
                return;
            }
        }

        // Captura de datos del supervisor
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Ingrese el sexo: ");
        String sexo = scanner.nextLine();

        System.out.print("Ingrese el área de supervisión (Educación, Pymes, Empresas, Individual): ");
        String area = scanner.nextLine();

        System.out.print("Ingrese el número de diseñadores supervisados: ");
        int numDisenadores = scanner.nextInt();

        System.out.print("Ingrese el número de proyectos supervisados: ");
        int numProyectos = scanner.nextInt();

        // Crear y agregar el supervisor al arreglo
        SupervisorModelo nuevoSupervisor = new SupervisorModelo(
                identificacion, nombre, apellido, direccion, telefono,
                LocalDate.parse(fechaNacimiento), sexo, area, numDisenadores, numProyectos
        );
        listaSupervisores[contadorSupervisores] = nuevoSupervisor;
        contadorSupervisores++;

        System.out.println("Supervisor agregado correctamente.");
    }

    // Método para listar supervisores
    public void listarSupervisores() {
        if (contadorSupervisores == 0) {
            System.out.println("No hay supervisores registrados.");
            return;
        }

        System.out.println("Lista de supervisores:");
        for (int i = 0; i < contadorSupervisores; i++) {
            SupervisorModelo supervisor = listaSupervisores[i];
            System.out.println("ID: " + supervisor.getIdentificacion() +
                    ", Nombre: " + supervisor.getNombre() +
                    ", Diseñadores: " + supervisor.getNumDisenadores() +
                    ", Proyectos: " + supervisor.getProyectosSupervisados());
        }
    }

    // Método para calcular el salario de cada supervisor
    public void calcularSalario() {
        if (contadorSupervisores == 0) {
            System.out.println("No hay supervisores registrados.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el pago por diseñador supervisado: ");
        double pagoPorDisenador = scanner.nextDouble();

        for (int i = 0; i < contadorSupervisores; i++) {
            SupervisorModelo supervisor = listaSupervisores[i];
            double salario = supervisor.getNumDisenadores() * pagoPorDisenador;
            System.out.println("Supervisor " + supervisor.getNombre() + " " + supervisor.getApellido() +
                    " - Salario: " + salario);
        }
    }

    // Método para encontrar el supervisor más joven
    public void supervisorMenorEdad() {
        if (contadorSupervisores == 0) {
            System.out.println("No hay supervisores registrados.");
            return;
        }

        SupervisorModelo menorEdadSupervisor = listaSupervisores[0];
        for (int i = 1; i < contadorSupervisores; i++) {
            if (calcularEdad(listaSupervisores[i].getFechaNacimiento()) <
                    calcularEdad(menorEdadSupervisor.getFechaNacimiento())) {
                menorEdadSupervisor = listaSupervisores[i];
            }
        }

        System.out.println("Supervisor con menor edad: ID: " + menorEdadSupervisor.getIdentificacion() +
                ", Nombre: " + menorEdadSupervisor.getNombre() + " " + menorEdadSupervisor.getApellido());
    }

    // Método para contar supervisores por área
    public void contarSupervisoresPorArea() {
        if (contadorSupervisores == 0) {
            System.out.println("No hay supervisores registrados.");
            return;
        }

        int educacion = 0, pymes = 0, empresas = 0, individual = 0;
        for (int i = 0; i < contadorSupervisores; i++) {
            switch (listaSupervisores[i].getArea()) {
                case "Educación":
                    educacion++;
                    break;
                case "Pymes":
                    pymes++;
                    break;
                case "Empresas":
                    empresas++;
                    break;
                case "Individual":
                    individual++;
                    break;
            }
        }

        System.out.println("Supervisores por área:");
        System.out.println("Educación: " + educacion);
        System.out.println("Pymes: " + pymes);
        System.out.println("Empresas: " + empresas);
        System.out.println("Individual: " + individual);
    }

    // Método para calcular edad a partir de la fecha de nacimiento
    private int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Menú principal
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Ingresar nuevo supervisor");
            System.out.println("2. Mostrar lista de supervisores");
            System.out.println("3. Calcular y mostrar salario");
            System.out.println("4. Supervisor con menor edad");
            System.out.println("5. Supervisores por área");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarSupervisor();
                    break;
                case 2:
                    listarSupervisores();
                    break;
                case 3:
                    calcularSalario();
                    break;
                case 4:
                    supervisorMenorEdad();
                    break;
                case 5:
                    contarSupervisoresPorArea();
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
    public SupervisorModelo[] getListaSupervisores() {
        return listaSupervisores;
    }

    public void setAgregarProyecto(int identificacion) {
        int numero_proyecto;

        for (SupervisorModelo listaSupervisor : listaSupervisores) {
            if (listaSupervisor != null) {
                if (listaSupervisor.getIdentificacion() == identificacion) {
                    numero_proyecto = listaSupervisor.getProyectosSupervisados() + 1;
                    listaSupervisor.setProyectosSupervisados(numero_proyecto);
                }
            }
        }
    }
}
