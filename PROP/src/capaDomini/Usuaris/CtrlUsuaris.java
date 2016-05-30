  package capaDomini.Usuaris;

import capaDomini.Graf.CtrlGraf;
import capaDomini.consulta.CtrlHistorial;
import capaPersistencia.CtrlDadesUsuari;


/**
 * @author toni_
 * 
 * Aquesta classe està dedicada exlcusivament per a conectar les
 * classes d'usuaris de la capa domini amb el controlador de la base de dades de
 * la capa persistència. Les operacions bàsiques seràn consultar un usuari a la BD
 * a partir del seu user_name o a partir d'un objecte usuari, modificar un usuari, elminar-lo o
 * insertar-n'hi un de nou.
 */

public class CtrlUsuaris {
    
    private final CtrlDadesUsuari du;
    private CtrlHistorial hist;

    
    public CtrlUsuaris() {
        du = new CtrlDadesUsuari();
    }
    
    public String consultar_username(UsuariNormal un) {
        return un.consultar_username();
    }
    
    public int modificar_usuari(String username, String password, String nou_user) {
        if (ExisteixUsuari(nou_user)) return 3;
        int id = ExisteixUsuari_contrasenya(username,password);
        if (id == 2) {
            CtrlDadesUsuari.modificar_usuari(username, password, nou_user);
            return 2;
        }
        return id;
    }
    
    public int modificar_password(String username, String password, String new_password) {
        int id = ExisteixUsuari_contrasenya(username,password);
        if (id == 2) {
            CtrlDadesUsuari.modificar_password(username, password, new_password);
            return 2;
        }
        return id;
    }

    public int ExisteixUsuari_contrasenya(String username, String password) {
        return du.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean ExisteixUsuari(String username) {
        return CtrlDadesUsuari.ExisteixUsuari(username);
    }
    
    public int borrarUsuari(String username, String password) {
        int id = ExisteixUsuari_contrasenya(username, password);
        if (id == 2) du.borrarUsuari(username, password);
        return id;
    }
    
    public int borrarUsuariAdmin(String username) {
        if (ExisteixUsuari(username)) {
            du.borrarUsuariAdmin(username);
            return 1;
        }
        return 0;
    }
    
    public int GuardarUsuari(String username, String password) {
        int id = ExisteixUsuari_contrasenya(username, password);
        if (id == 0) {
            CtrlDadesUsuari.GuardarUsuari(username, password);
            return 0;
        }
        return id;
    }
    
    public String consultaUsuarisBD() {
        return du.consultaUsuarisBD();
    }
    
    public String consultar_password(String username) {
            return CtrlDadesUsuari.consultar_password(username);
    }
    
    
    /*public void consultar(CtrlGraf G) {
        DriverHistorial dr = new DriverHistorial();
        dr.main(G);
    }*/

    public void esborrar(int n, String user) {
        hist.esborrar(n, user);
    }
    
    public int afegirNode(String nom,String tipus, CtrlGraf CG) {
        return CG.afegirNode(nom, tipus);
    }
    
    
    public int eliminarNode(String nomNode, String tipus, CtrlGraf CG) {
        return CG.eliminarNode(nomNode,tipus);
    }
    
    public int eliminarAresta(String nom1, String nom2, String tipus, CtrlGraf CG) {
        return CG.eliminarAresta(nom1, nom2, tipus);
    }
    
    public int afegirAresta(String nom1, String nom2, String tipus, CtrlGraf CG) {
        return CG.afegirAresta(nom1, nom2, tipus);
    }
}