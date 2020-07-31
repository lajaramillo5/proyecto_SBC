/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.keywords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.RDFWriter;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

/**
 *
 * @author Smart
 */
public class keywords {

    //CAMBIAR POR RUTAS DEL EQUIPO DONDE SE EJECUTE
    static String DataFilePath = "C:/Users/Smart/Documents/NetBeansProjects/keywords/dataset/"; //Data
    static String fuente = "fuentes.csv";
    static String documento = "documento.csv";
    static String autor = "autores.csv";
    static String key = "keywords.csv";
    static String GenFilePath = "C:/Users/Smart/Documents/NetBeansProjects/keywords/keywords_pruueba.rdf"; //Generated RDF

    public static void main(String... args) throws FileNotFoundException {
        //Get data from CSV and store in a list
        List<document> documents = readDocumentFromCSV(DataFilePath + documento);
        List<fuentes> recurso = readFuentesFromCSV(DataFilePath + fuente);
        List<autors> autores = readAutorsFromCSV(DataFilePath + autor);
        List<keys> keywords = readKeysFromCSV(DataFilePath + key);

        // create an empty Model
        Model model = ModelFactory.createDefaultModel();
        File f = new File(GenFilePath); //File to save the results of RDF Generation
        FileOutputStream os = new FileOutputStream(f);

        //Set prefix for the URI base (data)
        String dataPrefix = "http://ky.utpl.edu.ec/publicicovid/ontogy#";
        model.setNsPrefix("myonto", dataPrefix);

        //Vocab and models present in JENA
        String owl = "https://www.w3.org/2002/07/owl#";
        model.setNsPrefix("owl", owl);
        Model owlModel = ModelFactory.createDefaultModel();
        //dublincore
        String core = "https://dublincore.org/specifications/dublin-core/dcmi-terms/#";
        model.setNsPrefix("core", core);
        Model coreModel = ModelFactory.createDefaultModel();
        //bibo
        String bibo = "http://purl.org/ontology/bibo/";
        model.setNsPrefix("bibo", bibo);
        Model biboModel = ModelFactory.createDefaultModel();
        //fabio
        String fabio = "http://purl.org/spar/fabio/";
        model.setNsPrefix("fabio", fabio);
        Model fabioModel = ModelFactory.createDefaultModel();
        //dcat
        String dcat = "http://www.w3.org/ns/dcat#";
        model.setNsPrefix("dcat", dcat);
        Model dcatModel = ModelFactory.createDefaultModel();
        //SCHEMA
        String schema = "http://schema.org/";
        model.setNsPrefix("schema", schema);
        Model schemaModel = ModelFactory.createDefaultModel();
        //Dbpedia Ontology- DBO
        String dbo = "http://dbpedia.org/ontology/";
        model.setNsPrefix("dbo", dbo);
        Model dboModel = ModelFactory.createDefaultModel();
        //Dbpedia Resource - DBR
        String dbr = "http://dbpedia.org/resource/";
        model.setNsPrefix("dbr", dbr);
        Model dbrModel = ModelFactory.createDefaultModel();
        //skos
        String skos = "https://www.w3.org/2009/08/skos-reference/skos.html#";
        model.setNsPrefix("skos", skos);
        Model skosModel = ModelFactory.createDefaultModel();
        // create Classes & properties

        Property myonto = ResourceFactory.createProperty(dataPrefix);
        Resource fuente = null, paper = null, palabra = null, autor = null;
        for (document b : documents) {
            System.out.println(b);

            paper = model.createResource(core + b.getIdentificador())
                    .addProperty(fabioModel.getProperty(fabio + "Article"), b.getName_documento())
                    .addProperty(coreModel.getProperty(core + "date"), b.getDate())
                    .addProperty(coreModel.getProperty(core + "format"), b.getTipo())
                    .addProperty(coreModel.getProperty(core + "languaje"), b.getLanguaje())
                    .addProperty(coreModel.getProperty(core + "identifier"), b.getIdentificador());

        }
        for (autors a : autores) {
            String idautor = a.getName_autor().replaceAll(" ", "_");
            autor = model.createResource(dataPrefix + idautor)
                    .addProperty(coreModel.getProperty(core + "identifier"),a.getPaper())
                    .addProperty(RDF.type, FOAF.Person)
                    .addProperty(FOAF.name, idautor);

        }
        for (fuentes fu : recurso) {
            fuente = model.createResource(core + fu.getName_fuente())
                    .addProperty(dboModel.getProperty(dbo, "name"), fu.getName_fuente())
                    .addProperty(dcatModel.getProperty(dcat, "downloadURL"), fu.getUrl());
                    
        }
        for (keys ke : keywords) {
            String idkey = ke.getPalabra().replaceAll(" ", "-");
            palabra = model.createResource(dataPrefix + idkey)
                    .addProperty(coreModel.getProperty(core + "identifier"),ke.getId())
                    .addProperty(skosModel.createProperty(skos, "concept"), ke.getPalabra())
                    .addProperty(skosModel.createProperty(skos, "altLabel"), ke.getLable())
                    .addProperty(skosModel.createProperty(skos, "prefLabel"), ke.getEspañol())
                    .addProperty(owlModel.createProperty(owl, "sameAs"), ke.getDbpedia());

        }
        fuente.addProperty(RDF.type, paper);
       
                paper .addProperty(skosModel.getProperty(skos + "narrowers"), palabra)
                .addProperty(coreModel.getProperty(core + "created"), autor);;
        /**
         * Resource Document
         */
        /**
         * Formatting and resource creation by the recurso
         */
        StmtIterator iter = model.listStatements();

        System.out.println(
                "TRIPLES");
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();  // get next statement
            Resource subject = stmt.getSubject();     // get the subject
            Property predicate = stmt.getPredicate();   // get the predicate
            RDFNode object = stmt.getObject();      // get the object

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }

