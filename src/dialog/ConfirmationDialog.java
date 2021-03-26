package dialog;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationDialog {

    private boolean answer;
    private String title;
    private String message;

    public ConfirmationDialog(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public boolean show(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(300);
        //UI controls
        Label messageLabel = new Label();
        messageLabel.setText(message);
        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e->{
            answer = true;
            stage.close();
        });
        Button noButton = new Button("No");
        noButton.setOnAction(e->{
            answer = false;
            stage.close();
        });
        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        ObservableList<Node> hBoxChildren = hBox.getChildren();
        hBoxChildren.addAll(yesButton, noButton);
        //LayoutPane...
        VBox vBox = new VBox(10);
        ObservableList<Node> children = vBox.getChildren();
        children.add(messageLabel);
        children.add(hBox);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();
        return answer;
    }
}
