package View;

import Controller.DeckSaver;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static Program.ProgramGUI.deckView;
import static Program.ProgramGUI.decks;
import static View.DeckView.currDeck;

public class RemoveButtonPopup extends Stage {
    Scene scene;
    GridPane pane;
    Label message;
    Button confirm;
    Button cancel;

    public RemoveButtonPopup() {
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(2);
        pane.setVgap(10);

        message = new Label("Delete Deck?");

        confirm = new Button("Confirm");
        confirm.setOnAction(e -> {
            decks.remove(currDeck);
            DeckSaver.saveDecks(decks);
            deckView.reload();
            this.close();
        });

        cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            this.close();
        });

        pane.add(message, 0, 0);
        pane.add(confirm, 0, 1);
        pane.add(cancel, 1, 1);

        scene = new Scene(pane, 400, 300);
        this.setScene(scene);
        this.setTitle("Remove Deck");
    }
}
