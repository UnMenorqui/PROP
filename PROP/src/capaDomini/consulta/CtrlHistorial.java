/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import java.util.ArrayList;

/**
 *
 * @author Toni
 */
public class CtrlHistorial {
    private Historial hist = new Historial();
    
    public void afegirCerca(String nom, int id, String tipus) {
        Apunts cerca = new Apunts(nom,id,tipus);
        hist.afegirCerca(cerca);
    }
    
    public ArrayList<Apunts> getList() {
        return hist.getList();
    }

    public void esborrar(int n) {
        hist.esborrar(n);
    }
}
