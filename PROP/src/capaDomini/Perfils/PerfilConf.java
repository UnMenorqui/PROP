/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.consulta.Consulta;
import capaDomini.Graf.CtrlGraf;
import java.util.ArrayList;
import com.google.gson.Gson;

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
    
    
    public ArrayList<String> get_termes() {
        return termes;
    }
    public ArrayList<String> get_articles() {
        return articles;
    }
    public ArrayList<String> get_autors() {
        return autors;
    }
    
    public int get_quantitat_termes() {
        return quantitat_termes;
    }
    
    public void set_quantitat_termes(int q_terme) {
        quantitat_termes = q_terme;
    }
    
    public int get_quantitat_articles() {
        return quantitat_articles;
    }
    public void set_quantitat_articles(int q_articles) {
        quantitat_articles = q_articles;
    }
    
    public int get_quantitat_autors() {
        return quantitat_autors;
    }
    public void set_quantitat_autors(int q_autor) {
        quantitat_autors = q_autor;
    }
    
    
    public String crear_perfil_conf(CtrlGraf G, boolean usuaris) {
        Consulta cs = new Consulta();
        cs.obtenir_articles(articles,nom,"Conferencia",quantitat_articles,G);
        cs.obtenir_autors(autors,articles,nom,"Conferencia",quantitat_autors,G);
        cs.obtenir_termes(termes,articles,nom,"Conferencia",quantitat_termes,G);
        String json;
        if(articles.size()+termes.size()+autors.size() == 0) {
            json = ("No s'ha trobat cap conferència amb aquest nom.");
        } else {
            for (int i = 0; i < autors.size(); ++i) {
                String aux = autors.get(i);
                System.out.println("\t- "+aux);
            }
            if (quantitat_autors > autors.size()) {
                //System.out.println("No hi ha tants autors per la quantitat desitjada");
            }
            for (int i = 0; i < articles.size(); ++i) {
                String aux = articles.get(i);
            }
            if (quantitat_articles > articles.size()) {
                //System.out.println("No hi ha tants articles per la quantitat desitjada");
            }
            for (int i = 0; i < termes.size(); ++i) {
                String aux = termes.get(i);
            }
            if (quantitat_termes > termes.size()) {
                //System.out.println("No hi ha tants termes per la quantitat desitjada");
            }
            if (usuaris) {/*
                System.out.println("Vols Guardar la Consulta?(S/N)");
                Scanner sc = new Scanner(System.in); 
                String sino = sc.next();
                switch(sino) {
                    case "S":
                        CtrlHistorial hist = new CtrlHistorial();
                        hist.afegirCerca(nom,G.GetIDnode(G.getidArrayString(nom,"Conferencia"),"Conferencia"),"Conferencia");
                }*/

            }
            ArrayList<ArrayList<String>> ret = new ArrayList<>(4);
            ret.add(articles);
            ret.add(autors);
            ret.add(termes);
            
            Gson gson = new Gson();
            json = gson.toJson(ret);
            termes.clear();
            autors.clear();
            articles.clear();
            
        }
        return json;
    }
    
}

