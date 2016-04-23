/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.Graf.Graf_PageRank;
import capaDomini.consulta.Consulta;
import java.util.ArrayList;

/**
 *
 * @author marc_
 */
public class PerfilAutor extends Perfil {
    
    static ArrayList<String> termes = new ArrayList<>();
    static ArrayList<String> conferencies = new ArrayList<>();
    static ArrayList<String> articles = new ArrayList<>();
    static ArrayList<String> co_autors = new ArrayList<>();
    static int quantitat_termes;
    static int quantitat_conf;
    static int quantitat_articles;
    static int quantitat_coautors;
    
    
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
    public void set_quatitat_autors(int q_coautors) {
        quantitat_coautors = q_coautors;
    }
    
    public void crear_perfil_autor(Graf_PageRank G) {
        Consulta cs = new Consulta();
        //cs.obtenir_articles(articles,nom,quantitat_articles,G);
        //cs.obtenir_termes(termes,nom,quantitat_termes,G);
        //cs.obtenir_conferencies(conferencies,nom,quantitat_conf,G);
        cs.obtenir_autors(co_autors,nom,quantitat_coautors,G);
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
        System.out.println("");
        System.out.println("Co-Autors més rellevants d'aquest autor:");
        for (int i = 0; i < co_autors.size(); ++i) {
            String aux = co_autors.get(i);
            System.out.println(aux);
        }
        termes.clear();
        conferencies.clear();
        articles.clear();
        co_autors.clear();
    }
    
}
