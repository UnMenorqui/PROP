/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;


import capaDomini.Graf.CtrlGraf;
import capaDomini.Graf.Node;
import capaDomini.Perfils.PerfilArticle;
import capaDomini.Perfils.PerfilAutor;
import capaDomini.Perfils.PerfilConf;
import capaDomini.Perfils.PerfilTerme;
import capaPersistencia.CtrlDadesHistorial;
import capaDomini.Usuaris.CtrlUsuaris;
import capaDomini.consulta.DriverHistorial;

/**
 *
 * @author Toni
 */
public class CtrlPresentacio {
    
    private CtrlGraf cg;
    
    // FUNCIONS CTRL DADES HISTORIAL
    public static void saveHistorial(String json) {
        CtrlDadesHistorial.saveHistorial(json);
    }
    
    public static void getHistorial(String json) {
        CtrlDadesHistorial.getHistorial(json);
    }
    
    //FUNCIONS CTRL USUARIS
    
    CtrlUsuaris cu = new CtrlUsuaris();
    
    
    public String consultar_username() {
        return cu.consultar_username();
    }
    
    public int modificar_usuari(String username, String password, String nou_user) {
        if (ExisteixUsuari(nou_user)) return 3;
        int id = ExisteixUsuari_contrasenya(username,password);
        if (id == 2) {
            cu.modificar_usuari(username, password, nou_user);
            return 2;
        }
        return id;
    }
    
    public int modificar_password(String username, String password, String new_password) {
        int id = ExisteixUsuari_contrasenya(username, password);
        if (id == 2) {
            cu.modificar_password(username, password, new_password);
            return 2;
        }
        return id;
    }

    public int ExisteixUsuari_contrasenya(String username, String password) {
        return cu.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean ExisteixUsuari(String username) {
        return cu.ExisteixUsuari(username);
    }
    
    public int borrarUsuari(String username, String password) {
        int id = ExisteixUsuari_contrasenya(username, password);
        if (id == 2) {
            cu.borrarUsuari(username, password);
            return 2;
        }
        return id;
    }
    
    public int borrarUsuariAdmin(String username) {
        if (ExisteixUsuari(username)) {
            cu.borrarUsuariAdmin(username);
            return 1;
        }
        return 0;
    }
    
    public int GuardarUsuari(String username, String password) {
        int id = ExisteixUsuari_contrasenya(username, password);
        if (id == 0) {
            cu.GuardarUsuari(username, password);
            return 0;
        }
        return id;
    }
    
    public void consultaUsuarisBD() {
        cu.consultaUsuarisBD();
    }
    
    public String consultar_password(String username) {
            return cu.consultar_password(username);
    }
    
    public void consultar(CtrlGraf G) {
        DriverHistorial dr = new DriverHistorial();
        dr.main(G);
    }

    public void esborrar(int n) {
        cu.esborrar(n);
    }
    
    public void afegirNode(String tipus,String nom, CtrlGraf CG) {
        CG.afegirNode(tipus, nom);
    }
    
    
    public void eliminarNode(String nomNode, String tipus, CtrlGraf CG) {
        CG.eliminarNode(nomNode,tipus);
    }
    
    public void eliminarAresta(String nom1, String nom2, String tipus, CtrlGraf CG) {
        CG.eliminarAresta(nom1, nom2, tipus);
    }
    
    public void afegirAresta(String nom1, String nom2, String tipus, CtrlGraf CG) {
        CG.afegirAresta(nom1, nom2, tipus);
    }
    
    
    // FUNCIONS CTRL GRAF
    public CtrlGraf creaGraf() {
        cg = new CtrlGraf();
        return cg;
    }
    public int getidArrayString(String nom,String tipus) {
        return cg.getidArrayString(nom, tipus);
    }
    
    public Node getNodeIessim(int id, String tipus) {
        return cg.getNodeIessim(id, tipus);
    }
    
    public int getidArrayint(int id, String tipus) {
        return cg.getidArrayint(id, tipus);
    }
    
    public String getNomNode(int id, String tipus) {
        return cg.getNomNode(id, tipus);
    }
    
    public double getValorNode(int id, String tipus) {
        return cg.getValorNode(id, tipus);
    }
    
    public int GetIDnode(int id, String tipus) {
        return cg.GetIDnode(id, tipus);
    }
    
    public boolean existeixnode(String nom, String tipus) {
        return cg.existeixnode(nom, tipus);
    }
    
    public void afegirNode(String tipus,String nom) {
        cg.afegirNode(tipus, nom);
    }
    
    public void eliminarNode(String nomNode, String tipus) {
        cg.eliminarNode(nomNode, tipus);
    }
    
    public void eliminarAresta(String nom1, String nom2, String tipus) {
        cg.eliminarAresta(nom1, nom2, tipus);
    }
    
    public void afegirAresta(String nom1, String nom2, String tipus) {
        cg.afegirAresta(nom1, nom2, tipus);
    }
    
    
    
    // FUNCIONS CTRL PERFILS
    PerfilAutor p_autor = new PerfilAutor();
    public void crear_perfil_autor(String entitat, int articles, int co_autors, int termes, int conferencies, CtrlGraf G,boolean usuaris)
    {
        p_autor.set_name(entitat);
        p_autor.set_quantitat_articles(articles);
        p_autor.set_quantitat_autors(co_autors);
        p_autor.set_quantitat_termes(termes);
        p_autor.set_quantitat_conf(conferencies);
        p_autor.crear_perfil_autor(G,usuaris);
    }
    
    PerfilTerme p_terme = new PerfilTerme();
    public void crear_perfil_terme(String entitat, int articles, int autors, int conferencies, CtrlGraf G, boolean usuaris) 
    {
        p_terme.set_name(entitat);
        p_terme.set_quantitat_articles(articles);
        p_terme.set_quantitat_autors(autors);
        p_terme.set_quantitat_conf(conferencies);
        p_terme.crear_perfil_terme(G,usuaris);
    }
    
    PerfilConf p_conf = new PerfilConf();
    public void crear_perfil_conferencia(String entitat, int articles, int autors, int termes, CtrlGraf G, boolean usuaris) 
    {
        p_conf.set_name(entitat);
        p_conf.set_quantitat_articles(articles);
        p_conf.set_quantitat_autors(autors);
        p_conf.set_quantitat_termes(termes);
        p_conf.crear_perfil_conf(G,usuaris);
        
    }
    
    PerfilArticle p_art = new PerfilArticle();
    public void crear_perfil_article(String entitat, int autors, int termes, int conferencies, CtrlGraf G, boolean usuaris) 
    {
        p_art.set_name(entitat);
        p_art.set_quantitat_autors(autors);
        p_art.set_quantitat_conf(conferencies);
        p_art.set_quantitat_termes(termes);
        p_art.crear_perfil_article(G,usuaris);
    }
    
    

    
    // FUNCIONS CTRL CONSULTA
    
}