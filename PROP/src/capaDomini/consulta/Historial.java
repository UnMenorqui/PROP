/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;


import java.util.ArrayList;

/**
 *
 * @author rogia
 */
public class Historial {

    private ArrayList<Apunts> LlistaConsultes = new ArrayList();

    public Historial() {
        loadHistorial();
    }
    
    public int size() {
        return LlistaConsultes.size();
    }

    public void afegirCerca(Apunts cerca) {
        LlistaConsultes.add(cerca);
        saveHistorial();
    }
    
    public ArrayList<Apunts> getList() {
        return LlistaConsultes;
    }

    public void esborrar(int n) {
        LlistaConsultes.remove(n);
        saveHistorial();
    }
    
    private void loadHistorial() {
        LlistaConsultes = capaPersistencia.CtrlDadesHistorial.getHistorial();
        if(LlistaConsultes == null) {
            LlistaConsultes = new ArrayList<>();
            saveHistorial();
        }
    }
    
    private void saveHistorial() {
        capaPersistencia.CtrlDadesHistorial.saveHistorial(LlistaConsultes);
    }
}
