package org.example;

import java.io.File;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Diese Klasse ist für die Verwaltung der Wortpaare.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */

public class Worttrainer {

    private int counter = 0;

    //Konstruktor, der alle Wortpaare in eine Liste verfasst
    public Worttrainer() {

        ArrayList<Wortpaar> wortpaare = new ArrayList<>();
        wortpaare.add(new Wortpaar("Hund",  "https://img.freepik.com/free-vector/beagle-dog-cartoon-white-background_1308-75491.jpg?w=200"));
        wortpaare.add(new Wortpaar("Katze", "https://img.freepik.com/free-vector/sticker-template-cat-cartoon-character_1308-73047.jpg?w=200&t=st=1696107410~exp=1696108010~hmac=9021cad7ca1acbc07042cd0fa3e4cf8568e70819b0dba9724795d0e21dda8f3a"));
        wortpaare.add(new Wortpaar("Kamel", "https://img.freepik.com/free-vector/sticker-template-camel-cartoon-character_1308-70095.jpg?w=200&t=st=1696107521~exp=1696108121~hmac=671113e1e60e7c92639aad2ff1bb06ff67541edcbc061c2223802af9bfafc8cf"));
        wortpaare.add(new Wortpaar("Pferd", "https://img.freepik.com/premium-vector/standing-horse_150357-7.jpg?w=200"));

        writePaare(wortpaare);
    }

    //Methode zur Persistierung von einem Wortpaar
    public void writePaare(ArrayList<Wortpaar> wortpaare) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("wortpaare.json"), wortpaare);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Methode zur Überprüfung, ob die Wortpaar-Liste leer ist
    public boolean isMapEmpty() {
        ArrayList<Wortpaar> loadedPaare = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            loadedPaare = objectMapper.readValue(new File("wortpaare.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Wortpaar.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loadedPaare.isEmpty();
    }

    //Methode für das Mischen der Wortpaar-Liste
    public void shufflePaare() {

        ArrayList<Wortpaar> loadedPaare = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            loadedPaare = objectMapper.readValue(new File("wortpaare.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Wortpaar.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.shuffle(loadedPaare);

        writePaare(loadedPaare);
    }

    //Methode zum "Ziehen" eines Wortpaares
    public Wortpaar ziehPaar() {

        if(isMapEmpty()) {
            throw new RuntimeException("Die Wortpaar-Sammlung ist leer.");
        }

        ArrayList<Wortpaar> loadedPaare = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            loadedPaare = objectMapper.readValue(new File("wortpaare.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Wortpaar.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Wortpaar wortpaar = loadedPaare.get(counter);
        counter++;
        return wortpaar;

    }

    //Methode zum "Ziehen" eines bestimmten Wortpaares
    public Wortpaar ziehPaar(int index) {

        ArrayList<Wortpaar> loadedPaare = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            loadedPaare = objectMapper.readValue(new File("wortpaare.json"), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Wortpaar.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loadedPaare.get(counter);
    }

}