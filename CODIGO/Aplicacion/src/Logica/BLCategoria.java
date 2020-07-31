/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;



import Data.DataSkos;
import clases.Categorias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Smart
 */
public class BLCategoria {
     DataSkos ObjDatCte = new DataSkos();
    Categorias Objkey = new Categorias();

    public ArrayList<Categorias> ConsultaLista2(Categorias objdocumento) throws ClassNotFoundException, SQLException {
        ResultSet rs;//recuper datos desde rs y los desgloso o desconpone
        ArrayList lstctegori= new ArrayList<>();
        rs = ObjDatCte.Consultarsujeto(objdocumento);

        while (rs.next()) {
            Categorias p = new Categorias(rs.getString("sujeto"));
            lstctegori.add(p);
        }
        return lstctegori;
    }
}
