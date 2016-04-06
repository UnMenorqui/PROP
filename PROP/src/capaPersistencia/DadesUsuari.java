/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;

import capaDomini.Usuaris.UsuariNormal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Toni
 */
public class DadesUsuari {
    
    private final static String nom_BD = "BD_users.txt";
    
    
    public DadesUsuari() {
        
    }
    
    public static void main(String[] args) throws IOException {
        DadesUsuari dades = new DadesUsuari();
        dades.crea_arxiu();
        String user_name = "Anselmo";
        String password = "bbb";
        UsuariNormal usn;
        usn = new UsuariNormal(user_name,password);
        GuardarUsuari(usn);
        if (ExisteixUsuari_contrasenya(usn)) System.out.println("EXISTEIX");
        else System.out.println("NO EXISTEIX");
    }
    
    /*
    public Boolean existeix_arxiu() {
        File archivo = new File(nom_BD);
        if (archivo.exists()) return true;
        else return false;
    }
    */
    
    public static void GuardarUsuari(UsuariNormal us){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nom_BD,true);
            pw = new PrintWriter(fichero);
            pw.println(us.consultar_username()+"  "+us.consultar_password());
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
    
    public static Boolean ExisteixUsuari_contrasenya(UsuariNormal usn) {
        File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (nom_BD);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String aux = "";
         while((linea=br.readLine())!=null) {
            int i = 0;
            while (linea.charAt(i) != ' ') ++i;
             aux = linea.substring(0, i);
             System.out.println(aux);
            if (usn.consultar_username().equals(aux)) {
                i = i+2;
                aux = linea.substring(i,linea.length());
                System.out.println(aux);
                return true;
            }
         }
      }
      catch(Exception e){
          
      }
      finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }
      return false;
    }
    
    public static Boolean ExisteixUsuari(String username) {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (nom_BD);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String aux = "";
         while((linea=br.readLine())!=null) {
            int i = 0;
            while (linea.charAt(i) != ' ') ++i;
             aux = linea.substring(0, i);
             System.out.println(aux);
            if (username.equals(aux)) return true;
         }
      }
      catch(Exception e){
          
      }
      finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }
      return false;
    }
    
    public void crea_arxiu() throws IOException {
        File archivo = new File("BD_users.txt");
    }
}
