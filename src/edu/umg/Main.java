package edu.umg;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    
    private static ArrayList<ColaServicio> servicio = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    JSONParser parser = new JSONParser();
    
    public static void main(String[] args) {
        
        System.out.println("---------------PROYECTO 1 OPEN SOURCE TICKET REQUEST SYSTEM (OTRS)---------------");
        
        //El menu princial en el cual se nos preguntara como deseamos ingresar sin como cliente o empleado
        int opcion = 0;
        do{
            System.out.println("\n..........MENU PRINCIPAL............");
            System.out.println("1...........CLIENTE");
            System.out.println("2...........EMPLEADO");
            System.out.println("3...........SALIR");
            System.out.print("Ingrese su opcion: ");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    int option = 0;
                    do{
                        //Si decidimos que entraremos como cluente se nos mostrara
                        //2 opcines la cual sera agregar un nuevo ticket o mostra el estado del ticket del empleado
                        System.out.println("\n..........MENU CLIENTES............");
                        System.out.println("1...........NUEVO TICKET");
                        System.out.println("2...........MOSTRAR BITACORA DE TICKET");
                        System.out.println("0...........REGRESAR");
                        System.out.print("Ingrese su opcion: ");
                        option = sc. nextInt();
                        
                        switch(option){
                            case 1:
                                
                                int Id = 21;
                                Id = (int) (Math.random() *50);
                                
                                //A continuacion deberemos agregar los siguiente
                                String datos1,datos2,datos3;
                                System.out.println("\n\tIngrese los siguientes datos.");
                                System.out.print("Ingrese el Nit:  ");
                                datos1 = sc.next();
                                System.out.print("Ingrese el Problema:  ");
                                datos2 = sc.next();
                                System.out.print("Ingrese la cola:  ");
                                datos3 = sc.next();
                                Ticket ticket = new Ticket(Id,datos1, datos2,datos3);
                                
                                int no_urgencia = 0;
                                String urgencia = "";
                                
                                //Se nos preguntara cual es la urgencia del ticket
                                if(servicio.isEmpty()){
                                    no_urgencia = 0;
                                    System.out.print("Nivel de urgencia:  ");
                                    urgencia = sc.next();
                                } else {
                                    for (int i = 0; i < servicio.size(); i++){
                                        System.out.println(i + "- - ->" + servicio.get(i).getUrgencia());
                                    }
                                    //Se podra agrear un nuevo nivel de urgencia si el usuario lo desea
                                    System.out.println(servicio.size() + "- - > Nuevo nivel");
                                    
                                    System.out.print("Seleccione un Nivel: ");
                                    no_urgencia = sc.nextInt();
                                    
                                    if(no_urgencia >= servicio.size()){
                                        System.out.print("Nivel de urgencia: ");
                                        sc.nextLine();
                                        urgencia = sc.next();
                                    }
                                }
                                
                                //Para la fecha se utilizara un Date el cual servira para generar la fecha en la  
                                //que se creo el ticket
                                //Un random para el nit del soporte
                                Date fecha = new Date();
                                int random = 0;
                                random = (int) (Math.random() *1000);
                                ticket.addBitacora(new Bitacora(random, fecha, false));
                                
                                AgregarTicket(no_urgencia, urgencia, ticket);
                                break; 
                            case 2:
                                //El case 2 sirve para mostrar los ticket que el usuario ha ingresado
                                BitacoraT();
                                break;
                            default:
                                if(option !=0){
                                    System.out.println("Opcion invalida");
                                }
                                break;
                        }
                    }while(option !=0);
                    break;
                
                case 2:
                    int respuesta = 0;
                    do{
                        //La opcion 2 del meni principal lo dejara acceder
                        //a los ticket igresados por el usuario y mostrar el reporte del total de los tickets
                        System.out.println("\n..........MENU EMPLEADO............");
                        System.out.println("1...........SOLUCIONAR TICKET");
                        System.out.println("2...........MOSTRAR REPORTE DE TICKETS RECIENTES");
                        System.out.println("3...........MOSTRAR REPORTE DEL TOTAL DE TICKETS");
                        System.out.println("0...........REGRESAR");
                        System.out.print("Ingrese su opcion: ");
                        respuesta = sc. nextInt();
                        
                        switch(respuesta){
                            case 1:
                                System.out.print("Ingrese el Nit del Usuario:  ");
                                String msj = sc.next();
                                Solucion(msj);
                                break;
                            case 2:
                                BitacoraT();
                                break;
                            case 3:
                                MostrarTickets();
                                break;
                            default:
                                if(respuesta !=0){
                                    System.out.println("Opcion invalida");
                                }
                                break;
                        }
                    } while(respuesta !=0);
                    break;
                default:
                    if(opcion !=0){
                        System.out.println("Opcion invalida");
                    }
                    break;
            }
        } while(opcion !=3);
    }
    
    //Sirve para poder agreagar un nievo ticket
    public static void AgregarTicket(int no_urgencia, String urgencia, Ticket ticket1){
        
        if(no_urgencia < servicio.size()){
            servicio.get(no_urgencia).agregar(ticket1);
        }else{
            ColaServicio colaservicio1 = new ColaServicio(urgencia);
            colaservicio1.agregar(ticket1);
            servicio.add(colaservicio1);
        }
    }
    
    //Nos mostrara un reporte del los tickets que an sido
    //registrados junto con su Bitarora
    public static void BitacoraT(){
        
        if(0 < servicio.size()){
            System.out.println("\n"+servicio);
            servicio.get(0).MostrarBitacora();
        }else{
            System.out.println("\nNo hay ticket en cola");
        }
    }
    
    //Si esta en el menu de empleado lo dejara darle solucion al ticket
    public static void Solucion(String msj){
        int solucionar = 0;
        for(int i = 0; i < servicio.size(); i++){
            if(servicio.get(i).Resolver(msj) !=null){
                servicio.get(i).Resolver(msj).bitacora.get(i).setMensaje(true);
                solucionar = 1;
                break;
            }
        }
        if(solucionar==1){
            System.out.println("El ticket con Nit de Usuario  "+msj+"  a sido solucionado");
        } else{
            System.out.println("El ticket no existe.");
        }
    }
    
    //Sive ´para leer los archivos dentro del json 
    public static void MostrarTickets(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("informacion.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);
            
            JSONArray array = (JSONArray) jsonObject.get("Informacion");
            System.out.println("");
            
            for(int i = 0; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                
                System.out.println("Ticket: " + jsonObject1.get("ticket"));
                System.out.println("Nit Usuario: " + jsonObject1.get("nitUsuario"));
                System.out.println("Problema: " + jsonObject1.get("problema"));
                System.out.println("Cola: " + jsonObject1.get("cola"));
                System.out.println("");
            }
        } catch(FileNotFoundException e) {
        
        }catch(IOException e) {
        
        }catch(ParseException e) {
        
        }
    }
}