package org.example;

import java.io.IOException;

/**
 * Diese Klasse ist das Interface für die Persistierung um das Strategy-Pattern zu ermöglichen.
 *
 * @author Emmanuel Akwaonu
 * @version 2023-10-18
 */

public interface PersistenceInterface {
    //Methoden zur Persistierung von den Wortpaaren
    void save(WortPaarList wortPaarList) throws IOException;
    WortPaarList load();
}
