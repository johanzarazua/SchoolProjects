/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

import hotel.datos.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Efren
 */
public class CPago extends C{
    
    /**
     * El metodo consulta nos permite recuperar informacion de la tabla pago
     * que se encuentra en la base de datos.
     * @param idcompra. compra del cual se recuperaran los registros.
     * @return modelo. El cual es un objeto de la clase DefaultTableModel es decir una tabla (un vector de vectores).
     */
    @Override
    public DefaultTableModel consulta(String idcompra){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID Pago","ID Compra","Fecha de emision","Fecha de pago", "Tipo de pago", "Comprobante", "Numero de comprobante, Total"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[8];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por fecha, con ello buscaremos en un fecha.
        setsSQL("select * from pago where idCompra =" + idcompra +" order by idPago");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idPago");
                registro [1] = rs.getString("idCompra");
                registro [2] = rs.getString("fecha_emision");
                registro [3] = rs.getString("fecha_pago");
                registro [4] = rs.getString("tipoPago");
                registro [5] = rs.getString("comprobante");
                registro [6] = rs.getString("numeroComprobante");
                registro [7] = rs.getString("total");
                
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
     * tabla pago de la base de datos.
     * @param dt. Objeto de la clase Pago donde se aloja la informacion de 
     * una habitacion, apartir de esos datos se creara el registro.
     * @return, boolean con el cual indicaremos si se inserto el registro correctamente.
     */
    public boolean insertar(Object dt){
        Pago dts = (Pago)dt;
        //instrucciones para agregar un registro a base de datos
        setsSQL("insert into pago (idPago, idCompra, fecha_emision, fecha_pago, tipoPago, comprobante, numeroComprobante, total)" +
               "values (?,?,?,?,?,?,?,?)");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getIdPago());
            pst.setInt(2,dts.getIdCompra());
            pst.setDate(3,dts.getFecha_emision());
            pst.setDate(4, dts.getFecha_pago());
            pst.setString(5,dts.getTipoPago());
            pst.setString(6,dts.getComprobante());
            pst.setString(7, dts.getComprobantePago());
            pst.setDouble(8, dts.getTotal());
            
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
     * El metodo editar nos permite cambiar los datos de un registro de la tabla pago
     * de la base de datos, se cambiaran todos excepto su id.
     * @param dt. Objeto de la clase Pago el cual contendra los datos necesarios para cambiar 
     * el registro.
     * @return, booleano con el cual indicaremos si el cambio se hizo correctamente.
     */
    public boolean editar(Object dt){
        Pago dts = (Pago)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update pago set idCompra=?, fecha_emision=?, fecha_pago=?, tipoPago=?, comprobante=?, numeroComprobante=?, total=?" + 
               " where idPago=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1,dts.getIdCompra());
            pst.setDate(2,dts.getFecha_emision());
            pst.setDate(3, dts.getFecha_pago());
            pst.setString(4,dts.getTipoPago());
            pst.setString(5,dts.getComprobante());
            pst.setString(6, dts.getComprobantePago());
            pst.setDouble(7, dts.getTotal());
            pst.setInt(8,dts.getIdPago());
            
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
     * El metodo eliminar nos permite borrar un registro de la tabla pago en la base de datos
     * mediante su id.
     * @param dt. Objeto de la clase Pago del cual obtendremos el id para saber que registro
     * se debe eliminar.
     * @return, boolean para saber si se elimino el registro correctamente.
     */
    public boolean eliminar(Object dt){
        Pago dts = (Pago)dt;
        //Instruccion para borrar un registro en la base de datos.
        setsSQL("delete from pago where idPago=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            pst.setInt(1, dts.getIdPago());
            
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
    
    public DefaultTableModel consulta(String idcompra, String aux){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID Pago","ID Compra","Fecha de emision","Fecha de pago", "Tipo de pago", "Comprobante", "Numero de comprobante, Total"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[8];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por fecha, con ello buscaremos en un fecha.
        setsSQL("select * from pago order by idPago");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idPago");
                registro [1] = rs.getString("idCompra");
                registro [2] = rs.getString("fecha_emision");
                registro [3] = rs.getString("fecha_pago");
                registro [4] = rs.getString("tipoPago");
                registro [5] = rs.getString("comprobante");
                registro [6] = rs.getString("numeroComprobante");
                registro [7] = rs.getString("total");
                
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
    
    public DefaultTableModel consulta2(String idpago){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID Pago","ID Compra","Fecha de emision","Fecha de pago", "Tipo de pago", "Comprobante", "Numero de comprobante, Total"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[8];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por fecha, con ello buscaremos en un fecha.
        setsSQL("select * from pago where idPago =" + idpago +" order by idPago");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idPago");
                registro [1] = rs.getString("idCompra");
                registro [2] = rs.getString("fecha_emision");
                registro [3] = rs.getString("fecha_pago");
                registro [4] = rs.getString("tipoPago");
                registro [5] = rs.getString("comprobante");
                registro [6] = rs.getString("numeroComprobante");
                registro [7] = rs.getString("total");
                
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
}
