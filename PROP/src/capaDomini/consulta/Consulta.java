package capaDomini.consulta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aleixabrieprat
 */
public class Consulta {
    
    
    /*
        El primer Integer de cada map correspon a l'identificador de
        cada autor,conferència,terme o article.
    
        El segon Integer de cada map correspon a la prioritat de cada
        un dels autors,conferències, termes o articles.
    
        La prioritat ens serivirà per a buscar la informació més important.
        Aquesta, és la quantitat d'adjacències del node + cops consultat.
    
    */
    
    
    Map<Integer, Integer> Map_autors = new HashMap<>();
    
    Map<Integer, Integer> Map_conf = new HashMap<>();
    
    Map<Integer, Integer> Map_terme = new HashMap<>();
    
    Map<Integer, Integer> Map_article = new HashMap<>();
    
    
    private void omplir_map_autors() {
        
    }
    
    private void omplir_map_conferencies() {
        
    }
    
    private void omplir_map_terme() {
        
    }
    
    private void omplir_map_article() {
        
    }
    
    
    
    
    public void obtenir_autors(ArrayList<String> autors, String nom, int quantitat) {
    }
    public void obtenir_termes(ArrayList<String> autors, String nom, int quantitat) {
    }
    public void obtenir_conferencies(ArrayList<String> autors, String nom, int quantitat) {
    }
    public void obtenir_articles(ArrayList<String> autors, String nom, int quantitat) {
    }
}
