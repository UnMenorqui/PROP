/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Graf;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Toni
 */
public class DriverGraf {
    
    private Map<Integer,Double> node = new HashMap<Integer,Double>();
    
    private Map<Integer, Map<Integer,Double> > Matriu = new HashMap<Integer, Map<Integer,Double>>();
    
    public void main (String args[]) {
        node.put(100, 1.0);
        node.put(101,1.0);
        node.put(70, 1.0);
        node.put(51,1.0);
        node.put(102,0.0);
        node.put(103,0.0);
        node.put(52,0.0);
        node.put(104,0.0);
        node.put(72,0.0);
        node.put(71,0.0);
        Matriu.put(1, node);
        
        
        node.clear();
        node.put(100, 0.0);
        node.put(101,0.0);
        node.put(70, 0.0);
        node.put(51,1.0);
        node.put(102,1.0);
        node.put(103,0.0);
        node.put(52,0.0);
        node.put(104,0.0);
        node.put(72,0.0);
        node.put(71,1.0);
        Matriu.put(2, node);
        
        
        node.clear();
        node.put(100, 1.0);
        node.put(101,0.0);
        node.put(70, 0.0);
        node.put(51,0.0);
        node.put(102,0.0);
        node.put(103,1.0);
        node.put(52,1.0);
        node.put(104,1.0);
        node.put(72,1.0);
        node.put(71,0.0);
        Matriu.put(3, node);
        
        
        
        
    }
    
}