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
    
    public static Boolean modificar_usuari(UsuariNormal usn, String new_username) {
        String password = usn.consultar_password();
        if (!ExisteixUsuari(new_username)) {
            return du.modificar_usuari(new_username,password);
        }
        return false;    
    }
    
    public static Boolean modificar_password(UsuariNormal usn, String new_password) {
        if (ExisteixUsuari_contrasenya(usn)) {
            String username = usn.consultar_username();
            String password = usn.consultar_password();
            if (du.modificar_password(username,password,new_password)) return true;
        }
        return false;
    }
    
    public static Boolean ExisteixUsuari_contrasenya(UsuariNormal usn) {
        String username = usn.consultar_username();
        String password = usn.consultar_password();
        return du.ExisteixUsuari_contrasenya(username, password);
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
    
}
