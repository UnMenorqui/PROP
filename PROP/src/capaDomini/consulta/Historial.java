/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author rogia
 */
public class Historial {

    private ArrayList<Apunts> LlistaConsultes;
    
    protected String json;

    public Historial(CtrlHistorial ctrl) {
        LlistaConsultes = new ArrayList<>();
        loadHistorial(ctrl);
    }
    
    public int size() {
        return LlistaConsultes.size();
    }
    
    private static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    public void afegirCerca(int id, String nom, String tipus, CtrlHistorial ctrl) {
        LlistaConsultes.add(new Apunts(id,nom,tipus));
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
        ctrl.getHistorial(json);
        LlistaConsultes = (ArrayList<Apunts>) fromJson(json,
                    new TypeToken<ArrayList<Apunts>>() {}.getType());
        if(LlistaConsultes == null) {
            LlistaConsultes = new ArrayList<>();
            saveHistorial(ctrl);
        }
    }
    
    private void saveHistorial(CtrlHistorial ctrl) {
        Gson gson = new Gson();
        json = gson.toJson(LlistaConsultes);
        ctrl.save(json);
    }
}
