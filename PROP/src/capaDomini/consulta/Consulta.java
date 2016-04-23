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
    
    public void obtenir_autors(ArrayList<String> autors, String nom, int quantitat, Graf_PageRank G) 
    {
        int id = G.getID(nom);
        int size = G.size();
        int[][] mat = G.getMadj();
        ArrayList<Pair> autors1 = new ArrayList<>();
        if (G.getTipusNode(id).equals("Article")) {
            for (int j=0; j<size; ++j) {
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
            for (int i= 0; i<quantitat; ++i) {
                autors.add(G.getNom(autors1.get(i).GetF()));
            }
        } else if (G.getTipusNode(id).equals("Autor")) 
        {
            ArrayList<Pair> articles = new ArrayList<>();
            for (int j=0; j<size; ++j) {
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
            for (int i=0; i<articles.size(); ++i) {
                for (int j=0; j<size; ++i) {
                    if (mat[i][j] >= 0 && i != j && G.getTipusNode(j).equals("Autor")) {
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
            for (int i= 0; i<quantitat; ++i) {
                autors.add(G.getNom(autors1.get(i).GetF()));
            }
        } else if (G.getTipusNode(id).equals("Conferencia")) 
        {
            ArrayList<Pair> articles = new ArrayList<>();
            for (int j=0; j<size; ++j) {
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
            for (int i=0; i<articles.size(); ++i) {
                for (int j=0; j<size; ++i) {
                    if (mat[i][j] >= 0 && i != j && G.getTipusNode(j).equals("Autor")) {
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
            for (int i= 0; i<quantitat; ++i) {
                autors.add(G.getNom(autors1.get(i).GetF()));
            }
        } else {
            ArrayList<Pair> articles = new ArrayList<>();
            for (int j=0; j<size; ++j) {
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
            
            for (int i=0; i<articles.size(); ++i) {
                for (int j=0; j<size; ++i) {
                    if (mat[i][j] >= 0 && i != j && G.getTipusNode(j).equals("Autor")) {
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
            for (int i= 0; i<quantitat; ++i) {
                autors.add(G.getNom(autors1.get(i).GetF()));
            }
        }
        
    }
    public void obtenir_termes(ArrayList<String> termes, String nom, int quantitat, Graf_PageRank G) {
	int id = G.getID(nom);
	int[][] mat = G.getMadj();
	ArrayList<Pair> auxTermes = new ArrayList<>();

	if(G.getTipusNode(id).equals("Article")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Terme")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxTermes.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			termes.add(G.getNom(auxTermes.get(i).GetF()));
		}
	} else if(G.getTipusNode(id).equals("Autor")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Terme")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxTermes.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			termes.add(G.getNom(auxTermes.get(i).GetF()));
		}
	} else if(G.getTipusNode(id).equals("Conferencia")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Terme")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxTermes.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			termes.add(G.getNom(auxTermes.get(i).GetF()));
		}
	} else if(G.getTipusNode(id).equals("Terme")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
				for(int k = 0; k = G.size(); k++) {
					if(mat[j][k] >= && j != k && G.getTipusNode(k).equals("Terme")) {
						Pair aux = new Pair(k, mat[k][k]);
						auxTermes.add(aux);
					}
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
		for(int i = 0; i < quantitat; i++) {
			termes.add(G.getNom(auxTermes.get(i).GetF()));
		}
	}
    }
    public void obtenir_conferencies(ArrayList<String> conferencies, String nom, int quantitat, Graf_PageRank G) {
    	int id = G.getID(nom);
	int[][] mat = G.getMadj();
	ArrayList<Pair> auxConferencies = new ArrayList<>();

	if(G.getTipusNode(id).equals("Article")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Conferencia")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxConferencies.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
		}
	} else if(G.getTipusNode(id).equals("Autor")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Conferencia")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxConferencies.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
		}
	} else if(G.getTipusNode(id).equals("Terme")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Conferencia")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxConferencies.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			conferencies.add(G.getNom(auxConferencies.get(i).GetF()));
		}
	}
    }
    public void obtenir_articles(ArrayList<String> articles, String nom, int quantitat, Graf_PageRank G) {
	int id = G.getID(nom);
	int[][] mat = G.getMadj();
	ArrayList<Pair> auxArticles = new ArrayList<>();

	if(G.getTipusNode(id).equals("Conferencia")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxArticles.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			articles.add(G.getNom(auxArticles.get(i).GetF()));
		}
	} else if(G.getTipusNode(id).equals("Autor")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxArticles.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			articles.add(G.getNom(auxArticles.get(i).GetF()));
		}
	} else if(G.getTipusNode(id).equals("Terme")) {
		for(int j = 0; j < G.size(); j++) {
			if(mat[id][j] >= 0 && id != j && G.getTipusNode(j).equals("Article")) {
				Pair aux = new Pair(j, mat[j][j]);
				auxArticles.add(aux);
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
		for(int i = 0; i < quantitat; i++) {
			articles.add(G.getNom(auxArticles.get(i).GetF()));
		}
	}    	
    }
}
