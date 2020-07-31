/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import clases.Documentos;
import Data.DataDocumentos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class BLDocumento {

    DataDocumentos ObjDatDocumento = new DataDocumentos();
    Documentos ObjDocument = new Documentos();

    public ArrayList<Documentos> ConsultaLista2(Documentos objdocumento) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listDocuemntos = new ArrayList<>();
        rs = ObjDatDocumento.ConsultarDocumento(objdocumento);

        while (rs.next()) {
            Documentos p = new Documentos(rs.getString("nombre"));
            listDocuemntos.add(p);
        }
        return listDocuemntos;
    }
      public ArrayList<Documentos> ConsultaListaDoi(Documentos objdocumento) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList listDocuemntos = new ArrayList<>();
        rs = ObjDatDocumento.ConsultarDoi(objdocumento);

        while (rs.next()) {
            Documentos p = new Documentos(rs.getString("NOMBRE"),rs.getDate("FECHA"),rs.getString("TIPO"),rs.getString("IDIOMA"),rs.getString("DOI"));
            listDocuemntos.add(p);
        }
        return listDocuemntos;
    }

}
