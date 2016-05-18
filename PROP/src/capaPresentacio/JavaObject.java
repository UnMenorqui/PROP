/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Graf.Graf;
import capaDomini.Perfils.CtrlPerfils;
import capaDomini.Perfils.PerfilArticle;
import capaDomini.Perfils.PerfilAutor;
import capaDomini.Perfils.PerfilConf;
import capaDomini.Perfils.PerfilTerme;
import capaDomini.consulta.Consulta;
import capaDomini.consulta.CtrlHistorial;
import com.google.gson.Gson;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.events.ScriptContextEvent;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Toni
 */

public class JavaObject {
    
    private CtrlPresentacio cp = new CtrlPresentacio();
    private CtrlPerfils ctrl = new CtrlPerfils();
    private CtrlGraf CG = new CtrlGraf();
    
    
    private ArrayList<String> termes = new ArrayList<>();
    private ArrayList<String> conferencies = new ArrayList<>();
    private ArrayList<String> autors = new ArrayList<>();
    private ArrayList<String> articles = new ArrayList<>();
    private ArrayList<String> co_autors = new ArrayList<>();
    
    private String nom;
    public void print(String message) {
        System.out.println(message);
    }
    
    public Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return cp.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean CreaGraf() {
        CG = cp.creaGraf();
        return true;
    }
    
    public Boolean Registrarse(String user, String pass1, String pass2) {
        if (pass1.equals(pass2)) {
            if(!cp.ExisteixUsuari(user)) {
                cp.GuardarUsuari(user, pass1);
                return true;
            }
        }
        return false;
    }
    
    public boolean CanviarUsername(String username, String password, String new_username) {
        return cp.modificar_usuari(username, password, new_username);
    }
    
    public boolean CanviarPassword(String username, String password, String new_password) {
        return cp.modificar_password(username, password, new_password);
    }
    
    public boolean existeixnode(String nom, String tipus) {
        return cp.existeixnode(nom, tipus);
    }
    
    public String consulta(String tipus, String nom, int q_autors, int q_termes, int q_conferencies, int q_articles, boolean usuaris) {
        Gson gson = new Gson();
        ArrayList<ArrayList<String>> ret;
        String json;
        String out = "No s'ha trobat";
        switch(tipus) {
            case "General":
                //System.out.println("Introdueix l'entitat que desitjes cercar:");
                tipus = "";
                if (CG.existeixnode(nom,"Conferencia")) tipus = "Conferencia";
                else if (CG.existeixnode(nom,"Autor")) tipus = "Autor";
                else if (CG.existeixnode(nom, "Terme")) tipus = "Terme";
                else if (CG.existeixnode(nom, "Articles")) tipus = "Article";
                switch(tipus) {
                    case "Autor":
                        crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies, usuaris);
                        ret = new ArrayList<ArrayList<String>> (4);
                        ret.add(co_autors);
                        ret.add(articles);
                        ret.add(conferencies);
                        ret.add(termes);
                        json = gson.toJson(ret);
                        return json;

                    case "Conferencia":
                        crear_perfil_conferencia(nom, q_articles, q_autors, q_termes, usuaris);
                        ret = new ArrayList<ArrayList<String>> (3);
                        ret.add(articles);
                        ret.add(autors);
                        ret.add(termes);
                        json = gson.toJson(ret);
                        return json;

                    case "Article":
                        crear_perfil_article(nom, q_autors, q_termes, q_conferencies, usuaris);
                        ret = new ArrayList<ArrayList<String>> (3);
                        ret.add(autors);
                        ret.add(termes);
                        ret.add(conferencies);
                        json = gson.toJson(ret);
                        return json;

                    case "Terme":
                        crear_perfil_terme(nom, q_articles, q_autors, q_conferencies, usuaris);
                        ret = new ArrayList<ArrayList<String>> (3);
                        ret.add(articles);
                        ret.add(autors);
                        ret.add(conferencies);
                        json = gson.toJson(ret);
                        return json;

                    default:
                        return out;
                }
                
            case "Autor":
                        crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies, usuaris);
                        ret = new ArrayList<ArrayList<String>> (4);
                        ret.add(co_autors);
                        ret.add(articles);
                        ret.add(conferencies);
                        ret.add(termes);
                        json = gson.toJson(ret);
                        return json;

            case "Conferencia":
                crear_perfil_conferencia(nom, q_articles, q_autors, q_termes, usuaris);
                ret = new ArrayList<ArrayList<String>> (3);
                ret.add(articles);
                ret.add(autors);
                ret.add(termes);
                json = gson.toJson(ret);
                return json;

            case "Article":
                crear_perfil_article(nom, q_autors, q_termes, q_conferencies, usuaris);
                ret = new ArrayList<ArrayList<String>> (3);
                ret.add(autors);
                ret.add(termes);
                ret.add(conferencies);
                json = gson.toJson(ret);
                return json;

