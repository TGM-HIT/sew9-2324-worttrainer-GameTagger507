package org.example;

import java.util.ArrayList;

public interface PersistanceInterface {
    public void save(String filepath, WortPaarList wortpaarList);
    public WortPaarList load(String filepath);
}
