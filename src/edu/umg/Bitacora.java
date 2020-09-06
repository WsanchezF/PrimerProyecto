package edu.umg;

import java.util.Date;

public class Bitacora {
    //Declarar las variables
    private int nitSoporte;
    private Date fechaHora;
    private boolean mensaje;
    
    //Se crea un constructor en el cual se almancenaran datos
    public Bitacora(){
        
    }
    
    //Constructor con parametros(con datos en los parentesis)
    public Bitacora(int nitSoporte, Date fechaHora, boolean mensaje){
        //Objetos
        this.nitSoporte = nitSoporte;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
    }

    //Getters: Muestra el Nit del soporte 
    public int getNitSoporte() {
        return nitSoporte;
    }

     //Setters: Establecemos el Nit de Soporte
    public void setNitSoporte(int nitSoporte) {
        this.nitSoporte = nitSoporte;
    }

    //Getters:Muestra la fecha que fue creada
    public Date getFechaHora() {
        return fechaHora;
    }

    //Setters: Establecemos  la fecha y hora
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    //Getters: Muestra el mensaje
    public boolean iaMensaje() {
        return mensaje;
    }

    //Setters: Establecemos  el mensaje
    public void setMensaje(boolean mensaje) {
        this.mensaje = mensaje;
    }
    
    
    @Override
    public String toString(){
        String msj = "El ticket esta en PROCESO";
        if(this.mensaje == true){
            msj = "El ticket a sido RESUELTO";
        }
        return "NIT Soporte: " + nitSoporte + "\n\t\t   Fehca/Hora: " + fechaHora + "\n\t\t   Mensaje: " + msj;
    }
}
