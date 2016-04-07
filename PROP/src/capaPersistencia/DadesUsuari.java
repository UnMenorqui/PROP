package capaPersistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Toni
 */
public class DadesUsuari {
    
    private final static String nom_BD = "BD_users.txt";
    
    
    public DadesUsuari() {
        
    }
    
    //FETA
    public static void GuardarUsuari(String username, String password){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nom_BD,true);
            pw = new PrintWriter(fichero);
            pw.println(username+"  "+password);
        } catch (Exception e) {
            e.getStackTrace();
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
    
    //FETA
    public static Boolean ExisteixUsuari_contrasenya(String username, String password) {
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
            if (username.equals(aux)) {
                i = i+2;
                aux = linea.substring(i,linea.length());
                if (password.equals(aux)) return true;
            }
         }
      }
      catch(Exception e){
          e.getStackTrace();
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
             e2.getStackTrace();
         }
      }
      return false;
    }
    
    //FETA
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
          e.getStackTrace();
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
             e2.getStackTrace();
         }
      }
      return false;
    }
    
    // FALTA PER FER
    public static Boolean modificar_username(String username, String password, String new_username) {
        //Es sap que l'usuari existeix a la BD
        try {
            
        }
        catch(Exception e) {
            
        }
        
        return true;
        
    }
    
    //FALTA PER FER
    public static Boolean modificar_password(String username, String password, String new_password) {
        //Es sap que l'usuari existeix a la BD
        try {
            
        }
        catch(Exception e) {
            
        }
        
        return true;
    }
    
    //FETA
    public static boolean borrarlinea(String username, String password) {
        try {
            String borra = (username+"  "+password);

            File inFile = new File("BD_users");
            if (!inFile.isFile()) return false;
            
            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader("BD_users"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
              if (!line.trim().equals(borra)) {
                pw.println(line);
                pw.flush();
              }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) return false; 

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) return false;

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
