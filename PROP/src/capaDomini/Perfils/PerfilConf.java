/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import static capaDomini.Perfils.Perfil.nom;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author marc_
 */
public class PerfilConf extends Perfil {
    
    static ArrayList<String> termes = new ArrayList<>();
    static ArrayList<String> autors = new ArrayList<>();
    static ArrayList<String> articles = new ArrayList<>();
    static int quantitat_termes;
    static int quantitat_autors;
    static int quantitat_articles;
    
    
    public static int get_quantitat_termes() {
        return quantitat_termes;
    }
    
    public static int get_quantitat_autors() {
        return quantitat_autors;
    }
    
    public static int get_quantitat_articles() {
        return quantitat_articles;
    }
    
    public static ArrayList<String> articles_importants() {
        // obtenir_articles(articles,nom,quantitat_articles);
        return articles;
    }
    
    public static ArrayList<String> autors_importants() {
        // obtenir_autors(autors,nom,quantitat_autors);
        return autors;
    }
    
    public static ArrayList<String> termes_importants() {
        // obtenir_termes(termes,nom,quantitat_termes);
        return termes;
    }
    
    public static void crear_perfil_conf() {
        articles_importants();
        autors_importants();
        termes_importants();
        System.out.println(nom);
        System.out.println("");
        System.out.println("Autors més rellevants d'aquesta conferencia:");
        for (int i = 0; i < autors.size(); ++i) {
            String aux = autors.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Articles més rellevants d'aquesta confrencia:");
        for (int i = 0; i < articles.size(); ++i) {
            String aux = articles.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Termes més rellevants d'aquesta conferencia:");
        for (int i = 0; i < termes.size(); ++i) {
            String aux = termes.get(i);
            System.out.println(aux);
        }
    }
    
}

