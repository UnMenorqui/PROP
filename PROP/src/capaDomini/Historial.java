/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini;

import java.util.ArrayList;
import Utils.*;
/**
 *
 * @author rogia
 */
public class Historial {
    private ArrayList<Apunts> LlistaConsultes = new ArrayList();
    
    public Historial() {
        loadHistorial();
    }
    
    public void afegirCerca(Apunts cerca) {
        LlistaConsultes.add(cerca);
        saveHistorial();
    }
    
    public ArrayList<Apunts> consultar() {       
        return Utils.cloneArrayList(LlistaConsultes);
    }
    
    public void esborrar(int n) {
        LlistaConsultes.remove(n);
        saveHistorial();
    }
    
    private void loadHistorial() {
        LlistaConsultes = capaPersistencia.CtrlDadesHistorial.getHistorial();
    }
    
    private void saveHistorial() {
        capaPersistencia.CtrlDadesHistorial.saveHistorial(LlistaConsultes);
    }
}
