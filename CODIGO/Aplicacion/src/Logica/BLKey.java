/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Data.Datakeywords;
import clases.Keywords;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Smart
 */
public class BLKey {

    Datakeywords ObjDatkey = new Datakeywords();
    Keywords Objkey = new Keywords();

    public ArrayList<Keywords> ConsultaLista2(Keywords objdocumento) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listDocuemntos = new ArrayList<>();
        rs = ObjDatkey.ConsultarDoiDoumento(objdocumento);

        while (rs.next()) {
            Keywords p = new Keywords(rs.getString("documentoS_doi"));
            listDocuemntos.add(p);
        }
        return listDocuemntos;
    }

    public ArrayList<Keywords> ConsultaListaKey(Keywords objdocumento) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listDocuemntos = new ArrayList<>();
        rs = ObjDatkey.ConsultarPalabra(objdocumento);

        while (rs.next()) {
            Keywords p = new Keywords(rs.getString("keyword"));
            listDocuemntos.add(p);
        }
        return listDocuemntos;
    }

    public ArrayList<Keywords> ConsultaListaKeyes(Keywords objdocumento) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listDocuemntos = new ArrayList<>();
        rs = ObjDatkey.ConsultarPalabras(objdocumento);

        while (rs.next()) {
            Keywords p = new Keywords(rs.getInt("ID_KEYWORD"),rs.getString("DOCUMENTOS_DOI"),rs.getString("keyword"),rs.getString("lable"),rs.getString("palabra"),rs.getString("dbepedia"));
            listDocuemntos.add(p);
        }
        return listDocuemntos;
    }
}
