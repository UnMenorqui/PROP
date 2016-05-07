/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;

/**
 *
 * @author aleixabrieprat
 */
public class Graf_PageRank extends subGraf {
    private final int d = 85;
    private final int prob_Autor, prob_Conf, prob_Article;
    private int num_Autor, num_Conf, num_Article;
    
    public Graf_PageRank() {
       num_Autor = getnumAutors();
       num_Conf = getnumConf();
       num_Article = getnumArticles();
       prob_Autor = 100/num_Autor;
       prob_Conf = 100/num_Conf;
       prob_Article = 100/num_Article;
       pagerank();
    }
    
    private void pagerank() {
        for (int i=0; i<=num_Article; ++i) {
            int prob = 0;
            if (getTipusNode(i).equals("Autor") || getTipusNode(i).equals("Conferencia")) {
                for (int j=0; j<size(); ++j) {
                    if (adj[i][j] >= 0 && i!=j) {
                        prob += prob_Article/getNumAdj(j);
                    }
                }
                adj[i][i] = (100-d)+d*prob;
            }
            else if (getTipusNode(i).equals("Article")) {
                for (int j=0; j<size(); ++j) {
                    if (adj[i][j] >= 0 && i!=j) {
                        if (getTipusNode(j).equals("Autor")) {
                            prob += prob_Autor/getNumAdj(j);
                        } else if (getTipusNode(j).equals("Conferencia")) {
                            prob += prob_Conf/getNumAdj(j);
                        }
                    }
                }
                adj[i][i] = (100-d)+d*prob;
            }
            else if (getTipusNode(i).equals("Terme")) {
                adj[i][i] = getNumAdj(i);
            }
        }
    }
    
    private int getNumAdj(int id) {
        int numAdj = 0;
        for (int i=0; i<size(); ++i) {
            if (adj[id][i] >= 0 && id != i) ++numAdj;
        }
        return numAdj;
    }
    
}
