package capaDomini.Usuaris;

import capaDomini.Graf.CtrlGraf;

/**
 *
 * @author toni_
 * 
 * Aquesta classe, està definida per a poder portar a terme les
 * operacions que un administrador faria, tals como modificar usuaris,
 * eliminar-los, i altres operacions de gestionar la base de dades principals
 * i també el GRAF.
 */


public class Administrador extends UsuariNormal {
    
    private String nom = "admin";
    private String pass = "1234";
    CtrlUsuaris ctrl;
    
    public Administrador () {
        ctrl = new CtrlUsuaris();
    }
    
    public void consultaBD() {
        ctrl.consultaUsuarisBD();
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPass() {
        return pass;
    }
    
    public int borra_user(String usuari) {
        return ctrl.borrarUsuariAdmin(usuari);
    }
    
    public int afegir_node(String tipus,String nom, CtrlGraf CG) {
        return ctrl.afegirNode(tipus, nom, CG);
    }
    
    public int eliminar_node(String nomNode, String tipus, CtrlGraf CG) {
        return ctrl.eliminarNode(nomNode, tipus, CG);
    }
    
    public int afegir_aresta(String nom1, String nom2, String tipus, CtrlGraf CG) {
        return ctrl.afegirAresta(nom1, nom2, tipus, CG);
    }
    
    public int eliminar_aresta(String nom1, String nom2, String tipus, CtrlGraf CG) {
        return ctrl.eliminarAresta(nom1, nom2, tipus, CG);
    }
}