package View;

import Controller.DeckSaver;
import Model.Card;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static Program.ProgramGUI.deckView;
import static Program.ProgramGUI.decks;
import static View.DeckView.currDeck;

public class AddCardPopup extends Stage {
    GridPane pane;
    Label frontLabel;
    Label backLabel;
    TextField frontField;
    TextField backField;
    Button addButton;
    Button cancel;

    public AddCardPopup(int index) {
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        frontLabel = new Label("Front Side:");
        backLabel = new Label("Back Side:");
        addButton = new Button("Add Card");
        cancel = new Button("Cancel");

        frontField = new TextField();
        backField = new TextField();


        addButton.setOnAction(e -> {
            Card card = new Card(frontField.getText(), backField.getText());
            currDeck.insert(index, card);
            DeckSaver.saveDecks(decks);
            deckView.reload();
            this.close();
        });
        cancel.setOnAction(e -> this.close());

        pane.add(frontLabel, 0, 0);
        pane.add(frontField, 1, 0);
        pane.add(backLabel, 0, 1);
        pane.add(backField, 1, 1);
        pane.add(addButton, 0, 2);
        pane.add(cancel, 1, 2);

        Scene scene = new Scene(pane, 400, 300);

        this.setScene(scene);
        this.setTitle("Create New Card");
    }

}
