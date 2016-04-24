package capaDomini.consulta;

import capaDomini.Graf.Graf_PageRank;
import Utils.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author aleixabrieprat
 */

public class Consulta {
    
    public void obtenir_autors(ArrayList<String> autors, String nom, int quantitat, Graf_PageRank G) {
        int id = G.getID(nom);
        if(id >= 0) {
            int size = G.size();
            int[][] mat = G.getMadj();
            ArrayList<Pair> autors1 = new ArrayList<>();
            ArrayList<Pair> articles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Article":
                    for (int j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Autor")) {
                            Pair o = new Pair(j,mat[j][j]);
                            autors1.add(o);
                        }
                    }
                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) quantitat = autors1.size();
                    for (int i= 0; i<quantitat; i++) {
                        autors.add(G.getNom(autors1.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for (int j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                            Pair o = new Pair(j,mat[j][j]);
                            articles.add(o);
                        }
                    }
                    Collections.sort(articles, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                    for (int i=0; i<articles.size(); i++) {
                        int identificador = articles.get(i).GetF();
                        for (int j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador != j && j != id && G.getTipusNode(j).equals("Autor")) {
                                Pair o = new Pair(j,mat[j][j]);
                                autors1.add(o);
                            }  
                        }
                    }
                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) {
                        for (int i= 0; i<autors1.size(); i++)
                        autors.add(G.getNom(autors1.get(i).GetF()));
                    }
                    else {
                        for (int i= 0; i<quantitat; i++) 
                            autors.add(G.getNom(autors1.get(i).GetF()));
                    }
                    break;

                case "Conferencia":
                    for (int j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                            articles.add(new Pair(j,mat[j][j]));
                        }
                    }
                    Collections.sort(articles, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    for (int i=0; i<articles.size(); i++) {
                        int identificador = articles.get(i).GetF();
                        for (int j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador != j && G.getTipusNode(j).equals("Autor")) {
                                Pair o = new Pair(j,mat[j][j]);
                                autors1.add(o);
                            }  
                        }
                    }
                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) {
                        for (int i=0; i<autors1.size(); i++) 
                            autors.add(G.getNom(autors1.get(i).GetF()));
                    } 
                    else {
                        for (int i=0; i<quantitat; i++) 
                            autors.add(G.getNom(autors1.get(i).GetF()));    
                    }
                    break;

                default:
                    for (int j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                            articles.add(new Pair(j,mat[j][j]));
                        }
                    }
                    Collections.sort(articles, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });

                    for (int i=0; i<articles.size(); i++) {
                        int identificador = articles.get(i).GetF();
                        for (int j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador != j && G.getTipusNode(j).equals("Autor")) {
                                autors1.add(new Pair(j,mat[j][j]));
                            }  
                        }
                    }

                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) {
                        for (int i= 0; i<autors1.size(); i++) 
                            autors.add(G.getNom(autors1.get(i).GetF()));
                    } 
                    else {
                        for (int i= 0; i<quantitat; i++) 
                            autors.add(G.getNom(autors1.get(i).GetF()));
                    }
                    break;    
            }
            articles.clear();
            autors1.clear();
        }
    }
    
    public void obtenir_termes(ArrayList<String> termes, String nom, int quantitat, Graf_PageRank G) {
	int id = G.getID(nom);
        if(id >= 0) {
            int size = G.size();
            int[][] mat = G.getMadj();
            ArrayList<Pair> auxTermes = new ArrayList<>();
            ArrayList<Pair> Articles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Article":
                    for(int j = 0; j<size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Terme")) {
                                    auxTermes.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }	
                    });
                    if (quantitat > auxTermes.size()) quantitat = auxTermes.size();
                    for(int i = 0; i < quantitat; i++) {
                            termes.add(G.getNom(auxTermes.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for(int j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    Articles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (int i=0; i<Articles.size(); i++) {
                        int identificador = Articles.get(i).GetF();
                        for (int j=0; j<size; j++) {
                            if(mat[identificador][j] >= 0 && identificador != j && G.getTipusNode(j).equals("Terme")) {
                                    auxTermes.add(new Pair(j, mat[j][j]));
                            }
                        }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxTermes.size()) {
                        for (int i= 0; i<auxTermes.size(); i++) 
                            termes.add(G.getNom(auxTermes.get(i).GetF()));
                    }
                    else {
                        for (int i= 0; i<quantitat; i++) 
                            termes.add(G.getNom(auxTermes.get(i).GetF()));
                    }
                    break;

                case "Conferencia":
                    for(int j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                Articles.add(new Pair(j,mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override 
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (int i=0; i<Articles.size(); i++) {
                        int identificador = Articles.get(i).GetF();
                        for (int j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador!=j && G.getTipusNode(j).equals("Terme")) {
                                auxTermes.add(new Pair(j,mat[j][j]));
                            }  
                        }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > auxTermes.size()) {
                        for (int i= 0; i<auxTermes.size(); i++) 
                            termes.add(G.getNom(auxTermes.get(i).GetF()));
                    }
                    else {
                        for (int i= 0; i<quantitat; i++) 
                            termes.add(G.getNom(auxTermes.get(i).GetF()));
                    }
                    Articles.clear();
                    break;

                default:
                    for(int j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                Articles.add(new Pair(j,mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override 
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });

                    for (int i=0; i<Articles.size(); i++) {
                        int identificador = Articles.get(i).GetF();
                        for (int j=0; j<size; ++j) {
                            if (mat[identificador][j] >= 0 && identificador != j && j != id && G.getTipusNode(j).equals("Autor")) {
                                auxTermes.add(new Pair(j,mat[j][j]));
                            }  
                        }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > auxTermes.size()) {
                        for (int i= 0; i<auxTermes.size(); i++) 
                            termes.add(G.getNom(auxTermes.get(i).GetF()));
                    }
                    else {
                        for (int i= 0; i<quantitat; i++) 
                            termes.add(G.getNom(auxTermes.get(i).GetF()));
                    }
                    break;
            }
            auxTermes.clear();
            Articles.clear();
        }
    }
    
    public void obtenir_conferencies(ArrayList<String> conferencies, String nom, int quantitat, Graf_PageRank G) {
    	int id = G.getID(nom);
        if(id >= 0) {
            int size = G.size();
            int[][] mat = G.getMadj();
            ArrayList<Pair> auxConferencies = new ArrayList<>();
            ArrayList<Pair> Articles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Article":
                    for(int j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Conferencia")) {
                                    auxConferencies.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxConferencies, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }	
                    });
                    if (quantitat > auxConferencies.size()) {
                        for(int i = 0; i < auxConferencies.size(); i++) 
                            conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
                    }
                    else {
                        for(int i = 0; i < quantitat; i++) 
                            conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for(int j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    Articles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (int i=0; i<Articles.size(); i++) {
                        int identificador = Articles.get(i).GetF();
                        for(int j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador!=j && G.getTipusNode(j).equals("Conferencia")) {
                                auxConferencies.add(new Pair(j,mat[j][j]));
                            }
                        }
                    }
                    Collections.sort(auxConferencies, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxConferencies.size()) {
                        for(int i = 0; i < auxConferencies.size(); i++) 
                            conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
                    }
                    else {
                        for(int i = 0; i < quantitat; i++) 
                            conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
                    }
                    break;

                default:
                    for(int j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    Articles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override 
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (int i=0; i<Articles.size(); i++) {
                        int identificador = Articles.get(i).GetF();
                        for(int j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador!=j && G.getTipusNode(j).equals("Conferencia")) {
                                auxConferencies.add(new Pair(j,mat[j][j]));
                            }
                        }
                    }
                    Collections.sort(auxConferencies, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxConferencies.size()) {
                        for(int i = 0; i < auxConferencies.size(); i++) 
                            conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
                    }
                    else {
                        for(int i = 0; i < quantitat; i++) 
                            conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
                    }
                    break;
            }
            Articles.clear();
            auxConferencies.clear();
        }
    }
    
    public void obtenir_articles(ArrayList<String> articles, String nom, int quantitat, Graf_PageRank G) {
	int id = G.getID(nom);
        if(id >= 0) {
            int[][] mat = G.getMadj();
            ArrayList<Pair> auxArticles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Conferencia":
                    for(int j = 0; j < G.size(); j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    auxArticles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxArticles, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }	
                    });
                    if (quantitat > auxArticles.size()) {
                        for(int i = 0; i < auxArticles.size(); i++) 
                            articles.add(G.getNom(auxArticles.get(i).GetF()));
                    }
                    else {
                        for(int i = 0; i < quantitat; i++) 
                            articles.add(G.getNom(auxArticles.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for(int j = 0; j < G.size(); j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    auxArticles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxArticles, new Comparator() {
                            @Override
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxArticles.size()) {
                        for(int i = 0; i < auxArticles.size(); i++) 
                            articles.add(G.getNom(auxArticles.get(i).GetF()));
                    }
                    else {
                        for(int i = 0; i < quantitat; i++) 
                            articles.add(G.getNom(auxArticles.get(i).GetF()));
                    }
                    break;

                default:
                    for(int j = 0; j < G.size(); j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    auxArticles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxArticles, new Comparator() {
                            @Override 
                            public int compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxArticles.size()) {
                        for(int i = 0; i < auxArticles.size(); i++) 
                            articles.add(G.getNom(auxArticles.get(i).GetF()));
                    }
                    else {
                        for(int i = 0; i < quantitat; i++) 
                            articles.add(G.getNom(auxArticles.get(i).GetF()));
                    }
                    break;      
            }
            auxArticles.clear();        
        }
    }
}
