/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;

import java.io.BufferedWriter;
import java.io.File;

/**
 *
 * @author Toni
 */
public class DadesUsuari {
    
    public void crea_arxiu() {
        File dir = new File(".");
        String ruta = "/home/mario/archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
              // El fichero ya existe
        } else {
              // El fichero no existe y hay que crearlo
        }
        
        
   
}
