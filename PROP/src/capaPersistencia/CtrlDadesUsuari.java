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
    
    public static Boolean modificar_usuari(String username,String password, String nou_user) {
        return DadesUsuari.modificar_username(username,password,nou_user);
    }
    
    public static Boolean modificar_password(String username, String password, String new_password) {
        return DadesUsuari.modificar_password(username, password, new_password);
    }
    

    public int ExisteixUsuari_contrasenya(String username, String password) {
        return DadesUsuari.ExisteixUsuari_contrasenya(username,password);
    }
    
    public static Boolean ExisteixUsuari(String username) {
        return DadesUsuari.ExisteixUsuari(username);
    }
    public static void GuardarUsuari(String username, String password) {
        DadesUsuari.GuardarUsuari(username, password);
    }
    
    public Boolean borrarUsuari(String username, String password) {
        return DadesUsuari.borrarUsuari(username, password);
    }
    public void borrarUsuariAdmin(String username) {
        DadesUsuari.borrarUsuariAdmin(username);
    }
    
    public String consultaUsuarisBD() {

        return DadesUsuari.consultaUsuarisBD();
    }
    
    public static String consultar_password(String username) {
        return DadesUsuari.consultar_password(username);
    } 
}
