/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

import hotel.datos.Compra;
import hotel.logico.C;
import java.sql.Date;
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
public class CCompra extends C{ 
    
    public double totalConsumo;
    /**
     * El metodo consulta nos permite recuperar informacion de la tabla compras
     * que se encuentra en la base de datos, asociados a los servicios de un cliente.
     * @param buscar.
     * @return modelo. Un objeto de la clase DefaultTableModel, es decir una tabla (un vector de vectores).
     */
    
    @Override
    public DefaultTableModel consulta(String buscar){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID Compra","ID Reservacion","ID Servicio","Servicio","Fecha Compra", "Cantidad", "Precio Unitario", "Estado"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[8];
        totalregistros = 0;
        totalConsumo = 0.0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un select para consultar con un filtro por id de reservacion, con ello buscaremos en una reservacion.
        setsSQL("select c.idCompra, c.idReservacion, c.idServicio, s.tipo, c.fecha_compra, c.cantidad,"+
                " c.precio, c.estado from compra c inner join servicio s "+
                "on c.idServicio = s.idServicio where c.idReservacion="+ buscar+" order by idCompra");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idCompra");
                registro [1] = rs.getString("idReservacion");
                registro [2] = rs.getString("idServicio");
                registro [3] = rs.getString("tipo");
                registro [4] = rs.getString("fecha_compra");
                registro [5] = rs.getString("cantidad");
                registro [6] = rs.getString("precio");
                registro [7] = rs.getString("estado");
                
                //auemntamos el contador y guardamos el arreglo en forma de fila en modelo.
                totalregistros += 1;
                totalConsumo += rs.getDouble("precio") * rs.getInt("cantidad");
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
     * tabla compra de la base de datos.
     * @param dt. Objeto de la clase Compra donde se aloja la informacion de 
     * una Compra, a partir de esos datos se creara el registro.
     * @return booleano con el cual indicaremos si se inserto el registro correctamente.
     */
    @Override
    public boolean insertar(Object dt){
        Compra dts = (Compra)dt;
        //instrucciones para agregar un registro a base de datos
        setsSQL("insert into compra (idReservacion,idServicio,fecha_compra,cantidad,precio,estado)" +
               "values (?,?,?,?,?,?)");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getIdReservacion());
            pst.setInt(2,dts.getIdServicio());
            pst.setDate(3, dts.getFecha_compra());
            pst.setInt(4, dts.getCantidad());  
            pst.setDouble(5, dts.getPrecio()); 
            pst.setString(6, dts.getEstado()); 
            

            
            // if evaluando la ejecucuion del statement para saber si se guardo el registro o no
            //if (pst.executeUpdate() != 0){
            if (pst.executeUpdate()!= 0){
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
     * El metodo editar nos permite cambiar los datos de un registro de la tabla compra
     * de la base de datos, se cambiaran todos excepto su id.
     * @param dt. Objeto de la clase Compra el cual contendra los datos necesarios para cambiar 
     * el registro.  
     * @return, boolean con el cual indicaremos si el cambio se hizo correctamente.
     */
    @Override
    public boolean editar(Object dt){
        Compra dts = (Compra)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update compra set idReservacion=?, idServicio=?, cantidad=?, precio=?, estado=?" + 
               " where idCompra=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getIdReservacion());
            pst.setInt(2,dts.getIdServicio());
            pst.setInt(3, dts.getCantidad());  
            pst.setDouble(4, dts.getPrecio()); 
            pst.setString(5, dts.getEstado()); 
            pst.setInt(6, dts.getIdCompra()); 
            
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
        Compra dts = (Compra)dt;
        //Instruccion para borrar un registro en la base de datos.
        setsSQL("delete from compra where idCompra=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            pst.setInt(1, dts.getIdCompra());
            
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
        Compra dts = (Compra)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update compra set estado='Pagada'" + 
               " where idCompra=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setInt(1, dts.getIdCompra()); 
            
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
