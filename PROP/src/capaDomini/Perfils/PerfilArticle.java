/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;


import capaDomini.Graf.CtrlGraf;
import java.util.ArrayList;
import capaDomini.consulta.Consulta;
import com.google.gson.Gson;

/**
 *
 * @author marc_
 */
public class PerfilArticle extends Perfil {
    
    public ArrayList<String> termes = new ArrayList<>();
    public ArrayList<String> conferencies = new ArrayList<>();
    public ArrayList<String> autors = new ArrayList<>();
    public int quantitat_termes;
    public int quantitat_conf;
    public int quantitat_autors;
    
    public ArrayList<String> get_termes() {
        return termes;
    }
    public ArrayList<String> get_conferencies() {
        return conferencies;
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
    
    public String crear_perfil_article(CtrlGraf G, boolean usuari) {
        Consulta cs = new Consulta();
        ArrayList<String> articles = new ArrayList<>();
        cs.obtenir_autors(autors,articles,nom,"Article",quantitat_autors,G);
        cs.obtenir_termes(termes,articles,nom,"Article",quantitat_termes,G);
        cs.obtenir_conferencies(conferencies,articles,nom,"Article",quantitat_conf,G);
        String json;
        if(termes.size()+conferencies.size()+autors.size() == 0) {
            json = "-1";
        } else {
            for (int i = 0; i < conferencies.size(); ++i) {
                String aux = conferencies.get(i);
            }
            if (quantitat_conf > conferencies.size()) {
            }
            for (int i = 0; i < autors.size(); ++i) {
                String aux = autors.get(i);
            }
            if (quantitat_autors > autors.size()) {
            }
            for (int i = 0; i < termes.size(); ++i) {
                String aux = termes.get(i);
            }
            if (quantitat_termes > termes.size()) {
            }
            if (usuari) {
                /*System.out.println("Vols Guardar la Consulta?(S/N)");
                Scanner sc = new Scanner(System.in);
                String sino = sc.next();
                switch(sino) {
                    case "S":
                        CtrlHistorial hist = new CtrlHistorial();
                        hist.afegirCerca(nom,G.GetIDnode(G.getidArrayString(nom, "Article"),"Article"),"Article");


                }*/

            }
            ArrayList<ArrayList<String>> ret = new ArrayList<>(4);
            ret.add(conferencies);
            ret.add(autors);
            ret.add(termes);
            Gson gson = new Gson();
            json = gson.toJson(ret);
            termes.clear();
            conferencies.clear();
            autors.clear();
            
        }
        return json;
    }
    
}
