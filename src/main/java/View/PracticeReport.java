package View;

import Model.PracticeLog;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import static Program.ProgramGUI.*;

public class PracticeReport extends GridPane {
    GridPane logsPane;
    GridPane testsPane;

    Label[] logLabels;
    Label[] testLabels;

    Button reload;

    private final int upperLim = 10;

    public PracticeReport() {
        this.logsPane = new GridPane();
        this.testsPane = new GridPane();

        this.testsPane.setPadding(new Insets(10, 10, 10, 10));
        this.logsPane.setPadding(new Insets(10, 10, 10, 10));

        logLabels = new Label[logs.size()];

        int count = 0;
        for (PracticeLog log : logs) {
            if (count > upperLim) {
                break;
            }
            logLabels[count] = new Label("On " + log.getDate() + " you practiced for " + log.getMins() + " minutes.");
            logsPane.add(logLabels[count], 0, count);
            count++;
        }

        testLabels = new Label[tests.size()];

        for (int i = 0; i < tests.size(); i++) {
            if (tests.get(i) == null) {
                break;
            }
            if (i > upperLim) {
                break;
            }
            testLabels[i] = new Label("On " + tests.get(i).getDate() + " you tested yourself on the "
                    + tests.get(i).getDeckName() + " deck and got " + tests.get(i).getPercentageCorrect() + " percent correct.");
            testsPane.add(testLabels[i], 0, i);
        }

        reload = new Button("Reload");
        reload.setOnAction(e -> {
            this.getChildren().remove(logsPane);
            this.getChildren().remove(testsPane);
            this.logsPane = new GridPane();
            this.testsPane = new GridPane();

            this.testsPane.setPadding(new Insets(10, 10, 10, 10));
            this.logsPane.setPadding(new Insets(10, 10, 10, 10));

            logLabels = new Label[logs.size()];

            int count1 = 0;
            for (PracticeLog log : logs) {
                if (count1 > upperLim) {
                    break;
                }
                logLabels[count1] = new Label("On " + log.getDate() + " you practiced for " + log.getMins() + " minutes.");
                logsPane.add(logLabels[count1], 0, count1);
                count1++;
            }

            testLabels = new Label[tests.size()];

            for (int i = 0; i < tests.size(); i++) {
                if (tests.get(i) == null) {
                    break;
                }
                if (i > upperLim) {
                    break;
                }
                testLabels[i] = new Label("On " + tests.get(i).getDate() + " you tested yourself on the "
                        + tests.get(i).getDeckName() + " deck and got " + tests.get(i).getPercentageCorrect() + " percent correct.");
                testsPane.add(testLabels[i], 0, i);
            }
            this.add(logsPane, 0, 0);
            this.add(testsPane, 1, 0);
        });

        this.add(reload, 2, 0);
        this.add(logsPane, 0, 0);
        this.add(testsPane, 1, 0);
    }

}
