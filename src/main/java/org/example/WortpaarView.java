package org.example;

import javax.swing.*;

/**
 * Diese Klasse ist völlig zuständig für das Userinterface.
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */
public class WortpaarView {

    private Worttrainer worttrainer;

    //Konstruktor
    public WortpaarView(Worttrainer worttrainer) {
        this.worttrainer = worttrainer;
    }

    //Die Methode zum Starten des GUI
    public void start()  {


        int response = JOptionPane.showConfirmDialog(
                null,
                "Zufällig oder bestimmtes Paar ziehen?",
                "Zufällig oder nicht?",
                JOptionPane.YES_NO_OPTION
        );

        WortPaarList wortPaarList = worttrainer.ziehWortPaarList(); //Für das Persistieren von der Statistik

        if (response == JOptionPane.YES_OPTION) {

            worttrainer.shufflePaare();

            while (!worttrainer.isMapEmpty()) {
                Wortpaar currentWortpaar = worttrainer.ziehPaar();


                ImageIcon bildIcon = new ImageIcon(currentWortpaar.getBildUrl());
                JLabel bildLabel = new JLabel(bildIcon);

                String antwort = JOptionPane.showInputDialog(bildLabel);

                wortPaarList.incAllgemeinCounter();

                if (antwort.equals(currentWortpaar.getWort())) {
                    wortPaarList.incRichtigCounter();
                    JOptionPane.showMessageDialog(null, "Richtig!\nBis jetzt hast du " +
                            wortPaarList.richtigCounter + " von " + wortPaarList.allgemeinCounter + " richtig.");
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch!\nBis jetzt hast du " +
                            wortPaarList.richtigCounter + " von " + wortPaarList.allgemeinCounter + " richtig.");
                }

                worttrainer.saveStand();

            }

        } else if (response == JOptionPane.NO_OPTION) {

            boolean wiederholung = true;

            while(wiederholung) {

                wiederholung = false;

                int antwort1 = Integer.parseInt(JOptionPane.showInputDialog("Wähle einen Index aus für ein Wortpaar"));

                Wortpaar currentWortpaar = worttrainer.ziehPaar(antwort1);

                wortPaarList.incAllgemeinCounter();

                ImageIcon bildIcon = new ImageIcon(currentWortpaar.getBildUrl());
                JLabel bildLabel = new JLabel(bildIcon);

                String antwort = JOptionPane.showInputDialog(bildLabel);

                if (antwort.equals(currentWortpaar.getWort())) {
                    wortPaarList.incRichtigCounter();
                    JOptionPane.showMessageDialog(null, "Richtig!\nBis jetzt hast du " +
                            wortPaarList.richtigCounter + " von " + wortPaarList.allgemeinCounter + " richtig.");
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch!\nBis jetzt hast du " +
                            wortPaarList.richtigCounter + " von " + wortPaarList.allgemeinCounter + " richtig.");
                }

                worttrainer.saveStand();

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