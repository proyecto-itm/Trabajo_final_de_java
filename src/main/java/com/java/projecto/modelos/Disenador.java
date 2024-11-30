package com.java.projecto.modelos;

public class Disenador extends Persona {
   private String fecha;
   private String sexo;
   private String nivel;
   private int numero_proyecto;
   private int horas;

   // Constructor
   public Disenador(int identificacion, String nombre, String apellido, String direccion, String telefono, 
                    String fecha, String sexo, String nivel, int numero_proyecto, int horas) {
      super(identificacion, nombre, apellido, direccion, telefono);
      this.fecha = fecha;
      this.sexo = sexo;
      this.nivel = nivel;
      this.numero_proyecto = numero_proyecto;
      this.horas = horas;
   }

   // Métodos getters y setters
   public String getFecha() {
      return this.fecha;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public String getSexo() {
      return this.sexo;
   }

   public void setSexo(String sexo) {
      this.sexo = sexo;
   }

   public String getNivel() {
      return this.nivel;
   }

   public void setNivel(String nivel) {
      this.nivel = nivel;
   }

   public int getNumero_proyecto() {
      return this.numero_proyecto;
   }

   public void setNumero_proyecto(int numero_proyecto) {
      this.numero_proyecto = numero_proyecto;
   }

   public int getHoras() {
      return this.horas;
   }

   public void setHoras(int horas) {
      this.horas = horas;
   }

   // Método para calcular el salario dependiendo del nivel y las horas trabajadas
   public double calcularSalario(double valorHora) {
      return valorHora * this.horas;
   }

   // Método para mostrar la información del diseñador
   public String mostrarInformacion() {
      return this.getIdentificacion() + " - " + this.getNombre() + " " + this.getApellido() + " - " + this.nivel + " - " + this.numero_proyecto;
   }
}

