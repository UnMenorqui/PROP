/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Perfils.CtrlPerfils;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Toni
 */

public class JavaObject {
    
    private final CtrlPresentacio cp = new CtrlPresentacio();
    
    private CtrlGraf CG;
    
    
    private ArrayList<String> termes = new ArrayList<>();
    private ArrayList<String> conferencies = new ArrayList<>();
    private ArrayList<String> autors = new ArrayList<>();
    private ArrayList<String> articles = new ArrayList<>();
    private ArrayList<String> co_autors = new ArrayList<>();
    
    private String nom;
    CtrlPerfils ctrl = new CtrlPerfils();
    
    public JavaObject() {
        
    }
    
    public void print(String message) {
        System.out.println(message);
    }
    
    public Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return cp.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean CreaGraf() {
        CG = cp.creaGraf();
        termes = new ArrayList<>();
        conferencies = new ArrayList<>();
        articles = new ArrayList<>();
        co_autors = new ArrayList<>();
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
                        json = ctrl.crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies, CG, usuaris);
                        return json;

                    case "Conferencia":
                        json = ctrl.crear_perfil_conferencia(nom, q_articles, q_autors, q_termes,CG, usuaris);
                        ret = new ArrayList<> (3);
                        ret.add(articles);
                        ret.add(autors);
                        ret.add(termes);
                        json = gson.toJson(ret);
                        return json;

                    case "Article":
                        json = ctrl.crear_perfil_article(nom, q_autors, q_termes, q_conferencies,CG, usuaris);
                        ret = new ArrayList<> (3);
                        ret.add(autors);
                        ret.add(termes);
                        ret.add(conferencies);
                        json = gson.toJson(ret);
                        return json;

                    case "Terme":
                        json = ctrl.crear_perfil_terme(nom, q_articles, q_autors, q_conferencies,CG, usuaris);
                        ret = new ArrayList<> (3);
                        ret.add(articles);
                        ret.add(autors);
                        ret.add(conferencies);
                        json = gson.toJson(ret);
                        return json;

                    default:
                        return out;
                }
                
            case "Autor":
                        json = ctrl.crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies,CG, usuaris);
                        ret = new ArrayList<> (4);
                        ret.add(co_autors);
                        ret.add(articles);
                        ret.add(conferencies);
                        ret.add(termes);
                        json = gson.toJson(ret);
                        return json;

            case "Conferencia":
                json = ctrl.crear_perfil_conferencia(nom, q_articles, q_autors, q_termes,CG, usuaris);
                ret = new ArrayList<> (3);
                ret.add(articles);
                ret.add(autors);
                ret.add(termes);
                json = gson.toJson(ret);
                return json;

            case "Article":
                json = ctrl.crear_perfil_article(nom, q_autors, q_termes, q_conferencies,CG, usuaris);
                ret = new ArrayList<> (3);
                ret.add(autors);
                ret.add(termes);
                ret.add(conferencies);
                json = gson.toJson(ret);
                return json;

            case "Terme":
                json = ctrl.crear_perfil_terme(nom, q_articles, q_autors, q_conferencies,CG, usuaris);
                ret = new ArrayList<> (3);
                ret.add(articles);
                ret.add(autors);
                ret.add(conferencies);
                json = gson.toJson(ret);
                return json;

            default:
                return out;
        }
    }
}