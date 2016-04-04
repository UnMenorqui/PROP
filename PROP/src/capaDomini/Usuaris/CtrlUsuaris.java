/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package capaDomini.Usuaris;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author toni_
 * 
 * Aquesta classe està dedicada exlcusivament per a crear la
 * Base de Dades d'usuaris, les operacions seran tals com
 * carregar la BD, codificar la BD en un arxiu, modificar-la, etc..
 * 
 * 
 * 
 */

public class CtrlUsuaris {
    private Document document = null;
    
    
    public void main () throws TransformerException, SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        String BDusers = null;
        
        String user = "toni";
        String pass = "abc";
        String Nom = "Toni Riera Pons";
        
        crea_BD(factory);
        Document document = null;
        codifica_BD(document,BDusers);
        if(!existeix(BDusers,user)) {
            AfegirInformacio(BDusers,user,pass,Nom);
        }
    }
    
    
    // Crearà la Base de Dades
    /* 
    Pre:    Cap.
    
    Post:   Base de Dades creada.
    */
    
    public void crea_BD(DocumentBuilderFactory factory) {
        
        try {
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            
            
            //Creació d'elements
            Element Usuaris = document.createElement("Usuaris");
            
            Element Usuari = document.createElement("Usuari");
            
            Element Nom = document.createElement("Nom");
            
            Element user = document.createElement("user");
            
            Element pass = document.createElement("pass");
            
            document.setXmlVersion("1.0");
            
            document.getDocumentElement().appendChild(Usuaris);
            
            Usuaris.appendChild(Usuari);
            Usuari.appendChild(Nom);
            Usuari.appendChild(user);
            Usuari.appendChild(pass);
        }
        catch (ParserConfigurationException | DOMException e){
            System.err.println("Error al crear la Base de Dades");
        }
    }
    
    
    /*  Codificarà la base de dades com un arxiu, per a poder utilittzar-la
        i així guardar tota la informació.
    */
    /* 
    Pre:    Cap.
    
    Post:   Base de Dades codificada.
    */
    public static void codifica_BD (Document document, String BDusers) {
        try {
            TransformerFactory transFact = TransformerFactory.newInstance();

            transFact.setAttribute("indent-number", 3);

            Transformer trans = transFact.newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");


            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult();

            DOMSource domSource = new DOMSource(document);
            trans.transform(domSource, sr);
            
            try {
            //Creamos fichero para escribir en modo texto
            PrintWriter writer = new PrintWriter(new FileWriter(BDusers));

            //Escribimos todo el árbol en el fichero
            writer.println(sw.toString());

            //Cerramos el fichero
            writer.close();
        } 
            catch (IOException e) {
            e.printStackTrace();
        }
    } catch(Exception ex) {
        ex.printStackTrace();
    }
    }
    
    // Afegirà informació a la Base de Dades
    /* 
    Pre:    Cal saber la informació que es vol afegir.
    
    Post:   Base de Dades actualitzada amb la nova informació.
    */
    public void AfegirInformacio(String BDusers,String user, String pass, String Nom) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(new File(BDusers));
            document.getDocumentElement().normalize();
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
        }
        
        Element node_super = document.getDocumentElement();
        Text usuari = document.createTextNode(user);
        Text passw = document.createTextNode(pass);
        Text nom = document.createTextNode(Nom);
        Element nou_node = document.createElement("Usuari");
        
        nou_node.appendChild(usuari);
        nou_node.appendChild(passw);
        nou_node.appendChild(nom);
        node_super.appendChild(nou_node);
    }
    
    // Busca a la Base de Dades per nom d'usuari.
    /* 
    Pre:    Cal saber el nom de l'usuari.
    
    Post:   Retorna el node de l'usuari amb la informació per a treballar amb ell.
    */
    public Node cerca_per_nom(String BDusers, String nom) throws SAXException, IOException, ParserConfigurationException {

        //Cargamos el document del fichero XML existente
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(new File(BDusers));
        document.getDocumentElement().normalize();

        NodeList nodeUsuari = document.getDocumentElement().getElementsByTagName("Usuari");
        for (int i = 0; i < nodeUsuari.getLength(); ++i) {
            String nomm = nodeUsuari.item(i).getAttributes().getNamedItem("user").getTextContent();
            if (nomm.equals(nom)) return nodeUsuari.item(i);
        }
        return null;
    }
    
    // Busca a la Base de Dades per nom d'usuari si existeix.
    /* 
    Pre:    Cal saber el nom de l'usuari.
    
    Post:   retorna true o false si existeix o no, respectivament.
    */
    public boolean existeix(String BDusers, String nom) throws SAXException, IOException, ParserConfigurationException {

        //Cargamos el document del fichero XML existente
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(new File(BDusers));
        document.getDocumentElement().normalize();

        NodeList nodeUsuari = document.getDocumentElement().getElementsByTagName("Usuari");
        for (int i = 0; i < nodeUsuari.getLength(); ++i) {
            String nomm = nodeUsuari.item(i).getAttributes().getNamedItem("user").getTextContent();
            if (nomm.equals(nom)) return true;
        }
        return false;
    }
    
    
    
    public void elimina_usuari(String BDusers, String user) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(new File(BDusers));
        document.getDocumentElement().normalize();

        NodeList nodeUsuari = document.getDocumentElement().getElementsByTagName("Usuari");
        
        
        int i = 0;
        int mida = nodeUsuari.getLength(); // per no consultar lenght a cada iteració del while
        while (i < mida) {
            String user_cercat = nodeUsuari.item(i).getAttributes().getNamedItem("user").getTextContent();
            if (user_cercat.equals(user)) {
                nodeUsuari.item(i).removeChild(nodeUsuari.item(i));
                i = mida;
            }
            ++i;
        }
    }
    
    
    /*  Utilitzarà l'arixiu creat anteriorment com a Base de Dades
        per a escriure sobre aquest, i/o modificarl-o, poguent així
        afegir dades noves.
    */
    /* 
    Pre:    S'ha de saber l'identificador d'usuari desitjat 
            per a modificar
    
    Post:   Modificació de la Base de Dades.
    */
    public void modifica_informacio_usuari(String BDusers, String user_antic, String user_nou, String Nom, String pass) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(new File(BDusers));
        document.getDocumentElement().normalize();

        NodeList nodeUsuari = document.getDocumentElement().getElementsByTagName("Usuari");
        
        
        int i = 0;
        int mida = nodeUsuari.getLength(); // per no consultar lenght a cada iteració del while
        while (i < mida) {
            String user_cercat = nodeUsuari.item(i).getAttributes().getNamedItem("user").getTextContent();
            if (user_cercat.equals(user_antic)) {
                Text usuari = document.createTextNode(user_antic);
                Text nou_pass = document.createTextNode(pass);
                Text nou_nom = document.createTextNode(Nom);
                Node nou_node = document.createElement("Usuari");
                nou_node.appendChild(usuari);
                nou_node.appendChild(nou_pass);
                nou_node.appendChild(nou_nom);
                //Canvia el node antinc, per el nou node amb la informcio actualitzada
                nodeUsuari.item(i).replaceChild(nou_node, (Node) nodeUsuari.item(i).getAttributes());
                // Sortim del while assignant a i el valor maxim
                i = mida;
            }
            ++i;
        }
    }
}
