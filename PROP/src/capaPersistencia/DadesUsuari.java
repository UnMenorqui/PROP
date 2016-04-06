/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

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
        String user_name = "aaaaa";
        String password = "bbbbbbbbb";
        GuardarUsuari(user_name,password);
    }
    
    public static Boolean existeix_arxiu() {
        File archivo = new File("BD_users.txt");
        if (archivo.exists()) return true;
        else return false;
    }
    
    public static void GuardarUsuari(String user_name, String password){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("BD_users.txt",true);
            pw = new PrintWriter(fichero);
            pw.println(user_name+"  "+password);
        } catch (Exception e) {
            
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              
           }
        }
    }
    
    public void crea_arxiu() throws IOException {
        File archivo = new File("BD_users.txt");
        ruta_BD = archivo.getCanonicalPath();
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
        }
        bw.close();
    }
}
