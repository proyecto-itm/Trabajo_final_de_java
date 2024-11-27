package com.java.projecto;

import com.java.projecto.modelos.ClienteModelo;

import java.util.Scanner;

public class Factura {

        private static int consecutivoInicial = (int) (Math.random() * 100) + 1; //random me arroja numeros aleatorios entre 1 y 100
        private int numeroDeFactura;
        private Proyecto proyecto;

        public Factura(int numeroDeFactura, Proyecto proyecto) {
            this.numeroDeFactura = numeroDeFactura;
            this.proyecto = proyecto;
        }

        public int getNumeroDeFactura() {
            return numeroDeFactura;
        }

        public void setNumeroDeFactura(int numeroDeFactura) {
            this.numeroDeFactura = numeroDeFactura;
        }

        public Proyecto getProyecto() {
            return proyecto;
        }

        public void setProyecto(Proyecto proyecto) {
            this.proyecto = proyecto;
        }

        //realizamos metodo para calcular el iva
        public double calcularIVA(double total) {
            return total * 0.19;
        }

        //mostrar impresión o detalles
        public void verFactura() {
            System.out.println("Número de Factura = " + numeroDeFactura);
            System.out.println("Identificación Proyecto = " + proyecto.getId());
            System.out.println("Cliente: " + proyecto.getCliente().getClass());
            System.out.println("Servicios:");
            int[] servicios = proyecto.getServicios();
            double[] valores = proyecto.getValores();
            double total=0;

        }
    }
