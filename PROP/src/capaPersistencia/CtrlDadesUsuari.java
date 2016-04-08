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
    
    public Boolean modificar_usuari(String username, String password, String new_username) {
        return DadesUsuari.modificar_username(username,password,new_username);
    }
    
    public Boolean modificar_password(String username, String password, String new_password) {
        return DadesUsuari.modificar_password(username,password,new_password);
    }
    
    public Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return DadesUsuari.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean ExisteixUsuari(String username) {
        return DadesUsuari.ExisteixUsuari(username);
    }
    public Boolean borrarlinea(String username, String password) {
        return DadesUsuari.borrarlinea(username, password);
    }
    public void GuardarUsuari(String username, String password) {
        DadesUsuari.GuardarUsuari(username, password);
    }
}
