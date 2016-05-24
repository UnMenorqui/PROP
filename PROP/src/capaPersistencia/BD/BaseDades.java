package capaPersistencia.BD;

import capaDomini.Graf.*; 

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
    
    private static void save(ArrayList<Node> aL, String nomfitxer) {
        PrintWriter pw = null;
        try {
            File inFile = new File(nomfitxer);
            if (!inFile.isFile()) {
              System.out.println("No existeix el ficher amb nom "+nomfitxer);
            }
            else {
                //Eliminamos el fichero existente
                inFile.delete();
                File file = new File(nomfitxer);
                pw = new PrintWriter(new FileWriter(file));

                int id = 0;
                String nom = "";
                String line;
                for(int i=0; i<aL.size(); ++i) {
                    id = aL.get(i).getId();
                    nom = aL.get(i).getNom();
                    line = String.valueOf(id)+'\t'+nom;
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
    
    private static void savearesta(ArrayList<Aresta> aL, String nomfitxer) {
        PrintWriter pw = null;
        try {
            File inFile = new File(nomfitxer);
            if (!inFile.isFile()) {
              System.out.println("No existeix el ficher amb nom "+nomfitxer);
            }
            else {
                //Eliminamos el fichero existente
                inFile.delete();
                File file = new File(nomfitxer);
                pw = new PrintWriter(new FileWriter(file));

                int id = 0;
                int id1 = 0;
                String line = "";
                for(int i=0; i<aL.size(); ++i) {
                    id = aL.get(i).getNode1();
                    id1 = aL.get(i).getNode2();
                    line = String.valueOf(id)+'\t'+String.valueOf(id1);
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
    
    protected static void saveAutor(ArrayList<Node> autor) {
        save(autor,"author.txt");
    }
    
    protected static void saveConf(ArrayList<Node> conf) {
        save(conf,"conf.txt");
    }
    
    protected static void saveArticle(ArrayList<Node> article) {
        save(article,"paper.txt");
    }
    
    protected static void saveTerme(ArrayList<Node> terme) {
        save(terme,"term.txt");
    }
    
    protected static void savepa(ArrayList<Aresta> pa) {
        savearesta(pa,"paper_author.txt");
    }
    
    protected static void savept(ArrayList<Aresta> pt) {
        savearesta(pt,"paper_term.txt");
    }
    
    protected static void savepc(ArrayList<Aresta> pc) {
        savearesta(pc,"paper_conf.txt");
    }
}
