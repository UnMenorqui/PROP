/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Graf.CtrlGraf;
import capaDomini.Graf.Graf_PageRank;
import capaDomini.Perfils.CtrlPerfils;
import capaDomini.consulta.Apunts;
import capaPersistencia.CtrlDadesHistorial;
import capaDomini.Usuaris.CtrlUsuaris;
import java.util.ArrayList;

/**
 *
 * @author Toni
 */
public class CtrlPresentacio {
    
    
    // FUNCIONS CTRL DADES HISTORIAL
    public static void saveHistorial(ArrayList<Apunts> LlistaConsultes) {
        CtrlDadesHistorial.saveHistorial(LlistaConsultes);
    }
    public static ArrayList<Apunts> getHistorial() {
        return CtrlDadesHistorial.getHistorial();
    }
    
    //FUNCIONS CTRL USUARIS
    
    CtrlUsuaris cu = new CtrlUsuaris();
    
    public String consultar_username() {
        return cu.consultar_username();
    }
    
    public Boolean modificar_usuari(String username, String password, String nou_user) {
        if (ExisteixUsuari_contrasenya(username,password)) {
            cu.modificar_usuari(username,nou_user,password);
            return true;
        }
        return false;
    }
    
    public Boolean modificar_password(String username, String password, String new_password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            cu.modificar_password(username, password, new_password);
            return true;
        }
        return false;
    }

    public Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return cu.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean ExisteixUsuari(String username) {
        return cu.ExisteixUsuari(username);
    }
    
    public Boolean borrarlinea(String username, String password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            cu.borrarlinea(username, password);
            return true;
        }
        return false;
    }
    
    public boolean GuardarUsuari(String username, String password) {
        if (!ExisteixUsuari_contrasenya(username, password)) {
            cu.GuardarUsuari(username, password);
            return true;
        }
        return false;
    }
    
    public void consultaUsuarisBD() {
        cu.consultaUsuarisBD();
    }
    
    public String consultar_password(String username) {
            return cu.consultar_password(username);
    }
    
    
    // FUNCIONS CTRL GRAF
    
    CtrlGraf cg = new CtrlGraf();
    
    public int getID(String nom) {
        return cg.getID(nom);
    }
    
    public String getNom(int id) {
        return cg.getNom(id);
    }
    
    public int[][] getMadj() {
        return cg.getMadj();
    }
    
    public int size() {
        return cg.size();
    }
    
    public String getTipusNode(int id) {
        return cg.getTipusNode(id);
    }
    
    public void afegirNode(String tipus,String nom) {
        cg.afegirNode(tipus, nom);
    }
    
    
    public void eliminarNode(String nomNode) {
        cg.eliminarNode(nomNode);
    }
    
    public void eliminarAresta(String nom1, String nom2) {
        cg.eliminarAresta(nom1, nom2);
    }
    
    public void afegirAresta(String nom1, String nom2) {
        cg.afegirAresta(nom1, nom2);
    }
    
    // FUNCIONS CTRL PERFILS
    
    CtrlPerfils cp = new CtrlPerfils();
    
    public void crear_perfil_autor(String entitat, int articles, int co_autors, int termes, int conferencies, Graf_PageRank G,boolean usuaris)
    {
        cp.crear_perfil_autor(entitat, articles, co_autors, termes, conferencies, G, usuaris);
    }
    
    
    public void crear_perfil_terme(String entitat, int articles, int autors, int conferencies, Graf_PageRank G, boolean usuaris) 
    {
        cp.crear_perfil_terme(entitat, articles, autors, conferencies, G, usuaris);
    }
    
    
    public void crear_perfil_conferencia(String entitat, int articles, int autors, int termes, Graf_PageRank G, boolean usuaris) 
    {
        cp.crear_perfil_conferencia(entitat, articles, autors, termes, G, usuaris);
    }
    
    
    public void crear_perfil_article(String entitat, int autors, int termes, int conferencies, Graf_PageRank G, boolean usuaris) 
    {
        cp.crear_perfil_article(entitat, autors, termes, conferencies, G, usuaris);
    }
    
    // FUNCIONS CTRL CONSULTA
    
    
    
    
    
}