/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.Graf.CtrlGraf;
import capaDomini.consulta.Consulta;
import capaDomini.consulta.CtrlHistorial;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Scanner;

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
    
    
    public ArrayList<String> get_termes() {
        return termes;
    }
    public ArrayList<String> get_conferencies() {
        return conferencies;
    }
    public ArrayList<String> get_articles() {
        return articles;
    }
    public ArrayList<String> get_co_autors() {
        return co_autors;
    }
    
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
    public void set_quantitat_autors(int q_coautors) {
        quantitat_coautors = q_coautors;
    }
    
    public String crear_perfil_autor(CtrlGraf G, boolean usuari) {
        Consulta cs = new Consulta();
        cs.obtenir_articles(articles,nom,"Autor",quantitat_articles,G);
        cs.obtenir_termes(termes,articles,nom,"Autor",quantitat_termes,G);
        cs.obtenir_autors(co_autors,articles,nom,"Autor",quantitat_coautors,G);
        String json = null;
        if(articles.size()+termes.size()+conferencies.size()+co_autors.size() == 0) {
            json = "No s'ha trobat cap autor amb aquest nom.";
            System.out.println("No s'ha trobat cap autor amb aquest nom.");
        } 
        else {
            System.out.println(nom);
            System.out.println("");
            System.out.println("Conferencies més rellevants d'aquest autor:");
            for (int i = 0; i < conferencies.size(); ++i) {
                String aux = conferencies.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_conf > conferencies.size()) {
                System.out.println("No hi ha tantes conferencies per la quantitat desitjada");
            }
            System.out.println("");
            System.out.println("Articles més rellevants d'aquest autor:");
            for (int i = 0; i < articles.size(); ++i) {
                String aux = articles.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_articles > articles.size()) {
                System.out.println("No hi ha tants articles per la quantitat desitjada");
            }
            System.out.println("");
            System.out.println("Termes més rellevants d'aquest autor:");
            for (int i = 0; i < termes.size(); ++i) {
                String aux = termes.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_termes > termes.size()) {
                System.out.println("No hi ha tants termes per la quantitat desitjada");
            }
            System.out.println("");
            System.out.println("Co-Autors més rellevants d'aquest autor:");
            for (int i = 0; i < co_autors.size(); ++i) {
                String aux = co_autors.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_coautors > co_autors.size()) {
                System.out.println("No hi ha tants co-autors per la quantitat desitjada");
            }
            if (usuari) {/*
                System.out.println("Vols Guardar la Consulta?(S/N)");
                Scanner sc = new Scanner(System.in); 
                String sino = sc.next();
                switch(sino) {
                    case "S":
                        CtrlHistorial hist = new CtrlHistorial();
                        hist.afegirCerca(nom,G.GetIDnode(G.getidArrayString(nom, "Autor"),"Autor"),"Autor");


                }*/

            }
            ArrayList<ArrayList<String>> ret = new ArrayList<>(4);
            ret.add(articles);
            ret.add(conferencies);
            ret.add(termes);
            ret.add(co_autors);
            Gson gson = new Gson();
            json = gson.toJson(ret);
            articles.clear();
            conferencies.clear();
            termes.clear();
            co_autors.clear();
            
        }
        return json;
    }
    
}
