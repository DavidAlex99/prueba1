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
public class Venta implements Serializable{
    private Vendedor vendedor;
    private String cliente;
    private ArrayList<VentaDetalle> detalle;

    public Venta(Vendedor vendedor, String cliente) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.detalle = new ArrayList<>();
    }



    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public ArrayList<VentaDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<VentaDetalle> detalle) {
        this.detalle = detalle;
    }


    public void agregarDetalleVenta(Producto producto, int cantidad){
        detalle.add(new VentaDetalle(producto, cantidad));
    }
    
}




    

