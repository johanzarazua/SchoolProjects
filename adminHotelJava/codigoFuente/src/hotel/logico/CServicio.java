/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

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
public class CServicio extends C{ 
    
    /**
     * El metodo consulta nos permite recuperar informacion de la tabla servicio
     * que se encuentra en la base de datos.
     * @param buscar.
     * @return modelo. Un objeto de la clase DefaultTableModel, es decir una tabla (un vector de vectores).
     */
    @Override
    public DefaultTableModel consulta(String buscar){
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID","Tipo","Descripcion","Precio"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[4];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por tipo, con ello buscaremos en un piso.
        setsSQL("select * from servicio order by idServicio");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idServicio");
                registro [1] = rs.getString("tipo");
                registro [2] = rs.getString("descripcion");
                registro [3] = rs.getString("precio");
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
     * tabla servicio de la base de datos.
     * @param dt. Objeto de la clase Servico donde se aloja la informacion de 
     * un servicio, apartir de esos datos se creara el registro.
     * @return, booleano con el cual indicaremos si se inserto el registro correctamente.
     */
    @Override
    public boolean insertar(Object dt){
        Servicio dts = (Servicio)dt;
        //instrucciones para agregar un registro a base de datos
        setsSQL("insert into servicio (tipo,descripcion,precio)" +
               "values (?,?,?)");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setString(1, dts.getTipo());
            pst.setString(2,dts.getDescripcion());
            pst.setDouble(3, dts.getPrecio());  
            
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
        Servicio dts = (Servicio)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update servicio set tipo=?, descripcion=?, precio=?" + 
               " where idServicio=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            //se manda valor a valor inidicando indice y valor.
            pst.setString(1, dts.getTipo());
            pst.setString(2,dts.getDescripcion());
            pst.setDouble(3,dts.getPrecio());
            pst.setInt(4, dts.getIdServicio());
            
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
        Servicio dts = (Servicio)dt;
        //Instruccion para borrar un registro en la base de datos.
        setsSQL("delete from servicio where idServicio=?");
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            pst.setInt(1, dts.getIdServicio());
            
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
}
