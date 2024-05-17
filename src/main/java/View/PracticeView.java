package View;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class PracticeView extends GridPane {
    Button generateButton;
    Label selectTimeFrameMessage;
    ComboBox<Label> cmb;
    Label[] cmbLabels;

    Font font = new Font(20);

    public PracticeView() {
        generateButton = new Button("Generate Report");
        selectTimeFrameMessage = new Label("Select a time frame");
        initComboBox();

        generateButton.setFont(font);
        selectTimeFrameMessage.setFont(font);

        generateButton.setOnAction(e -> {
            PracticeReport p = new PracticeReport();
            this.getChildren().remove(generateButton);
            this.add(p, 0, 0);
        });

        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);

        //this.add(selectTimeFrameMessage, 0, 0);
        //this.add(cmb, 0, 1);
        this.add(generateButton, 0, 2);
    }

    public void initComboBox() {
        cmb = new ComboBox<>();
        cmbLabels = new Label[] {
                new Label("Past day"), new Label("Past 7 days"), new Label("Past 30 days")
        };
        for (Label label : cmbLabels) {
            label.setFont(font);
            cmb.getItems().add(label);
        }
        cmb.setPrefWidth(150);
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
