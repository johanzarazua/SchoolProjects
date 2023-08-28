/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

import java.util.Random;

/**
 *
 * @author Efren
 */
public class Personas {
    private int idPersona;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String telefono;
    private String email;
     
    /**
     * Constructor vacio de la clase Persona
     */
    public Personas(){
    } 
    
    /**
     * Constructor para la clase Persoan
     * @param idPersona, identifiacdor unico de una persona.
     * @param nombre, nombre de la persona.
     * @param aPaterno, apellido paterno de la persona.
     * @param aMaterno, apellido materno de la persona.
     * @param telefono, telefono de la persona.
     * @param email , emial de la persona.
     */
    public Personas (int idPersona, String nombre, String aPaterno, String aMaterno, String telefono, String email){
        setIdpersona(idPersona);
        this.nombre=nombre;
        this.aPaterno=aPaterno;
        this.aMaterno=aMaterno;
        setTelefono(telefono);
        this.email=email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public void setTelefono(String telefono) {
        this.telefono=telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getIdpersona() {
        return idPersona;
    }

    public void setIdpersona(int idPersona) {
        this.idPersona = idPersona;
    }
}
