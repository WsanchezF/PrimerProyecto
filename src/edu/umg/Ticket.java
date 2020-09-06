package edu.umg;

import java.util.ArrayList;

public class Ticket{
    //psvm + tab
    //Atributos
    //Declarar as variables
    private String nitUsuario;
    private int id;
    private String problema;
    private String estado;
    ArrayList<Bitacora> bitacora;
    
    //Se crea un constructor en el cual se almacenara datos
    public Ticket(){
    
    }
    
    //Constructor con parametros(con datos en los parentesis)
    public Ticket(int id, String nitUsuario, String problema,String estado){
        //Objetos
        this.id = id;
        this.nitUsuario = nitUsuario;
        this.problema = problema;
        this.estado = estado;
        bitacora = new ArrayList();
    }
    
    
    public void addBitacora(Bitacora bi){
        bitacora.add(bi);
    }
    
    //Getters: Muestra el Nit del usuario
    public String getNitUsuario() {
        return nitUsuario;
    }
    
    //Setters: Establecemos el Nit del Usuario
    public void setNitUsuario(String nitUsuario) {
        this.nitUsuario = nitUsuario;
    }
    
    //Getters: Muestra el id
    public int getId() {
        return id;
    }
    
    //Setters: Establecemos el id del ticket
    public void setId(int id) {
        this.id = id;
    }
    
    //Getters: Muestra el problema del ticket
    public String getProblema() {
        return problema;
    }
    
    //Setters: Establecemos loq ue seria el problema 
    public void setProblema(String problema) {
        this.problema = problema;
    }
    
     //Getters: Muestra el estado en el que se encuenta el ticket
    public String getEstado() {
        return estado;
    }
    
    //Setters: Establecemos el estado en el que se cuentra el ticket
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString(){
        return "Id: " + this.id + "\nNit Usuario: " + this.nitUsuario +"\nProblema: " + this.problema +"\nCola: " + this.estado +"\n\tBitacora: " + bitacora;
    }
}