/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini;

/**
 *
 * @author toni_
 */

public class UsuariNormal extends UsuariConvidat {
    
    private String user_name;
    private String password;
    
    public void guarda_perfil(){
        
    }
    public void consulta_historial() {
        
    }
    public String consulta_username() {
        return user_name;
    }
    public String consulta_password() {
        return password; 
    }
    public void modifica_user(String user) {
        user_name = user;
    }
    public void modifica_pass(String pass) {
        password = pass;
    }
}
