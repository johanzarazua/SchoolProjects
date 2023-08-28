/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.datos;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * La clase Pago modela objetos con valores representantivos de un pago
 * @author Efren
 */
public class Pago {
   private int idPago;
    private int idCompra;
    private Date fecha_emision;
    private Date fecha_pago;
    private String tipoPago;
    private String comprobante;
    private String comprobantePago;
    private double total;

    /**
     * Constructor vacio de la clase Pago
     */
    public Pago() {
    }

    /**
     * Constructor de la clase Pago
     * @param idPago, identificador unico de pago
     * @param idCompra, identificador unico de la reservacion a pagar
     * @param fecha_emision, fecha de emision
     * @param fecha_pago, fecha de pago
     * @param tipoPago, tipo de pago que se realiza
     * @param comprobante, tipo de comprobante que se realiza 
     * @param comprobantePago, numero de comprobante
     * @param total, monto total a pagar
     */
    public Pago(int idPago, int idCompra, Date fecha_emision, Date fecha_pago, String tipoPago, String comprobante, String comprobantePago, double total) {
        this.idPago = idPago;
        this.idCompra = idCompra;
        this.fecha_emision = fecha_emision;
        this.fecha_pago = fecha_pago;
        this.tipoPago = tipoPago;
        this.comprobante = comprobante;
        this.comprobantePago = comprobantePago;
        this.total = total;
    }

    

    public int getIdPago() {
        return idPago;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public String getComprobante() {
        return comprobante;
    }

    public String getComprobantePago() {
        return comprobantePago;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public void setComprobantePago(String comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}
