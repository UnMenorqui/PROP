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
    
    public static Boolean modificar_usuari(String username,String nou_user, String password) {
        return du.modificar_usuari(username,nou_user,password);
    }
    
    public static Boolean modificar_password(String username, String password, String new_password) {
        return du.modificar_password(username,password,new_password);
    }

    public static Boolean ExisteixUsuari_contrasenya(UsuariNormal usn) {
        return du.ExisteixUsuari_contrasenya(usn.consultar_username(),usn.consultar_password());
    }
    
    public static Boolean ExisteixUsuari(String username) {
        return du.ExisteixUsuari(username);
    }
    
    public static Boolean borrarlinea(String username, String password) {
        return du.borrarlinea(username, password);
    }
    
    public static void GuardarUsuari(String username, String password) {
        du.GuardarUsuari(username, password);
    }
    
    public static void consultaBD() {
        du.consultaBD();
    }
    
    public static String consultar_password(String username) {
        return du.consultar_password(username);
    }
    
}
