/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;


import capaDomini.consulta.Apunts;
import capaPersistencia.CtrlDadesHistorial;
import capaDomini.Usuaris.CtrlUsuaris;
import java.util.ArrayList;

/**
 *
 * @author Toni
 */
public class CtrlPresentacio {
    
    
    // FUNCIONS CTRL DADES HISTORIAL
    public static void saveHistorial(ArrayList<Apunts> LlistaConsultes) {
        CtrlDadesHistorial.saveHistorial(LlistaConsultes);
    }
    public static ArrayList<Apunts> getHistorial() {
        return CtrlDadesHistorial.getHistorial();
    }
    
    //FUNCIONS CTRL USUARIS
    
    CtrlUsuaris cu = new CtrlUsuaris();
    
    public String consultar_username() {
        return cu.consultar_username();
    }
    
    public Boolean modificar_usuari(String username, String password, String nou_user) {
        if (ExisteixUsuari_contrasenya(username,password)) {
            cu.modificar_usuari(username,nou_user,password);
            return true;
        }
        return false;
    }
    
    public Boolean modificar_password(String username, String password, String new_password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            cu.modificar_password(username, password, new_password);
            return true;
        }
        return false;
    }

    public Boolean ExisteixUsuari_contrasenya(String username, String password) {
        return cu.ExisteixUsuari_contrasenya(username,password);
    }
    
    public Boolean ExisteixUsuari(String username) {
        return cu.ExisteixUsuari(username);
    }
    
    public Boolean borrarlinea(String username, String password) {
        if (ExisteixUsuari_contrasenya(username, password)) {
            cu.borrarlinea(username, password);
            return true;
        }
        return false;
    }
    
    public boolean GuardarUsuari(String username, String password) {
        if (!ExisteixUsuari_contrasenya(username, password)) {
            cu.GuardarUsuari(username, password);
            return true;
        }
        return false;
    }
    
    public void consultaUsuarisBD() {
        cu.consultaUsuarisBD();
    }
    
    public String consultar_password(String username) {
            return cu.consultar_password(username);
    }
    
    
    // FUNCIONS CTRL GRAF
    
    
    
    // FUNCIONS CTRL PERFILS

    
    // FUNCIONS CTRL CONSULTA
    
    
    
    
    
}