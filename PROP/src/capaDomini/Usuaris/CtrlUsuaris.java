/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package capaDomini;

import java.io.BufferedWriter;
import java.io.File;

/**
 *
 * @author toni_
 */

public class CtrlUsuaris {
    public String ruta_BD;
    
    protected static void carrega() {
        
    }
    protected static void codifica() {
        
    }
    
    protected boolean crea_arxiu() {
        File f = null;
        String v;
        boolean bool = false;
         // create new file
        f = new File("Usuaris.txt");

        // pathname string from abstract pathname
        v = f.getPath();
        ruta_BD = v;

        // true if the file path exists
        bool = f.exists();

        // if file exists
        if (bool) return true;
        return false;
    }
    
    protected void modifica_arxiu() {
        BufferedWriter bw;
        String ruta = ruta_BD;
        if(ruta.exists()) {
        } else {
         }
    
    
}
