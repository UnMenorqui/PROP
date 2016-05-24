package capaPersistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    
    public static void GuardarUsuari(String username, String password){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nom_BD,true);
            pw = new PrintWriter(fichero);
            pw.println(username+"  "+password);
        } catch (Exception e){} 
        finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {}
        }
    }
    
    public static String consultar_password(String username) {
        String aux = "";
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
           boolean acabat = false;
           while(!acabat && (linea=br.readLine())!=null) {
              int i = 0;
              while (linea.charAt(i) != ' ') ++i;
               aux = linea.substring(0, i);
              if (username.equals(aux)) {
                  acabat = true;
                  return linea.substring(i+2,linea.length());
              }
           }
        }
        catch(Exception e){}
        finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }
           catch (Exception e2){}
        }
        return null;
    }
    
    public static int ExisteixUsuari_contrasenya(String username, String password) {
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
                if (username.equals(aux)) {
                    i = i+2;
                    aux = linea.substring(i,linea.length());
                    if (password.equals(aux)) return 2;     //User/Contrasenya existeix
                    else return 1;                          //Contrasenya incorrecta
                }                           
            }
        }
        catch(Exception e){}
        finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }
            catch (Exception e2){}
        }
        return 0;       //No existeix usuari
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
              if (username.equals(aux)) return true;
           }
        }
        catch(Exception e){}
        finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }
           catch (Exception e2){}
        }
        return false;
      }

    public static boolean modificar_username(String username, String nou_user, String password) {
          //Es sap que l'usuari existeix a la BD i que el nou nom de l'usuari no està a la BD.
          borrarUsuari(username,password);
          GuardarUsuari(nou_user,password);
          return true;
      }

    public static boolean modificar_password(String username,String password, String new_password) {
          //Es sap que l'usuari existeix a la BD
          borrarUsuari(username,password);
          GuardarUsuari(username,new_password);
          return true;
      }

    public static boolean borrarUsuari(String user, String pass) {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            File inFile = new File(nom_BD);
            if (!inFile.isFile()) {
              System.out.println("Parameter is not an existing file");
              return false;
            }

            //Construct the new file that will later be renamed to the original filename. 
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            br = new BufferedReader(new FileReader("BD_users.txt"));
            pw = new PrintWriter(new FileWriter(tempFile));

            String line;
            String borra = user+"  "+pass;
            //Read from the original file and write to the new 
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
              
              if (!line.trim().equals(borra)) {
                pw.println(line);
                pw.flush();
              }
            }

            //Delete the original file
            if (!inFile.delete()) return false;

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) return false;
          }
          catch (FileNotFoundException ex) {}
          catch (IOException ex) {}
          finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{                  
                if( null != pw ){   
                    pw.close();     
                  } 
                if (null != br) {
                    br.close();
                }
            }catch (Exception e2){}
          }
          return true;
    } 
    
    public static void borrarUsuariAdmin(String user) {
        String pass = consultar_password(user);
        borrarUsuari(user,pass);
    }
    
    public static void consultaUsuarisBD() {
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
               aux = linea.substring(0,i);
               System.out.println(aux);
           }
        }
        catch(Exception e){}
        finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
               if( null != fr ) fr.close();                     
           }
           catch (Exception e2){}
        }
    }
}
