package capaPersistencia.BD;

import capaDomini.Graf.*; 

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BaseDades extends DataBase {
    private ArrayList<Node> datPaper;
    private ArrayList<Node> datAuthor;
    private ArrayList<Node> datTerm;
    private ArrayList<Node> datConference;
    private ArrayList<Aresta> datPaperConference;
    private ArrayList<Aresta> datPaperAuthor;
    private ArrayList<Aresta> datPaperTerm;

    public BaseDades() {
        this.datPaper = new ArrayList<>();
        this.datAuthor = new ArrayList<>();
        this.datTerm = new ArrayList<>();
        this.datConference = new ArrayList<>();
        this.datPaperConference = new ArrayList<>();
        this.datPaperAuthor = new ArrayList<>();
        this.datPaperTerm = new ArrayList<>();
    }
    
    private void loadPaper() {
        String path = route + "\\paper.txt";
        readFile(path, datPaper, "Paper");
    }

    private void loadAuthor() {
        String path = route + "\\author.txt";
        readFile(path, datAuthor,"Author");
    }

    private void loadTerm() {
        String path = route + "\\term.txt";
        readFile(path, datTerm,"Term");
    }

    private void loadConference() {
        String path = route + "\\conf.txt";
        readFile(path, datConference,"Conf");
    }
    
    private void loadArestaPaperConference() {
        String path = route + "\\paper_conf.txt";
        readFileAresta(path, datPaperConference);
    }

    private void loadArestaPaperAuthor() {
        String path = route + "\\paper_author.txt";
        readFileAresta(path, datPaperAuthor);
    }

    private void loadArestaPaperTerm() {
        String path = route + "\\paper_term.txt";
        readFileAresta(path, datPaperTerm);
    }

    // No crec que fagi falta
    private Node busqueda_node_id(int id, String tipus){
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
    }

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
                /*
                if (line != null) {
                    int i = 0;
                    while (line.charAt(i) != '\t') i++;

                    id1 = Integer.parseInt(line.substring(0, i));
                    id2 = Integer.parseInt(line.substring(i + 1,line.length()));
                    Node paperaresta = busqueda_node_id(id1, "Paper"); // porque esto
                    Node altrearesta = busqueda_node_id(id2, tipus);
                    //aL.add(new Aresta(id_aresta, 0, paperaresta, altrearesta)); // int int int int parameter
                }
                line = reader.readLine();
                ++id_aresta;
            }
        */
    }

    
    //Falta per fer
    public subGraf load(){
        loadAuthor();
        loadConference();
        loadPaper();
        loadTerm();
        loadArestaPaperConference();
        loadArestaPaperAuthor();
        loadArestaPaperTerm();
        return new subGraf(datPaper,datAuthor,datTerm,datConference,datPaperConference,datPaperAuthor,datPaperTerm);
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
        /*
            String line = reader.readLine();
            while (line != null) {
                if (line != null) {
                    int i = 0;
                    while (line.charAt(i) != '\t') i++;
                    switch(tipo){
                        case "Paper": aL.add(new NodePaper(Integer.parseInt(line.substring(0, i)),
                                line.substring(i + 1, line.length()))); break;
                        case "Author": aL.add(new NodeAuthor(Integer.parseInt(line.substring(0, i)),
                                line.substring(i + 1, line.length()))); break;
                        case "Conf": aL.add(new NodeConference(Integer.parseInt(line.substring(0, i)),
                                line.substring(i + 1, line.length()))); break;
                        case "Term": aL.add(new NodeTerm(Integer.parseInt(line.substring(0, i)),
                                line.substring(i + 1, line.length()))); break;
                    }
                }
                line = reader.readLine();
            }
            */
    }       
}
