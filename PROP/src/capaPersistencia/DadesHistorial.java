/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;

import capaDomini.consulta.Apunts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author rogia
 */
public class DadesHistorial {
    
    private static final String path = "BDHistorial.json";
    
    public static void saveHistorial(String json) {        
        try (FileWriter writer = new FileWriter(path)) {
		writer.write(json);
	} catch (IOException e) {}
    }
    
    public static void getHistorial(String json) {      
	try {

		BufferedReader br = new BufferedReader(
		new FileReader(path));

                json = br.readLine();
		
	} catch (IOException e) {
	}
    }
}
