package edu.umg;

import java.util.ArrayList;

public class ColaServicio {
    //Declarar las variables
    private String urgencia;
    private static ArrayList<Ticket> cola = new ArrayList();
    
    //Getters: Muestra el nivel de urgencia en el que se encuentra el tiket
    public String getUrgencia() {
        return urgencia;
    }

    //Setters: Establecemos el Nivel de emergencia
    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }
    
    //Con este se mostrara el nivel de urgencia que se encuentra e ticket
    public ColaServicio(String urgencia){
        this.urgencia = urgencia;
    }
  
    //Se podra agregar los tickets
    public void agregar(Ticket ticket1){
        cola.add(ticket1);
    }
    
    //Con esta funcion se podra resolver los
    public Ticket Resolver (String nitUsuario){
        Ticket usuario = null;
        for(int i = 0; i < cola.size(); i++){
            if(nitUsuario.equals(cola.get(i).getNitUsuario())){
                usuario = cola.get(i);
            }
        }
        return usuario;
    }
    
    //Ara que muestra la bitacora 
    public void MostrarBitacora(){
        for (int i = 0; i < cola.size(); i ++){
            System.out.println(cola.get(i));
            System.out.println("***************************");
        }
    }
    
    public String toString(){
        return "Nivel de Urgencia: " + this.urgencia;
    }
}