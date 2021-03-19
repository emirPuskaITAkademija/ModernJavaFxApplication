import dialog.MessageDialog;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ulazna klasa unutar koje će biti smješten JavaFx kod koji
 * će iscrtavati GUI korisniku.
 * <p>
 * ActionListener -> EventHandler<E extends Event
 * </p>
 * <li>1. Main implement EventHandler<ActionEvent></li>
 * <li>2. Anonymous inner class type</li>
 * <li>3. EventHandler<ActionEvent> -> Funciontal interfejs .... LAMBDA </li>
 * <li>4. EventHandler<ActionEvent> -> Funciontal interfejs .... METHOD referenciranje </li>
 */
public class Main extends Application {

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
    //deklaracija scena
  /*  private Scene firstScene;
    private Scene secondScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label scene1Label = new Label("Dobro došli na scenu 1 !");
        Button scene1Button = new Button("Idi na scenu 2");
        scene1Button.setOnAction(e -> stage.setScene(secondScene));
        VBox scene1Layout = new VBox(20);
        scene1Layout.getChildren().addAll(scene1Label, scene1Button);
        firstScene = new Scene(scene1Layout, 200, 200);

        Label scene2Label = new Label("Dobro došli na sceun 2 !");
        Button scene2Button = new Button("Vrati se na scenu 1");
        scene2Button.setOnAction(e -> stage.setScene(firstScene));
        HBox scene2Layout = new HBox(50);
        scene2Layout.setPadding(new Insets(20, 20, 20 , 20));
        scene2Layout.getChildren().addAll(scene2Label, scene2Button);
        secondScene = new Scene(scene2Layout, 700, 100);

        stage.setScene(firstScene);
        stage.setTitle("Naša DRUGA JavaFx Application");
        stage.show();
    }


    public void handleButtonClick(ActionEvent event) {
        System.out.println("Pozdrav kaže Button iz JavaFx biblioteke...Na njemu se desio klik događaj...");
    }
    */
}
