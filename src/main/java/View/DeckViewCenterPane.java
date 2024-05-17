package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static View.CardView.currCardIndex;

public class DeckViewCenterPane extends BorderPane {
    DeckViewCenterCenterPane center;
    AnchorPane bottom;

    public DeckViewCenterPane() {
        initCenter();
        initBottom();
    }

    private void initCenter() {
        center = new DeckViewCenterCenterPane();
        this.setCenter(center);
    }

    private void initBottom() {
        bottom = new AnchorPane();
        HBox left = new HBox();
        HBox right = new HBox();

        left.setAlignment(Pos.CENTER_LEFT);
        right.setAlignment(Pos.CENTER_RIGHT);

        Insets insets = new Insets(10, 10, 10 ,10);
        left.setPadding(insets);
        right.setPadding(insets);

        Button addCardButton = new Button("Add Card");
        Button removeButton = new Button("Remove Card");

        removeButton.setAlignment(Pos.CENTER_LEFT);
        removeButton.setAlignment(Pos.CENTER_RIGHT);

        removeButton.setOnAction(e -> {
            if (!center.cardView.editing) {
                RemoveCardPopup popup = new RemoveCardPopup();
                popup.show();
            }
        });
        addCardButton.setOnAction(e -> {
            if (!center.cardView.editing) {
                AddCardPopup popup = new AddCardPopup(currCardIndex + 1);
                popup.show();
            }
        });

        left.getChildren().add(addCardButton);
        right.getChildren().add(removeButton);

        AnchorPane.setLeftAnchor(left, 10.0);
        AnchorPane.setRightAnchor(right, 10.0);

        bottom.getChildren().addAll(left, right);

        bottom.setBorder(new Border(new BorderStroke
                (Color.DARKGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)
        ));

        this.setBottom(bottom);
    }

}
