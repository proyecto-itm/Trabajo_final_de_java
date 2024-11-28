package com.java.projecto;

import com.java.projecto.modelos.*;

import java.util.Objects;
import java.util.Scanner;

public class Proyecto {
    private static final int MAX_ELEMENTOS = 2;
    private ProyectoModelo listaProyecto[] = new ProyectoModelo[MAX_ELEMENTOS];
    private Supervisor supervisor = new Supervisor();
    private Disenador disenador = new Disenador();
    private Cliente cliente = new Cliente();
    private int totalProyectos = 0;
    private Scanner scanner = new Scanner(System.in);





    public ProyectoModelo[] Inicio (){
        int opcion = 0;
        boolean validar = true;
        do{
            this.menu();
            do{
                validar = scanner.hasNextInt();
                if(validar){
                    opcion = scanner.nextInt();
                }
            }while(!validar);

            switch (opcion){
                case 1:
                    this.CraerProyecto();
                    break;
                case 2:
                    this.RegistrarServicio();
                    break;
                case 3:
                    this.MostrarProyecto();
                    break;
                case 4:
                    this.ProyectoMayorValor();
                    break;
                case 5:
                    ProyectoValorSuperior();
                    break;
                case 6:
                    System.out.println("Saliendo del modulo de proyectos");
                    scanner.close();
                    break;
                default:
                    System.out.println("La opción elegida no existe");
                    break;
            }
        }while (opcion != 6);
        return listaProyecto;
    }
    private void menu(){

        System.out.println("\n--- Menú de Proyectos ---");
        System.out.println("1. Crear nuevo proyecto");
        System.out.println("2. Registrar nuevo servicio a un proyecto");
        System.out.println("3. Mostrar lista de todos los proyectos");
        System.out.println("4. Proyecto de mayor valor");
        System.out.println("5. Proyectos con valor superior a una cifra");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void CraerProyecto(){
        String fechaInicio;
        String descripcion;
        if (totalProyectos >= listaProyecto.length) {
            System.out.println("No se pueden agregar más proyectos.");
            return;
        }

        int codigo = this.ValidarIdentificacionCodigo();
        int idDisenador = this.ValidarIdentificacionDisenador();
        int idSupervisor = this.ValidarIdentificacionSupervisor();
        int idCliente =  this.ValidarIdentificacionCliente();
        int numeroDeserviocio = this.ValidarIngreso("servicios");
        System.out.print("Ingrese la fecha de inicio (DD/MM/YYYY): ");
         fechaInicio = scanner.next();
        System.out.print("Ingrese la descripción del proyecto: ");

        descripcion = scanner.next();
        listaProyecto[totalProyectos++] = new ProyectoModelo(codigo,fechaInicio,descripcion,idDisenador, idSupervisor,
                idCliente,numeroDeserviocio);
        System.out.println("Proyecto creado exitosamente.");
        this.AgregarCliente(idCliente);
        this.AgregarSupervisor(idSupervisor);
        this.AgregarDisenador(idDisenador);
    }

    private void AgregarCliente(int identificacion){
        cliente.setAgregarProyecto(identificacion);
    }

    private void AgregarSupervisor(int identificacion){
        supervisor.setAgregarProyecto(identificacion);
    }

    private void AgregarDisenador(int identificacion){
        disenador.setAgregarProyecto(identificacion);
    }

    private void RegistrarServicio(){

        int codigoProyecto = this.ValidarIngreso("proyecto");
        ProyectoModelo proyecto = BuscarProyecto(codigoProyecto);

        if (proyecto == null) {
            System.out.println("El proyecto no existe.");
            return;
        }

        int codigoServicio = this.ValidarIngreso("servicio");

        System.out.print("Ingrese la descripción del servicio: ");


        String descripcion = scanner.next();
        System.out.print("Ingrese el valor unitario del servicio: ");

        double valorUnitario = scanner.nextDouble();

        proyecto.agregarServicio(new ServicioModelo(codigoServicio, descripcion, valorUnitario));
        System.out.println("Servicio agregado exitosamente.");

    }
    private void MostrarProyecto() {
        String nombre;
        int identificacion = 0;
        for (int i = 0; i <= totalProyectos-1; i++) {
            ProyectoModelo p = listaProyecto[i];


            identificacion = p.getIdCliente();
            nombre = cliente.getNombreCliente(identificacion);
            System.out.println("Proyecto: " + p.getCodigo());
            System.out.println("Cliente: " + nombre);
            System.out.println("Descripción: " + p.getDescripcion());
            System.out.println("Subtotal: " +  p.calcularSubtotal());
            System.out.println("IVA: " + p.calcularIVA());
            System.out.println("Total: " + p.calcularTotal());
        }
    }
    private void ProyectoMayorValor(){
        String nombre;
        if (totalProyectos == 0) {
            System.out.println("No hay proyectos registrados.");
            return;
        }

        ProyectoModelo mayor = listaProyecto[0];
        for (int i = 1; i < totalProyectos; i++) {
            if (listaProyecto[i].calcularTotal() > mayor.calcularTotal()) {
                mayor = listaProyecto[i];
            }
        }

        nombre = cliente.getNombreCliente(mayor.getIdCliente());
        System.out.println("Proyecto con mayor valor");
        System.out.println("Codigo: " + mayor.getCodigo());
        System.out.println("Nombre cliente: "+ nombre);
        System.out.println("Total:" + mayor.calcularTotal());
    }


    private void ProyectoValorSuperior(){
        int registroSuperores = 0;
        System.out.println("Ingresar el valor");
        double valor = scanner.nextDouble();
        String nombre;
        if (totalProyectos == 0) {
            System.out.println("No hay proyectos registrados.");
            return;
        }

        for (int i = 0; i < totalProyectos; i++) {
            if (this.listaProyecto[i].calcularTotal() > valor) {
                registroSuperores++;
            }
        }

        ProyectoModelo[] listaProyecto = new  ProyectoModelo[registroSuperores];

        for (int i = 0; i < totalProyectos; i++) {
            if (this.listaProyecto[i].calcularTotal() > valor) {
                listaProyecto[i] = this.listaProyecto[i];
            }
        }

        for (int i = 0; i < listaProyecto.length; i++){
            nombre = cliente.getNombreCliente(listaProyecto[i].getIdCliente());
            System.out.println("Proyecto con mayor valor");
            System.out.println("Codigo: " + listaProyecto[i].getCodigo());
            System.out.println("Nombre cliente: "+ nombre);
            System.out.println("Total:" + listaProyecto[i].calcularTotal());
            System.out.println("\n");
        }

    }

    private ProyectoModelo BuscarProyecto(int codigo) {
        for (int i = 0; i < totalProyectos; i++) {
            if (listaProyecto[i].getCodigo() == codigo) {
                return listaProyecto[i];
            }
        }
        return null;
    }


    private int ValidarIdentificacionCodigo(){
        int idCodigo;
        int existe = 0;

        boolean salir = false;

        do{
            idCodigo = this.ValidarIngreso("codigo");
            for(int i = 0; i< listaProyecto.length;i++){
                if(this.listaProyecto[i] != null){
                    if(listaProyecto[i].getCodigo() == idCodigo){
                        existe = 1;
                    }
                }
            }

            if(existe == 1){
                System.out.print("El codigo del proyecto ya  existe");
            }else{
                salir = true;
            }

        }while(!salir);
        return idCodigo;
    }


    private int ValidarIdentificacionDisenador(){
        int idDisenador;
        int existe = 0;
        boolean salir = false;
        DisenoModelo[]  listaDisenadores = this.disenador.getListaDiseno();
        do{
            idDisenador = this.ValidarIngreso("Diseñador");
            for (DisenoModelo listaDisenador : listaDisenadores) {
                if (listaDisenador != null) {
                    if (listaDisenador.getIdentificacion() == idDisenador) {
                        existe = 1;
                        salir = true;
                    }
                }
            }

            if(existe == 0){
                System.out.print("La identificación del Diseñador no existe \n");
            }


        }while(!salir);
        return idDisenador;
    }

    private int ValidarIdentificacionSupervisor(){
        int idSupervisor;
        int existe = 0;
        boolean salir = false;
        SupervisorModelo[]  listaSupervisores = this.supervisor.getListaSupervisores();
        do{
            idSupervisor = this.ValidarIngreso("Supervisor");
            for (SupervisorModelo listaSupervisor : listaSupervisores) {
                if (listaSupervisor != null) {
                    if (listaSupervisor.getIdentificacion() == idSupervisor) {
                        existe = 1;
                        salir = true;
                    }
                }
            }

            if(existe == 0){
                System.out.print("La identificacion del supervisor no existe");
            }

        }while(!salir);
        return idSupervisor;
    }

    private int ValidarIdentificacionCliente(){
        int idCliente;
        int existe = 0;
        boolean salir = false;
       ClienteModelo[]  listaClientes = this.cliente.getListasClientes();
        idCliente =  this.ValidarIngreso("Cliente");
        do{

            for (ClienteModelo cliente : listaClientes) {
                if (cliente != null) {
                    if (cliente.getIdentificacion() == idCliente) {
                        existe = 1;
                        salir = true;
                    }
                }
            }

            if(existe == 0){
                System.out.print("La identificacion del cliente no existe");
            }


        }while(!salir);

        return idCliente;
    }

    private int  ValidarIngreso(String tipoCampo){
        boolean salir = true;
        int numero = 0;
        if(Objects.equals(tipoCampo, "codigo")){
            System.out.print("Ingrese el "+ tipoCampo +" de la proyecto: ");
        }else if(Objects.equals(tipoCampo, "servicios")){
            System.out.print("Ingrese el codigo del  "+tipoCampo+ " : ");
        }
        else{
            System.out.print("Ingrese la identificación del " +tipoCampo+ ":");
        }

        do{
            salir = this.scanner.hasNextInt();
            if(salir){
                numero = this.scanner.nextInt();
            }else{
                System.out.print("Lo ingresado no es un numero¨ \n");
            }
        }while (!salir);
        return numero;
    }
}
