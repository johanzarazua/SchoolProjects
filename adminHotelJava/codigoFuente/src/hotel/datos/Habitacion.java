/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

/**
 * La clse habitacion genera objetos con valores caracteristicos de una habitacion de hotel
 * @author Efren
 */
public class Habitacion {
    private int idHabitacion;
    private int numero;
    private int piso;
    private String tipo;
    private int camas;
    private String estado;
    private String descripcion;
    private double precioNoche;
    
    /**
     * Constructor vacio de la clase Habitacion
     */
    public Habitacion() {
    }

    /**
     * Constructor de la clase Habitacion
     * @param numero, numero de la habitacion
     * @param piso, piso de la habitacion
     * @param tipo, tipo de habitacion
     * @param camas, numero de camas de la habitacion
     * @param estado, estado de la habitacion
     * @param descripcion, descripcion de la habitacion
     * @param precioNoche, precio de la habitacion 
     */
    public Habitacion(int numero, int piso, String tipo, int camas, String estado, String descripcion, double precioNoche) {
        //this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.piso = piso;
        this.tipo = tipo;
        this.camas = camas;
        this.estado = estado;
        this.descripcion = descripcion;
        this.precioNoche = precioNoche;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }
    
    
}
