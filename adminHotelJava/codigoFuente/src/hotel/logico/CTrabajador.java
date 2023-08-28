/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.logico;

import hotel.datos.Trabajador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author drago
 */
public class CTrabajador extends C{
    private String sSQL2;
    /**
     * El metodo consulta nos permite recuperar informacion de la tabla trabajador
     * que se encuentra en la base de datos.
     * @param email. email del cual se recuperar la informacion.
     * @return modelo. Un objeto de la clase DefaultTableModel es decir una tabla (un vector de vectores).
     */
    @Override
    public DefaultTableModel consulta(String email) {
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID","Nombre","A. Paterno","A. Materno","Telefono","Email","Sueldo","Puesto","Usuario","Contrasena","Estado log" ,"Pregunta de Seguridad", "Respuesta de seguridad"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[13];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por email y relacionando una persona con cliente, con ello buscaremos un cliente mediante su email.
        setsSQL("select p.idPersona, p.nombre, p.aPaterno, p.aMaterno, p.telefono, p.email, " +
                "t.sueldo, t.puesto, t.usuario, t. contrasena, t.estadoLog, t.preguntaSeguridad, "+
                "t.respuetaSeguridad from persona p inner join trabajador t " + 
                "on p.idPersona = t.idPersona where email like '%" + email +"%' order by idPersona");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idPersona");
                registro [1] = rs.getString("nombre");
                registro [2] = rs.getString("aPaterno");
                registro [3] = rs.getString("aMaterno");
                registro [4] = rs.getString("telefono");
                registro [5] = rs.getString("email");
                registro [6] = rs.getString("sueldo");
                registro [7] = rs.getString("puesto");
                registro [8] = rs.getString("usuario");
                registro [9] = rs.getString("contrasena");
                registro [10] = rs.getString("estadoLog");
                registro [11] = rs.getString("preguntaSeguridad");
                registro [12] = rs.getString("respuetaSeguridad");
                
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
     * El metodo insertar nos permite agregar un registro a las
     * tablas trabajador y persona de la base de datos.
     * @param dt. Objeto de la clase Trabajador donde se aloja la informacion de 
     * una persona que es trabajador, apartir de esos datos se creara el registro.
     * @return, booleano con el cual indicaremos si se inserto el registro correctamente.
     */
    @Override
    public boolean insertar(Object dt) {
        Trabajador dts = (Trabajador)dt;
        //instrucciones para agregar un registro a base de datos
        setsSQL("insert into persona (nombre,aPaterno,aMaterno,telefono,email)" +
               "values (?,?,?,?,?)");
        sSQL2 = "insert into trabajador (idPersona,sueldo,puesto,usuario,contrasena,estadoLog,preguntaSeguridad,respuetaSeguridad)" +
               "values ((select idPersona from persona order by idPersona desc limit 1),?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            PreparedStatement pst2 = getCn().prepareStatement(sSQL2);

            //se manda valor a valor inidicando indice y valor.
            pst.setString(1, dts.getNombre());
            pst.setString(2,dts.getaPaterno());
            pst.setString(3,dts.getaMaterno());
            pst.setString(4, dts.getTelefono());
            pst.setString(5,dts.getEmail());
            
            pst2.setDouble(1,dts.getSueldo());
            pst2.setString(2, dts.getPuesto());
            pst2.setString(3,dts.getUsuario());
            pst2.setString(4,dts.getContrasena());
            pst2.setString(5,dts.getEstado_log());
            pst2.setString(6,dts.getPreguntaSeguridad());
            pst2.setString(7,dts.getRespuestaSeguridad());
            
            // if evaluando ejecucuion del statement para saber si se guardo el registro en persona.
            if (pst.executeUpdate() != 0){
                // if evaluando ejecucuion del statement para saber si se guardo el registro en cliente.
                if(pst2.executeUpdate() != 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } 
        
    }

    /**
     * El metodo editar nos permite cambiar los datos de un registro de las tablas persona y trabajador
     * de la base de datos, se cambiaran algunos datos excepto su id.
     * @param dt. Objeto de la clase Trabajador el cual contendra los datos necesarios para cambiar 
     * el registro.
     * @return, booleano con el cual indicaremos si el cambio se hizo correctamente.
     */
    @Override
    public boolean editar(Object dt) {
        Trabajador dts = (Trabajador)dt;
        //instruccion para editar un registro en la base de datos.
        setsSQL("update persona set nombre=?, aPaterno=?, aMaterno=?, telefono=?, email=?" + 
               " where idPersona=?");
        sSQL2 = "update trabajador set sueldo=?, puesto=?,contrasena=? where idPersona=?";
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            PreparedStatement pst2 = getCn().prepareStatement(sSQL2);

            //se manda valor a valor inidicando indice y valor.
            pst.setString(1, dts.getNombre());
            pst.setString(2,dts.getaPaterno());
            pst.setString(3,dts.getaMaterno());
            pst.setString(4, dts.getTelefono());
            pst.setString(5,dts.getEmail());
            pst.setInt(6,dts.getIdpersona());

            pst2.setDouble(1,dts.getSueldo());
            pst2.setString(2, dts.getPuesto());
            pst2.setString(3,dts.getContrasena());
            pst2.setInt(4,dts.getIdpersona());

            
            // if evaluando ejecucuion del statement para saber si se edito el registro en persona.
            if (pst.executeUpdate() != 0){
                // if evaluando ejecucuion del statement para saber si se edito el registro en cliente.
                if(pst2.executeUpdate() != 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }   
    }

    /**
     * El metodo eliminar nos permite borrar un registro de las tablas persona y trabajador en la base de datos
     * mediante su id.
     * @param dt. Objeto de la clase Trabajador del cual obtendremos el id para saber que registro
     * se debe eliminar.
     * @return, boolean para saber si se elimino el registro correctamente.
     */
    @Override
    public boolean eliminar(Object dt) {
        Trabajador dts = (Trabajador)dt;
         //Instruccion para borrar un registro en la base de datos.
        setsSQL("delete from trabajador where idPersona=?");
        sSQL2 = "delete from persona where idPersona=?";
        try {
            PreparedStatement pst = getCn().prepareStatement(getsSQL());
            PreparedStatement pst2 = getCn().prepareStatement(sSQL2);
            
            pst.setInt(1, dts.getIdpersona());
            pst2.setInt(1, dts.getIdpersona());
            
            // if evaluando ejecucuion del statement para saber si se elimino el registro en persona.
            if (pst.executeUpdate() != 0){
                // if evaluando ejecucuion del statement para saber si se elimino el registro en cliente.
                if(pst2.executeUpdate() != 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false; 
        }   
    }
    
    /**
     * Sobrecarga del metodo consulta, nos ayuda a consultar si existe un trabajador en el sistema consultando en la tabla trabajador si existe
     * su usario y contrasena, ademas debe de ser un trabajador activo.
     * @param usuario. Usuario con el que se registra el cliente.
     * @param contrasena. Contrasena para el inicio de sesion.
     * @return Objeto de DefaultTableModel donde se encuentra la informacion del trabajador buscado.
     */
    public DefaultTableModel consulta(String usuario, String contrasena) {
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID","Nombre","A. Paterno","A. Materno","Puesto","Usuario","Contrasena","Estado log" ,"Pregunta de Seguridad", "Respuesta de seguridad"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[10];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por email y relacionando una persona con cliente, con ello buscaremos un cliente mediante su email.
        setsSQL("select p.idPersona, p.nombre, p.aPaterno, p.aMaterno, p.telefono, p.email, " +
                "t.puesto, t.usuario, t. contrasena, t.estadoLog, t.preguntaSeguridad, "+
                "t.respuetaSeguridad from persona p inner join trabajador t " + 
                "on p.idPersona = t.idPersona where t.usuario='" + usuario +"' and t.contrasena='"+contrasena+
                "' and t.estadoLog='Activa'");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idPersona");
                registro [1] = rs.getString("nombre");
                registro [2] = rs.getString("aPaterno");
                registro [3] = rs.getString("aMaterno");
                registro [4] = rs.getString("puesto");
                registro [5] = rs.getString("usuario");
                registro [6] = rs.getString("contrasena");
                registro [7] = rs.getString("estadoLog");
                registro [8] = rs.getString("preguntaSeguridad");
                registro [9] = rs.getString("respuetaSeguridad");
                
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
     * Sobrecarga del metodo consulta, nos ayuda a consultar si existe un trabajador en el sistema consultando en la tabla trabajador para
     * comprobar si el usuario existe y si la pregunta y respuesta coinciden para poder recuperar la contrasena.
     * @param pregunta. Pregunta que registro el trabajador.
     * @param respuesta. Respuesta que registro el trabajador.
     * @param usuario. usuario del trabajador que esta intentando acceder.
     * @return Objeto de DefaultTableModel donde se encuentra la informacion del trabajador buscado.
     */
    public DefaultTableModel consulta(String pregunta, String respuesta, String usuario) {
        DefaultTableModel modelo;
        //Arreglo para guardar los titulos de las culumnas existentes en la base de datos.
        String [] columnas = {"ID","Nombre","A. Paterno","A. Materno","Puesto","Usuario","Contrasena","Estado log" ,"Pregunta de Seguridad", "Respuesta de seguridad"};
        //Arreglo para guardar informacion de cada columna.
        String [] registro = new String[10];
        totalregistros = 0;
        //se guardan al inicio los titulos de las columnas.
        modelo = new DefaultTableModel(null, columnas);
        //se hace un selct para consultar con un filtro por email y relacionando una persona con cliente, con ello buscaremos un cliente mediante su email.
        setsSQL("select p.idPersona, p.nombre, p.aPaterno, p.aMaterno, p.telefono, p.email, " +
                "t.puesto, t.usuario, t. contrasena, t.estadoLog, t.preguntaSeguridad, "+
                "t.respuetaSeguridad from persona p inner join trabajador t " + 
                "on p.idPersona = t.idPersona where t.preguntaSeguridad='" + pregunta +"' and t.respuetaSeguridad='"+respuesta+
                "' and t.estadoLog='Activa' and t.usuario='"+usuario+"'");
        
        try {
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(getsSQL());
            
            //se recorreran los registros mediante un while.
            while(rs.next()){
                registro [0] = rs.getString("idPersona");
                registro [1] = rs.getString("nombre");
                registro [2] = rs.getString("aPaterno");
                registro [3] = rs.getString("aMaterno");
                registro [4] = rs.getString("puesto");
                registro [5] = rs.getString("usuario");
                registro [6] = rs.getString("contrasena");
                registro [7] = rs.getString("estadoLog");
                registro [8] = rs.getString("preguntaSeguridad");
                registro [9] = rs.getString("respuetaSeguridad");
                
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
