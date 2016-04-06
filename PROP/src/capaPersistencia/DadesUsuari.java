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
        String user_name = "hola";
        String password = "que tal?";
        GuardarUsuari(user_name,password);
    }
    
    public static Boolean existeix_arxiu() {
        File archivo = new File("BD_users.txt");
        if (archivo.exists()) return true;
        else return false;
    }
    
    public static void GuardarUsuari(String user_name, String password){
       FileOutputStream fos = null;
       ObjectOutputStream salida = null;
       File f = null;
       try{
            f = new File("BD_users.txt");
            //System.out.println(f.getAbsolutePath());
            fos = new FileOutputStream(f.getAbsolutePath());
            salida = new ObjectOutputStream(fos);
            try {
                salida.reset();
                salida.writeObject(user_name+"  "+password);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                System.out.println(e1.getMessage());
            }                      
       }catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       } catch (IOException e) {
           System.out.println(e.getMessage());
       } finally {
           try {
               if(fos!=null) fos.close();
               if(salida!=null) salida.close();
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
       }
    }
    
    public void crea_arxiu() throws IOException {
        File archivo = new File("BD_users.txt");
        ruta_BD = archivo.getCanonicalPath();
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
