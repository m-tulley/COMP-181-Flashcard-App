package Program;

import Controller.DeckLoader;
import Model.Card;
import Model.Deck;

public class Test {
    static Deck[] decks;
    static int numDecks = 0;

    public static void main(String[] args) {
        deckSaverTest();
        deckLoaderTest();
    }

    public static void deckSaverTest() {
        decks = new Deck[3];
        Deck deck1 = new Deck("Deck 1", 10);
        deck1.addCard(new Card("hallo", "hello"));
        deck1.addCard(new Card("rot", "red"));
        deck1.addCard(new Card("grün", "green"));
        deck1.addCard(new Card("gelb", "yellow"));
        deck1.addCard(new Card("weiß", "white"));
        deck1.addCard(new Card("blumen", "flowers"));
        deck1.addCard(new Card("Löwe", "Lion"));

        Deck deck2 = new Deck("Deck 2", 10);
        deck2.addCard(new Card("hallo", "hello"));
        deck2.addCard(new Card("rot", "red"));
        deck2.addCard(new Card("grün", "green"));
        deck2.addCard(new Card("gelb", "yellow"));
        deck2.addCard(new Card("weiß", "white"));
        deck2.addCard(new Card("blumen", "flowers"));
        deck2.addCard(new Card("Löwe", "Lion"));

        Deck deck3 = new Deck("Deck 3", 10);
        deck3.addCard(new Card("hallo", "hello"));
        deck3.addCard(new Card("rot", "red"));
        deck3.addCard(new Card("grün", "green"));
        deck3.addCard(new Card("gelb", "yellow"));
        deck3.addCard(new Card("weiß", "white"));
        deck3.addCard(new Card("blumen", "flowers"));
        deck3.addCard(new Card("Löwe", "Lion"));

        decks[0] = deck1;
        numDecks++;
        decks[1] = deck2;
        numDecks++;
        decks[2] = deck3;
        numDecks++;

        //DeckSaver.saveDecks(decks, numDecks);
    }

    public static void deckLoaderTest() {
        //decks = DeckLoader.loadDecks();
        numDecks = DeckLoader.getNumDecks();

        System.out.println(numDecks);

        for (int i = 0; i < decks.length; i++) {
            if (decks[i] == null){
                return;
            }
            decks[i].printContents();
        }
    }

}
