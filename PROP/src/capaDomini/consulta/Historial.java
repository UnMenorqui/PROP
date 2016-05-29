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

    /*public Historial(CtrlHistorial ctrl) {
        LlistaConsultes = new ArrayList<>();
        loadHistorial(ctrl);
    }*/
    
    public int size() {
        return LlistaConsultes.size();
    }
    
    private static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    public void afegirCerca(int id, String nom, String tipus, CtrlHistorial ctrl, String user) {
        LlistaConsultes.add(new Apunts(id,nom,tipus));
        saveHistorial(ctrl, user);
    }
    
    public ArrayList<Apunts> getList(String user, CtrlHistorial ctrl) {
        loadHistorial(ctrl, user);
        return LlistaConsultes;
    }

    public void esborrar(int n, CtrlHistorial ctrl, String user) {
        if(n >= 0 && n < LlistaConsultes.size()) {
            LlistaConsultes.remove(n);
            saveHistorial(ctrl, user);
        }
    }
    
    private void loadHistorial(CtrlHistorial ctrl, String user) {
        json = ctrl.getHistorial(user);
        LlistaConsultes = (ArrayList<Apunts>) fromJson(json,
                    new TypeToken<ArrayList<Apunts>>() {}.getType());
        if(LlistaConsultes == null) {
            LlistaConsultes = new ArrayList<>();
            saveHistorial(ctrl, user);
        }
    }
    
    private void saveHistorial(CtrlHistorial ctrl, String user) {
        Gson gson = new Gson();
        json = gson.toJson(LlistaConsultes);
        ctrl.save(json, user);
    }
}
