/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.Graf.Graf_PageRank;
import java.util.List;
import java.util.ArrayList;
import capaDomini.consulta.Consulta;

/**
 *
 * @author marc_
 */
public class PerfilArticle extends Perfil {
    
    public static ArrayList<String> termes = new ArrayList<>();
    public static ArrayList<String> conferencies = new ArrayList<>();
    public static ArrayList<String> autors = new ArrayList<>();
    public static int quantitat_termes;
    public static int quantitat_conf;
    public static int quantitat_autors;
    
    
    public static int get_quantitat_termes() {
        return quantitat_termes;
    }
    
    public static void set_quantitat_termes(int q_terme) {
        quantitat_termes = q_terme;
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
    
    public static void crear_perfil_article(Graf_PageRank G) {
        Consulta cs = new Consulta();
        cs.obtenir_autors(autors,nom,quantitat_autors,G);
        //cs.obtenir_termes(termes,nom,quantitat_termes,G);
        //cs.obtenir_conferencies(conferencies,nom,quantitat_conf,G);
        System.out.println(nom);
        System.out.println();
        System.out.println("Conferencies més rellevants d'aquest article:");
        for (int i = 0; i < conferencies.size(); ++i) {
            String aux = conferencies.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Autors més rellevants d'aquest article:");
        for (int i = 0; i < autors.size(); ++i) {
            String aux = autors.get(i);
            System.out.println(aux);
        }
        System.out.println("");
        System.out.println("Termes més rellevants d'aquest article:");
        for (int i = 0; i < termes.size(); ++i) {
            String aux = termes.get(i);
            System.out.println(aux);
        }
    }
    
}
