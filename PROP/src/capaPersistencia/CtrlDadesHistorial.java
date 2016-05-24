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
    public static void saveHistorial(ArrayList<Integer> id, ArrayList<String> noms, ArrayList<String> tipus) {
        DadesHistorial.saveHistorial(id,noms,tipus);
    }
    
    public static void getHistorial(ArrayList<Integer> id, ArrayList<String> noms, ArrayList<String> tipus) {
        DadesHistorial.getHistorial(id, noms, tipus);
    }
}
