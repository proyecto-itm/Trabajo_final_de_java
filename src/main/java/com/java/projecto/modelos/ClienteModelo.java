
package com.java.projecto.modelos;


public class ClienteModelo extends PersonaModelo{
 private String tipo_cliente;
 private int cantidad;
 private String fecha; 
 
 public ClienteModelo(int identificacion, String nombre, String apellido,
         String direccion, String telefono,String tipo_cliente, 
         int cantidad,String fecha){
     
     super(identificacion,nombre,apellido,direccion,telefono);
     this.tipo_cliente = tipo_cliente;
     this.cantidad = cantidad;
     this.fecha = fecha;
 }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
