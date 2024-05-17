package View;

import Model.Deck;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class TestView extends FlowPane {
    TestForm form;
    Test test;
    TestEnd end;

    public TestView() {
        this.form = new TestForm();
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(form);
    }

    public void setTest(Deck deck) {
        this.test = new Test(deck);
        this.getChildren().remove(this.form);
        this.getChildren().add(test);
    }

    public void setTestEnd(TestEnd te) {
        this.end = te;
        this.getChildren().remove(this.test);
        this.getChildren().add(te);
    }

    public void reset() {
        this.getChildren().remove(this.end);
        this.form = new TestForm();
        this.getChildren().add(this.form);
    }


//    private void initRight() {
//        right = new GridPane();
//        right.setBorder(new Border(new BorderStroke
//                (Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))
//        );
//        right.setPadding(new Insets(10, 10, 10, 10));
//        right.setVgap(10);
//        right.setHgap(10);
//        initDeckButtons();
//        this.setRight(right);
//    }

//    private void initCenter() {
////        center = new Test();
////        this.setCenter(center);
//        this.setCenter(new TestForm());
//    }

//    private void initDeckButtons() {
//        buttons = new Button[DeckLoader.getNumDecks()];
//
//        for (int i = 0; i < buttons.length; i++) {
//            Deck deck = decks.get(i);
//            String buttonName = deck.getName();
//
//            buttons[i] = new Button(buttonName);
//            buttons[i].setPrefWidth(200);
//            right.add(buttons[i], 0, i);
//
//            buttons[i].setOnAction(e -> {
//                currDeck = deck;
//                center.switchDeck(currDeck);
//            });
//        }
//    }

}
