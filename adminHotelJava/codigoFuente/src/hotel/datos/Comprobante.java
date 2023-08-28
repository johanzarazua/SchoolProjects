/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * La clase Comprobante nos ayuda a crear comprobantes de compra en pdf y a abrirlos.
 * @author Efren
 */
public class Comprobante {
    
    /**
     * El metodo guardar crea un nuevo comprobante de pago en pdf
     * @param p, Objeto de la clase Pago
     * @param p_res, precio de la reservacion
     * @param p_serv, precio total de los servicios 
     * @param cliente, cliente que realiza pago 
     */
    public static void guardar(Pago p, String p_res, String p_serv, String cliente){
        String text;
        String tipo;
        if (p.getComprobante().equalsIgnoreCase("Factura")){
            text = "        Hotel - in      \n" + "     Factura de pago     \n" + 
                    "       No. Factura " + p.getComprobantePago() + "      \n" +
                    "       Cliente " + cliente + "     \n" +
                    "       Fecha de pago " + p.getFecha_pago() + "         \n\n" +
                    "ID Reservacion " + p.getIdCompra() + "\n\n" + 
                    "Costo Reservacion $" + p_res + "\n" + 
                    "Costo servicios $" + p_serv + "\n" + 
                    "Total $" + p.getTotal();
            tipo = "f";
        }else{
            text = "Fecha de pago " + p.getFecha_pago() + "\n\n" +
                    "Costo Reservacion $" + p_res + "\n" + 
                    "Costo servicios $" + p_serv + "\n" + 
                    "----------------------------------------------------------------------------\n" +
                    "Total $" + p.getTotal();
            tipo = "t";
        }
        try {
            FileOutputStream fout = new FileOutputStream("src\\hotel\\comprobantes\\" + p.getIdCompra() + tipo + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, fout);
            doc.open();
            doc.add(new Paragraph(text));
            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    /**
     * El metodo abrir nos ayuda a abrir los comprobantes en pdf
     * @param tipo, tipo de comprobante
     * @param nombre, id de reservacion
     */
    public static void abrir(String tipo, String nombre){
        try {
            String archivo;
            if (tipo.equalsIgnoreCase("Factura")){
                archivo = nombre+"f.pdf";
            }else{
                archivo = nombre+"t.pdf";
            }
            
            //Se debera seleccionar la carpeta del proyectodonde se ecnuetre el archivo .jar  y en esta carpeta
            //habra una carpeta llamada src debera entre en ella y seleccionar la carpeta comprobantes la cual es la que se abrira.
            JFileChooser jfc = new JFileChooser();
            int op =  jfc.showOpenDialog(null);
            if (op == JFileChooser.APPROVE_OPTION){
                File f = jfc.getSelectedFile();
                String ruta = f.toString();
                ProcessBuilder p = new ProcessBuilder();
                p.command("cmd.exe", "/c", ruta);
                p.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
