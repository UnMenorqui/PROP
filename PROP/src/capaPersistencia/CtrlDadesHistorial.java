/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;


/**
 *
 * @author rogia
 */
public class CtrlDadesHistorial {
    public static void saveHistorial(String json) {
        DadesHistorial.saveHistorial(json);
    }
    
    public static void getHistorial(String json) {
        DadesHistorial.getHistorial(json);
    }
}
