package capaPersistencia.BD;

import capaDomini.Graf.*; ////?????????

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
    /*
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
    */

    private void loadArestaPaperConference(int id_aresta) {
        String path = route + "\\paper_conf.txt";
        String tipus = "Conference";
        readFileAresta(path, datPaperConference, id_aresta, tipus);
    }

    private void loadArestaPaperAuthor(int id_aresta) {
        String path = route + "\\paper_author.txt";
        String tipus = "Author";
        readFileAresta(path, datPaperAuthor, id_aresta, tipus);
    }

    private void loadArestaPaperTerm(int id_aresta) {
        String path = route + "\\paper_term.txt";
        String tipus = "Term";
        readFileAresta(path, datPaperTerm, id_aresta, tipus);
    }

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

    private void readFileAresta(String r, ArrayList<Aresta> aL, int id_aresta, String tipus) {
        //Llegeix un fitxer de relacions de l'enunciat
        try {
            FileReader file = new FileReader(r);
            BufferedReader reader = new BufferedReader(file);

            String par1 = "";
            String par2 = "";
            int id1 = 0;
            int id2 = 0;

            String line = reader.readLine();
            while (line != null) {
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public Graf load(){
        //llegeix tots els fitxers i crea el graph
        loadAuthor();
        loadConference();
        loadPaper();
        loadTerm();
        int id_aresta = 0;
        loadArestaPaperConference(id_aresta);
        loadArestaPaperAuthor(id_aresta);
        loadArestaPaperTerm(id_aresta);

        return new Graf(datPaper,datAuthor,datTerm,datConference,datPaperConference,datPaperAuthor,datPaperTerm);
    }*/

    public void safe(Graf g) {
        //Escriu la informació del graph als fitxers
    }

    /*
    private void readFile(String r, ArrayList<Node> aL, String tipo) {
        //llegeix els fitxers dels nodes
        try {
            FileReader file = new FileReader(r);
            BufferedReader reader = new BufferedReader(file);

            String par1 = "";
            String par2 = "";

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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
