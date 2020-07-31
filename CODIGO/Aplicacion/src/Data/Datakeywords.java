/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import clases.Documentos;
import clases.Keywords;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Smart
 */
public class Datakeywords {

    private Keywords key = new Keywords();
    OracleConection c = new OracleConection();

    public ResultSet ConsultarDoiDoumento(Keywords palabra) throws ClassNotFoundException, SQLException {
        Statement st = c.Conectar().getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select documentos_doi from keyword WHERE dbepedia=" + palabra.getDbepedia();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
       public ResultSet ConsultarPalabra(Keywords palabra) throws ClassNotFoundException, SQLException {
        Statement st = c.Conectar().getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select distinct keyword from keyword WHERE dbepedia=" + palabra.getDbepedia();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
          public ResultSet ConsultarPalabras(Keywords palabra) throws ClassNotFoundException, SQLException {
        Statement st = c.Conectar().getConexion().createStatement();//obj para poder manipular abre coneccion y crea unStatement 
        String Sentencia = "Select  * from keyword WHERE documentos_doi=" + palabra.getDoi();//crea un a varible y ponermos la cadena para recuperar todo desde la BDD
        ResultSet rs = st.executeQuery(Sentencia);//recuper un un ResultSet y envio la varible a executeQuery
        return rs;//retornma en un obj ResultSet rs
    }
}
