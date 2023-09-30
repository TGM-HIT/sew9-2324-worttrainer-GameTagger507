package org.example;

public class Wortpaar{
    private final String wort;
    private final String bildUrl;

    public Wortpaar(String wort, String bildUrl) {
        this.wort = wort;
        this.bildUrl = bildUrl;
    }

    String getBildUrl() {
        return this.bildUrl;
    }
    String getWort() {
        return this.wort;
    }

}
