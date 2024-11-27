package com.java.projecto.modelos;

import java.time.LocalDate;
import java.time.Period;

public class SupervisorModelo {
    private int identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String area;
    private int numDisenadores;
    private int proyectosSupervisados;

    public SupervisorModelo(int identificacion, String nombre, String apellido, String direccion, 
                            String telefono, LocalDate fechaNacimiento, String sexo, String area, 
                            int numDisenadores, int proyectosSupervisados) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.area = area;
        this.numDisenadores = numDisenadores;
        this.proyectosSupervisados = proyectosSupervisados;
    }

    public int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    // Getters y Setters
    public int getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getArea() { return area; }
    public int getNumDisenadores() { return numDisenadores; }
    public int getProyectosSupervisados() { return proyectosSupervisados; }

    public void setProyectosSupervisados(int proyectosSupervisados) {
        this.proyectosSupervisados = proyectosSupervisados;
    }
}
