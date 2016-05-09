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
    
    public void obtenir_autors(ArrayList<String> autors, String nom, short quantitat, Graf_PageRank G) {
        short id = G.GetID(nom);
        if(id >= 0) {
            short size = G.size();
            short[][] mat = G.GetMadj();
            ArrayList<Pair> autors1 = new ArrayList<>();
            ArrayList<Pair> articles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Article":
                    for (short j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Autor")) {
                            Pair o = new Pair(j,mat[j][j]);
                            autors1.add(o);
                        }
                    }
                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) quantitat = autors1.size();
                    for (short i= 0; i<quantitat; i++) {
                        autors.add(G.getNomNode(autors1.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for (short j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                            Pair o = new Pair(j,mat[j][j]);
                            articles.add(o);
                        }
                    }
                    Collections.sort(articles, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                    for (short i=0; i<articles.size(); i++) {
                        short identificador = articles.get(i).GetF();
                        for (short j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador != j && j != id && G.getTipusNode(j).equals("Autor")) {
                                Pair o = new Pair(j,mat[j][j]);
                                autors1.add(o);
                            }  
                        }
                    }
                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) {
                        for (short i= 0; i<autors1.size(); i++)
                        autors.add(G.getNomNode(autors1.get(i).GetF()));
                    }
                    else {
                        for (short i= 0; i<quantitat; i++) 
                            autors.add(G.getNomNode(autors1.get(i).GetF()));
                    }
                    break;

                case "Conferencia":
                    for (short j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                            articles.add(new Pair(j,mat[j][j]));
                        }
                    }
                    Collections.sort(articles, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    for (short i=0; i<articles.size(); i++) {
                        short identificador = articles.get(i).GetF();
                        for (short j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador != j && G.getTipusNode(j).equals("Autor")) {
                                Pair o = new Pair(j,mat[j][j]);
                                autors1.add(o);
                            }  
                        }
                    }
                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) {
                        for (short i=0; i<autors1.size(); i++) 
                            autors.add(G.getNomNode(autors1.get(i).GetF()));
                    } 
                    else {
                        for (short i=0; i<quantitat; i++) 
                            autors.add(G.getNomNode(autors1.get(i).GetF()));    
                    }
                    break;

                default:
                    for (short j=0; j<size; j++) {
                        if (mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                            articles.add(new Pair(j,mat[j][j]));
                        }
                    }
                    Collections.sort(articles, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });

                    for (short i=0; i<articles.size(); i++) {
                        short identificador = articles.get(i).GetF();
                        for (short j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador != j && G.getTipusNode(j).equals("Autor")) {
                                autors1.add(new Pair(j,mat[j][j]));
                            }  
                        }
                    }

                    Collections.sort(autors1, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > autors1.size()) {
                        for (short i= 0; i<autors1.size(); i++) 
                            autors.add(G.getNomNode(autors1.get(i).GetF()));
                    } 
                    else {
                        for (short i= 0; i<quantitat; i++) 
                            autors.add(G.getNomNode(autors1.get(i).GetF()));
                    }
                    break;    
            }
            articles.clear();
            autors1.clear();
        }
    }
    
    public void obtenir_termes(ArrayList<String> termes, String nom, short quantitat, Graf_PageRank G) {
	short id = G.GetID(nom);
        if(id >= 0) {
            short size = G.size();
            short[][] mat = G.GetMadj();
            ArrayList<Pair> auxTermes = new ArrayList<>();
            ArrayList<Pair> Articles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Article":
                    for(short j = 0; j<size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Terme")) {
                                    auxTermes.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }	
                    });
                    if (quantitat > auxTermes.size()) quantitat = auxTermes.size();
                    for(short i = 0; i < quantitat; i++) {
                            termes.add(G.getNomNode(auxTermes.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for(short j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    Articles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (short i=0; i<Articles.size(); i++) {
                        short identificador = Articles.get(i).GetF();
                        for (short j=0; j<size; j++) {
                            if(mat[identificador][j] >= 0 && identificador != j && G.getTipusNode(j).equals("Terme")) {
                                    auxTermes.add(new Pair(j, mat[j][j]));
                            }
                        }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxTermes.size()) {
                        for (short i= 0; i<auxTermes.size(); i++) 
                            termes.add(G.getNomNode(auxTermes.get(i).GetF()));
                    }
                    else {
                        for (short i= 0; i<quantitat; i++) 
                            termes.add(G.getNomNode(auxTermes.get(i).GetF()));
                    }
                    break;

                case "Conferencia":
                    for(short j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                Articles.add(new Pair(j,mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override 
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (short i=0; i<Articles.size(); i++) {
                        short identificador = Articles.get(i).GetF();
                        for (short j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador!=j && G.getTipusNode(j).equals("Terme")) {
                                auxTermes.add(new Pair(j,mat[j][j]));
                            }  
                        }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > auxTermes.size()) {
                        for (short i= 0; i<auxTermes.size(); i++) 
                            termes.add(G.getNomNode(auxTermes.get(i).GetF()));
                    }
                    else {
                        for (short i= 0; i<quantitat; i++) 
                            termes.add(G.getNomNode(auxTermes.get(i).GetF()));
                    }
                    Articles.clear();
                    break;

                default:
                    for(short j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                Articles.add(new Pair(j,mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override 
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });

                    for (short i=0; i<Articles.size(); i++) {
                        short identificador = Articles.get(i).GetF();
                        for (short j=0; j<size; ++j) {
                            if (mat[identificador][j] >= 0 && identificador != j && j != id && G.getTipusNode(j).equals("Autor")) {
                                auxTermes.add(new Pair(j,mat[j][j]));
                            }  
                        }
                    }
                    Collections.sort(auxTermes, new Comparator() {
                        @Override
                        public short compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Integer(a.GetS()).compareTo(b.GetS());
                        }
                    });
                    if (quantitat > auxTermes.size()) {
                        for (short i= 0; i<auxTermes.size(); i++) 
                            termes.add(G.getNomNode(auxTermes.get(i).GetF()));
                    }
                    else {
                        for (short i= 0; i<quantitat; i++) 
                            termes.add(G.getNomNode(auxTermes.get(i).GetF()));
                    }
                    break;
            }
            auxTermes.clear();
            Articles.clear();
        }
    }
    
    public void obtenir_conferencies(ArrayList<String> conferencies, String nom, short quantitat, Graf_PageRank G) {
    	short id = G.GetID(nom);
        if(id >= 0) {
            short size = G.size();
            short[][] mat = G.GetMadj();
            ArrayList<Pair> auxConferencies = new ArrayList<>();
            ArrayList<Pair> Articles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Article":
                    for(short j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Conferencia")) {
                                    auxConferencies.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxConferencies, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }	
                    });
                    if (quantitat > auxConferencies.size()) {
                        for(short i = 0; i < auxConferencies.size(); i++) 
                            conferencies.add(G.getNomNode(auxConferencies.get(i).GetF()));
                    }
                    else {
                        for(short i = 0; i < quantitat; i++) 
                            conferencies.add(G.getNomNode(auxConferencies.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for(short j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    Articles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (short i=0; i<Articles.size(); i++) {
                        short identificador = Articles.get(i).GetF();
                        for(short j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador!=j && G.getTipusNode(j).equals("Conferencia")) {
                                auxConferencies.add(new Pair(j,mat[j][j]));
                            }
                        }
                    }
                    Collections.sort(auxConferencies, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxConferencies.size()) {
                        for(short i = 0; i < auxConferencies.size(); i++) 
                            conferencies.add(G.getNomNode(auxConferencies.get(i).GetF()));
                    }
                    else {
                        for(short i = 0; i < quantitat; i++) 
                            conferencies.add(G.getNomNode(auxConferencies.get(i).GetF()));
                    }
                    break;

                default:
                    for(short j = 0; j < size; j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    Articles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(Articles, new Comparator() {
                            @Override 
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    for (short i=0; i<Articles.size(); i++) {
                        short identificador = Articles.get(i).GetF();
                        for(short j=0; j<size; j++) {
                            if (mat[identificador][j] >= 0 && identificador!=j && G.getTipusNode(j).equals("Conferencia")) {
                                auxConferencies.add(new Pair(j,mat[j][j]));
                            }
                        }
                    }
                    Collections.sort(auxConferencies, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxConferencies.size()) {
                        for(short i = 0; i < auxConferencies.size(); i++) 
                            conferencies.add(G.getNomNode(auxConferencies.get(i).GetF()));
                    }
                    else {
                        for(short i = 0; i < quantitat; i++) 
                            conferencies.add(G.getNomNode(auxConferencies.get(i).GetF()));
                    }
                    break;
            }
            Articles.clear();
            auxConferencies.clear();
        }
    }
    
    public void obtenir_articles(ArrayList<String> articles, String nom, short quantitat, Graf_PageRank G) {
	short id = G.GetID(nom);
        if(id >= 0) {
            short[][] mat = G.GetMadj();
            ArrayList<Pair> auxArticles = new ArrayList<>();
            String tipus = G.getTipusNode(id);
            switch(tipus) {
                case "Conferencia":
                    for(short j = 0; j < G.size(); j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    auxArticles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxArticles, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }	
                    });
                    if (quantitat > auxArticles.size()) {
                        for(short i = 0; i < auxArticles.size(); i++) 
                            articles.add(G.getNomNode(auxArticles.get(i).GetF()));
                    }
                    else {
                        for(short i = 0; i < quantitat; i++) 
                            articles.add(G.getNomNode(auxArticles.get(i).GetF()));
                    }
                    break;

                case "Autor":
                    for(short j = 0; j < G.size(); j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    auxArticles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxArticles, new Comparator() {
                            @Override
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxArticles.size()) {
                        for(short i = 0; i < auxArticles.size(); i++) 
                            articles.add(G.getNomNode(auxArticles.get(i).GetF()));
                    }
                    else {
                        for(short i = 0; i < quantitat; i++) 
                            articles.add(G.getNomNode(auxArticles.get(i).GetF()));
                    }
                    break;

                default:
                    for(short j = 0; j < G.size(); j++) {
                            if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
                                    auxArticles.add(new Pair(j, mat[j][j]));
                            }
                    }
                    Collections.sort(auxArticles, new Comparator() {
                            @Override 
                            public short compare(Object o1, Object o2) {
                                    Pair a = (Pair) o1;
                                    Pair b = (Pair) o2;
                                    return new Integer(a.GetS()).compareTo(b.GetS());
                            }
                    });
                    if (quantitat > auxArticles.size()) {
                        for(short i = 0; i < auxArticles.size(); i++) 
                            articles.add(G.getNomNode(auxArticles.get(i).GetF()));
                    }
                    else {
                        for(short i = 0; i < quantitat; i++) 
                            articles.add(G.getNomNode(auxArticles.get(i).GetF()));
                    }
                    break;      
            }
            auxArticles.clear();        
        }
    }
}
