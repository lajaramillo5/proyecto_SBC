/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Documentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class DataDocumentos extends OracleConection {

    private Documentos document = new Documentos ();
    OracleConection c = new OracleConection();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM DOCUEMENTOS";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public ResultSet ConsultarDocumento(Documentos document) throws ClassNotFoundException, SQLException {
        Statement st = c.Conectar().getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select  nombre from documentos WHERE doi="+document.getDoi();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
      public ResultSet ConsultarDoi(Documentos document) throws ClassNotFoundException, SQLException {
        Statement st = c.Conectar().getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select * from documentos WHERE nombre="+document.getDocumento();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
   

}
