/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

import hotel.datos.Reservacion;
import hotel.datos.Servicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Efren
 */
public class CReservacion extends C{ 
    
    /**
     * El metodo consulta nos permite recuperar informacion de la tabla reservacion
     * que se encuentra en la base de datos.
     * @param buscar.
     * @return modelo. Un objeto de la clase DefaultTableModel, es decir una tabla (un vector de vectores).
     */
    @Override
    public DefaultTableModel consulta(String buscar){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID reservacion","ID cliente","Cliente","ID trabajador","Trabajador","ID habitaciion","Habitacion","Fecha tramite","Fecha ingreso","Fecha salida","Estado","Costo"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[12];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por la fecha de tramite, con ello buscaremos en una fecha.
        setsSQL("select r.idReservacion, r.idCliente, " +
                "(select nombre from persona where idPersona = r.idCliente)as ncliente, "+
                "(select aPaterno from persona where idPersona = r.idCliente)as apcliente, "+
                "r.idTrabajador, (select nombre from persona where idPersona = r.idTrabajador)as ntrabajador, "+
                "(select aPaterno from persona where idPersona = r.idTrabajador)as aptrabajador, "+
                "r.idHabitacion, h.numero, r.fecha_tramite, r.fechaIngreso, r.fechaSalida, r.estado, r.costo"+
                " from reservacion r inner join habitacion h on r.idHabitacion = h.idHabitacion"
                + " where r.fecha_tramite like '%"+ buscar + "%' order by idReservacion");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idReservacion");
                registro [1] = rs.getString("idCliente");
                registro [2] = rs.getString("ncliente") + " " + rs.getString("apcliente");
                registro [3] = rs.getString("idTrabajador");
                registro [4] = rs.getString("ntrabajador") + " " + rs.getString("aptrabajador");
                registro [5] = rs.getString("idHabitacion");
                registro [6] = rs.getString("numero");
                registro [7] = rs.getString("fecha_tramite");
                registro [8] = rs.getString("fechaIngreso");
                registro [9] = rs.getString("fechaSalida");
                registro [10] = rs.getString("estado");
                registro [11] = rs.getString("costo");
                //auemntamos el contador y guardamos el arreglo en forma de fila en modelo.
                totalregistros += 1;
                modelo.addRow(registro);
            }
            rs.close();
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    /**
     * El metodo insertar nos permite agregar un registro a la
     * tabla reservacion de la base de datos.
     * @param dt. Objeto de la clase Reservacion donde se aloja la informacion de 
     * una reservacion, apartir de esos datos se creara el registro.
     * @return, booleano con el cual indicaremos si se inserto el registro correctamente.
     */
    @Override
    public boolean insertar(Object dt){
        Reservacion dts = (Reservacion)dt;
        //instrucciones para agregar un registro a base de datos
        setsSQL("insert into reservacion (idCliente,idTrabajador,idHabitacion,fecha_tramite,fechaIngreso,fechaSalida,estado,costo)" +
               "values (?,?,?,?,?,?,?,?)");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getIdCliente());
            pst.setInt(2,dts.getIdTrabajador());
            pst.setInt(3, dts.getIdHabitacion()); 
            pst.setDate(4, dts.getFecha_tramite());
            pst.setDate(5, dts.getFechaIngreso());
            pst.setDate(6, dts.getFechaSalida());
            pst.setString(7, dts.getEstado());
            pst.setDouble(8, dts.getCosto());
            
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
     * El metodo editar nos permite cambiar los datos de un registro de la tabla servicio
     * de la base de datos, se cambiaran todos excepto su id.
     * @param dt. Objeto de la clase Servicio el cual contendra los datos necesarios para cambiar 
     * el registro.
     * @return, booleano con el cual indicaremos si el cambio se hizo correctamente.
     */
    public boolean editar(Object dt){
        Reservacion dts = (Reservacion)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update reservacion set idCliente=?, idTrabajador=?, idHabitacion=?, fecha_tramite=?, fechaIngreso=?, fechaSalida=?, estado=?, costo=?" + 
               " where idReservacion=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getIdCliente());
            pst.setInt(2,dts.getIdTrabajador());
            pst.setInt(3, dts.getIdHabitacion()); 
            pst.setDate(4, dts.getFecha_tramite());
            pst.setDate(5, dts.getFechaIngreso());
            pst.setDate(6, dts.getFechaSalida());
            pst.setString(7, dts.getEstado());
            pst.setDouble(8, dts.getCosto());
            pst.setInt(9, dts.getIdReservacion());
            
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
     * El metodo eliminar nos permite borrar un registro de la tabla servicio en la base de datos
     * mediante su id.
     * @param dt. Objeto de la clase Servicio del cual obtendremos el id para saber que registro
     * se debe eliminar.
     * @return, boolean para saber si se elimino el registro correctamente.
     */
    @Override
    public boolean eliminar(Object dt){
        Reservacion dts = (Reservacion)dt;
        //Instruccion para borrar un registro en la base de datos.
        setsSQL("delete from reservacion where idReservacion=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            pst.setInt(1, dts.getIdReservacion());
            
            // if evaluando la ejecucuion del statement para saber si se elimino el registro o no
            if (pst.executeUpdate() != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false; 
        }   
    }
    
    public boolean pagar(Object dt){
        Reservacion dts = (Reservacion)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update reservacion set estado='Pagada'" + 
               " where idReservacion=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getIdReservacion());
            
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
