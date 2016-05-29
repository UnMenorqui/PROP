/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import capaPersistencia.CtrlDadesHistorial;
import java.util.ArrayList;

/**
 *
 * @author Toni
 */
public class CtrlHistorial {
    private final Historial hist;    

    public CtrlHistorial() {
        this.hist = new Historial();
    }
    
    public void afegirCerca(String nom, int id, String tipus, String user) {
        hist.afegirCerca(id, nom, tipus, CtrlHistorial.this, user);
    }
    
    public void save(String json, String user) {
        CtrlDadesHistorial.saveHistorial(json, user);
    }
    
    public String getHistorial(String user) {
        return CtrlDadesHistorial.getHistorial(user);
    }
    
    public int size() {
        return hist.size();
    }
    
    public ArrayList<Apunts> getList(String user) {
        return hist.getList(user, CtrlHistorial.this);
    }

    public void esborrar(int n, String user) {
        hist.esborrar(n,CtrlHistorial.this, user);
    }
}
