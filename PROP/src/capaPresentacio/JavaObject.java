/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.events.ScriptContextEvent;

/**
 *
 * @author Toni
 */

public class JavaObject {
    
    private CtrlPresentacio cp = new CtrlPresentacio();
    public void print(String message) {
        System.out.println(message);
    }
    
    public Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return cp.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean CreaGraf() {
        cp.creaGraf();
        return true;
    }
    
    public Boolean Registrarse(String user, String pass1, String pass2) {
        if (pass1.equals(pass2)) {
            if(!cp.ExisteixUsuari(user)) {
                cp.GuardarUsuari(user, pass1);
                return true;
            }
        }
        return false;
    }
}
