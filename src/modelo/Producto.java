/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import excepcion.*;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author alexx
 */
public class Producto implements Serializable{
    
    private String codigo;
    private String nombre;
    private String descripcion;
    private float valorVenta;
    private float comisionVendedor;
    private int stock;

    public Producto(String codigo, String nombre, String descripcion, float valorVenta, float comisionVendedor, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorVenta = valorVenta;
        this.comisionVendedor = comisionVendedor;
        this.stock = stock;
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(float valorVenta) {
        this.valorVenta = valorVenta;
    }

    public float getComisionVendedor() {
        return comisionVendedor;
    }

    public void setComisionVendedor(float comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", valorVenta=" + valorVenta + ", stock=" + stock + '}';
    }
    
    
    //implementar método reducirStock
    public void reducirStock(int c) throws StockInsuficienteExcepcion{
      if(c<=stock){
        stock = stock - c;

      }else{
        //tirando el erro cuando la cantidad comprada sobrepasa al sock disponible
        throw new StockInsuficienteExcepcion("Producto sin stock suficiente");

      }
      

    }
    


}

    

