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
    private Historial hist = new Historial(CtrlHistorial.this);
    
    public void afegirCerca(String nom, int id, String tipus) {
        Apunts cerca = new Apunts(nom,id,tipus);
        hist.afegirCerca(cerca, CtrlHistorial.this);
    }
    
    public void save(ArrayList<Integer> id, ArrayList<String> noms, ArrayList<String> tipus) {
        CtrlDadesHistorial.saveHistorial(id,noms,tipus);
    }
    
    public void getHistorial(ArrayList<Integer> id, ArrayList<String> noms, ArrayList<String> tipus) {
        CtrlDadesHistorial.getHistorial(id,noms,tipus);
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
