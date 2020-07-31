/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Dbpedia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Smart
 */
public class DataDbpedia {
      private Dbpedia document = new Dbpedia ();
    OracleConection c = new OracleConection();

    public ResultSet Consultar() throws ClassNotFoundException, SQLException {
        Statement st = c.getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "SELECT * FROM dbpedia";//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }

    public ResultSet Consultarsujeto(Dbpedia db) throws ClassNotFoundException, SQLException {
        Statement st = c.Conectar().getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select distinct sujeto from dbpedia WHERE objeto="+db.getObjeto();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
}
