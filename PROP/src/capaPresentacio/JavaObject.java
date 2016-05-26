/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Perfils.CtrlPerfils;
import capaDomini.consulta.Apunts;
import capaDomini.consulta.CtrlHistorial;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;

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
    private CtrlHistorial ch = new CtrlHistorial();
    
    private String nom;

    
    public JavaObject() {
        
    }
    
    public void print(String message) {
        System.out.println(message);
    }
    
    public int ExisteixUsuari_contrasenya(String username, String password) {
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
    
    public int CanviarUsername(String username, String password, String new_username) {
        return cp.modificar_usuari(username, password, new_username);
    }
    
    public int CanviarPassword(String username, String password, String new_password) {
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
                else if (CG.existeixnode(nom, "Article")) tipus = "Article";
                switch(tipus) {
                    case "Autor":
                        json = cp.crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies, CG, usuaris);
                        return json;

                    case "Conferencia":
                        json = cp.crear_perfil_conferencia(nom, q_articles, q_autors, q_termes,CG, usuaris);
                        return json;

                    case "Article":
                        json = cp.crear_perfil_article(nom, q_autors, q_termes, q_conferencies,CG, usuaris);
                        return json;

                    case "Terme":
                        json = cp.crear_perfil_terme(nom, q_articles, q_autors, q_conferencies,CG, usuaris);
                        return json;

                    default:
                        return out;
                }
                
            case "Autor":
                        json = cp.crear_perfil_autor(nom, q_articles, q_autors, q_termes, q_conferencies,CG, usuaris);
                        return json;

            case "Conferencia":
                json = cp.crear_perfil_conferencia(nom, q_articles, q_autors, q_termes,CG, usuaris);
                return json;

            case "Article":
                json = cp.crear_perfil_article(nom, q_autors, q_termes, q_conferencies,CG, usuaris);
                return json;

            case "Terme":
                json = cp.crear_perfil_terme(nom, q_articles, q_autors, q_conferencies,CG, usuaris);
                return json;

            default:
                return out;
        }
    }
    
    public void historial_set(String nom, String tipus) {
        cp.afegirCerca(nom, 0, tipus);
    }
    
    public String historial_get() {
        Gson gson = new Gson();
        ArrayList<Apunts> a = cp.getList();
        ArrayList<String> b = new ArrayList<>();
        Iterator<Apunts> i = a.iterator();
        while(i.hasNext()) {
            Apunts apunts = i.next();
            String p = apunts.getNom();
            b.add(p);
        }
        return gson.toJson(b);
    }

    
    public void historial_remove(int n) {
        cp.esborra(n);
    }
    
    public void afegirNode(String tipus,String nom) {
        cp.afegirNode(tipus, nom);
        System.out.println("tipus: ");System.out.println(tipus);
        System.out.println("nom: ");System.out.println(nom);
        System.out.println("Node afegit correctament!");
    }
    
    
    public void eliminarNode(String nomNode) {
        System.out.println("nomNode: ");System.out.println(nomNode);
        
        String tip = "";
        if (CG.existeixnode(nomNode,"Conferencia")) tip = "Conferencia";
        else if (CG.existeixnode(nomNode,"Autor")) tip = "Autor";
        else if (CG.existeixnode(nomNode, "Terme")) tip = "Terme";
        else if (CG.existeixnode(nomNode, "Article")) tip = "Article";
        cp.eliminarNode(nomNode,tip);
        System.out.println("Node eliminat correctament!");
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        System.out.println("nom1: ");System.out.println(nom1);
        System.out.println("nom2: ");System.out.println(nom2);
        
        String tip = "";
        if (CG.existeixnode(nom2,"Conferencia")) tip = "Conferencia";
        else if (CG.existeixnode(nom2,"Autor")) tip = "Autor";
        else if (CG.existeixnode(nom2, "Terme")) tip = "Terme";
        else if (CG.existeixnode(nom2, "Article")) tip = "Article";
        cp.eliminarAresta(nom1, nom2, tip);
        System.out.println("Aresta afegida correctament!");
    }
    
    public void afegirAresta(String nom1, String nom2) {
        System.out.println("nom1: ");System.out.println(nom1);
        System.out.println("nom2: ");System.out.println(nom2);
        
        String tip = "";
        if (CG.existeixnode(nom2,"Conferencia")) tip = "Conferencia";
        else if (CG.existeixnode(nom2,"Autor")) tip = "Autor";
        else if (CG.existeixnode(nom2, "Terme")) tip = "Terme";
        else if (CG.existeixnode(nom2, "Article")) tip = "Article";
        cp.afegirAresta(nom1, nom2, tip);
        System.out.println("Aresta eliminada correctament!");
    }
    
    public String consultausuarisBD() {
        return cp.consultaUsuarisBD();
    }
    
    public int BorraUsuariAdmin(String nom) {
        return cp.borrarUsuariAdmin(nom);
    }
    
    public boolean actualitzar() {
        cp.actualitzar();
        return true;
    }
}