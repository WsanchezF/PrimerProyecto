package edu.umg;

import java.util.ArrayList;

public class ColaServicio {
    //Declarar las variables
    private String estado;
    private static ArrayList<Ticket> cola = new ArrayList();
    
    //
    public ColaServicio(String estado){
        this.estado = estado;
    }
  
    public void agregar(Ticket ticket1){
        cola.add(ticket1);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Ticket Resolver (String nitUsuario){
        Ticket usuario = null;
        for(int i = 0; i < cola.size(); i++){
            if(nitUsuario.equals(cola.get(i).getNitUsuario())){
                usuario = cola.get(i);
            }
        }
        return usuario;
    }
    
    public void MostrarBitacora(){
        for (int i = 0; i < cola.size(); i ++){
            System.out.println(cola.get(i));
            System.out.println("***************************");
        }
    }
    
    public String toString(){
        return "Nivel de Urgencia: " + this.estado;
    }
}