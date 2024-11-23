
package com.java.projecto.modelos;

public class SupervisorModelo extends PersonaModelo{
    private String fecha_nacimiento;
    private String sexo;
    private String area;
    private int numero_disenador;
    private int proyecto_supervisado;
    public SupervisorModelo(int identificacion, String nombre, String apellido, 
            String direccion, String telefono,String fecha_nacimiento,
            String sexo,String area,int numero_disenador,
            int proyecto_supervisado) {
        super(identificacion, nombre, apellido, direccion, telefono);
        
        this.fecha_nacimiento =fecha_nacimiento;
        this.sexo =sexo;
        this.area =area;
        this.numero_disenador =numero_disenador;
        this.proyecto_supervisado =proyecto_supervisado;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getNumero_disenador() {
        return numero_disenador;
    }

    public void setNumero_disenador(int numero_disenador) {
        this.numero_disenador = numero_disenador;
    }

    public int getProyecto_supervisado() {
        return proyecto_supervisado;
    }

    public void setProyecto_supervisado(int proyecto_supervisado) {
        this.proyecto_supervisado = proyecto_supervisado;
    }
    
}
