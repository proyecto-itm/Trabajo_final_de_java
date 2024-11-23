
package com.java.projecto.modelos;


public class DisenoModelo extends PersonaModelo{
    
    private String fecha;
    private String sexo;
    private String nivel;
    private int numero_proyecto;
    private int horas;

    public DisenoModelo(int identificacion, String nombre, String apellido,
            String direccion, String telefono,String fecha,String sexo,
            String nivel,int numero_proyecto,int horas) {
        super(identificacion, nombre, apellido, direccion, telefono);
    
        this.fecha =fecha;
        this.sexo = sexo;
        this.nivel = nivel;
        this.numero_proyecto = numero_proyecto;
        this.horas = horas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNumero_proyecto() {
        return numero_proyecto;
    }

    public void setNumero_proyecto(int numero_proyecto) {
        this.numero_proyecto = numero_proyecto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    
    
}
