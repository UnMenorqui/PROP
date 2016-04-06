/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Toni
 */
public class DadesUsuari {
    
    private String ruta_BD;
    
    
    public DadesUsuari() {
        
    }
    
    public static void main(String[] args) throws IOException {
        DadesUsuari dades = new DadesUsuari();
        dades.crea_arxiu();
    }
    
    
    public void crea_arxiu() throws IOException {
        File archivo = new File("BD_users.txt");
        ruta_BD = archivo.getCanonicalPath();
        System.out.println(ruta_BD);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
        bw.close();
    }
}
