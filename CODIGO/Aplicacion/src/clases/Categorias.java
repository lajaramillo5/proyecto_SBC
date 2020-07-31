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
public class Categorias {
    
     int id_categoria;
    String sujeto, predicado, objeto;
    int id;

    public Categorias() {
    }

    public Categorias(String sujeto) {
        this.sujeto = sujeto;
    }
    

    public Categorias(int id_categoria, String sujeto, String predicado, String objeto, int id) {
        this.id_categoria = id_categoria;
        this.sujeto = sujeto;
        this.predicado = predicado;
        this.objeto = objeto;
        this.id = id;
    }

    public int getId_categoria() {
        return id_categoria;
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

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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
        return "Categorias{" + "id_categoria=" + id_categoria + ", sujeto=" + sujeto + ", predicado=" + predicado + ", objeto=" + objeto + ", id=" + id + '}';
    }
    
    
}
