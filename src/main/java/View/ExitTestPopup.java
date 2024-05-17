package View;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ExitTestPopup extends Alert {
    Label message;
    Button confirm;

    public ExitTestPopup(AlertType alertType) {
        super(alertType);
        this.setAlertType(AlertType.CONFIRMATION);
        this.setContentText("Are you sure you would like to exit this test?\n" +
                            "Progress will not be saved.");
    }
}
