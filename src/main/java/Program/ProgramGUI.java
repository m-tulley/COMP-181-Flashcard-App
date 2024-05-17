package Program;

import Controller.DeckLoader;
import Controller.PracticeLogger;
import Controller.TestLogger;
import Model.Deck;
import Model.PracticeLog;
import Model.TestLog;
import View.DeckView;
import View.MainMenu;

import View.PracticeView;
import View.TestView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProgramGUI extends Application {
    private Stage stage;

    private Scene scene;
    BorderPane pane;

    private ToolBar toolBar;
    private Button mainMenuButton;
    private Button practiceReportButton;
    private Button decksButton;
    private Button testViewButton;

    public static MainMenu mainMenu;
    public static DeckView deckView;
    public static TestView testView;
    public static PracticeView practiceView;

    public static ArrayList<Deck> decks;
    public static ArrayList<PracticeLog> logs;
    public static ArrayList<TestLog> tests;

    private long programStartTime;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;

        pane = new BorderPane();

        initTop();
        initCenter();

        scene = new Scene(pane, 1280, 720);

        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();

        programStartTime = System.currentTimeMillis();
    }

    private void initCenter() {
        mainMenu = new MainMenu();
        deckView = new DeckView();
        testView = new TestView();
        practiceView = new PracticeView();
        pane.setCenter(mainMenu);
    }

    private void initTop() {
        initToolBarButtons();
        toolBar = new ToolBar(mainMenuButton, decksButton, testViewButton, practiceReportButton);
        toolBar.setPadding(new Insets(10, 10, 10, 10));
        toolBar.setBorder(new Border(
                        new BorderStroke(Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)
                )
        );
        pane.setTop(toolBar);
    }

    private void initToolBarButtons() {
        mainMenuButton = new Button("Main Menu");
        practiceReportButton = new Button("View Practice Log");
        decksButton = new Button("View Decks");
        testViewButton = new Button("Test");

        mainMenuButton.setOnAction(e -> {
            pane.setCenter(mainMenu);
            stage.setTitle("Main Menu");
        });
        decksButton.setOnAction(e -> {
            pane.setCenter(deckView);
            stage.setTitle("Deck View");
        });
        practiceReportButton.setOnAction(e -> {
            pane.setCenter(practiceView);
            stage.setTitle("Practice Report");
        });
        testViewButton.setOnAction(e -> {
            pane.setCenter(testView);
            stage.setTitle("Test");
        });
    }

    public static void main(String[] args) {
        decks = DeckLoader.loadDecks();
        logs = PracticeLogger.getLogs();
        tests = TestLogger.getLogs();
        launch();
    }

    @Override
    public void stop() {
        long programEndTime = System.currentTimeMillis();
        long programRunTime = programEndTime - programStartTime;
        logs.add(new PracticeLog(LocalDate.now(), programRunTime));
        PracticeLogger.log(logs);
    }

}
