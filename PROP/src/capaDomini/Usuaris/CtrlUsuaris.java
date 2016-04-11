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
    
    public static Boolean modificar_usuari(String username, String password, String nou_user) {
        if (ExisteixUsuari_contrasenya(username,password)) {
            du.modificar_usuari(username,nou_user,password);
            return true;
        }
        return false;
    }
    
    public static Boolean modificar_password(String username, String password, String new_password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            du.modificar_password(username, password, new_password);
            return true;
        }
        return false;
    }

    public static Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return du.ExisteixUsuari_contrasenya(username,password);
    }
    
    public static Boolean ExisteixUsuari(String username) {
        return du.ExisteixUsuari(username);
    }
    
    public static Boolean borrarlinea(String username, String password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            du.borrarlinea(username, password);
            return true;
        }
        return false;
    }
    
    public static boolean GuardarUsuari(String username, String password) {
        if (!ExisteixUsuari_contrasenya(username, password)) {
            du.GuardarUsuari(username, password);
            return true;
        }
        return false;
    }
    
    public static void consultaBD() {
        du.consultaBD();
    }
    
    public static String consultar_password(String username) {
        if (ExisteixUsuari(username)) {
            return du.consultar_password(username);
        }
        return "";
    }
}
