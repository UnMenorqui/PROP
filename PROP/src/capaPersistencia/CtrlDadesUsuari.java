/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;
/**
 * @author aleixabrieprat
 */
public class CtrlDadesUsuari {
    
    public static Boolean modificar_usuari(String username,String nou_user, String password) {
        return DadesUsuari.modificar_username(username,nou_user,password);
    }
    
    public static Boolean modificar_password(String username, String password, String new_password) {
        return DadesUsuari.modificar_password(username, password, new_password);
    }
    
<<<<<<< HEAD
    public static Boolean ExisteixUsuari_contrasenya(String username, String password) {
=======
    public int ExisteixUsuari_contrasenya(String username, String password) {
>>>>>>> Branca-Def
        return DadesUsuari.ExisteixUsuari_contrasenya(username,password);
    }
    
    public static Boolean ExisteixUsuari(String username) {
        return DadesUsuari.ExisteixUsuari(username);
    }
<<<<<<< HEAD
    public static Boolean borrarlinea(String username, String password) {
        return DadesUsuari.borrarlinea(username, password);
    }
    public static void GuardarUsuari(String username, String password) {
        DadesUsuari.GuardarUsuari(username, password);
    }
    public static void consultaUsuarisBD() {
=======
    
    public Boolean borrarUsuari(String username, String password) {
        return DadesUsuari.borrarUsuari(username, password);
    }
    public void borrarUsuariAdmin(String username) {
        DadesUsuari.borrarUsuariAdmin(username);
    }
    
    public void GuardarUsuari(String username, String password) {
        DadesUsuari.GuardarUsuari(username, password);
    }
    
    public void consultaUsuarisBD() {
>>>>>>> Branca-Def
        DadesUsuari.consultaUsuarisBD();
    }
    
    public static String consultar_password(String username) {
        return DadesUsuari.consultar_password(username);
    } 
}
