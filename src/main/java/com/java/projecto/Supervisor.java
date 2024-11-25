package com.java.projecto;

import com.java.projecto.modelos.ClienteModelo;
import com.java.projecto.modelos.SupervisorModelo;

public class Supervisor {

    private SupervisorModelo[] listaSupervisores = new SupervisorModelo[50];
    
    
    public void setListaDiseno(SupervisorModelo[] listaDiseno) {
        this.listaSupervisores = listaDiseno;
    }

    public void setAgregarProyecto(int identificacion){
        int numero_proyecto;
        
        for (SupervisorModelo listaSupervisor : listaSupervisores) {
            if (listaSupervisor != null) {
                if (listaSupervisor.getIdentificacion() == identificacion) {
                    numero_proyecto = listaSupervisor.getProyecto_supervisado() +1;
                    listaSupervisor.setProyecto_supervisado(numero_proyecto);
                }
            }

        }
    }

}

