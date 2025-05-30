package com.java.projecto.modelos;

public class Persona {
    private int identificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
 
    // Constructor
    public Persona(int identificacion, String nombre, String apellido, String direccion, String telefono) {
       this.identificacion = identificacion;
       this.nombre = nombre;
       this.apellido = apellido;
       this.direccion = direccion;
       this.telefono = telefono;
    }
 
    // Métodos getters y setters
    public int getIdentificacion() {
       return identificacion;
    }
 
    public void setIdentificacion(int identificacion) {
       this.identificacion = identificacion;
    }
 
    public String getNombre() {
       return nombre;
    }
 
    public void setNombre(String nombre) {
       this.nombre = nombre;
    }
 
    public String getApellido() {
       return apellido;
    }
 
    public void setApellido(String apellido) {
       this.apellido = apellido;
    }
 
    public String getDireccion() {
       return direccion;
    }
 
    public void setDireccion(String direccion) {
       this.direccion = direccion;
    }
 
    public String getTelefono() {
       return telefono;
    }
 
    public void setTelefono(String telefono) {
       this.telefono = telefono;
    }
}