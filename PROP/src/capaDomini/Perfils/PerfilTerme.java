/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import static capaDomini.Perfils.Perfil.nom;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marc_
 */
public class PerfilTerme extends Perfil {
    
    static ArrayList<String> autors = new ArrayList<>();
    static ArrayList<String> conferencies = new ArrayList<>();
    static ArrayList<String> articles = new ArrayList<>();
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
    
    public static ArrayList<String> articles_importants() {
        
        // obtenir_articles(articles,nom,quantitat_articles);
        return articles;
    }
    
    public static ArrayList<String> conferencies_importants() {
        // obtenir_conferencies(conferencies,nom,quantitat_conf);
        return conferencies;
    }
    
    public static ArrayList<String> autors_importants() {
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
