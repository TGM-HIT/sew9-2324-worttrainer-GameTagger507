package org.example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WortpaarView {

    private Worttrainer worttrainer;

    public WortpaarView(Worttrainer worttrainer) {
        this.worttrainer = worttrainer;
    }

    public void start() throws MalformedURLException {

        int richtigCounter = 0;
        int paarCounter = 0;

        int response = JOptionPane.showConfirmDialog(
                null,
                "Zufällig oder bestimmtes Paar ziehen?",
                "Zufällig oder nicht?",
                JOptionPane.YES_NO_OPTION
        );

        if (response == JOptionPane.YES_OPTION) {

            worttrainer.shufflePaare();

            while (!worttrainer.isMapEmpty()) {
                Wortpaar currentWortpaar = worttrainer.ziehPaar();

                paarCounter++;

                URL url = new URL(currentWortpaar.getBildUrl());
                ImageIcon bildIcon = new ImageIcon(url);
                JLabel bildLabel = new JLabel(bildIcon);

                String antwort = JOptionPane.showInputDialog(bildLabel);

                if (antwort.equals(currentWortpaar.getWort())) {
                    richtigCounter++;
                    JOptionPane.showMessageDialog(null, "Richtig!\nBis jetzt hast du " +
                            richtigCounter + " von " + paarCounter + " richtig.");
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch!\nBis jetzt hast du " +
                            richtigCounter + " von " + paarCounter + " richtig.");
                }
            }

        } else if (response == JOptionPane.NO_OPTION) {

            boolean wiederholung = true;

            while(wiederholung) {

                wiederholung = false;

                int antwort1 = Integer.parseInt(JOptionPane.showInputDialog("Wähle einen Index aus für ein Wortpaar"));


                Wortpaar currentWortpaar = worttrainer.ziehPaar(antwort1);

                paarCounter++;

                URL url = new URL(currentWortpaar.getBildUrl());
                ImageIcon bildIcon = new ImageIcon(url);
                JLabel bildLabel = new JLabel(bildIcon);

                String antwort = JOptionPane.showInputDialog(bildLabel);

                if (antwort.equals(currentWortpaar.getWort())) {
                    richtigCounter++;
                    JOptionPane.showMessageDialog(null, "Richtig!\nBis jetzt hast du " +
                            richtigCounter + " von " + paarCounter + " richtig.");
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch!\nBis jetzt hast du " +
                            richtigCounter + " von " + paarCounter + " richtig.");
                }

                int responseNochmal = JOptionPane.showConfirmDialog(
                        null,
                        "Willst du nochmal ziehen?",
                        "Willst du nochmal ziehen?",
                        JOptionPane.YES_NO_OPTION
                );

                if(responseNochmal == JOptionPane.YES_OPTION) {
                    wiederholung = true;
                }

            }
        }
    }
}