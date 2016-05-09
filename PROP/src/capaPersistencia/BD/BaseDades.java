package capaPersistencia.BD;

import capaDomini.Graf.*; 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BaseDades extends DataBase {
    
    public BaseDades() {
    
    }
    
    private void loadPaper(ArrayList<Node> paper) {
       
        readFile("paper.txt", paper, "Paper");
    }

    private void loadAuthor(ArrayList<Node> autor) {
        
        readFile("author.txt", autor,"Author");
    }

    private void loadTerm(ArrayList<Node> terme) {
        
        readFile("term.txt", terme,"Term");
    }

    private void loadConference(ArrayList<Node> conf) {
        
        readFile("conf.txt", conf,"Conf");
    }
    
    private void loadArestaPaperConference(ArrayList<Aresta> pc) {
        
        readFileAresta("paper_conf.txt", pc);
    }

    private void loadArestaPaperAuthor(ArrayList<Aresta> pa) {
    
        readFileAresta("paper_author.txt", pa);
    }

    private void loadArestaPaperTerm(ArrayList<Aresta> pt) {
     
        readFileAresta("paper_term.txt", pt);
    }

    // No crec que fagi falta
    /*private Node busqueda_node_id(int id, String tipus){
        //busca un node en les llistes internes
        int i = 0;
        if (tipus.equals("Paper")) {
            while (i < datPaper.size() && datPaper.get(i).getId()!= id) {
                ++i;
            }
            if(i == datPaper.size())return null;
            return datPaper.get(i);
        }
        else if (tipus.equals("Conference")) {
            while (i < datConference.size() && datConference.get(i).getId() != id) {
                ++i;
            }
            if(i == datConference.size())return null;
            return datConference.get(i);
        }
        else if (tipus.equals("Author")) {
            while (i < datAuthor.size() && datAuthor.get(i).getId() != id) {
                ++i;
            }
            if(i == datAuthor.size())return null;
            return datAuthor.get(i);
        }
        else if (tipus.equals("Term")) {
            while (i < datTerm.size() && datTerm.get(i).getId() != id) {
                ++i;
            }
            if(i == datTerm.size())return null;
            return datTerm.get(i);
        }

        return null;
    }*/

    private void readFileAresta(String r, ArrayList<Aresta> aL) {
        //Llegeix un fitxer de relacions de l'enunciat
        try {
            FileReader file = new FileReader(r);
            BufferedReader reader = new BufferedReader(file);
            
            int cont = 1;
            int id1 = 0;
            int id2 = 0;

            String line = reader.readLine();
            while (line != null) {
                int i = 0;
                while (line.charAt(i) != '\t') i++;
                id1 = Integer.parseInt(line.substring(0, i));
                id2 = Integer.parseInt(line.substring(i+1,line.length()));
                aL.add(new Aresta(cont,id1,id2));
                ++cont;
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException e) {} 
        catch (IOException e) {}
    }

    
    
    public void load(ArrayList<Node> paper, ArrayList<Node> autor, ArrayList<Node> terme, ArrayList<Node> conf, ArrayList<Aresta> pc, ArrayList<Aresta> pa, ArrayList<Aresta> pt){
        loadAuthor(autor);
        loadConference(conf);
        loadPaper(paper);
        loadTerm(terme);
        loadArestaPaperConference(pc);
        loadArestaPaperAuthor(pa);
        loadArestaPaperTerm(pt);
       
    }

    public void safe(Graf g) {
        //Escriu la informació del graph als fitxers
    }

    private void readFile(String r, ArrayList<Node> aL, String tipo) {
        //llegeix els fitxers dels nodes
        try {
            FileReader file = new FileReader(r);
            BufferedReader reader = new BufferedReader(file);
            
            int id = 0;
            String nom = "";
            String linea = "";
            
            while ((linea = reader.readLine()) != null) {
                int i = 0;
                while (linea.charAt(i) != '\t') ++i;
                id = Integer.parseInt(linea.substring(0,i));
                nom = linea.substring(i+1,linea.length());
                aL.add(new Node(id,nom,tipo));
            }
        }
        catch (FileNotFoundException e) {} 
        catch (IOException e) {}
    }       
}
