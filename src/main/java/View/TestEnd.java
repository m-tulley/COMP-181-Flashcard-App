package View;

import Controller.TestLogger;
import Model.Deck;
import Model.TestLog;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.time.LocalDate;

import static Program.ProgramGUI.testView;
import static Program.ProgramGUI.tests;

public class TestEnd extends GridPane {
    Label endMessage;
    Label percentageMessage;
    Button exit;

    Font font = new Font(20);

    public TestEnd(int numCorrect, Deck deck) {
        endMessage = new Label("You've completed the test!");
        percentageMessage = new Label("You got: " + numCorrect + " out of " + deck.size() + " correct.");

        exit = new Button("Exit");
        exit.setOnAction(e -> {
            tests.add(new TestLog(deck.getName(), ((double)numCorrect / (double)deck.size()) * 100, LocalDate.now()));
            TestLogger.log(tests);
            testView.reset();
        });

        setFont();

        this.setHgap(10);
        this.setVgap(10);

        this.add(endMessage, 0, 0);
        this.add(percentageMessage, 0, 1);
        this.add(exit, 0, 2);
    }

    public void setFont() {
        endMessage.setFont(font);
        percentageMessage.setFont(font);
        exit.setFont(font);
    }

}
