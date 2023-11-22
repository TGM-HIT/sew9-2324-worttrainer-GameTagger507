package org.example;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Diese Klasse ist für die Verwaltung der Wortpaare.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */

public class Worttrainer {

    private int counter = 0;
    WortPaarList wortPaarList = new WortPaarList();
    JsonPersistence jsonPersistence = new JsonPersistence();

    //Konstruktor, der alle Wortpaare in eine Liste verfasst
    public Worttrainer() {
        try {
            jsonPersistence.save(wortPaarList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Methode zur Überprüfung, ob die Wortpaar-Liste leer ist
    public boolean isMapEmpty() {
        WortPaarList wortPaarList = jsonPersistence.load();
        return wortPaarList.isEmpty();
    }

    //Methode für das Mischen der Wortpaar-Liste
    public void shufflePaare() {

        WortPaarList wortPaarList = jsonPersistence.load();
        ArrayList<Wortpaar> wortpaare = wortPaarList.getWortpaare();

        Collections.shuffle(wortpaare);

        try {
            jsonPersistence.save(wortPaarList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Methode zum "Ziehen" eines Wortpaares
    public Wortpaar ziehPaar() {

        if(isMapEmpty()) {
            throw new RuntimeException("Die Wortpaar-Sammlung ist leer.");
        }

        WortPaarList wortPaarList = jsonPersistence.load();
        ArrayList<Wortpaar>  wortpaare = wortPaarList.getWortpaare();
        Wortpaar wortpaar = wortpaare.get(counter);
        counter++;
        return wortpaar;

    }

    //Methode zum "Ziehen" eines bestimmten Wortpaares
    public Wortpaar ziehPaar(int index) {

        WortPaarList wortPaarList = jsonPersistence.load();
        ArrayList<Wortpaar> wortpaare = wortPaarList.getWortpaare();

        return wortpaare.get(index);
    }

    //Methode zur Persistierung von den Wortpaaren

}   