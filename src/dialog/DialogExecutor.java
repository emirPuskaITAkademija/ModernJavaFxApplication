package dialog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DialogExecutor extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Glavni STAGE ili PROZOR");
        Button button = new Button("Otvori message stage");
        String title = "Message info";
        String message = "Ovo je poruka prikazana u drugom prozoru...";
        button.setOnAction(e->{
            System.out.println("Test test test ");
            MessageDialog messageDialog = new MessageDialog(title, message);
            messageDialog.display();
        });
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);
        Scene scene = new Scene(stackPane, 300, 250);
        stage.setScene(scene);

        stage.show();
    }
}

