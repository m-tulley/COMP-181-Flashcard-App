package View;

import Model.Deck;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static Program.ProgramGUI.decks;

public class DeckView extends BorderPane {
    BorderPane right;
    DeckViewCenterPane center;

    AnchorPane anchorPane;

    ScrollPane scrollPane;
    GridPane scrollPaneGrid;
    Button addButton;
    GridPane grid;

    Button[] buttons;

    static Deck currDeck;

    public DeckView() {
        currDeck = decks.getFirst();
        initCenter();
        initRight();
    }

    private void initCenter() {
        center = new DeckViewCenterPane();
        this.setCenter(center);
    }

    private void initRight() {
        right = new BorderPane();
        right.setBorder(new Border(new BorderStroke
                (Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))
        );

        initTopBar();
        initScrollPane();
        initDeckButtons();
        initRightBottom();

        right.setTop(grid);
        right.setCenter(scrollPane);
        right.setBottom(anchorPane);

        this.setRight(right);
    }

    private void initRightBottom() {
        anchorPane = new AnchorPane();
        HBox leftHBox = new HBox();
        HBox rightHBox = new HBox();

        leftHBox.setAlignment(Pos.CENTER_LEFT);
        rightHBox.setAlignment(Pos.CENTER_RIGHT);

        Insets insets = new Insets(10, 10, 10 ,10);
        leftHBox.setPadding(insets);
        rightHBox.setPadding(insets);


        Button renameButton = new Button("rename");
        Button removeButton = new Button("remove");

        removeButton.setAlignment(Pos.CENTER_LEFT);
        removeButton.setAlignment(Pos.CENTER_RIGHT);

        removeButton.setOnAction(e -> {
            if (!center.center.cardView.editing) {
                RemoveButtonPopup popup = new RemoveButtonPopup();
                popup.show();
            }
        });
        renameButton.setOnAction(e -> {
            if (!center.center.cardView.editing) {
                RenameDeckPopup popup = new RenameDeckPopup();
                popup.show();
            }
        });

        leftHBox.getChildren().add(renameButton);
        rightHBox.getChildren().add(removeButton);

        AnchorPane.setLeftAnchor(leftHBox, 10.0);
        AnchorPane.setRightAnchor(rightHBox, 10.0);

        anchorPane.getChildren().addAll(leftHBox, rightHBox);

        anchorPane.setBorder(new Border(new BorderStroke
                (Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)
        ));

        this.right.setBottom(anchorPane);
    }

    private void initDeckButtons() {
        buttons = new Button[decks.size()];

        for (int i = 0; i < buttons.length; i++) {
            Deck deck = decks.get(i);
            String buttonName = deck.getName();
            int deckSize = deck.size();

            buttons[i] = new Button(buttonName);
            buttons[i].setPrefWidth(200);
            scrollPaneGrid.add(buttons[i], 0, i);

            buttons[i].setOnAction(e -> {
                if (!center.center.cardView.editing) {
                    center.center.deckName.setText(buttonName);
                    center.center.cardCount.setText("1/" + deckSize);
                    currDeck = deck;
                    center.center.cardView.setToFirstCard();
                }
            });
        }
    }

    private void initScrollPane() {
        initScrollPaneGrid();
        scrollPane = new ScrollPane();
        scrollPane.setContent(scrollPaneGrid);
    }

    private void initTopBar() {
        initAddButton();
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(addButton, 0, 0);
    }

    private void initAddButton() {
        addButton = new Button("Add");
        addButton.setPrefWidth(200);
        addButton.setOnAction(actionEvent -> {
            AddDeckPopup popup = new AddDeckPopup();
            popup.show();
        });
    }

    private void initScrollPaneGrid() {
        scrollPaneGrid = new GridPane();
        scrollPaneGrid.setPadding(new Insets(10, 10, 10, 10));
        scrollPaneGrid.setVgap(5);
    }

    public void reload() {
        currDeck = decks.getFirst();
        initCenter();
        initRight();
    }

}
