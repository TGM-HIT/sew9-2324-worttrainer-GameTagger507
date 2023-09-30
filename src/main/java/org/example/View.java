package org.example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class View {

    private Worttrainer worttrainer;

    public void View(Worttrainer worttrainer) {
        this.worttrainer = worttrainer;

    }

    public void start() throws MalformedURLException {

        Wortpaar currentWortpaar = worttrainer.ziehPaar();

        URL url = new URL(currentWortpaar.getBildUrl());
        ImageIcon bildIcon = new ImageIcon(url);
        JLabel bildLabel = new JLabel(bildIcon);

        String antwort = JOptionPane.showInputDialog(bildLabel);
        if (antwort == currentWortpaar.getWort()) {
            JOptionPane.showMessageDialog(null, "Richtig!");
        }
    }

}
