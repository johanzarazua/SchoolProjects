/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * La clase Compra modela los datos que caracterisan una compra en el sistema.
 * @author Efren
 */
public class Compra {
     private int idCompra;
    private int idReservacion;
    private int idServicio;
    private Date fecha_compra;
    private int cantidad;
    private double precio;
    private String estado;

    /**
     * Constructor vacio de la clase Compra
     */
    public Compra() {
    }

    /**
     * Constructor de la clase Compra
     * @param idCompra, identificador unico de la commpra
     * @param idReservacion, identificador unico de la reservacion
     * @param idServicio, identificador unico del servicio
     * @param fecha_compra, fecha de compra
     * @param cantidad, cantiddad de servicios comprados
     * @param precio, precio total de la compra
     * @param estado, estado de la compra
     */
    public Compra(int idCompra, int idReservacion, int idServicio, Date fecha_compra, int cantidad, double precio, String estado) {
        this.idCompra = idCompra;
        this.idReservacion = idReservacion;
        this.idServicio = idServicio;
        this.fecha_compra = fecha_compra;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
