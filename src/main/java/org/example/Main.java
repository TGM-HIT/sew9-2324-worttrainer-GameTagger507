package org.example;

/**
 * Main-Klasse zum Starten dieses Programms.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */
public class Main {
    public static void main(String[] args) {
        Worttrainer worttrainer = new Worttrainer();
        WortpaarView wortpaarView = new WortpaarView(worttrainer);
        wortpaarView.start();
    }
}
