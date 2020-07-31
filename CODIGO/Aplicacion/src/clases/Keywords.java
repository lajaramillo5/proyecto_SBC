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
public class Keywords {

    int id;
    String doi;
    String palabra;
    String lable, esp, dbepedia;

    public Keywords() {
    }

    public Keywords(int id, String doi, String palabra, String lable, String esp, String dbepedia) {
        this.id = id;
        this.doi = doi;
        this.palabra = palabra;
        this.lable = lable;
        this.esp = esp;
        this.dbepedia = dbepedia;
    }
    
 

    public Keywords(String doi) {
        this.doi = doi;
    }

    public int getId() {
        return id;
    }

    public String getDoi() {
        return doi;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getLable() {
        return lable;
    }

    public String getEsp() {
        return esp;
    }

    public String getDbepedia() {
        return dbepedia;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public void setDbepedia(String dbepedia) {
        this.dbepedia = dbepedia;
    }

    @Override
    public String toString() {
        return "Keywords{" + "id=" + id + ", doi=" + doi + ", key=" + palabra + ", lable=" + lable + ", esp=" + esp + ", dbepedia=" + dbepedia + '}';
    }

}
