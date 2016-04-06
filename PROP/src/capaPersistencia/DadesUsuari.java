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
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Toni
 */
public class DadesUsuari {
    
    private String ruta_BD;
    
    
    public DadesUsuari() {
        
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean bool = false;
        System.out.println("Marca 1 si vols afegir un usuari.");
        System.out.println("Marca 2 si vols borrar un usuari.");
        while(!bool) {
            System.out.println("Escriu el numero: ");
            int prova = sc.nextInt();
            switch(prova) {
                case 1:
                    afegeix_usr(sc);
                    break;
                case 2:
                    borra_usr(sc);
                    break;
                case 3:
                    bool = true;
                    break;
            }
        }
    }
    
    public static Boolean existeix_arxiu() {
        File archivo = new File("BD_users.txt");
        if (archivo.exists()) return true;
        else return false;
    }
    
    public static void borra_usr (Scanner sc) {
        //Scanner lp = new Scanner(System.in);
        System.out.println("Entra l'usuari a borrar: ");
        String usr = sc.next();
        System.out.println("Entra la password: ");
        String pass = sc.next();
        String borra = (usr+"  "+pass);
        borralinea("BD_users",borra);
    }
    
    public static void afegeix_usr(Scanner sc) {
        //Scanner lp = new Scanner(System.in);
        System.out.println("Entra l'usuari a guardar: ");
        String usr = sc.next();
        System.out.println("Entra la password: ");
        String pass = sc.next();
        UsuariNormal usuari = new UsuariNormal(usr,pass);
        GuardarUsuari(usuari);
    }
    
    public static void GuardarUsuari(UsuariNormal us){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("BD_users.txt",true);
            //pw.println();
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
    
    public void crea_arxiu() throws IOException {
        File archivo = new File("BD_users.txt");

    }
    
    
    public static boolean borralinea(String file, String lineToRemove) {
 
    try {
 
      File inFile = new File(file);
      
      if (!inFile.isFile()) {
        return false;
      }
       
      //Construct the new file that will later be renamed to the original filename. 
      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
      
      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
      
      String line = null;
 
      //Read from the original file and write to the new 
      //unless content matches data to be removed.
      while ((line = br.readLine()) != null) {
        
        if (!line.trim().equals(lineToRemove)) {
 
          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();
      
      //Delete the original file
      if (!inFile.delete()) {
        return false;
      } 
      
      //Rename the new file to the filename the original file had.
      if (!tempFile.renameTo(inFile))
      return false;
      
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    return true;
  }
}
