/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia.BD;

import java.util.ArrayList;


public class CtrlBaseDades {
    
    public void load_autor(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_autor(id,noms);
    }
    public void load_conf(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_conf(id,noms);
    }
    public void load_paper(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_paper(id,noms);
    }
    public void load_terme(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.load_terme(id,noms);
    }
    
    public void load_pa(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.load_pa(id,id1);
    }
    
    public void load_pc(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.load_pc(id,id1);
    }
    
    public void load_pt(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.load_pt(id,id1);
    }
    
    public void saveAutor(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.saveAutor(id,noms);
    }
    
    public void saveConf(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.saveConf(id,noms);
    }
    
    public void saveArticle(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.saveArticle(id,noms);
    }
    
    public void saveTerme(ArrayList<Integer> id, ArrayList<String> noms) {
        BaseDades.saveTerme(id,noms);
    }
    
    public void savepa(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.savepa(id,id1);
    }
    
    public void savept(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.savept(id,id1);
    }
    
    public void savepc(ArrayList<Integer> id, ArrayList<Integer> id1) {
        BaseDades.savepc(id,id1);
    }
    
}
