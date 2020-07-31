/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Data.DataDbpedia;
import clases.Dbpedia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Smart
 */
public class BLDbpedia {
     DataDbpedia ObjDatDbpedia = new DataDbpedia();
    Dbpedia Objkey = new Dbpedia();

    public ArrayList<Dbpedia> ConsultaLista2(Dbpedia objdocumento) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listDocuemntos = new ArrayList<>();
        rs = ObjDatDbpedia.Consultarsujeto(objdocumento);

        while (rs.next()) {
            Dbpedia p = new Dbpedia(rs.getString("sujeto"));
            listDocuemntos.add(p);
        }
        return listDocuemntos;
    }
}
