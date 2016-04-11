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
    
    public static Boolean modificar_usuari(UsuariNormal usn, String nou_user) {
        if (ExisteixUsuari_contrasenya(usn)) {
            du.modificar_usuari(usn.consultar_username(),nou_user,usn.consultar_password());
            return true;
        }
        return false;
    }
    
    public static Boolean modificar_password(UsuariNormal usn, String new_password) {
        if (ExisteixUsuari_contrasenya(usn)) {
            du.modificar_password(usn.consultar_username(),usn.consultar_password(),new_password);
            return true;
        }
        return false;
    }

    public static Boolean ExisteixUsuari_contrasenya(UsuariNormal usn) {
        return du.ExisteixUsuari_contrasenya(usn.consultar_username(),usn.consultar_password());
    }
    
    public static Boolean ExisteixUsuari(String username) {
        return du.ExisteixUsuari(username);
    }
    
    public static Boolean borrarlinea(UsuariNormal usn) {
        if (ExisteixUsuari_contrasenya(usn)) {
            du.borrarlinea(usn.consultar_username(), usn.consultar_password());
            return true;
        }
        return false;
    }
    
    public static void GuardarUsuari(UsuariNormal usn) {
        if (!ExisteixUsuari_contrasenya(usn)) {
            du.GuardarUsuari(usn.consultar_username(), usn.consultar_password());
        }
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
