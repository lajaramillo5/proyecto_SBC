/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author lenovo
 */
public class Dbpedia {

    int id_debepedia;
    String sujeto, predicado, objeto;
    int id;

    public Dbpedia() {
    }

    public Dbpedia(String sujeto) {
        this.sujeto = sujeto;
    }
    

    public Dbpedia(int id_debepedia, String sujeto, String predicado, String objeto, int id) {
        this.id_debepedia = id_debepedia;
        this.sujeto = sujeto;
        this.predicado = predicado;
        this.objeto = objeto;
        this.id = id;
    }

    public int getId_debepedia() {
        return id_debepedia;
    }

    public String getSujeto() {
        return sujeto;
    }

    public String getPredicado() {
        return predicado;
    }

    public String getObjeto() {
        return objeto;
    }

    public int getId() {
        return id;
    }

    public void setId_debepedia(int id_debepedia) {
        this.id_debepedia = id_debepedia;
    }

    public void setSujeto(String sujeto) {
        this.sujeto = sujeto;
    }

    public void setPredicado(String predicado) {
        this.predicado = predicado;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dbpedia{" + "id_debepedia=" + id_debepedia + ", sujeto=" + sujeto + ", predicado=" + predicado + ", objeto=" + objeto + ", id=" + id + '}';
    }
    
}
