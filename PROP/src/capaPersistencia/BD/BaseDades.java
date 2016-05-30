package capaPersistencia.BD;

import java.io.*;
import java.util.ArrayList;


public class BaseDades  {
    
    public BaseDades() {
    
    }
    
    protected static void load_paper(ArrayList<Integer> id, ArrayList<String> noms) {
        readFile("paper.txt", id, noms, "Paper");
    }

    protected static void load_autor(ArrayList<Integer> id, ArrayList<String> noms) {
        readFile("author.txt", id, noms,"Autor");
    }

    protected static void load_conf(ArrayList<Integer> id, ArrayList<String> noms) {
        readFile("conf.txt", id, noms, "Conferencia");
    }
    
    protected static void load_terme(ArrayList<Integer> id, ArrayList<String> noms) {
        readFile("term.txt", id, noms,"Terme");
    }
    
    protected static void load_pc(ArrayList<Integer> id, ArrayList<Integer> id1) {
        readFileAresta("paper_conf.txt", id, id1);
    }

    protected static void load_pa(ArrayList<Integer> id, ArrayList<Integer> id1) {
        readFileAresta("paper_author.txt", id, id1);
    }

    protected static void load_pt(ArrayList<Integer> id, ArrayList<Integer> id1) {
        readFileAresta("paper_term.txt", id, id1);
    }

    private static void readFile(String r, ArrayList<Integer> id, ArrayList<String> noms, String tipo) {
        //llegeix els fitxers dels nodes
        try {
            FileReader file = new FileReader(r);
            BufferedReader reader = new BufferedReader(file);
            
            String linea = "";
            while ((linea = reader.readLine()) != null) {
                int i = 0;
                while (linea.charAt(i) != '\t') ++i;
                id.add(Integer.parseInt(linea.substring(0,i)));
                noms.add(linea.substring(i+1,linea.length()));
                
            }
        }
        catch (FileNotFoundException e) {} 
        catch (IOException e) {}
    }       
    
    private static void readFileAresta(String r, ArrayList<Integer> id, ArrayList<Integer> id1) {
        //Llegeix un fitxer de relacions de l'enunciat
        try {
            FileReader file = new FileReader(r);
            BufferedReader reader = new BufferedReader(file);
            
            String line = reader.readLine();
            while (line != null) {
                int i = 0;
                while (line.charAt(i) != '\t') i++;
                id.add(Integer.parseInt(line.substring(0, i)));
                id1.add(Integer.parseInt(line.substring(i+1,line.length())));
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException e) {} 
        catch (IOException e) {}
    }
    
    private static void save(ArrayList<Integer> id, ArrayList<String> noms, String nomfitxer) {
        PrintWriter pw = null;
        try {
            File inFile = new File(nomfitxer);
            if (!inFile.isFile()) {
              //System.out.println("No existeix el ficher amb nom "+nomfitxer);
            }
            else {
                //Eliminamos el fichero existente
                inFile.delete();
                File file = new File(nomfitxer);
                pw = new PrintWriter(new FileWriter(file));
                String line;
                for(int i=0; i<id.size(); ++i) {
                    line = String.valueOf(id.get(i))+'\t'+noms.get(i);
                    pw.println(line);
                    pw.flush();
                }
            }
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
            }catch (Exception e2){}
      }
    }
    
    private static void savearesta(ArrayList<Integer> id, ArrayList<Integer> id1, String nomfitxer) {
        PrintWriter pw = null;
        try {
            File inFile = new File(nomfitxer);
            if (!inFile.isFile()) {
              //System.out.println("No existeix el ficher amb nom "+nomfitxer);
            }
            else {
                //Eliminamos el fichero existente
                inFile.delete();
                File file = new File(nomfitxer);
                pw = new PrintWriter(new FileWriter(file));
                
                String line = "";
                for(int i=0; i<id.size(); ++i) {
                    line = String.valueOf(id.get(i))+'\t'+String.valueOf(id1.get(i));
                    pw.println(line);
                    pw.flush();
                }
            }
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
            }catch (Exception e2){}
      }
    }
    
    protected static void saveAutor(ArrayList<Integer> id, ArrayList<String> noms) {
        save(id,noms,"author.txt");
    }
    
    protected static void saveConf(ArrayList<Integer> id, ArrayList<String> noms) {
        save(id,noms,"conf.txt");
    }
    
    protected static void saveArticle(ArrayList<Integer> id, ArrayList<String> noms) {
        save(id,noms,"paper.txt");
    }
    
    protected static void saveTerme(ArrayList<Integer> id, ArrayList<String> noms) {
        save(id,noms,"term.txt");
    }
    
    protected static void savepa(ArrayList<Integer> id, ArrayList<Integer> id1) {
        savearesta(id,id1,"paper_author.txt");
    }
    
    protected static void savept(ArrayList<Integer> id, ArrayList<Integer> id1) {
        savearesta(id,id1,"paper_term.txt");
    }
    
    protected static void savepc(ArrayList<Integer> id, ArrayList<Integer> id1) {
        savearesta(id,id1,"paper_conf.txt");
    }
}
