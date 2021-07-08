package com.example.inventario;

public class Producto {

    int codigo;
    String nombre;
    double precio;

    public Producto(){
    }
    public Producto(int codigo, String nombre, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }
    public void setPrecio ( double precio ) {
        this.precio = precio;
    }
    public int getCodigo () {
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public double getPrecio(){
        return this.precio;
    }
}
