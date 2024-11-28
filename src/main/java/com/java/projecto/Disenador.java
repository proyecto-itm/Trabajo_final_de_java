package com.java.projecto;

import com.java.projecto.modelos.ClienteModelo;
import com.java.projecto.modelos.DisenoModelo;

public class Disenador {

    private DisenoModelo[] listaDiseno = new DisenoModelo[50];



    public DisenoModelo[] getListaDiseno() {
        return listaDiseno;
    }

    public void setListaDiseno(DisenoModelo[] listaDiseno) {
        this.listaDiseno = listaDiseno;
    }


    public void setAgregarProyecto(int identificacion){
        int numero_proyecto;

        for (DisenoModelo listaDisenador : listaDiseno) {
            if (listaDisenador != null) {
                if (listaDisenador.getIdentificacion() == identificacion) {
                    numero_proyecto = listaDisenador.getNumero_proyecto() +1;
                    listaDisenador.setNumero_proyecto(numero_proyecto);
                }
            }
        }
    }
}
