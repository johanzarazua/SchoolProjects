/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Esta clase nos permite crear una conexion a la base de datos.
 * Nos proporciona una instancia la cual sera nuestro punto
 * de acceso a la informacion.
 * @author Equipo 7
 * @version 11/10/19
 */
public class Conexion {
    /*atributo para referenciar objeto de la misma clase
    / para utilizar el patron Singleton.*/
    private static Conexion cn =  new Conexion();
    //nombre de la base de datos.
    public String DB = "hotel";
    //usuario y contrasena para acceder a la base
    public String user = "JohanZR";
    public String password = "1602J";
    //hostname de la base de datos.
    public String url = "jdbc:mysql://localhost:3306/" + DB +"?userTimezone=true&serverTimezone=UTC&enabledTLSProtocols=TLSv1.2";
    
    /**
     * Constructor vacio para la clase Conexion.
     * Este metodo devuelve una instancia de la clase.
     */
    private Conexion() {
    }
    
    /**
     * Metodo que devuelve un objeto de la clase Connection el cual contiene
     * la conexion con la base de datos.
     * @return, Objeto de la clase Connection el cual contiene la conexion a la base de datos.
     */
    public Connection conectar(){
       Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,password);
            //JOptionPane.showMessageDialog(null, "Conectaddo a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conexion;
    }

    public static Conexion getCn(){
        return cn;
    }  
}
