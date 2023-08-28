/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

/**
 * La clase Trabajador hereda de la clase persona y nos permite crear objetos
 * con los datos necesarios para operar con la tabla trabajador de la base de datos.
 * @author Equipo 7
 * @version 13/11/19
 */
public class Trabajador extends Personas{
    //Atributos de un trabajador.
    private double sueldo;
    private String puesto;
    private String usuario;
    private String contrasena;
    private String estado_log;
    private String preguntaSeguridad;
    private String respuestaSeguridad;

    /**
     * Constructor vacio para la clase Trabajador, intancia objetos sin inicializar sus atributos.
     */
    public Trabajador() {
        super();
    }
    
    /**
     * Constructor para la clase Trabajador, iniciaiza sus atributos con un valor enviado.
     * @param sueldo, tipo double salario del trabajador.
     * @param puesto, tipo String modela el puesto del trabajador.
     * @param usuario, tipo String almacena el usuario para iniciar sesion.
     * @param contrasena, tipo String almacena la contrasena para inicio de sesion.
     * @param estado_log, tipo String ayuda a saber el estado del trabajador (activo o inactivo).
     * @param idPersona, tipo int identificador unico para cada persona.
     * @param nombre, tipo String nombre de la persona.
     * @param aPaterno, tipo String apelllido paterno de la persona.
     * @param aMaterno, tipo String apellido materno de la persona.
     * @param telefono, tipo String telefono de la perosna.
     * @param email, tipo String email de la persona.
     */
    public Trabajador(double sueldo, String puesto, String usuario, String contrasena, String estado_log, int idPersona, String nombre, String aPaterno, String aMaterno, String telefono, String email) {
        super(idPersona, nombre, aPaterno, aMaterno, telefono, email);
        this.sueldo = sueldo;
        this.puesto = puesto;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado_log = estado_log;
    }
    
    /**
     * Metodo de acceso al atributo sueldo.
     * @return el sueldo del trabajador en un double.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Metodo de acceso al atributo puesto.
     * @return el puesto del trabajador en un String
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Metodo de acceso al atributo usuario.
     * @return el usuario del trabajador en un String
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Metodo de acceso al atributo contrasena.
     * @return la contrasena del trabajador en un String
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo de acceso al atributo estado_log.
     * @return el estado en el sistema del trabajador en un String
     */
    public String getEstado_log() {
        return estado_log;
    }

    /**
     * Metodo de acceso al atributo sueldo.
     * @param sueldo, sueldo del trabajador de tipo double.
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Metodo de acceso al atributo puesto.
     * @param puesto, puesto del trabajador de tipo String.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Metodo de acceso al atributo usuario.
     * @param usuario del trabajador de tipo String.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo de acceso al atributo contrasena.
     * @param contrasena, contrasena del trabajador de tipo String.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo de acceso al atributo estado_log.
     * @param estado_log, estado del trabajador en el sistema de tipo String.
     */
    public void setEstado_log(String estado_log) {
        this.estado_log = estado_log;
    }

    /**
     * Metodo de acceso al atributo preguntaSeguridad.
     * @return una cadena de texto con una pregunta.
     */
    public String getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    /**
     * Metodo de acceso al atributo preguntaSeguridad.
     * @param preguntaSeguridad, pregunta de seguridad en cadena de texto.
     */
    public void setPreguntaSeguridad(String preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    /**
     * Metodo de acceso al atributo respuestaSeguridad.
     * @return una respuesta de seguridad en un String.
     */
    public String getRespuestaSeguridad() {
        return respuestaSeguridad;
    }

    /**
     * Metodo de acceso al atributo respuestaSeguridad.
     * @param respuestaSeguridad, respuesta de seguridad en tipo String.
     */
    public void setRespuestaSeguridad(String respuestaSeguridad) {
        this.respuestaSeguridad = respuestaSeguridad;
    }
    
}
