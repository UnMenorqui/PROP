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
        this.hist = new Historial(CtrlHistorial.this);
    }
    
    public void afegirCerca(String nom, int id, String tipus) {
        hist.afegirCerca(id, nom, tipus, CtrlHistorial.this);
    }
    
    public void save(String json) {
        CtrlDadesHistorial.saveHistorial(json);
    }
    
    public void getHistorial(String json) {
        CtrlDadesHistorial.getHistorial(json);
    }
    
    public int size() {
        return hist.size();
    }
    
    public ArrayList<Apunts> getList() {
        return hist.getList();
    }

    public void esborrar(int n) {
        hist.esborrar(n,CtrlHistorial.this);
    }
}
