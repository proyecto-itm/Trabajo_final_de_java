
package com.java.projecto.modelos;

import java.util.Date;


public class ClienteModelo extends PersonaModelo{
 private String tipo_cliente;
 private int cantidad;
 private Date fecha; 
 
 public ClienteModelo(int identificacion, String nombre, String apellido,
         String direccion, String telefono,String tipo_cliente, 
         int cantidad,Date fecha){
     
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String calcularNivelFidelidad() {
        long tiempo = new Date().getTime() - fecha.getTime();
        int años = (int) (tiempo / (1000L * 60 * 60 * 24 * 365));

        if (años < 2) {
            return "Novel";
        } else if (años <= 5) {
            return "Plus";
        } else {
            return "Premium";
        }
    }
}
