/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import capaDomini.Graf.Graf_PageRank;

/**
 *
 * @author Toni
 */
public class CtrlHistorial {
    private Historial hist = new Historial();
    
    public void afegirCerca(Apunts cerca) {
        hist.afegirCerca(cerca);
    }
    
    public void consultar(Graf_PageRank G) {
        hist.consultar(G);
    }

    public void esborrar(int n) {
        hist.esborrar(n);
    }
}
