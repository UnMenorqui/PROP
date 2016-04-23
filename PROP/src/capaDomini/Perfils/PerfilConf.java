/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.consulta.Consulta;
import capaDomini.Graf.Graf_PageRank;
import static capaDomini.Perfils.Perfil.nom;
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
    
    public static void set_quantitat_termes(int q_terme) {
        quantitat_termes = q_terme;
    }
    
    public static int get_quantitat_articles() {
        return quantitat_articles;
    }
    public static void set_quantitat_articles(int q_articles) {
        quantitat_articles = q_articles;
    }
    
    public static int get_quantitat_autors() {
        return quantitat_autors;
    }
    public static void set_quantitat_autors(int q_autor) {
        quantitat_autors = q_autor;
    }
    
    
    public static void crear_perfil_conf(Graf_PageRank G) {
        Consulta cs = new Consulta();
        //cs.obtenir_articles(articles,nom,quantitat_articles,G);
        cs.obtenir_autors(autors,nom,quantitat_autors,G);
        //cs.obtenir_termes(termes,nom,quantitat_termes,G);
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
        termes.clear();
        articles.clear();
        autors.clear();
        
    }
    
}

