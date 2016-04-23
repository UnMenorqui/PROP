/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;


import java.util.ArrayList;
import capaDomini.Graf.Graf_PageRank;
import capaDomini.Perfils.Perfil;
import capaDomini.Perfils.PerfilArticle;
import capaDomini.Perfils.PerfilAutor;
import capaDomini.Perfils.PerfilConf;
import java.util.Scanner;

/**
 *
 * @author rogia
 */
public class Historial {

    private ArrayList<Apunts> LlistaConsultes = new ArrayList();

    public Historial() {
        loadHistorial();
    }
    
    public int size() {
        return LlistaConsultes.size();
    }

    public void afegirCerca(Apunts cerca) {
        LlistaConsultes.add(cerca);
        saveHistorial();
    }
    
    public void consultar(Graf_PageRank G) {
	Scanner sc = new Scanner(System.in);
        System.out.println("HISTORIAL");
	for(int i = LlistaConsultes.size()-1; i >= 0; i--) {
		System.out.print(LlistaConsultes.size()-i);
		System.out.print(". ");
                Apunts aux = LlistaConsultes.get(i);
                System.out.println(aux.getNom());
	}
	System.out.print("\n");
	System.out.println("Selecciona un número de cerca o -1 per sortir");
        int n = sc.nextInt();
	while(n != -1) {
            Perfil p = new Perfil();
            Apunts a = LlistaConsultes.get(n-1);
            switch(a.getTipus()) {
                    case "Autor":
                        PerfilAutor pa = new PerfilAutor();
                        pa.crear_perfil_autor(G);
                        break;
                    case "Conferencia": 
                            PerfilConf pc = new PerfilConf();
                            pc.crear_perfil_conf(G);
                            break;
                    case "Article":
                        PerfilArticle par = new PerfilArticle();
                        par.crear_perfil_article(G);
                        break;
                    case "Terme" : 
            }
            System.out.print("\n");
            System.out.println("Selecciona un número de cerca o -1 per sortir");
            n = sc.nextInt();
	}
    }

    public void esborrar(int n) {
        LlistaConsultes.remove(n);
        saveHistorial();
    }
    
    private void loadHistorial() {
        LlistaConsultes = capaPersistencia.CtrlDadesHistorial.getHistorial();
        if(LlistaConsultes == null) {
            LlistaConsultes = new ArrayList<>();
            saveHistorial();
        }
    }
    
    private void saveHistorial() {
        capaPersistencia.CtrlDadesHistorial.saveHistorial(LlistaConsultes);
    }
}
