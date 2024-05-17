package View;

import Controller.DeckSaver;
import Model.Deck;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static Program.ProgramGUI.decks;
import static Program.ProgramGUI.deckView;

public class AddDeckPopup extends Stage {
    GridPane pane;
    Label nameLabel;
    Label lengthLabel;
    TextField name;
    TextField length;
    Button create;

    public AddDeckPopup() {
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        nameLabel = new Label("Deck Name:");
        lengthLabel = new Label("Initial Length:");

        name = new TextField();
        length = new TextField();

        create = new Button("Add Deck");
        create.setOnAction(e -> {
            Deck deck = new Deck(name.getText(), Integer.parseInt(length.getText()));
            decks.add(deck);
            DeckSaver.saveDecks(decks);
            deckView.reload();
            this.close();
        });

        pane.add(nameLabel, 0, 0);
        pane.add(name, 1, 0);
        pane.add(lengthLabel, 0, 1);
        pane.add(length, 1, 1);
        pane.add(create, 0, 2);

        Scene scene = new Scene(pane, 400, 300);

        this.setScene(scene);
        this.setTitle("Create New Deck");
    }

}
