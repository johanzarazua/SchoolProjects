/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

import hotel.datos.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * La clase THabitacion nos permitira realizar operaciones sobre la informacion
 * que se encuentra en la tabla Habitacion de base de datos.
 * Las operaciones pueden ser consultar, insertar o eliminar.
 * @author Equipo 7
 * @version 11/10/19
 */
public class CHabitacion extends C{
    
    /**
     * El metodo consulta nos permite recuperar informacion de la tabla habitacion
     * que se encuentra en la base de datos.
     * @param piso. Piso del cual se recuperar la informacion.
     * @return modelo. Un objeto de la clase DefaultTableModel es decir una tabla (un vector de vectores).
     */
    @Override
    public DefaultTableModel consulta(String piso){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID","Numero","Piso","Tipo","Camas","Estado","Descripcion","Precio por noche"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[8];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por piso, con ello buscaremos en un piso.
        setsSQL("select * from habitacion where piso like '%" + piso +"%' order by idHabitacion");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idHabitacion");
                registro [1] = rs.getString("numero");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("tipo");
                registro [4] = rs.getString("camas");
                registro [5] = rs.getString("estado");
                registro [6] = rs.getString("descripcion");
                registro [7] = rs.getString("precioNoche");
                
                //auemntamos el contador y guardamos el arreglo en forma de fila en modelo.
                totalregistros += 1;
                modelo.addRow(registro);
            }
            rs.close();
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    /**
     * El metodo insertar nos permite agregar un registro a la
     * tabla habitacion de la base de datos.
     * @param dt. Objeto de la clase Habitacion donde se aloja la informacion de 
     * una habitacion, apartir de esos datos se creara el registro.
     * @return, booleano con el cual indicaremos si se inserto el registro correctamente.
     */
    @Override
    public boolean insertar(Object dt){
        Habitacion dts = (Habitacion)dt;
        //instrucciones para agregar un registro a base de datos
        setsSQL("insert into habitacion (numero,piso,tipo,camas,estado,descripcion,precioNoche)" +
               "values (?,?,?,?,?,?,?)");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getNumero());
            pst.setInt(2,dts.getPiso());
            pst.setString(3,dts.getTipo());
            pst.setInt(4, dts.getCamas());
            pst.setString(5,dts.getEstado());
            pst.setString(6,dts.getDescripcion());
            pst.setDouble(7, dts.getPrecioNoche());
            
            // if evaluando la ejecucuion del statement para saber si se guardo el registro o no
            if (pst.executeUpdate() != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }   
    }
    
    /**
     * El metodo editar nos permite cambiar los datos de un registro de la tabla habitacion
     * de la base de datos, se cambiaran todos excepto su id.
     * @param dt. Objeto de la clase Habitacion el cual contendra los datos necesarios para cambiar 
     * el registro.
     * @return, booleano con el cual indicaremos si el cambio se hizo correctamente.
     */
    @Override
    public boolean editar(Object dt){
        Habitacion dts = (Habitacion)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update habitacion set numero=?, piso=?, tipo=?, camas=?, estado=?, descripcion=?, precioNoche=?" + 
               " where idHabitacion=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getNumero());
            pst.setInt(2,dts.getPiso());
            pst.setString(3,dts.getTipo());
            pst.setInt(4, dts.getCamas());
            pst.setString(5,dts.getEstado());
            pst.setString(6,dts.getDescripcion());
            pst.setDouble(7, dts.getPrecioNoche());
            pst.setInt(8,dts.getIdHabitacion());
            
            // if evaluando la ejecucuion del statement para saber si se edito el registro o no
            if (pst.executeUpdate() != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }   
    }
    
    /**
     * El metodo eliminar nos permite borrar un registro de la tabla habitacion en la base de datos
     * mediante su id.
     * @param dt. Objeto de la clase Habitacion del cual obtendremos el id para saber que registro
     * se debe eliminar.
     * @return, boolean para saber si se elimino el registro correctamente.
     */
    @Override
    public boolean eliminar(Object dt){
        Habitacion dts = (Habitacion)dt;
        //Instruccion para borrar un registro en la base de datos.
        setsSQL("delete from habitacion where idHabitacion=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            pst.setInt(1, dts.getIdHabitacion());
            
            // if evaluando la ejecucuion del statement para saber si se elimino el registro o no
            if (pst.executeUpdate() != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false; 
        }   
    } 
    
    /**
     * Sobrecarga del metodo consulta nos permite recuperar informacion de la tabla habitacion
     * que se encuentra en la base de datos pero unicamente habitaciones disponibles.
     * @param piso. Piso del cual se recuperar la informacion.
     * @param sentencia. Comando de sql para filtrar por habitacione disponibles.
     * @return modelo. Un objeto de la clase DefaultTableModel es decir una tabla (un vector de vectores).
     */
    public DefaultTableModel consulta(String piso, String sentencia){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID","Numero","Piso","Tipo","Camas","Estado","Descripcion","Precio por noche"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[8];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por piso, con ello buscaremos en un piso.
        // sentencia es: and estado = 'Disponible' para solo mostrar habitaciones disponibles.
        setsSQL("select * from habitacion where piso like '%" + piso +"%' " + sentencia +" order by idHabitacion");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idHabitacion");
                registro [1] = rs.getString("numero");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("tipo");
                registro [4] = rs.getString("camas");
                registro [5] = rs.getString("estado");
                registro [6] = rs.getString("descripcion");
                registro [7] = rs.getString("precioNoche");
                
                //auemntamos el contador y guardamos el arreglo en forma de fila en modelo.
                totalregistros += 1;
                modelo.addRow(registro);
            }
            rs.close();
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public boolean desocupar(Object dt){
        Habitacion dts = (Habitacion)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update habitacion set estado='Disponible'" + 
               " where idHabitacion=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1,dts.getIdHabitacion());
            
            // if evaluando la ejecucuion del statement para saber si se edito el registro o no
            if (pst.executeUpdate() != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }   
    }
    
    public boolean ocupar(Object dt){
        Habitacion dts = (Habitacion)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update habitacion set estado='Ocupado'" + 
               " where idHabitacion=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1,dts.getIdHabitacion());
            
            // if evaluando la ejecucuion del statement para saber si se edito el registro o no
            if (pst.executeUpdate() != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }   
    }
}
