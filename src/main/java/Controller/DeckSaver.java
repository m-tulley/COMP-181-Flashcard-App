package Controller;

import Model.Deck;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DeckSaver {
    static FileOutputStream fos;
    static PrintWriter pw;

    public static void saveDecks(ArrayList<Deck> decks) {
        if (decks == null) {
            System.out.println("Saving Failed: No decks to save");
            return;
        } try {
            fos = new FileOutputStream("src/main/resources/saves/decks.txt");
            pw = new PrintWriter(fos);

            for (Deck deck : decks) {
                pw.println(deck.getName());

                for (int j = 0; j < deck.size(); j++) {
                    String cardInfo = deck.getCard(j).getFront() +
                            "\n" + deck.getCard(j).getBack();
                    pw.write(cardInfo);
                    pw.println();
                }

                pw.println();
                pw.flush();
            }

            pw.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(-1);
        }
    }
}
