/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.consulta;

import capaDomini.consulta.Apunts;
import java.util.ArrayList;
import capaDomini.Graf.Graf_PageRank;
import capaDomini.Perfils.Perfil;
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

    public void afegirCerca(Apunts cerca) {
        LlistaConsultes.add(cerca);
        saveHistorial();
    }

    public void consultar(Graf_PageRank G) {
	Scanner sc = new Scanner(System.in);
        System.out.println("HISTORIAL");
	for(int i = LlistaConsultes.size()-1; i >= 0; i--) {
		System.out.print(LlistaConsultes.size()-i);
		System.out.println(". " + LlistaConsultes.get(i).getNom());
	}
	System.out.print("\n");
	System.out.println("Selecciona un número de cerca o -1 per sortir");
        int n = sc.nextInt();
	while(n != -1) {
            Perfil p = new Perfil();
            Apunts a = LlistaConsultes.get(LlistaConsultes.size()-n);
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
    }

    public void esborrar(int n) {
        LlistaConsultes.remove(n);
        saveHistorial();
    }
    
    private void loadHistorial() {
        LlistaConsultes = capaPersistencia.CtrlDadesHistorial.getHistorial();
    }
    
    private void saveHistorial() {
        capaPersistencia.CtrlDadesHistorial.saveHistorial(LlistaConsultes);
    }
}
