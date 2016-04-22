package capaDomini.consulta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aleixabrieprat
 */
public class Consulta {
    
    public void cerca_tipus(String nom,double id, String tipus) {
        id = 100.;
        tipus = "autor";
    }
    
    
    public void obtenir_autors(ArrayList<String> autors, String nom, int quantitat) {
        double id = 0;
        String tipus = null;
        cerca_tipus(nom,id,tipus);
        
        
    }
    public void obtenir_termes(ArrayList<String> termes, String nom, int quantitat) {
    }
    public void obtenir_conferencies(ArrayList<String> conferencies, String nom, int quantitat) {
    }
    public void obtenir_articles(ArrayList<String> articles, String nom, int quantitat) {
    }
}
