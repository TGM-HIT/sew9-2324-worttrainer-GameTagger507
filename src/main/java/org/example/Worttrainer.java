package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Diese Klasse ist für die Verwaltung der Wortpaare.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */

public class Worttrainer implements PersistanceInterface{

    private int counter = 0;

    //Konstruktor, der alle Wortpaare in eine Liste verfasst
    public Worttrainer() {
        WortPaarList wortPaarList = new WortPaarList();
        save("wortpaare.json", wortPaarList);
    }

    //Methode zur Überprüfung, ob die Wortpaar-Liste leer ist
    public boolean isMapEmpty() {
        WortPaarList wortPaarList = load("wortpaare.json");
        return wortPaarList.isEmpty();
    }

    //Methode für das Mischen der Wortpaar-Liste
    public void shufflePaare() {

        WortPaarList wortPaarList = load("wortpaare.json");
        ArrayList<Wortpaar> wortpaare = wortPaarList.getWortpaare();

        Collections.shuffle(wortpaare);

        save("wortpaare.json", wortPaarList);
    }

    //Methode zum "Ziehen" eines Wortpaares
    public Wortpaar ziehPaar() {

        if(isMapEmpty()) {
            throw new RuntimeException("Die Wortpaar-Sammlung ist leer.");
        }

        WortPaarList wortPaarList = load("wortpaare.json");
        ArrayList<Wortpaar>  wortpaare = wortPaarList.getWortpaare();
        Wortpaar wortpaar = wortpaare.get(counter);
        counter++;
        return wortpaar;

    }

    //Methode zum "Ziehen" eines bestimmten Wortpaares
    public Wortpaar ziehPaar(int index) {

        WortPaarList wortPaarList = load("wortpaare.json");
        ArrayList<Wortpaar> wortpaare = wortPaarList.getWortpaare();

        return wortpaare.get(counter);
    }

    //Methode zur Persistierung von den Wortpaaren
    @Override
    public void save(String filepath, WortPaarList wortPaarList) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filepath), wortPaarList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Methode zum Laden von persistierten Wortpaaren
    @Override
    public WortPaarList load(String filepath) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                File file = new File("wortpaarlist.json");
                if (file.exists()) {
                    // Deserialize JSON data from the file into an ArrayList of Wortpaar
                    return objectMapper.readValue(file, WortPaarList.class);
                } else {
                    // Handle the case where the file doesn't exist or is empty
                    throw new Exception("Laden ist falsch gelaufen");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }
}