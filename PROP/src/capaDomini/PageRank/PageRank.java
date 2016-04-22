/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.PageRank;

/**
 *
 * @author Toni
 */
public class PageRank {
    int d = 85;
    
    int prob_def_autor; // probabilitat per defecte de l'autor
    int num_adj_autor[]; // vector amb número d'adjecències per cada autor
    
    
    int prob_def_conf; // probabilitat per defecte de la conferència
    int num_adj_conf[]; // vector amb número d'adjecències per cada conf.
    
    
    int prob_def_article; // probabilitat per defecte de l'article
    int num_adj_article[]; // vector amb número d'adjecències per cada article
    
    int num_adj_terme; //Popularitat.
    
    
    
    
    public void rank_articles(int d, int prob_def_autor, int prob_def_conf, int num_adj_autor[], int num_adj_conf[]) {
        
    }
    
    public void rank_conferencies(int d, int prob_def_article, int num_adj_article[]) {
        
    }
    
    public void rank_autor(int d, int prob_def_article, int num_adj_article[]) {
        
    }
    
    public void rank_terme(int d, int num_adj_terme) {
        
    }
}
