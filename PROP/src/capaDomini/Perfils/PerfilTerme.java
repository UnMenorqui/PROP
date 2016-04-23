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
public class PerfilTerme extends Perfil {
    
    static ArrayList<String> autors = new ArrayList<>();
    static ArrayList<String> conferencies = new ArrayList<>();
    static ArrayList<String> articles = new ArrayList<>();
    static int quantitat_autors;
    static int quantitat_conf;
    static int quantitat_articles;
    
    
    public static int get_quantitat_articles() {
        return quantitat_articles;
    }
    
    public static void set_quantitat_articles(int q_articles) {
        quantitat_articles = q_articles;
    }
    
    public static int get_quantitat_conf() {
        return quantitat_conf;
    }
    public static void set_quantitat_conf(int q_conferencia) {
        quantitat_conf = q_conferencia;
    }
    
    public static int get_quantitat_autors() {
        return quantitat_autors;
    }
    public static void set_quantitat_autors(int q_autor) {
        quantitat_autors = q_autor;
    }
    
    public static void crear_perfil_terme(Graf_PageRank G) {
        Consulta cs = new Consulta();
        //cs.obtenir_articles(articles,nom,quantitat_articles,G);
        //cs.obtenir_conferencies(conferencies,nom,quantitat_conf,G);
        cs.obtenir_autors(autors,nom,quantitat_autors,G);
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