            case "Terme":
                crear_perfil_terme(nom, q_articles, q_autors, q_conferencies, usuaris);
                ret = new ArrayList<ArrayList<String>> (3);
                ret.add(articles);
                ret.add(autors);
                ret.add(conferencies);
                json = gson.toJson(ret);
                return json;

            default:
                return out;
        }
    }
    
    
    public void crear_perfil_autor(String entitat, int articles, int co_autors, int termes, int conferencies, boolean usuaris)
    {
        PerfilAutor p_autor = new PerfilAutor();
        p_autor.set_name(entitat);
        p_autor.set_quantitat_articles(articles);
        p_autor.set_quantitat_autors(co_autors);
        p_autor.set_quantitat_termes(termes);
        p_autor.set_quantitat_conf(conferencies);
        crear_perfil_autor_v(usuaris, articles, termes, conferencies, co_autors);
    }
    public void crear_perfil_terme(String entitat, int articles, int autors, int conferencies, boolean usuaris) 
    {
        PerfilTerme p_terme = new PerfilTerme();
        p_terme.set_name(entitat);
        p_terme.set_quantitat_articles(articles);
        p_terme.set_quantitat_autors(autors);
        p_terme.set_quantitat_conf(conferencies);
        p_terme.crear_perfil_terme(CG,usuaris);
    }
    public void crear_perfil_conferencia(String entitat, int articles, int autors, int termes, boolean usuaris) 
    {
        PerfilConf p_conf = new PerfilConf();
        p_conf.set_name(entitat);
        p_conf.set_quantitat_articles(articles);
        p_conf.set_quantitat_autors(autors);
        p_conf.set_quantitat_termes(termes);
        crear_perfil_conf_v(usuaris,articles, autors,termes);
        
    }
    public void crear_perfil_article(String entitat, int autors, int termes, int conferencies, boolean usuaris) 
    {
        PerfilArticle p_art = new PerfilArticle();
        p_art.set_name(entitat);
        p_art.set_quantitat_autors(autors);
        p_art.set_quantitat_conf(conferencies);
        p_art.set_quantitat_termes(termes);
        crear_perfil_article_v(usuaris, autors, termes, conferencies);
    }
    
    public void crear_perfil_article_v(boolean usuari, int quantitat_autors, int quantitat_termes, int quantitat_conf) {
        autors = new ArrayList<>();
        conferencies = new ArrayList<>();
        termes = new ArrayList<>();
        Consulta cs = new Consulta();
        cs.obtenir_autors(autors,articles,nom,"Article",quantitat_autors,CG);
        cs.obtenir_termes(termes,articles,nom,"Article",quantitat_termes,CG);
        cs.obtenir_conferencies(conferencies,articles,nom,"Article",quantitat_conf,CG);
    }
    
    public void crear_perfil_autor_v(boolean usuari, int quantitat_articles, int quantitat_termes, int quantitat_conf, int quantitat_coautors) {
        termes = new ArrayList<>();
        conferencies = new ArrayList<>();
        articles = new ArrayList<>();
        co_autors = new ArrayList<>();
        Consulta cs = new Consulta();
        cs.obtenir_articles(articles,nom,"Autor",quantitat_articles,CG);
        cs.obtenir_termes(termes,articles,nom,"Autor",quantitat_termes,CG);
        cs.obtenir_conferencies(conferencies,articles,nom,"Autor",quantitat_conf,CG);
        cs.obtenir_autors(co_autors,articles,nom,"Autor",quantitat_coautors,CG);
    }
    
    public void crear_perfil_conf_v(boolean usuaris, int quantitat_articles, int quantitat_autors, int quantitat_termes) {
        Consulta cs = new Consulta();
        termes = new ArrayList<>();
        autors = new ArrayList<>();
        articles = new ArrayList<>();
        cs.obtenir_articles(articles,nom,"Conferencia",quantitat_articles,CG);
        cs.obtenir_autors(autors,articles,nom,"Conferencia",quantitat_autors,CG);
        cs.obtenir_termes(termes,articles,nom,"Conferencia",quantitat_termes,CG);
    }
    
    public void crear_perfil_terme(boolean usuari, int quantitat_articles, int quantitat_conf, int quantitat_autors) {
        Consulta cs = new Consulta();
        autors = new ArrayList<>();
        conferencies = new ArrayList<>();
        articles = new ArrayList<>();
        cs.obtenir_articles(articles,nom,"Terme",quantitat_articles,CG);
        cs.obtenir_conferencies(conferencies,articles,nom,"Terme",quantitat_conf,CG);
        cs.obtenir_autors(autors,articles,nom,"Terme",quantitat_autors,CG);
    } 
}
