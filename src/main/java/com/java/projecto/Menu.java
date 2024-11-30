package com.java.projecto;

import com.java.projecto.modelos.Disenador;
import java.util.*;

public class Menu {
   private static List<Disenador> diseñadores = new ArrayList<>();
   private static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args) {
      boolean continuar = true;
      
      while (continuar) {
         mostrarMenu();
         int opcion = scanner.nextInt();
         scanner.nextLine(); // Limpiar el buffer
         
         switch(opcion) {
            case 1:
               ingresarNuevoDisenador();
               break;
            case 2:
               mostrarListaDiseñadores();
               break;
            case 3:
               calcularSalarioDiseñadores();
               break;
            case 4:
               diseñadorConMásProyectos();
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
      System.out.println("Seleccione una opción:");
      System.out.println("1. Ingresar nuevo diseñador");
      System.out.println("2. Mostrar lista de diseñadores");
      System.out.println("3. Calcular salario de diseñadores");
      System.out.println("4. Diseñador con más proyectos");
      System.out.println("5. Cantidad de diseñadores por nivel");
      System.out.println("6. Salir");
   }

   private static void ingresarNuevoDisenador() {
    // Ingresar la identificación
    System.out.print("Ingrese la identificación: ");
    int id = scanner.nextInt();
    scanner.nextLine();  // Limpiar el buffer

    // Ingresar el nombre
    System.out.print("Ingrese el nombre: ");
    String nombre = scanner.nextLine();

    // Ingresar el apellido
    System.out.print("Ingrese el apellido: ");
    String apellido = scanner.nextLine();

    // Ingresar la dirección
    System.out.print("Ingrese la dirección: ");
    String direccion = scanner.nextLine();

    // Ingresar el teléfono
    System.out.print("Ingrese el teléfono: ");
    String telefono = scanner.nextLine();

    // Ingresar la fecha de nacimiento
    System.out.print("Ingrese la fecha de nacimiento (DD/MM/AAAA): ");
    String fecha = scanner.nextLine();

    // Ingresar el sexo
    System.out.print("Ingrese el sexo (M/F): ");
    String sexo = scanner.nextLine();

    // Ingresar el nivel
    System.out.print("Ingrese el nivel (junior, master, senior): ");
    String nivel = scanner.nextLine();

    // Ingresar el número de proyectos
    System.out.print("Ingrese el número de proyectos desarrollados: ");
    int numeroProyecto = scanner.nextInt();

    // Ingresar el número de horas trabajadas
    System.out.print("Ingrese el número de horas trabajadas: ");
    int horasTrabajadas = scanner.nextInt();
    scanner.nextLine();  // Limpiar el buffer

    // Crear un nuevo diseñador con los datos obtenidos
    Disenador diseñador = new Disenador(id, nombre, apellido, direccion, telefono, fecha, sexo, nivel, numeroProyecto, horasTrabajadas);

    // Agregar el nuevo diseñador a la lista
    diseñadores.add(diseñador);

    // Confirmar que el diseñador fue agregado correctamente
    System.out.println("Diseñador ingresado correctamente.");
}


   // Mostrar lista de diseñadores
   private static void mostrarListaDiseñadores() {
      for (Disenador d : diseñadores) {
         System.out.println(d.mostrarInformacion());
      }
   }

   // Calcular y mostrar salario
   private static void calcularSalarioDiseñadores() {
      System.out.println("Ingrese el valor por hora de los diseñadores:");
      double valorHora = scanner.nextDouble();
      
      for (Disenador d : diseñadores) {
         double salario = d.calcularSalario(valorHora);
         System.out.println(d.getNombre() + " " + d.getApellido() + " - Salario: " + salario);
      }
   }

   // Diseñador con más proyectos
private static void diseñadorConMásProyectos() {
    if (diseñadores.isEmpty()) {
        System.out.println("No hay diseñadores registrados.");
        return;
    }

    Disenador maxProyectosDisenador = diseñadores.get(0);

    for (Disenador d : diseñadores) {
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
    for (Disenador d : diseñadores) {
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
} // Fin del método mostrarCantidadPorNivel
} // Fin de la clase Menu





