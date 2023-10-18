package org.example;

import java.util.ArrayList;

public class WortPaarList {

    private ArrayList<Wortpaar> wortpaare;

    public WortPaarList() {
        wortpaare.add(new Wortpaar("Hund",  "https://img.freepik.com/free-vector/beagle-dog-cartoon-white-background_1308-75491.jpg?w=200"));
        wortpaare.add(new Wortpaar("Katze", "https://img.freepik.com/free-vector/sticker-template-cat-cartoon-character_1308-73047.jpg?w=200&t=st=1696107410~exp=1696108010~hmac=9021cad7ca1acbc07042cd0fa3e4cf8568e70819b0dba9724795d0e21dda8f3a"));
        wortpaare.add(new Wortpaar("Kamel", "https://img.freepik.com/free-vector/sticker-template-camel-cartoon-character_1308-70095.jpg?w=200&t=st=1696107521~exp=1696108121~hmac=671113e1e60e7c92639aad2ff1bb06ff67541edcbc061c2223802af9bfafc8cf"));
        wortpaare.add(new Wortpaar("Pferd", "https://img.freepik.com/premium-vector/standing-horse_150357-7.jpg?w=200"));
    }

    public ArrayList<Wortpaar> getWortpaare() {
        return wortpaare;
    }

    public void setWortpaare(ArrayList<Wortpaar> wortpaare) {
        this.wortpaare = wortpaare;
    }

    public boolean isEmpty() {
        return this.wortpaare.isEmpty();
    }
}
