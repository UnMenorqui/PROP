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
public class Graf_PageRank extends StubGraf {
    private final int d = 85;
    private int Mat[][];
    private final int prob_Autor, prob_Conf, prob_Article;
    private int num_Autor, num_Conf, num_Article;
    
    public Graf_PageRank() {
       Mat = getMadj();
       getnumArticle_Conferencia_Autors();
       prob_Autor = 100/num_Autor;
       prob_Conf = 100/num_Conf;
       prob_Article = 100/num_Article;
       pagerank();
    }
    
    private void pagerank() {
        for (int i=0; i<size(); ++i) {
            int prob = 0;
            if (getTipusNode(i).equals("Autor") || getTipusNode(i).equals("Conferencia")) {
                for (int j=0; j<size(); ++j) {
                    if (Mat[i][j] >= 0 && i!=j) {
                        prob += prob_Article/getNumAdj(j);
                    }
                }
                Mat[i][i] = (100-d)+d*prob;
            }
            else if (getTipusNode(i).equals("Article")) {
                for (int j=0; j<size(); ++j) {
                    if (Mat[i][j] >= 0 && i!=j) {
                        if (getTipusNode(j).equals("Autor")) {
                            prob += prob_Autor/getNumAdj(j);
                        } else if (getTipusNode(j).equals("Conferencia")) {
                            prob += prob_Conf/getNumAdj(j);
                        }
                    }
                }
                Mat[i][i] = (100-d)+d*prob;
            }
            else if (getTipusNode(i).equals("Terme")) {
                Mat[i][i] = getNumAdj(i);
            }
        }
    }
    
    private int getNumAdj(int id) {
        int numAdj = 0;
        for (int i=0; i<size(); ++i) {
            if (Mat[id][i] >= 0 && id != i) ++numAdj;
        }
        return numAdj;
    }
    
    private void getnumArticle_Conferencia_Autors() {
        for (int i=0; i<size(); ++i) {
            if (getTipusNode(i).equals("Article")) ++num_Article;
            else if (getTipusNode(i).equals("Autor")) ++num_Autor;
            else if (getTipusNode(i).equals("Conferencia")) ++num_Conf;      
        }
    }
}
