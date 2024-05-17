package View;

import Model.Deck;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Callback;

import static Program.ProgramGUI.decks;
import static Program.ProgramGUI.testView;

public class TestForm extends GridPane {
    Label message;
    Button confirm;

    ComboBox<Label> cmb;
    Label[] cmbLabels;

    Font font = new Font(20);

    public TestForm() {
        initDeckLabels();
        initComboBox();

        message = new Label("Which deck would you like to test yourself with?");
        message.setFont(font);

        confirm = new Button("Confirm");
        confirm.setPrefWidth(150);
        confirm.setFont(font);
        confirm.setOnAction(e -> {
            String deckName = cmb.getValue().getText();
            for (Deck deck : decks) {
                if (deck.getName().equals(deckName)) {
                    testView.setTest(deck);
                }
            }

        });

        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);

        this.add(message, 0, 0);
        this.add(cmb, 0, 1);
        this.add(confirm, 0 , 2);
    }

    private void initDeckLabels() {
        cmbLabels = new Label[decks.size()];
        for (int i = 0; i < cmbLabels.length; i++) {
            Deck deck = decks.get(i);
            cmbLabels[i] = new Label(deck.getName());
            cmbLabels[i].setPrefWidth(150);
            cmbLabels[i].setFont(font);
        }
    }

    private void initComboBox() {
        cmb = new ComboBox<>();
        cmb.setPrefWidth(150);
        for (int i = 0; i < cmbLabels.length; i++) {
            cmb.getItems().add(cmbLabels[i]);
        }
        cmb.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Label> call(ListView<Label> p) {
                return new ListCell<>() {

                    private final Label cell; {
                        cell = new Label();
                    }

                    @Override
                    protected void updateItem(Label item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getText());
                        }
                    }
                };
            }
        });
    }

}
