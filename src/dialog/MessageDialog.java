package dialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageDialog {

    private String title;
    private String message;

    public MessageDialog(String title, String message){
        this.title = title;
        this.message = message;
    }

    public void display(){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);// stage -> owner  NONE, WINDOW_MODAL
        stage.setMinWidth(300);
        stage.setMinHeight(200);
        //UI controls
        Label messageLabel = new Label();
        messageLabel.setText(message);
        Button okButton = new Button("OK");
        okButton.setOnAction(e->stage.close());

        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20, 20 , 20 , 20));
        vBox.getChildren().addAll(messageLabel, okButton);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.showAndWait();
    }
}
