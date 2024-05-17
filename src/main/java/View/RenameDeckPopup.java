package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static Program.ProgramGUI.deckView;
import static View.DeckView.currDeck;

public class RenameDeckPopup extends Stage {
    Scene scene;
    GridPane pane;
    Label newNameLabel;
    TextField newNameField;
    Button confirm;

    public RenameDeckPopup() {
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        newNameLabel = new Label("New Deck Name:");
        newNameField = new TextField();
        confirm = new Button("Confirm");
        confirm.setOnAction(e -> {
            currDeck.setName(newNameField.getText());
            deckView.reload();
            this.close();
        });

        pane.add(newNameLabel, 0, 0);
        pane.add(newNameField, 1, 0);
        pane.add(confirm, 0, 1);

        scene = new Scene(pane, 400, 300);
        this.setScene(scene);
        this.setTitle("Rename Deck");
    }
}
