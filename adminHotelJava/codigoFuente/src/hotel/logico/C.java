/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Efren
 */
public abstract class C {
    /*Instancia de la clase Conexion e istancia de Connection
    /para almacenar el valor de rotorno de metodo conectar.*/
    private Conexion mysql = Conexion.getCn();
    private Connection cn = mysql.conectar();
    //variable para almacenar cadena de conexion.
    private String sSQL = "";
    //contador de registros.
    public int totalregistros; 
    
    //metodos abstractos de operaciones en base de datos.
    public abstract DefaultTableModel consulta(String buscar);
    public abstract boolean insertar(Object dt);
    public abstract boolean editar(Object dt);
    public abstract boolean eliminar(Object dt);

    public Conexion getMysql() {
        return mysql;
    }

    public void setMysql(Conexion mysql) {
        this.mysql = mysql;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public String getsSQL() {
        return sSQL;
    }

    public void setsSQL(String sSQL) {
        this.sSQL = sSQL;
    }
    
    
}
