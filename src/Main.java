/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import modelo.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
//CLASE IOEXCEPTION IMPORTADA
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.util.Scanner;
/**
 *
 * @author alexx
 */
public class Main {
  //ARRAYLIST DE PRODUCTOS
    ArrayList<Producto> productos;
    //ARRAYLIST DE EMPLEADOS
    ArrayList<Empleado> empleados;
    //ARAYLIST DE LAS VENTAS
    ArrayList<Venta> ventas;  

    

    public Main(){
      
      productos=  new ArrayList<Producto>();
      empleados=  new ArrayList<Empleado>();
      ventas=  new ArrayList<Venta>();  
      
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Main empresa = new Main();

       empresa.crearProductos();
       empresa.crearEmpleados();
       empresa.registrarVentas();
       
       
       //haciendo el bloque try catch
       empresa.guardarVentas();
    
    }

    public void crearProductos(){
       //lectura de productos a partir de archivo productos.csv

       try{
       FileReader entrada = new FileReader("src/recursos/productos.csv");

       BufferedReader mibuffer = new BufferedReader(entrada);

       String linea = "";
       
     
       while(linea != null){
         linea = mibuffer.readLine();

         if(linea != null){
           String[] temporal = linea.split(",");
           
           float pvp = Float.parseFloat(temporal[3]);
           float comision = Float.parseFloat(temporal[4]);
           int stock = Integer.parseInt(temporal[5]);
           productos.add(new Producto(temporal[0],temporal[1],temporal[2],pvp,comision,stock));
         }
       }
       entrada.close();
       }catch(IOException ex){
         System.out.println("Archivo no encontrado");
       }

       for(Producto pro: productos){
         System.out.println(pro.getStock());
       }



               
    }
    public void crearEmpleados(){
       //crear 4 empleados
      
       //empleados administrativos
       
       empleados.add(new Administrativo("0917586814","Silvia Patricia", "Orellana Castro",500.00f,true));
       empleados.add(new Administrativo("1256896565","Maria Leticia", "Pérez Ortiz",200.00f,false));
       //empleados vendedores
       empleados.add(new Vendedor("0924865687","Antonio José", "Arias Centeno",300.00f));
       empleados.add(new Vendedor("0956881256","Andrea Cecilia", "Méndez López",300.00f));        
       
    }
    
    public void registrarVentas(){

       System.out.println("Ingresando datos de venta ...");
       Scanner sc = new Scanner(System.in);
       //pedir ingreso de 5 ventas
       
       System.out.println("Ingrese la cedula del vendedor");
       String ced = sc.nextLine();
       for (Empleado em: empleados){

       if((em.getCedula().equalsIgnoreCase(ced))== true && em instanceof Vendedor){
       Vendedor vend = (Vendedor)em;
       for (int i=0;i<5;i++)
       {

        //solicitar cedula delc liente
          System.out.println("Ingrese cedula del cliente");
          String cl = sc.next();
          //crear a venta
          //solicitar los productos vendidos
          System.out.println("Ingrese los productos que se ha vendido");
          String opcion = " ";
          while(!opcion.equalsIgnoreCase("N")){
            System.out.println("Ingrese el codigo del producto");
            String cod = sc.next();
            for (Producto prod: productos){
              if(prod.getCodigo().equalsIgnoreCase(cod)){
                System.out.println("Producto: "+prod.getNombre());
                //ta cuando se ha equivalido el nombre con el de la lista se hace el stock
                System.out.println("Cuantas unidades del producto se ha adquirido");
                int stck = sc.nextInt();
                //verificacion para el stock del producto
                
                  //reducimos el stock si es que la cantidad que se quiere no supera a este del producto por medio del metodo en la clae producto
                  try{
                    prod.reducirStock(stck);
                  }catch(Exception e){
                    System.out.println("Producto sin stock suficiente");
                  }
                  //rodeamos en un bloque try catch porque esta con una excepcion
                  
                  //anadiendo al vendedor y al cliente
                  Venta venta = new Venta(vend,cl);
                  venta.agregarDetalleVenta(prod, stck);
                  ventas.add(venta);
                  
                  

                  
                  System.out.println(prod.getStock());
                  for(Venta v:ventas){
                      System.out.println(v.getCliente());
                  }
                  
                  System.out.println("Desea agregar mas productos?");
                  String op = sc.next();
                  if(op.equalsIgnoreCase("S")){
                    opcion = "S";
                  }else{
                    opcion = "N";
                    i++;
                  }
                }
              }
            }
          }
        }
       }
       
       /*
           //solicitar cédula del vendedor y buscar en lista de empleados
      System.out.println("Ingrese la cedula del vendedor");
      String ced = sc.nextLine();
      for (Empleado em: empleados){

        if((em.getCedula().equalsIgnoreCase(ced))== true && em instanceof Vendedor){
          Vendedor vend = (Vendedor)em;
        //solicitar cedula delc liente
          System.out.println("Ingrese cedula del cliente");
          String cl = sc.nextLine();
          //crear a venta
          //solicitar los productos vendidos
          System.out.println("Ingrese los productos que se ha vendido");
          String opcion = "";
          while(!opcion.equalsIgnoreCase("N")){
            System.out.println("Ingrese el codigo del producto");
            String cod = sc.nextLine();
            for (Producto prod: productos){
              if(prod.getCodigo().equalsIgnoreCase(cod)){
                System.out.println("Producto: "+prod.getNombre());
                //ta cuando se ha equivalido el nombre con el de la lista se hace el stock
                System.out.println("Cuantas unidades del producto se ha adquirido");
                int stck = sc.nextInt();
                //verificacion para el stock del producto
                
                  //reducimos el stock si es que la cantidad que se quiere no supera a este del producto por medio del metodo en la clae producto
                  try{
                    prod.reducirStock(stck);
                  }catch(Exception e){
                    System.out.println("Producto sin stock suficiente");
                  }
                  //rodeamos en un bloque try catch porque esta con una excepcion
                  
                  //anadiendo al vendedor y al cliente
                  Venta venta = new Venta(vend,cl);
                  venta.agregarDetalleVenta(prod, stck);
                  ventas.add(venta);

                  for(Venta v:ventas){
                    System.out.println(v);         
                  }
                  
                  System.out.println("Desea agregar mas productos?");
                  String op = sc.nextLine();
                  if(op.equalsIgnoreCase("S")){
                    opcion = "S";
                  }else{
                    opcion = "N";
                  }
                }
              }
            }
          }
        }
        */
      }
           //solcitar cedula del cliente
           //crear la venta
           // solicitar los productos vendidos, solicitar ingreso hasta que ingrese N en codigo
            //solicitar còdigo del producto y buscar en lista

            //solicitar cantidad vendida y verificar stock

            //agregar detalle a la venta
           
           //agregar la venta a la lista ventas
               
    
    
    public void guardarVentas(){
        //aqui serializar el arraylist de ventas, crear archivo en la carpeta recursos
        try{
         FileOutputStream fos = new FileOutputStream("src/recursos/ventas.ser");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(ventas);
         oos.flush();
           
        }catch(Exception e){
            System.out.println("error");
            //PUSE A LAS CLASES RESTNATES COMO SERIALIZABLE
        }
             
    }
    
 
    
}

    
    

