package org.example;

public class Controller {

    private Worttrainer worttrainer;
    private WortpaarView wortpaarView;

    Controller(Worttrainer worttrainer, WortpaarView wortpaarView) {
        this.worttrainer = worttrainer;
        this.wortpaarView = wortpaarView;
    }

    public Wortpaar ziehPaar() {
        return this.worttrainer.ziehPaar();
    }

    public boolean isMapEmpty() {
        return this.worttrainer.isMapEmpty();
    }
}
