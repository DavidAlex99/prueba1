/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alexx
 */
public class Administrativo extends Empleado{


    private boolean jornadaCompleta;

    public Administrativo(String cedula, String nombres, String apellidos, double sueldo,boolean jornadaCompleta) {
        super(cedula, nombres, apellidos, sueldo);
        this.jornadaCompleta = jornadaCompleta;
    }

    public boolean isJornadaCompleta() {
        return jornadaCompleta;
    }

    public void setJornadaCompleta(boolean jornadaCompleta) {
        this.jornadaCompleta = jornadaCompleta;
    }
    
    /**
     *
     * @return el sueldo del empleado administrativo
     */
    @Override
    public double calculaSueldo(){
       
        double sueldo = 0;

        return sueldo;
    }
}


