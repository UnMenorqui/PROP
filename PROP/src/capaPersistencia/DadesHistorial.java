/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author rogia
 */
public class DadesHistorial {
    
    public static void saveHistorial(String json, String user) {        
        try (FileWriter writer = new FileWriter("BDHistorial"+user+".json")) {
		writer.write(json);
	} catch (IOException e) {}
    }
    
    public static String getHistorial(String user) { 
        String json = "";
	try {

		BufferedReader br = new BufferedReader(
		new FileReader("BDHistorial"+user+".json"));

                json = br.readLine();
		
	} catch (IOException e) {
	}
        return json;
    }
}
