/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;

import capaDomini.consulta.Apunts;
import java.util.ArrayList;

/**
 *
 * @author rogia
 */
public class CtrlDadesHistorial {
    public static void saveHistorial(ArrayList<Apunts> LlistaConsultes) {
        DadesHistorial.saveHistorial(LlistaConsultes);
    }
    
    public static ArrayList<Apunts> getHistorial() {
        return DadesHistorial.getHistorial();
    }
}
