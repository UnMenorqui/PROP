/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import static capaDomini.Perfils.Perfil.nom;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marc_
 */
public class PerfilTerme extends Perfil {
    
    static List<String> autors = new Vector<String>();
    static List<String> conferencies = new Vector<String>();
    static List<String> articles = new Vector<String>();
    static int quantitat_autors;
    static int quantitat_conf;
    static int quantitat_articles;
    
    
    public static int get_quantitat_autors() {
        return quantitat_autors;
    }
    
    public static int get_quantitat_conf() {
        return quantitat_conf;
    }
    
    public static int get_quantitat_articles() {
        return quantitat_articles;
    }
    
    public static List<String> articles_importants() {
        
        // obtenir_articles(articles,nom,quantitat_articles);
        return articles;
    }
    
    public static List<String> conferencies_importants() {
        // obtenir_conferencies(conferencies,nom,quantitat_conf);
        return conferencies;
    }
    
    public static List<String> autors_importants() {
        // obtenir_autors(autors,nom,quantitat_autors);
        return autors;
    }
    
    public static void crear_perfil_terme() {
        articles_importants();
        conferencies_importants();
        autors_importants();
        System.out.println(nom);
        System.out.println("");
        System.out.println("Conferencies més rellevants d'aquest terme:");
        for (int i = 0; i < conferencies.size(); ++i) {
            String aux = conferencies.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Articles més rellevants d'aquest terme:");
        for (int i = 0; i < articles.size(); ++i) {
            String aux = articles.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Autors més rellevants d'aquest terme:");
        for (int i = 0; i < autors.size(); ++i) {
            String aux = autors.get(i);
            System.out.println(aux);
        }
    }
    
}