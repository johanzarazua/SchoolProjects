/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

/**
 *  La clase cliente modela los datos que se registran de un cliente en el sistema
 * @author Efren
 */
public class Cliente extends Personas{
    private String tipo;
    private int descuento;
    
    private String usuario;
    private String contrasena;
    private String estado_log;
    private String preguntaSeguridad;
    private String respuestaSeguridad;
    
    
    /**
     * Constructor vacio de la clase cliente.
     */
    public Cliente() {
        super();
    }

    /**
     * Constructor de la clase cliente
     * @param tipo, tipo de cliente
     * @param descuento, descuento del cliente.
     * @param usuario, usuario para iniciar sesion
     * @param contrasena, contrasena de inicio de sesion
     * @param estado_log, estadode cliente
     * @param idPersona, identificador unico
     * @param nombre, nombre del cliente
     * @param aPaterno, apellido paterno del cliente
     * @param aMaterno, apellido materno del cliente
     * @param telefono, telefono cliente
     * @param email, email del cliente
     */
    public Cliente(String tipo, int descuento, String usuario, String contrasena, String estado_log, int idPersona, String nombre, String aPaterno, String aMaterno, String telefono, String email) {
        super(idPersona, nombre, aPaterno, aMaterno, telefono, email);
        this.tipo = tipo;
        this.descuento = descuento;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado_log = estado_log;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDescuento() {
        return descuento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEstado_log() {
        return estado_log;
    }

    public String getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    public void setPreguntaSeguridad(String preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    public String getRespuestaSeguridad() {
        return respuestaSeguridad;
    }

    public void setRespuestaSeguridad(String respuestaSeguridad) {
        this.respuestaSeguridad = respuestaSeguridad;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEstado_log(String estado_log) {
        this.estado_log = estado_log;
    }
}
