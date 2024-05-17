package Model;

public class Deck {
    private Card[] cards;
    private int size;
    private String name;

    public Deck(){

    }

    public Deck(String name, int initialLength) {
        this.cards = new Card[initialLength];
        this.name = name;
    }

    public Deck(String name, int initialLength, Card[] cards) {
        this.cards = cards;
        this.name = name;
        this.cards = new Card[initialLength];
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card[] getCards() {
        return this.cards;
    }

    public String getName() {
        return this.name;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public void setCard(int index, Card card) {
        this.cards[index] = card;
    }

    public int size() {
        return this.size;
    }

    public Card getCard(int index) {
        return this.cards[index];
    }

    public void addCard(Card card) {
        if (this.cards.length == this.size) {
            resize();
        }
        this.cards[size] = card;
        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < cards.length) {
            for (int i = index; i < cards.length-1; i++) {
                cards[i] = cards[i+1];
            }
            cards[cards.length-1] = null;
        }
        size--;
    }

    private void resize() {
        Card[] temp = new Card[this.size + 10];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.cards[i];
        }
        cards = temp;
    }

    public void insert(int index, Card card) {
        if (index >= 0 && index < cards.length + 1) {
            if (this.cards.length == this.size) {
                resize();
            }
            for (int i = this.size - 1; i >= index; i--) {
                cards[i + 1] = cards[i];
            }
            cards[index] = card;
            size++;
        }
    }

    public void printContents() {
        System.out.println(this.name);
        for (int i = 0; i < this.size; i++) {
            System.out.println(cards[i].getFront());
            System.out.println(cards[i].getBack());
        }
    }

}
