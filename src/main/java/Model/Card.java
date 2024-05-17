

package Model;

public class Card {
    private String front;
    private String back;
    private String tag;

    public Card(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public void setFront(String word) {
        this.front = word;
    }

    public void setBack(String word) {
        this.back = word;
    }

    public void setSide(String word, String side) {
        if (side.equals("front")) {
            this.front = word;
        } else if (side.equals("back")) {
            this.back = word;
        }
    }

    public String getBack() {
        return this.back;
    }

    public String getFront() {
        return this.front;
    }

}