/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import capaDomini.consulta.Apunts;
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

    public Boolean afegirCerca() {
        return true;
    }

    public ArrayList<Apunts> consultar() {
        return Utils.cloneArrayList(LlistaConsultes);
    }

    public void esborrar() {
        LlistaConsultes = new ArrayList();
    }

    private void loadHistorial() {

    }
}
