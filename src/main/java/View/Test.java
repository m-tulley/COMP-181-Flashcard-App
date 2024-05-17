package View;

import Model.Card;
import Model.Deck;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import static Program.ProgramGUI.testView;

public class Test extends GridPane {
    Deck deck;
    Card currCard;

    int cardIndex;
    int numCorrect;

    Label frontSide;
    Label validAnswer;
    TextField input;
    Button enter;

    public Test(Deck deck) {
        this.deck = deck;
        this.currCard = deck.getCard(0);
        this.cardIndex = 0;
        this.frontSide = new Label(currCard.getFront());
        this.input = new TextField("Enter Translation");
        this.enter = new Button("Enter");
        this.validAnswer = new Label();
        this.numCorrect = 0;

        this.enter.setOnAction(e -> {
            checkAnswer();
            nextCard();
        });

        this.frontSide.setAlignment(Pos.CENTER);
        this.input.setAlignment(Pos.CENTER);
        this.enter.setAlignment(Pos.CENTER);
        this.validAnswer.setAlignment(Pos.CENTER);

        this.frontSide.setFont(new Font(20));
        this.input.setFont(new Font(20));
        this.validAnswer.setFont(new Font(20));
        this.enter.setFont(new Font(20));

        this.setHgap(10);
        this.setVgap(10);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.add(frontSide, 0, 0);
        this.add(input, 0, 1);
        this.add(enter, 0, 2);
        this.add(validAnswer, 0, 3);
    }

    private void nextCard() {
        ++cardIndex;
        if (cardIndex >= deck.size()) {
            testView.setTestEnd(new TestEnd(this.numCorrect, this.deck));
        } else {
            this.currCard = deck.getCard(cardIndex);
            frontSide.setText(currCard.getFront());
            input.setText("Enter Translation");
        }
    }

    private void checkAnswer() {
        if (input.getText().equals(currCard.getBack())) {
            validAnswer.setText("Correct!");
            numCorrect++;
        } else {
            validAnswer.setText("Wrong.");
        }
    }

}
