package org.example;

import java.util.ArrayList;

public class WortPaarList {

    private ArrayList<Wortpaar> wortpaare = new ArrayList<Wortpaar>();
    int richtigCounter;
    int allgemeinCounter;

    public WortPaarList() {

        this.wortpaare.add(new Wortpaar("Hund",  "https://img.freepik.com/free-vector/beagle-dog-cartoon-white-background_1308-75491.jpg?w=200"));
        this.wortpaare.add(new Wortpaar("Katze", "https://img.freepik.com/free-vector/sticker-template-cat-cartoon-character_1308-73047.jpg?w=200&t=st=1696107410~exp=1696108010~hmac=9021cad7ca1acbc07042cd0fa3e4cf8568e70819b0dba9724795d0e21dda8f3a"));
        this.wortpaare.add(new Wortpaar("Kamel", "https://img.freepik.com/free-vector/sticker-template-camel-cartoon-character_1308-70095.jpg?w=200&t=st=1696107521~exp=1696108121~hmac=671113e1e60e7c92639aad2ff1bb06ff67541edcbc061c2223802af9bfafc8cf"));
        this.wortpaare.add(new Wortpaar("Fuchs", "https://img.freepik.com/free-vector/collection-hand-drawn-foxes_52683-20536.jpg?w=200&t=st=1700665999~exp=1700666599~hmac=53c5c5622da006210539990b4e45ccddd0de5700ef4cc6375fa1e34c81ec0ee6"));
        this.wortpaare.add(new Wortpaar("Pferd", "https://img.freepik.com/premium-vector/standing-horse_150357-7.jpg?w=200"));
        this.wortpaare.add(new Wortpaar("Nashorn", "https://img.freepik.com/free-vector/coloured-rhino-design_1152-63.jpg?size=200"));
        this.wortpaare.add(new Wortpaar("Tiger", "https://img.freepik.com/free-vector/cute-tiger-jumping-cartoon-vector-icon-illustration-animal-nature-icon-concept-isolated-vector_138676-4382.jpg?w=740"));

        richtigCounter = 0;
        allgemeinCounter = 0;

    }

    public ArrayList<Wortpaar> getWortpaare() {
        return wortpaare;
    }

    public boolean isEmpty() {
        return this.wortpaare.isEmpty();
    }

    public void incRichtigCounter() {
        this.richtigCounter++;
    }

    public void incAllgemeinCounter() {
        this.allgemeinCounter++;
    }

}
