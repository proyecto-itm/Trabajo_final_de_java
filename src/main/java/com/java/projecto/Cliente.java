package com.java.projecto;

import com.java.projecto.modelos.ClienteModelo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cliente {
    
    private static final int MAX_ELEMENTOS = 50; // Tamaño máximo para cada matriz
    private static ClienteModelo[] listaClientes = new ClienteModelo[MAX_ELEMENTOS];
    private static int contadorClientes = 0;
        
    public void iniciar(Scanner scanner){
        int opcion = 0;
         do {
             
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Ingresar nuevo cliente");
            System.out.println("2. Mostrar todos los clientes almacenados");
            System.out.println("3. Calcular y mostrar el nivel de fidelidad del cliente");
            System.out.println("4. Mostrar el cliente con mayor cantidad de proyectos");
            System.out.println("5. Mostrar cantidad de clientes por tipo");
            System.out.println("6. Mostrar Clientes Ordenados por proyecto");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            switch (opcion) {
            case 1:
                ingresarNuevoCliente(scanner);
                break;
            case 2:
                getListaClientes();
                break;
            case 3:
                calcularNivelFidelidad();
                break;
            case 4:
                clienteMayorProyectos();
                break;
            case 5:
                mostrarClientesPorTipo();
                break;
            case 7:
                System.out.println("Volviendo al menú principal...");
                break;
            case 6:
                mostrarClientesOrdenadosPorProyectos();
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
            }
         } while (opcion != 7);          
    }
    private static void ingresarNuevoCliente(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;
        if (contadorClientes >= MAX_ELEMENTOS) {
        System.out.println("No se pueden agregar más clientes. Límite alcanzado.");
        return;
        }
        System.out.print("Ingrese la identificación del cliente: ");
        Integer identificacion = scanner.nextInt();
        scanner.nextLine ();
        // Verificar si el cliente ya existe
        
        for (int i = 0; i < contadorClientes; i++) {
            if (listaClientes[i].getIdentificacion() == identificacion) {
                System.out.println("El cliente ya existe. Intente con una identificación diferente.");
                return;
            }
        }
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente (o deje en blanco si es persona jurídica): ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el tipo de cliente (Persona Natural / Persona Juridica): ");
        String tipoCliente = scanner.nextLine();
        System.out.print("Ingrese la cantidad de proyectos asociados: ");
        int cantidadProyectos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese la fecha de inicio como cliente (yyyy-MM-dd): ");
        String fechaInicio = scanner.nextLine();
        try {
            fecha = sdf.parse(fechaInicio);  // Convertir el String a Date            
        } catch (Exception e) {
            System.out.println("Error en el formato de la fecha. Intente de nuevo.");
            return;
        }
        
        //Crear cliente y agregarlo al arreglo
        ClienteModelo  cliente = new ClienteModelo(identificacion,nombre, apellido, direccion, telefono, tipoCliente, cantidadProyectos, fecha);
        listaClientes[contadorClientes++] = cliente;
        System.out.println("Cliente Registrado Correctamente");        
    }
    private static void getListaClientes() {
        if (contadorClientes == 0){
            System.out.println("No hay clientes registrados");
            return;
        }
        System.out.println("---- Lista de Clientes ----");
        System.out.println("---- Nombre | Apellido | Direccion | Telefono | Proyectos | Fecha Inicio ----");
        for (int i = 0; i < contadorClientes; i++){
            System.out.println(listaClientes[i].getNombre() + " - " + listaClientes[i].getApellido() + 
                    " - " +listaClientes[i].getDireccion() + " - " + listaClientes[i].getTelefono() + " - " + listaClientes[i].getCantidad() + " proyectos"
                    + " - " + listaClientes[i].getFecha()
            );
        }
    }
    private static void calcularNivelFidelidad() {
        if (contadorClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("\n--- Nivel de Fidelidad de los Clientes ---");
        for (int i = 0; i < contadorClientes; i++) {
            ClienteModelo cliente = listaClientes[i];
            String nivelFidelidad = cliente.calcularNivelFidelidad(); // Método en clase Cliente
            System.out.println(cliente.getNombre()+ " " + cliente.getApellido() +  " - Nivel de Fidelidad: " + nivelFidelidad);
        }
    }
    private static void clienteMayorProyectos() {
        if (contadorClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        ClienteModelo clienteMayor = listaClientes[0];
        for (int i = 1; i < contadorClientes; i++) {
            if (listaClientes[i].getCantidad() > clienteMayor.getCantidad()) {
                clienteMayor = listaClientes[i];
            }
        }

        System.out.println("Cliente con más proyectos: " + clienteMayor.getNombre() + " " +  clienteMayor.getApellido() +
        " (" + clienteMayor.getCantidad() + " proyectos).");
    }
    private static void mostrarClientesPorTipo() {
        if (contadorClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        int personasNaturales = 0;
        int personasJuridicas = 0;

        for (int i = 0; i < contadorClientes; i++) {
            if (listaClientes[i].getTipo_cliente().equalsIgnoreCase("Persona Natural")) {
                personasNaturales++;
            } else if (listaClientes[i].getTipo_cliente().equalsIgnoreCase("Persona Juridica")) {
                personasJuridicas++;
            }
        }

        System.out.println("Cantidad de clientes:");
        System.out.println("Persona Natural: " + personasNaturales);
        System.out.println("Persona Juridica: " + personasJuridicas);
    }
    private static void mostrarClientesOrdenadosPorProyectos() {
        if (contadorClientes == 0) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        
        // Ordenar los clientes utilizando un algoritmo de ordenación básico (Bubble Sort)
        for (int i = 0; i < contadorClientes - 1; i++) {
            for (int j = 0; j < contadorClientes - 1 - i; j++) {
                if (listaClientes[j].getCantidad() < listaClientes[j + 1].getCantidad()) {
                    // Intercambiar los elementos de posición si el cliente j tiene menos proyectos que el cliente j+1
                    ClienteModelo temp = listaClientes[j];
                    listaClientes[j] = listaClientes[j + 1];
                    listaClientes[j + 1] = temp;
                }
            }
        }
        System.out.println("---- Clientes ordenados por Proyectos ----");
        for (int i = 0;i< contadorClientes; i++){
            System.out.println(listaClientes[i].getNombre() + " - " +  listaClientes[i].getApellido() + " - " + listaClientes[i].getCantidad() 
            + " proyectos" );
        }
        
    }    
    public String getNombreCliente(int identificacion ){
        String nombre = "";

        for (ClienteModelo listaCliente : listaClientes) {
            if (listaCliente != null) {
                if (listaCliente.getIdentificacion() == identificacion) {
                    nombre = listaCliente.getNombre() + listaCliente.getApellido();
                }
            }
        }

        return nombre;
    }

    public void setAgregarProyecto(int identificacion){
        int numero_proyecto;

        for (ClienteModelo listaCliente : listaClientes) {
            if (listaCliente != null) {
                if (listaCliente.getIdentificacion() == identificacion) {
                    numero_proyecto = listaCliente.getCantidad() +1;
                    listaCliente.setCantidad(numero_proyecto);
                }
            }
        }
    }
}
    
