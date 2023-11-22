package org.example;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Diese Klasse ist eine Klasse für die JSON-Persistierung.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */

public class JsonPersistence implements PersistenceInterface{
    @Override
    public void save(WortPaarList wortPaarList) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter fileWriter = new FileWriter("wortpaare.json")){
            gson.toJson(wortPaarList,fileWriter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
        public WortPaarList load() {
        Gson gson = new Gson();
        try(FileReader fileReader = new FileReader("wortpaare.json")){
            return gson.fromJson(fileReader, WortPaarList.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
