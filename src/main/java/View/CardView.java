package View;

import Controller.DeckSaver;
import Model.Card;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static Program.ProgramGUI.deckView;
import static Program.ProgramGUI.decks;
import static View.DeckView.currDeck;

public class CardView extends HBox {
    public static Card currCard;
    public static String currSide;
    public static int currCardIndex;

    boolean editing = false;

    Card emptyCard = new Card("Deck is empty", "Deck is empty");

    Label label;
    TextField editCard;

    public CardView() {
        currCard = currDeck.getCard(0);
        currSide = "front";
        currCardIndex = 0;

        label = new Label(currCard.getFront());
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(40));
        label.setOnMouseClicked(e -> {
            editing = true;
            editCard = new TextField(label.getText());
            editCard.setAlignment(Pos.CENTER);
            editCard.setFont(new Font(40));
            this.getChildren().remove(label);
            this.getChildren().add(editCard);
            editCard.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    String editedSide = editCard.getText();
                    label.setText(editCard.getText());
                    this.getChildren().remove(editCard);
                    this.getChildren().add(label);
                    currDeck.getCard(currCardIndex).setSide(editedSide, this.currSide);
                    DeckSaver.saveDecks(decks);
                    deckView.reload();
                    editing = false;
                }
            });
        });

        this.getChildren().add(label);
        this.setOnMouseClicked(e -> {
            if (!editing) {
                switchSides();
            }
        });

        this.setAlignment(Pos.CENTER);
        this.setBorder(new Border(new BorderStroke
                (Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))
        );
    }

    public void setToFirstCard() {
        if (currDeck.size() == 0) {
            this.currCard = emptyCard;
            this.currCardIndex = -1;
            currSide = "front";
            draw();
        } else {
            currCardIndex = 0;
            currCard = currDeck.getCard(currCardIndex);
            currSide = "front";
            draw();
        }
    }

    public void moveRight() {
        currCardIndex++;
        currCard = currDeck.getCard(currCardIndex);
        currSide = "front";
        draw();
    }

    public void moveLeft() {
        currCardIndex--;
        currCard = currDeck.getCard(currCardIndex);
        currSide = "front";
        draw();
    }

    private void switchSides() {
        if (currSide.equals("front")) {
            currSide = "back";
        } else if (currSide.equals("back")) {
            currSide = "front";
        }
        draw();
    }

    private void draw() {
        if (currSide.equals("front")) {
            label.setText(currCard.getFront());
        } else if (currSide.equals("back")) {
            label.setText(currCard.getBack());
        }
    }

}
