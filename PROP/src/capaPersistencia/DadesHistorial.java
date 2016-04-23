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
    
    public static void saveHistorial(ArrayList<Apunts> LlistaConsultes) {
        Gson gson = new Gson();
        String json = gson.toJson(LlistaConsultes);
        
        try (FileWriter writer = new FileWriter(path)) {
		writer.write(json);

	} catch (IOException e) {
		e.printStackTrace();
	}
    }
    
    private static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    
    public static ArrayList<Apunts> getHistorial() {
        Gson gson = new Gson();
        
	try {

		BufferedReader br = new BufferedReader(
		new FileReader(path));

		//convert the json string back to object
                String jsonString = br.readLine();
		ArrayList<Apunts> LlistaConsultes = (ArrayList<Apunts>) fromJson(jsonString,
                    new TypeToken<ArrayList<Apunts>>() {
                    }.getType());

                return LlistaConsultes;

	} catch (IOException e) {
                return null;
	}
    }
}
