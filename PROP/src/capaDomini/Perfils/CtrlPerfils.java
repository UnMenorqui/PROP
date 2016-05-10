/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Perfils;

import capaDomini.Graf.Graf;

/**
 *
 * @author aleixabrieprat
 */

public class CtrlPerfils {
    
    public CtrlPerfils() {
        
    }
    
    public void crear_perfil_autor(String entitat, int articles, int co_autors, int termes, int conferencies, Graf G,boolean usuaris)
    {
        PerfilAutor p_autor = new PerfilAutor();
        p_autor.set_name(entitat);
        p_autor.set_quantitat_articles(articles);
        p_autor.set_quantitat_autors(co_autors);
        p_autor.set_quantitat_termes(termes);
        p_autor.set_quantitat_conf(conferencies);
        p_autor.crear_perfil_autor(G,usuaris);
    }
    public void crear_perfil_terme(String entitat, int articles, int autors, int conferencies, Graf G, boolean usuaris) 
    {
        PerfilTerme p_terme = new PerfilTerme();
        p_terme.set_name(entitat);
        p_terme.set_quantitat_articles(articles);
        p_terme.set_quantitat_autors(autors);
        p_terme.set_quantitat_conf(conferencies);
        p_terme.crear_perfil_terme(G,usuaris);
    }
    public void crear_perfil_conferencia(String entitat, int articles, int autors, int termes, Graf G, boolean usuaris) 
    {
        PerfilConf p_conf = new PerfilConf();
        p_conf.set_name(entitat);
        p_conf.set_quantitat_articles(articles);
        p_conf.set_quantitat_autors(autors);
        p_conf.set_quantitat_termes(termes);
        p_conf.crear_perfil_conf(G,usuaris);
        
    }
    public void crear_perfil_article(String entitat, int autors, int termes, int conferencies, Graf G, boolean usuaris) 
    {
        PerfilArticle p_art = new PerfilArticle();
        p_art.set_name(entitat);
        p_art.set_quantitat_autors(autors);
        p_art.set_quantitat_conf(conferencies);
        p_art.set_quantitat_termes(termes);
        p_art.crear_perfil_article(G,usuaris);
    }  
}
