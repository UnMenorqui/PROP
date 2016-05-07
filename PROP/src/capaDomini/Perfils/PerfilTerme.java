
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.consulta.Consulta;
import capaDomini.Graf.Graf_PageRank;
import capaDomini.consulta.CtrlHistorial;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    
    public int get_quantitat_articles() {
        return quantitat_articles;
    }
    
    public void set_quantitat_articles(int q_articles) {
        quantitat_articles = q_articles;
    }
    
    public int get_quantitat_conf() {
        return quantitat_conf;
    }
    public void set_quantitat_conf(int q_conferencia) {
        quantitat_conf = q_conferencia;
    }
    
    public int get_quantitat_autors() {
        return quantitat_autors;
    }
    public void set_quantitat_autors(int q_autor) {
        quantitat_autors = q_autor;
    }
    
    public void crear_perfil_terme(Graf_PageRank G, boolean usuari) {
        Consulta cs = new Consulta();
        cs.obtenir_articles(articles,nom,quantitat_articles,G);
        cs.obtenir_conferencies(conferencies,nom,quantitat_conf,G);
        cs.obtenir_autors(autors,nom,quantitat_autors,G);
        if(articles.size()+conferencies.size()+autors.size() == 0) {
            System.out.println("No s'ha trobat cap terme amb aquest nom.");
        } else {
            System.out.println(nom);
            System.out.println("");
            System.out.println("Conferencies més rellevants d'aquest terme:");
            for (int i = 0; i < conferencies.size(); ++i) {
                String aux = conferencies.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_conf > conferencies.size()) {
                System.out.println("No hi ha tantes conferències per la quantitat desitjada");
            }
            System.out.println("");
            System.out.println("Articles més rellevants d'aquest terme:");
            for (int i = 0; i < articles.size(); ++i) {
                String aux = articles.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_articles > articles.size()) {
                System.out.println("No hi ha tants articles per la quantitat desitjada");
            }
            System.out.println("");
            System.out.println("Autors més rellevants d'aquest terme:");
            for (int i = 0; i < autors.size(); ++i) {
                String aux = autors.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_autors > autors.size()) {
                System.out.println("No hi ha tants autors per la quantitat desitjada");
            }
            if (usuari) {
                System.out.println("Vols Guardar la Consulta?(S/N)");
                Scanner sc = new Scanner(System.in); 
                String sino = sc.next();
                switch(sino) {
                    case "S":
                        CtrlHistorial hist = new CtrlHistorial();
                        hist.afegirCerca(nom,G.GetID(nom),G.getTipusNode(G.GetID(nom)));


                }

            }
            articles.clear();
            conferencies.clear();
            autors.clear();
        }
    }
    
}
