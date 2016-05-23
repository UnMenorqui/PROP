package capaDomini.consulta;

import Utils.Pair;
import capaDomini.Graf.CtrlGraf;
import capaDomini.Graf.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author aleixabrieprat
 */

public class Consulta {
    
    public void obtenir_autors(ArrayList<String> autors, ArrayList<String> articles, String nom, String tipus, int quantitat, CtrlGraf G) {
        ArrayList<Pair> autors1 = new ArrayList<>();
        int id;
        Node node;
        String nomt;
        double valor;
        Pair p;
        Boolean repetit;
        switch (tipus) {
            case "Article":
                id = G.getidArrayString(nom,tipus);
                node = G.getNodeIessim(id, tipus);
                for (int i=0; i<node.getsize(); ++i) {
                    if (node.nodeiessimSecond(i).equals("Autor")) {
                        id = G.getidArrayint(node.nodeiessimFirst(i), "Autor");
                        nomt = G.getNomNode(id, "Autor");
                        valor = G.getValorNode(id, "Autor");
                        p = new Pair(nomt,valor);
                        repetit = false;
                        for (int j = 0; j < autors1.size() && !repetit; ++j) {
                            if (autors1.get(j).GetF().equals(nomt)) {
                               repetit = true;
                            }
                        }
                        if (!repetit) autors1.add(p);
                    }
                }
                Collections.sort(autors1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Double(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                
                if (autors1.size() > quantitat) {
                    for (int i=0; i<quantitat; ++i) {
                        autors.add(autors1.get(i).GetF());
                    }
                } else {
                    for (int i=0; i<autors1.size(); ++i) {
                        autors.add(autors1.get(i).GetF());
                    }
                }
                break;
                
            default:
                System.out.println("Estic dins co-autors");
                for (int i=0; i<articles.size(); ++i) {
                    System.out.println("Estic al primer for");
                    node = G.getNodeIessim(G.getidArrayString(articles.get(i), "Article"), "Article");
                    for (int j = 0; j<node.getsize(); ++j) {
                        System.out.println("PEstic al segon for");
                        if (node.nodeiessimSecond(j).equals("Autor")) {
                            id = G.getidArrayint(node.nodeiessimFirst(j), "Autor");
                            nomt = G.getNomNode(id, "Autor");
                            if (!nom.equals(nomt)) {
                                System.out.println("Estic al if del segon for");
                                valor = G.getValorNode(id, "Autor");
                                p = new Pair(nomt,valor);
                                repetit = false;
                                for (int k = 0; k < autors1.size() && !repetit; ++k) {
                                    System.out.println("Estic al tercer for");
                                    if (autors1.get(k).GetF().equals(nomt)) {
                                        repetit = true;
                                    }
                                }
                                System.out.println("Tercer for superat");
                                if (!repetit) autors1.add(p); 
                            }
                        }
                    }
                    System.out.println("Segon for superat");
                }
                System.out.println("Primer for superat");
                Collections.sort(autors1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Double(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                if (autors1.size() > quantitat) {
                    for (int i=0; i<quantitat; ++i) {
                        autors.add(autors1.get(i).GetF());
                    }
                } else {
                    for (int i=0; i<autors1.size(); ++i) {
                        autors.add(autors1.get(i).GetF());
                    }
                }
                break;
        }
        System.out.println("Execució acabada");
        autors1.clear();
    }
    
    public void obtenir_termes(ArrayList<String> termes, ArrayList<String> articles, String nom, String tipus, int quantitat, CtrlGraf G) {
        ArrayList<Pair> termes1 = new ArrayList<>();
        int id;
        Node node;
        String nomt;
        double valor;
        Pair p;
        Boolean repetit;
        switch (tipus) {
            case "Article":
                id = G.getidArrayString(nom,tipus);
                node = G.getNodeIessim(id, tipus);
                for (int i=0; i<node.getsize(); ++i) {
                    if (node.nodeiessimSecond(i).equals("Terme")) {
                        id = G.getidArrayint(node.nodeiessimFirst(i), "Terme");
                        nomt = G.getNomNode(id, "Terme");
                        valor = G.getValorNode(id, "Terme");
                        p = new Pair(nomt,valor);
                        repetit = false;
                        for (int j = 0; j < termes1.size() && !repetit; ++j) {
                            if (termes1.get(j).GetF().equals(nomt)) {
                               repetit = true;
                            }
                        }
                        if (!repetit) termes1.add(p);
                    }
                }
                Collections.sort(termes1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Double(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                
                if (termes1.size() > quantitat) {
                    for (int i=0; i<quantitat; ++i) {
                        termes.add(termes1.get(i).GetF());
                    }
                } else {
                    for (int i=0; i<termes1.size(); ++i) {
                        termes.add(termes1.get(i).GetF());
                    }
                }
                break;

            default:
                for (int i=0; i<articles.size(); ++i) {
                    node = G.getNodeIessim(G.getidArrayString(articles.get(i), "Article"), "Article");
                    for (int j = 0; j<node.getsize(); ++j) {
                        if (node.nodeiessimSecond(j).equals("Terme")) {
                            id = G.getidArrayint(node.nodeiessimFirst(j), "Terme");
                            nomt = G.getNomNode(id, "Terme");
                            valor = G.getValorNode(id, "Terme");
                            p = new Pair(nomt,valor);
                            repetit = false;
                            for (int k = 0; k < termes1.size() && !repetit; ++k) {
                                if (termes1.get(k).GetF().equals(nomt)) {
                                   repetit = true;
                                }
                            }
                            if (!repetit) termes1.add(p);
                        }
                    }
                }
                Collections.sort(termes1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Double(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                if (termes1.size() > quantitat) {
                    for (int i=0; i<quantitat; ++i) {
                        termes.add(termes1.get(i).GetF());
                    }
                } else {
                    for (int i=0; i<termes1.size(); ++i) {
                        termes.add(termes1.get(i).GetF());
                    }
                }
                break;
              
                
            
        }
	termes1.clear();
    }
    
    public void obtenir_conferencies(ArrayList<String> conferencies, ArrayList<String> articles, String nom, String tipus, int quantitat, CtrlGraf G) {
        ArrayList<Pair> conferencies1 = new ArrayList<>();
        int id;
        Node node;
        String nomt;
        double valor;
        Pair p;
        Boolean repetit;
        switch (tipus) {   
            case "Article":
                id = G.getidArrayString(nom,tipus);
                node = G.getNodeIessim(id, tipus);
                for (int i=0; i<node.getsize(); ++i) {
                    if (node.nodeiessimSecond(i).equals("Conferencia")) {
                        id = G.getidArrayint(node.nodeiessimFirst(i), "Conferencia");
                        nomt = G.getNomNode(id, "Conferencia");
                        valor = G.getValorNode(id, "Conferencia");
                        p = new Pair(nomt,valor);
                        repetit = false;
                        for (int j = 0; j < conferencies1.size() && !repetit; ++j) {
                            if (conferencies1.get(j).GetF().equals(nomt)) {
                               repetit = true;
                            }
                        }
                        if (!repetit) conferencies1.add(p);
                    }
                }
                Collections.sort(conferencies1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Double(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                
                if (conferencies1.size() > quantitat) {
                    for (int i=0; i<quantitat; ++i) {
                        conferencies.add(conferencies1.get(i).GetF());
                    }
                } else {
                    for (int i=0; i<conferencies1.size(); ++i) {
                        conferencies.add(conferencies1.get(i).GetF());
                    }
                }
                break;
                
            default:
                for (int i=0; i<articles.size(); ++i) {
                    node = G.getNodeIessim(G.getidArrayString(articles.get(i), "Article"), "Article");
                    for (int j = 0; j<node.getsize(); ++j) {
                        if (node.nodeiessimSecond(j).equals("Conferencia")) {
                            id = G.getidArrayint(node.nodeiessimFirst(j), "Conferencia");
                            nomt = G.getNomNode(id, "Conferencia");
                            valor = G.getValorNode(id, "Conferencia");
                            p = new Pair(nomt,valor);
                            repetit = false;
                            for (int k = 0; k < conferencies1.size() && !repetit; ++k) {
                                if (conferencies1.get(k).GetF().equals(nomt)) {
                                   repetit = true;
                                }
                            }
                            if (!repetit) conferencies1.add(p);
                        }
                    }
                }
                Collections.sort(conferencies1, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Pair a = (Pair)o1;
                            Pair b = (Pair)o2;
                            return new Double(a.GetS()).compareTo(b.GetS());
                        }   
                    });
                if (conferencies1.size() > quantitat) {
                    for (int i=0; i<quantitat; ++i) {
                        conferencies.add(conferencies1.get(i).GetF());
                    }
                } else {
                    for (int i=0; i<conferencies1.size(); ++i) {
                        conferencies.add(conferencies1.get(i).GetF());
                    }
                }
                break;
        } 
        conferencies1.clear();
    }
    
    public void obtenir_articles(ArrayList<String> articles, String nom, String tipus, int quantitat, CtrlGraf G) {
        ArrayList<Pair> articles1 = new ArrayList<>();
        int id = G.getidArrayString(nom,tipus);
        Node node = G.getNodeIessim(id, tipus);
        Boolean repetit;
        for (int i=0; i<node.getsize(); ++i) {
            if (node.nodeiessimSecond(i).equals("Article")) {
                int id1 = G.getidArrayint(node.nodeiessimFirst(i), "Article");
                String nomt = G.getNomNode(id1, "Article");
                double valor = G.getValorNode(id1, "Article");
                Pair p = new Pair(nomt,valor);
                repetit = false;
                for (int j = 0; j < articles1.size() && !repetit; ++j) {
                    if (articles1.get(j).GetF().equals(nomt)) {
                       repetit = true;
                    }
                }
                if (!repetit) articles1.add(p);
            }
        }
        Collections.sort(articles1, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    Pair a = (Pair)o1;
                    Pair b = (Pair)o2;
                    return new Double(a.GetS()).compareTo(b.GetS());
                }   
            });
        if (articles1.size() > quantitat) {
            for (int i=0; i<quantitat; ++i) {
                articles.add(articles1.get(i).GetF());
            }
        } else {
            for (int i=0; i<articles1.size(); ++i) {
                articles.add(articles1.get(i).GetF());
            }
        }  
        articles1.clear();
    }
}
