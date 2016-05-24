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
    
    public static void saveHistorial(ArrayList<Integer> id, ArrayList<String> noms, ArrayList<String> tipus) {
        Gson gson = new Gson();
        String json = gson.toJson(id);
        String json1 = gson.toJson(noms);
        String json2 = gson.toJson(tipus);
        
        
        try (FileWriter writer = new FileWriter(path)) {
		writer.write(json);
                writer.write(json1);
                writer.write(json2);

	} catch (IOException e) {
		e.printStackTrace();
	}
    }
    
    private static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    
    public static void getHistorial(ArrayList<Integer> id, ArrayList<String> noms, ArrayList<String> tipus) {
        Gson gson = new Gson();
        
	try {

		BufferedReader br = new BufferedReader(new FileReader(path));

		//convert the json string back to object
                String jsonString = br.readLine();
		id = (ArrayList<Integer>) fromJson(jsonString,
                    new TypeToken<ArrayList<Integer>>() {
                    }.getType());
                jsonString =br.readLine();
                noms = (ArrayList<String>) fromJson(jsonString,
                    new TypeToken<ArrayList<String>>() {
                    }.getType());
                jsonString = br.readLine();
                tipus = (ArrayList<String>) fromJson(jsonString,
                    new TypeToken<ArrayList<String>>() {
                    }.getType());
                
                
                

	} catch (IOException e) {}
    }
}
