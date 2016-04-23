  package capaDomini.Usuaris;

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
    
    private static CtrlDadesUsuari du;
    
    public CtrlUsuaris() {
        du = new CtrlDadesUsuari();
    }
    
    public Boolean modificar_usuari(String username, String password, String nou_user) {
        if (ExisteixUsuari_contrasenya(username,password)) {
            du.modificar_usuari(username,nou_user,password);
            return true;
        }
        return false;
    }
    
    public Boolean modificar_password(String username, String password, String new_password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            du.modificar_password(username, password, new_password);
            return true;
        }
        return false;
    }

    public Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return du.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean ExisteixUsuari(String username) {
        return du.ExisteixUsuari(username);
    }
    
    public Boolean borrarlinea(String username, String password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            du.borrarlinea(username, password);
            return true;
        }
        return false;
    }
    
    public boolean GuardarUsuari(String username, String password) {
        if (!ExisteixUsuari_contrasenya(username, password)) {
            du.GuardarUsuari(username, password);
            return true;
        }
        return false;
    }
    
    public void consultaUsuarisBD() {
        du.consultaUsuarisBD();
    }
    
    public String consultar_password(String username) {
        if (ExisteixUsuari(username)) {
            return du.consultar_password(username);
        }
        return "";
    }
}