            System.out.println(" .");
        }
        // now write the model in XML form to a file

        System.out.println(
                "MODELO RDF------");
        model.write(System.out,
                "RDF/XML-ABBREV");

        // Save to a file
        RDFWriter writer = model.getWriter("RDF/XML");

        writer.write(model, os,
                "");

        //Close models
        dboModel.close();

        model.close();
    }

    /**
     * Method to read and instance objects from CSV
     *
     * @param fileName Route of file
     * @return List of Persons from the CSV metadata
     */
    private static List<document> readDocumentFromCSV(String fileName) {
        List<document> documents = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(";");

                document documento = createDocument(attributes);

                // adding person into ArrayList
                documents.add(documento);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return documents;
    }

    private static List<fuentes> readFuentesFromCSV(String fileName) {
        List<fuentes> fuente = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(";");

                fuentes document = createfuentes(attributes);

                // adding person into ArrayList
                fuente.add(document);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return fuente;
    }

    private static List<autors> readAutorsFromCSV(String fileName) {
        List<autors> autores = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(";");

                autors autor = createautors(attributes);

                // adding person into ArrayList
                autores.add(autor);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return autores;
    }

    private static List<keys> readKeysFromCSV(String fileName) {
        List<keys> palabras = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(";");

                keys palabra = createkeys(attributes);

                // adding person into ArrayList
                palabras.add(palabra);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return palabras;
    }

    /**
     * Method createPerson
     *
     * @param metadata attributes obtained from the read line of CSV
     * @return an Objet of type person
     */
    private static document createDocument(String[] metadata) {

        String name_documento = metadata[0];
        String date = metadata[1];
        String tipo = metadata[2];
        String languaje = metadata[3];
        String identificador = metadata[4];
        // create and return person of this metadata
        return new document(name_documento, date, tipo, languaje, identificador);
    }

    private static fuentes createfuentes(String[] metadata) {
        String name_fuente = metadata[0];
        String url = metadata[1];

        // create and return person of this metadata
        return new fuentes(name_fuente, url);
    }

    private static autors createautors(String[] metadata) {
        String paper = metadata[0];
        String autors = metadata[1];

        // create and return person of this metadata
        return new autors(paper, autors);
    }

    private static keys createkeys(String[] metadata) {
        String id = metadata[0];
        String palabra = metadata[1];
        String lable = metadata[2];
        String español = metadata[3];
        String dbpedia = metadata[4];

        // create and return person f this metadata
        return new keys(id, palabra, lable, español, dbpedia);

    }
}

//Person Class
class document {

    private String name_documento;
    private String date;
    private String tipo;
    private String languaje;
    private String identificador;

    public document(String name_documento, String date, String tipo, String languaje, String identificador) {
        this.name_documento = name_documento;
        this.date = date;
        this.tipo = tipo;
        this.languaje = languaje;
        this.identificador = identificador;
    }

    public String getName_documento() {
        return name_documento;
    }

    public String getDate() {
        return date;
    }

    public String getTipo() {
        return tipo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getLanguaje() {
        return languaje;
    }

    public void setName_documento(String name_documento) {
        this.name_documento = name_documento;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setLanguaje(String languaje) {
        this.languaje = languaje;
    }

    @Override
    public String toString() {
        return "document{" + "name_documento=" + name_documento + ", date=" + date + ", tipo=" + tipo + ", languaje=" + languaje + ", identificador=" + identificador + '}';
    }

}

class fuentes {

    private String name_fuente;
    private String url;

    public fuentes(String name_fuente, String url) {
        this.name_fuente = name_fuente;
        this.url = url;
    }

    public String getName_fuente() {
        return name_fuente;
    }

    public String getUrl() {
        return url;
    }

    public void setName_fuente(String name_fuente) {
        this.name_fuente = name_fuente;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "fuentes{" + "name_fuente=" + name_fuente + ", url=" + url + '}';
    }

}

class autors {

    private String paper;
    private String name_autor;

    public autors(String paper, String name_autor) {
        this.paper = paper;
        this.name_autor = name_autor;
    }

    public String getPaper() {
        return paper;
    }

    public String getName_autor() {
        return name_autor;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public void setName_autor(String name_autor) {
        this.name_autor = name_autor;
    }

    @Override
    public String toString() {
        return "autors{" + "paper=" + paper + ", name_autor=" + name_autor + '}';
    }

}

class keys {

    private String id;
    private String palabra;
    private String lable;
    private String español;
    private String dbpedia;

    public keys(String id, String palabra, String lable, String español, String dbpedia) {
        this.id = id;
        this.palabra = palabra;
        this.lable = lable;
        this.español = español;
        this.dbpedia = dbpedia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getLable() {
        return lable;
    }

    public String getEspañol() {
        return español;
    }

    public String getDbpedia() {
        return dbpedia;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public void setEspañol(String español) {
        this.español = español;
    }

    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }

    @Override
    public String toString() {
        return "keys{" + "palabra=" + palabra + ", lable=" + lable + ", espa\u00f1ol=" + español + ", dbpedia=" + dbpedia + '}';
    }

}
