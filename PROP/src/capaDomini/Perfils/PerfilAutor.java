/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.Consulta;
import capaDomini.Graf.Graf_PageRank;
import java.util.ArrayList;

/**
 *
 * @author marc_
 */
public class PerfilAutor extends Perfil {
    
    static ArrayList<String> termes = new ArrayList<>();
    static ArrayList<String> conferencies = new ArrayList<>();
    static ArrayList<String> articles = new ArrayList<>();
    static int quantitat_termes;
    static int quantitat_conf;
    static int quantitat_articles;
    
    
    public int get_quantitat_termes() {
        return quantitat_termes;
    }
    
    public void set_quantitat_termes(int q_terme) {
        quantitat_termes = q_terme;
    }
    
    public int get_quantitat_conf() {
        return quantitat_conf;
    }
    public void set_quantitat_conf(int q_conferencia) {
        quantitat_conf = q_conferencia;
    }
    
    public int get_quantitat_articles() {
        return quantitat_articles;
    }
    public void set_quantitat_articles(int q_articles) {
        quantitat_articles = q_articles;
    }
    
    public ArrayList<String> articles_importants() {
        // obtenir_articles(articles,nom,quantitat_articles);
        return articles;
    }
    
    public ArrayList<String> conferencies_importants() {
        // obtenir_conferencies(conferencies,nom,quantitat_conf);
        return conferencies;
    }
    
    public ArrayList<String> termes_importants() {
        // obtenir_termes(termes,nom,quantitat_termes);
        return termes;
    }
    
    public void crear_perfil_autor(Graf_PageRank G) {
        Consulta cs = new Consulta();
        //cs.obtenir_articles(articles,nom,quantitat_articles,G);
        //cs.obtenir_termes(termes,nom,quantitat_termes,G);
        //cs.obtenir_conferencies(conferencies,nom,quantitat_conf,G);
        articles_importants();
        conferencies_importants();
        termes_importants();
        System.out.println(nom);
        System.out.println("");
        System.out.println("Conferencies més rellevants d'aquest autor:");
        for (int i = 0; i < conferencies.size(); ++i) {
            String aux = conferencies.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Articles més rellevants d'aquest autor:");
        for (int i = 0; i < articles.size(); ++i) {
            String aux = articles.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Termes més rellevants d'aquest autor:");
        for (int i = 0; i < termes.size(); ++i) {
            String aux = termes.get(i);
            System.out.println(aux);
        }
    }
    
}
