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
    
    ArrayList<String> noms;
    
    ArrayList<Integer> id;
    
    ArrayList<String> tipus;

    public Historial(CtrlHistorial ctrl) {
        noms = new ArrayList<>();
        tipus = new ArrayList<>();
        id = new ArrayList<>();
        loadHistorial(ctrl);
    }
    
    public int size() {
        return LlistaConsultes.size();
    }

    public void afegirCerca(Apunts cerca, CtrlHistorial ctrl) {
        LlistaConsultes.add(cerca);
        saveHistorial(ctrl);
    }
    
    public ArrayList<Apunts> getList() {
        return LlistaConsultes;
    }

    public void esborrar(int n, CtrlHistorial ctrl) {
        if(n >= 0 && n < LlistaConsultes.size()) {
            LlistaConsultes.remove(n);
            saveHistorial(ctrl);
        }
    }
    
    private void loadHistorial(CtrlHistorial ctrl) {
        ctrl.getHistorial(id,noms,tipus);
        if(LlistaConsultes == null) {
            LlistaConsultes = new ArrayList<>();
            saveHistorial(ctrl);
        }
    }
    
    private void saveHistorial(CtrlHistorial ctrl) {
        for (int i = 0; i < LlistaConsultes.size(); ++i) {
            id.add(LlistaConsultes.get(i).getID());
            noms.add(LlistaConsultes.get(i).getNom());
            tipus.add(LlistaConsultes.get(i).getTipus());
        }
        ctrl.save(id,noms,tipus);
        noms.clear();
        tipus.clear();
        id.clear();
    }
}
