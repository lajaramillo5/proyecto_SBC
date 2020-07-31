/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Documentos {

    String documento;
    Date fecha;
    String tipo;
    String idioma;
    String doi;

    public Documentos() {
    }

    public Documentos(String documento) {
        this.documento = documento;
    }
    

    public Documentos(String documento, Date fecha, String tipo, String idioma, String doi) {
        this.documento = documento;
        this.fecha = fecha;
        this.tipo = tipo;
        this.idioma = idioma;
        this.doi = doi;
    }

    public String getDocumento() {
        return documento;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getDoi() {
        return doi;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    @Override
    public String toString() {
        return "Documentos{" + "documento=" + documento + ", fecha=" + fecha + ", tipo=" + tipo + ", idioma=" + idioma + ", doi=" + doi + '}';
    }
    
    

}
