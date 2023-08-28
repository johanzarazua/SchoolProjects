/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

import java.sql.Date;

/**
 * La clase Reservacion moldea objetos para definir una reservacion de una habitacion
 * solicitada por un cliente y realizada por un trabajador.
 * @author Equipo 7
 * @version 13/11/19
 */
public class Reservacion {
    //atributos de una reservacion
    private int idReservacion;
    private int idCliente;
    private int idTrabajador;
    private int idHabitacion;
    private Date fecha_tramite;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String estado;
    private double costo;

    /**
     * Constructor vacio de la clase Reservacion.
     */
    public Reservacion() {
    }

    /**
     * Constructor para la clase Reservacion, nos permite crear intancias e la clase y moldear una reservacion.
     * @param idReservacion, identificador unico de una reservacion de tipo int.
     * @param idCliente, inditificador unico del cliente que solicita la reservacion.
     * @param idTrabajador, identificador unico del trabajador que realiza la reservacio.
     * @param idHabitacion, identificador unico de la habitacion reservada.
     * @param fecha_tramite, fecha en la cual se realiza la reservacion.
     * @param fechaIngreso, fecha en la cual el cliente comenzara su alojamiento en la habitacion.
     * @param fechaSalida, fecha en la cual el cliente abandonara la habitacion.
     * @param estado, estado de la reservacion.
     * @param costo, costo del alojamiento. 
     */
    public Reservacion(int idReservacion, int idCliente, int idTrabajador, int idHabitacion, Date fecha_tramite, Date fechaIngreso, Date fechaSalida, String estado, double costo) {
        this.idReservacion = idReservacion;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.idHabitacion = idHabitacion;
        this.fecha_tramite = fecha_tramite;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.costo = costo;
    }
    

    /**
     * Metodo de acceso al atributo idreservacion.
     * @return el identificador de la reservacion.
     */
    public int getIdReservacion() {
        return idReservacion;
    }

    /**
     * Metodo de acceso al atributo idcliente.
     * @return el identificador del cliente que solicita la reservacion.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Metodo de acceso al atributo idtrabajador.
     * @return identificador unico del trabajador que realizo la reservacion.
     */
    public int getIdTrabajador() {
        return idTrabajador;
    }

    /**
     * Metodo de acceso al atributo idhabitacion.
     * @return identificador unico de la habitacion reservada'
     */
    public int getIdHabitacion() {
        return idHabitacion;
    }

    /**
     * Metodo de acceso al atributo fecha_tramite.
     * @return la fecha en la cual se realizo el tramite de la reservacion.
     */
    public Date getFecha_tramite() {
        return fecha_tramite;
    }

    /**
     * Metodo de acceso al atributo fechaingreso.
     * @return la fecha en la cual comienza el alojamiento del cliente.
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Metodo de acceso al atributo fechasalida.
     * @return la fecha en la cual el cliente desalojara el cuerto.
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Metodo de acceso al atributo idreservacion.
     * @param idReservacion identificador unico de la reservacion.
     */
    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    /**
     * Metodo de acceso al atributo idcliente.
     * @param idCliente identificador unico del cliente que solicita la reservvacion.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Metodo de acceso al atributo idtrabajador.
     * @param idTrabajador identificador unico del trabajador que realiza la reservacion.
     */
    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    /**
     * Metodo de acceso al atributo idhabitaccion.
     * @param idHabitacion identificador unico de la habitacion reservada.
     */
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    /**
     * Metodo de acceso al atributo fecha_tramite.
     * @param fecha_tramite fecha en la cual se realiza el tramite.
     */
    public void setFecha_tramite(Date fecha_tramite) {
        this.fecha_tramite = fecha_tramite;
    }

    /**
     * Metodo de acceso al atributo fechaigreso.
     * @param fechaIngreso fecha en la cual ingresa el cliente.
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Metodo de acceso al atributo fechasalida.
     * @param fechaSalida fecha en la cual el usuario abandona la habitacion.
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Metodo de acceso al atributo estado.
     * @return el estado de la reservacion
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo de acceso al atributo estado.
     * @param estado estado en el cual esta la reservacion.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo de acceso al atributo costo.
     * @return el costo del alojamiento.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Metodo de acceso al atributo costo.
     * @param costo costo del alojamiento.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
