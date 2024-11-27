package com.java.projecto;

import com.java.projecto.modelos.SupervisorModelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Supervisor {
    private final List<SupervisorModelo> listaSupervisores = new ArrayList<>();

    public void ingresarSupervisor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la identificación: ");
        int identificacion = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        for (SupervisorModelo sup : listaSupervisores) {
            if (sup.getIdentificacion() == identificacion) {
                System.out.println("Ya existe un supervisor con esta identificación.");
                return;
            }
        }

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese el sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Ingrese el área de supervisión: ");
        String area = scanner.nextLine();
        System.out.print("Ingrese el número de diseñadores supervisados: ");
        int numDisenadores = scanner.nextInt();
        System.out.print("Ingrese el número de proyectos supervisados: ");
        int numProyectos = scanner.nextInt();

        listaSupervisores.add(new SupervisorModelo(identificacion, nombre, apellido, direccion, 
                                                    telefono, fechaNacimiento, sexo, area, 
                                                    numDisenadores, numProyectos));
        System.out.println("Supervisor agregado correctamente.");
    }

    public void listarSupervisores() {
        for (SupervisorModelo sup : listaSupervisores) {
            System.out.println("ID: " + sup.getIdentificacion() + 
                               ", Nombre: " + sup.getNombre() + " " + sup.getApellido() +
                               ", Diseñadores: " + sup.getNumDisenadores() +
                               ", Proyectos: " + sup.getProyectosSupervisados());
        }
    }

    public void calcularSalario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el pago por diseñador supervisado: ");
        double pagoPorDisenador = scanner.nextDouble();

        for (SupervisorModelo sup : listaSupervisores) {
            double salario = sup.getNumDisenadores() * pagoPorDisenador;
            System.out.println("Supervisor " + sup.getNombre() + " " + sup.getApellido() +
                               " - Salario: " + salario);
        }
    }

    public void supervisorMenorEdad() {
        SupervisorModelo menor = listaSupervisores.stream()
                .min(Comparator.comparingInt(SupervisorModelo::calcularEdad))
                .orElse(null);

        if (menor != null) {
            System.out.println("Supervisor con menor edad: ID: " + menor.getIdentificacion() +
                               ", Nombre: " + menor.getNombre() + ", Apellido: " + menor.getApellido());
        }
    }

    public void contarSupervisoresPorArea() {
        listaSupervisores.stream()
                .map(SupervisorModelo::getArea)
                .distinct()
                .forEach(area -> {
                    long count = listaSupervisores.stream().filter(sup -> sup.getArea().equals(area)).count();
                    int totalDisenadores = listaSupervisores.stream()
                            .filter(sup -> sup.getArea().equals(area))
                            .mapToInt(SupervisorModelo::getNumDisenadores)
                            .sum();
                    System.out.println("Área: " + area + ", Supervisores: " + count + 
                                       ", Diseñadores Supervisados: " + totalDisenadores);
                });
    }

    public void listarSupervisoresPorEdadDesc() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el pago por diseñador supervisado: ");
        double pagoPorDisenador = scanner.nextDouble();

        listaSupervisores.stream()
                .sorted(Comparator.comparingInt(SupervisorModelo::calcularEdad).reversed())
                .forEach(sup -> {
                    double salario = sup.getNumDisenadores() * pagoPorDisenador;
                    System.out.println("Nombre: " + sup.getNombre() + " " + sup.getApellido() +
                                       ", Edad: " + sup.calcularEdad() + ", Salario: " + salario);
                });
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu de opciones:");
            System.out.println("1. Ingresar nuevo supervisor");
            System.out.println("2. Mostrar lista de supervisores");
            System.out.println("3. Calcular y mostrar salario");
            System.out.println("4. Supervisor con menor edad");
            System.out.println("5. Supervisores por área");
            System.out.println("6. Supervisores por edad y salario");
            System.out.println("7. Salir");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": ingresarSupervisor(); break;
                case "2": listarSupervisores(); break;
                case "3": calcularSalario(); break;
                case "4": supervisorMenorEdad(); break;
                case "5": contarSupervisoresPorArea(); break;
                case "6": listarSupervisoresPorEdadDesc(); break;
                case "7": System.out.println("Saliendo del programa."); return;
                default: System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor();
        supervisor.menu();
    }

    SupervisorModelo[] getListaDiseno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setAgregarProyecto(int identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
