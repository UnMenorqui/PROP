/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPersistencia;

import capaDomini.Apunts;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    public static ArrayList<Apunts> getHistorial() {
        Gson gson = new Gson();

	try {

		BufferedReader br = new BufferedReader(
		new FileReader(path));

		//convert the json string back to object
		ArrayList<Apunts> LlistaConsultes = gson.fromJson(br, ArrayList.class);

                return LlistaConsultes;

	} catch (IOException e) {
                return null;
	}
    }
}
