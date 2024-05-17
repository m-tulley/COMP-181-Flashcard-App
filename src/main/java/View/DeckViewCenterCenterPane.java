package View;

import Program.ProgramGUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import static Program.ProgramGUI.decks;
import static View.DeckView.currDeck;

public class DeckViewCenterCenterPane extends BorderPane {
    HBox top;
    HBox bottom;
    HBox left;
    HBox right;

    CardView cardView;

    Label deckName;
    Label cardCount;
    Button leftArrowButton;
    Button rightArrowButton;

    public DeckViewCenterCenterPane() {
        initCenter();
        initTop();
        initBottom();
        initLeft();
        initRight();
    }

    private void initCenter() {
        cardView = new CardView();
        this.setCenter(cardView);
    }

    private void initTop() {
        deckName = new Label(decks.getFirst().getName());
        deckName.setFont(new Font(30));
        top = new HBox(deckName);
        top.setPadding(new Insets(10, 10, 10, 10));
        top.setAlignment(Pos.CENTER);
        this.setTop(top);
    }

    private void initBottom() {
        cardCount = new Label((cardView.currCardIndex + 1) + "/" + currDeck.size());
        cardCount.setFont(new Font(25));
        cardCount.setTextAlignment(TextAlignment.CENTER);
        cardCount.setAlignment(Pos.CENTER);
        bottom = new HBox(cardCount);
        bottom.setAlignment(Pos.CENTER);
        this.setBottom(bottom);
    }

    private void initLeft() {
        leftArrowButton = new Button("<");
        leftArrowButton.setFont(new Font(30));
        leftArrowButton.setPrefHeight(150);
        leftArrowButton.setAlignment(Pos.CENTER);
        leftArrowButton.setOnAction(e -> {
            if (cardView.currCardIndex > 0) {
                if (!cardView.editing) {
                    cardView.moveLeft();
                    cardCount.setText((cardView.currCardIndex + 1) + "/" + currDeck.size());
                }
            }
        });

        left = new HBox(leftArrowButton);
        left.setPadding(new Insets(10, 10, 10, 10));
        left.setAlignment(Pos.CENTER);

        this.setLeft(left);
    }

    private void initRight() {
        rightArrowButton = new Button(">");
        rightArrowButton.setFont(new Font(30));
        rightArrowButton.setPrefHeight(150);
        rightArrowButton.setAlignment(Pos.CENTER);
        rightArrowButton.setOnAction(e -> {
            if (cardView.currCardIndex < currDeck.size()-1) {
                if (!cardView.editing) {
                    cardView.moveRight();
                    cardCount.setText(cardView.currCardIndex + 1 + "/" + currDeck.size());
                }
            }
        });

        right = new HBox(rightArrowButton);
        right.setPadding(new Insets(10, 10, 10, 10));
        right.setAlignment(Pos.CENTER);

        this.setRight(right);
    }

}


