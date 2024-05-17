package Controller;

import Model.Card;
import Model.Deck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeckLoader {
    static File file;
    static FileInputStream fis;
    static ArrayList<Deck> decks;
    static Scanner scnr;
    static int numDecks;

    public static ArrayList<Deck> loadDecks() {
        decks = new ArrayList<>(0);
        file = new File("src/main/resources/saves/decks.txt");
        numDecks = 0;

        try {
            fis = new FileInputStream(file);
            scnr = new Scanner(fis);

            int count = 0;

            while (scnr.hasNext()) {
                String next = scnr.nextLine();

                if (next.isEmpty()) {
                    count = 0;
                    continue;
                }
                if (count == 0) {
                    decks.add(numDecks, new Deck(next, 10));
                    numDecks++;
                } else {
                    decks.get(numDecks-1).addCard(new Card(next, scnr.nextLine()));
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return decks;
    }

    public static int getNumDecks() {
        return numDecks;
    }

}
