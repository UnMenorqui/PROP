/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rogia
 */
public class Apunts {
    
    Consulta consulta;
    
    public Apunts(Consulta c) {
        try {
            Consulta n = new Consulta();
            n = (Consulta) c.clone();
            consulta = n;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Apunts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Consulta getConsulta() {
        Consulta n = new Consulta();
        try {
            n = (Consulta) consulta.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Apunts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
