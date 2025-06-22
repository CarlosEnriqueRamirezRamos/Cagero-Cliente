package com.example.Cagero_Automatico.ML;

public class Efectivo {
private int IdEfectivo;
private String Tipo;
private String Denominacion;
private String Cantidad;

    public int getIdEfectivo() {
        return IdEfectivo;
    }

    public void setIdEfectivo(int IdEfectivo) {
        this.IdEfectivo = IdEfectivo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(String Denominacion) {
        this.Denominacion = Denominacion;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

}
