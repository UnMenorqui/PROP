/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import capaDomini.consulta.Apunts;
import java.util.ArrayList;
import Utils.*;

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

    public Boolean afegirCerca() {
        return true;
    }
<<<<<<< HEAD

    public ArrayList<Apunts> consultar() {
        return Utils.cloneArrayList(LlistaConsultes);
=======
    
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
            int marca = 4;
            switch(a.getTipus()) {
                    case "Autor": marca = 1; break;
                    case "Conferencia": marca = 2; break;
                    case "Article": marca = 3; break;
            }
            p.creacio_perfil(marca, a.getNom(), G);
            System.out.print("\n");
            System.out.println("Selecciona un número de cerca o -1 per sortir");
            n = sc.nextInt();
	}
>>>>>>> Merge-Consultes-i-Main
    }

    public void esborrar() {
        LlistaConsultes = new ArrayList();
    }

    private void loadHistorial() {
<<<<<<< HEAD

=======
        LlistaConsultes = capaPersistencia.CtrlDadesHistorial.getHistorial();
        if(LlistaConsultes == null) {
            LlistaConsultes = new ArrayList<>();
            saveHistorial();
        }
    }
    
    private void saveHistorial() {
        capaPersistencia.CtrlDadesHistorial.saveHistorial(LlistaConsultes);
>>>>>>> Merge-Consultes-i-Main
    }
}
