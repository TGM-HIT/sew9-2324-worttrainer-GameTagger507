package org.example;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        Worttrainer worttrainer = new Worttrainer();
        try {
            worttrainer.start();
        } catch (MalformedURLException e) {
            System.out.println("Fehler");
            e.printStackTrace();
        }
    }
}
