package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class MainMenu extends FlowPane {
    Label welcomeMessage;

    public MainMenu() {
        welcomeMessage = new Label("Welcome to Flapp!");
        welcomeMessage.setFont(new Font(20));
        this.getChildren().add(welcomeMessage);
        this.setAlignment(Pos.CENTER);
    }
}
