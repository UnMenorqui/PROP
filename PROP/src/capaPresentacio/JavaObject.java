/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Usuaris.Administrador;
import capaDomini.Usuaris.UsuariConvidat;
import capaDomini.Usuaris.UsuariNormal;
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
    
    private UsuariNormal user;
    

    
    public JavaObject() {
        
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
    
    public int CanviarUsername(String new_username) {
        //return cp.modificar_usuari(username, password, new_username);
        return user.modifica_user(new_username);
    }
    
    public int CanviarPassword(String new_password) {
        //return cp.modificar_password(username, password, new_password);
        return user.modifica_pass(new_password);
    }
    
    public boolean existeixnode(String nom, String tipus) {
        return cp.existeixnode(nom, tipus);
    }
    public String consulta_username() {
        System.out.println("consulta user");
        return user.consultar_username();
    }
    
    public String consulta_password() {
        System.out.println("consulta pass");
        return user.consultar_password();
    }
    
    public boolean login(String username, String password) {
        System.out.println("login 1");
        if (ExisteixUsuari_contrasenya(username,password) == 2) {
            System.out.println("login 2");
            user = new UsuariNormal(username,password);
            return true;
        }
        System.out.println("login 3");
        return false;
    }
    
    public void logout () {
        user = null;
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
                else return "-1";
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
    
    public void historial_set(String nom, String tipus, String user) {
        cp.afegirCerca(nom, 0, tipus, user);
    }
    
    public String historial_get(String user) {
        Gson gson = new Gson();
        ArrayList<Apunts> a = cp.getList(user);
        ArrayList<String> b = new ArrayList<>();
        Iterator<Apunts> i = a.iterator();
        while(i.hasNext()) {
            Apunts apunts = i.next();
            String p = apunts.getNom();
            b.add(p);
        }
        return gson.toJson(b);
    }

    
    public void historial_remove(int n, String user) {
        cp.esborra(n, user);
    }
    
    public boolean afegirNode(String tipus,String nom) {
        int i = CG.afegirNode(nom, tipus);
        if(i == 1) return true;
        return false;
    }
    
    
    public boolean eliminarNode(String nomNode) {
        
        String tip = "";
        if (CG.existeixnode(nomNode,"Conferencia")) tip = "Conferencia";
        else if (CG.existeixnode(nomNode,"Autor")) tip = "Autor";
        else if (CG.existeixnode(nomNode, "Terme")) tip = "Terme";
        else if (CG.existeixnode(nomNode, "Article")) tip = "Article";
        int i = cp.eliminarNode(nomNode,tip);
        if(i == 1) return true;
        return false;
    }
    
    public int eliminarAresta(String nom1, String nom2) {
        String tip = "";
        if (CG.existeixnode(nom2,"Conferencia")) tip = "Conferencia";
        else if (CG.existeixnode(nom2,"Autor")) tip = "Autor";
        else if (CG.existeixnode(nom2, "Terme")) tip = "Terme";
        else if (CG.existeixnode(nom2, "Article")) tip = "Article";
        return cp.eliminarAresta(nom1, nom2, tip);
    }
    
    public int afegirAresta(String nom1, String nom2) {
        String tip = "";
        if (CG.existeixnode(nom2,"Conferencia")) tip = "Conferencia";
        else if (CG.existeixnode(nom2,"Autor")) tip = "Autor";
        else if (CG.existeixnode(nom2, "Terme")) tip = "Terme";
        else if (CG.existeixnode(nom2, "Article")) tip = "Article";
        
        return CG.afegirAresta(nom1, nom2, tip);
    }
    
    public String consultausuarisBD() {
        return cp.consultaUsuarisBD();
    }
    
    public int BorraUsuariAdmin(String nom) {
        return cp.borrarUsuariAdmin(nom);
    }
    
    public boolean actualitzar() {
        CG.actualitzar();
        return true;
    }
}