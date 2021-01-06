/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alexx
 */
public class Vendedor extends Empleado implements Serializable{
 
    private double valorComision;

    
    
    public Vendedor(String cedula, String nombres, String apellidos, double sueldo) {
        super(cedula, nombres, apellidos, sueldo);
    }

    public double getValorComision() {
        return valorComision;
    }

    public void setValorComision(double valorComision) {
        this.valorComision = valorComision;
    }
    
    
    @Override
    public double calculaSueldo() {
      
        double sueldo = 0;
       
        return sueldo;
        
    }
    
    public void calcularComision(ArrayList<Venta> ventas){
       
    }
}

    

