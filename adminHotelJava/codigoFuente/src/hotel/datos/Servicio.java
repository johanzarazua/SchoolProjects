/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

/**
 * La clase servicio ayuda a moldear objetos que representan servicios que
 * ofrece el hotel.
 * @author Equipo7
 * @version 13/11/19
 */
public class Servicio {
    //atributos
    private int idServicio;
    private String tipo;
    private String descripcion;
    private double precio;

    /**
     * Constructor vacio de la clase Servicio, este constructor no inicializa ningun atributo del objeto.
     */
    public Servicio() {
    }

    /**
     * Constructor para la clase Servicio, iniclaiza los atributos con un valor enviado.
     * @param idServivio, identificador unico oara cada servicio de tipo int.
     * @param tipo, nombre del servicio en tipo String.
     * @param descripcion, desripcion del servicio en tipo String.
     * @param precio, precio del servicio en tipo double.
     */
    public Servicio(int idServivio, String tipo, String descripcion, double precio) {
        this.idServicio = idServivio;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * Metodo de acceso al atributo id.
     * @return el id de un servicio. 
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Metodo de acceso al atributo tipo.
     * @return el nombre del servicio.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo de acceso al atributo descripcion.
     * @return la descripcion de un servicio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Metodo de acceso al atributo sueldo.
     * @return el precio de un servicio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo de acceso al atributo id.
     * @param idServivio , id de tipo int para un servicio.
     */
    public void setIdServicio(int idServivio) {
        this.idServicio = idServivio;
    }

    /**
     * Metodo de acceso al atributo tipo.
     * @param tipo , nombre del servicio en tipo String.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo de acceso al atributo descripcion.
     * @param descripcion , descripcion de un servico en tipo String.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo de acceso al atributo precio.
     * @param precio, precio de un servicio en un double.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
