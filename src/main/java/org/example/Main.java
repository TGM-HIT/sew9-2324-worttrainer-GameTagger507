package org.example;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        Worttrainer worttrainer = new Worttrainer();
        WortpaarView wortpaarView = new WortpaarView(worttrainer);
        try {
            wortpaarView.start();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
