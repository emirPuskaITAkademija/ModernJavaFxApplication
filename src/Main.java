import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * <li>CheckBox</li>
 * <li>ChoiceBox</li>
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ChoiceBox<String> fruitChoiceBox;

    @Override
    public void start(Stage stage) throws Exception {
        fruitChoiceBox = new ChoiceBox<>();
        ObservableList<String> observableItems = fruitChoiceBox.getItems();
        observableItems.add("Jabuka");
        observableItems.addAll("Limun", "Naradža");
        observableItems.add("Jagoda");
        observableItems.add("Kiwi");
        observableItems.addAll("Ananas", "Banana","Malina", "Kupina", "Kruška");
        fruitChoiceBox.setValue(observableItems.get(6));
        // listen to selection changes
        SingleSelectionModel<String> selectionModel = fruitChoiceBox.getSelectionModel();
        ReadOnlyObjectProperty<String> itemProperty = selectionModel.selectedItemProperty();
        itemProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("Pojedena voćka:" + oldValue+", Treba još pojesti: " + newValue);
        });

        Button buyButton = new Button("Kupi voće");
        buyButton.setOnAction(this::handleFruitChoice);
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        ObservableList<Node> children = vBox.getChildren();
        children.addAll(fruitChoiceBox, buyButton);

        Scene scene = new Scene(vBox, 300, 250);
        stage.setTitle("Fruits");
        stage.setScene(scene);
        stage.show();
    }

    private void handleFruitChoice(Event event){
        String fruit = fruitChoiceBox.getValue();
        System.out.println("Voće: "+ fruit);
    }
}

    /*CHECK BOX
    private CheckBox cevapiCheckBox;
    private CheckBox pizzaCheckBox;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Narudžba hrane");
        cevapiCheckBox = new CheckBox("Čevapi");
        pizzaCheckBox = new CheckBox("Pizza");
        pizzaCheckBox.setSelected(true);
        Button orderButton = new Button("Izvrši narudžbu");
        orderButton.setOnAction(this::handleOrder);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        ObservableList<Node> vboxObservableList = vBox.getChildren();
        vboxObservableList.addAll(cevapiCheckBox, pizzaCheckBox, orderButton);

        Scene scene = new Scene(vBox, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private  void handleOrder(Event event){
        //\n NOVI RED NA UNIX
        //\r\n
        String lineSeparator = System.lineSeparator();
        String message = "User's order:"+lineSeparator;
        if(cevapiCheckBox.isSelected()){
            message+="Čevapi"+lineSeparator;
        }
        if(pizzaCheckBox.isSelected()){
            message+="PIZZA"+lineSeparator;
        }
        System.out.println(message);
    }
}
/*  LOGIN FORM
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx GridPane");
        GridPane formGridPane = new GridPane();
        //spoljasni i unutarnji razmak
        formGridPane.setPadding(new Insets(10, 10, 10, 10));
        GridPane.setMargin(formGridPane, new Insets(20, 20, 20, 20));
        formGridPane.setVgap(8);
        formGridPane.setHgap(10);

        //Username ili korisnički nalog
        Label usernameLabel = new Label("Username");
        GridPane.setConstraints(usernameLabel, 0, 0);
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Enter username....");
        GridPane.setConstraints(usernameTextField, 1, 0);

        //Password ili lozinka
        Label passwordLabel = new Label("Password");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Enter password..");
        GridPane.setConstraints(passwordTextField, 1, 1);

        //LOGIN button
        Button loginButton = new Button("Sign in");
        GridPane.setConstraints(loginButton, 1, 2);

        ObservableList<Node> children = formGridPane.getChildren();
        children.addAll(usernameLabel, usernameTextField, passwordLabel, passwordTextField, loginButton);

        Scene scene = new Scene(formGridPane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }
}
/*BorderPane USAGE
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Slaganje kontejnera unutar kontejnera");
        HBox topMenuBox = new HBox();
        Button fileButton = new Button("File");
        Button editButton = new Button("Edit");
        Button viewButton = new Button("View");
        topMenuBox.getChildren().addAll(fileButton, editButton, viewButton);

        VBox leftMenuBox =new VBox();
        Button fileButton1 = new Button("File");
        Button editButton1 = new Button("Edit");
        Button viewButton1 = new Button("View");
        leftMenuBox.getChildren().addAll(fileButton1, editButton1, viewButton1);

        BorderPane borderPane = new BorderPane();
        //top left center right bottom
        borderPane.setTop(topMenuBox);
        borderPane.setLeft(leftMenuBox);

        Scene scene = new Scene(borderPane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }
}

    /* IZVRŠAVANJE NEKO koda PRI ZATVARANJU APLIKACIJE..ČUVANJE STANJA
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Proper closing of window");
        stage.setOnCloseRequest(e->{
            //Moramo reći JavaFx-u: Vjeruj nam...mi znaom zatvoriti prozor
            e.consume();
            closeProgram(e);
        });
        Button button = new Button("Close application");
        button.setOnAction(this::closeProgram);
        StackPane stackPane = new StackPane();
        ObservableList<Node> children = stackPane.getChildren();
        children.add(button);

        Scene scene = new Scene(stackPane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void closeProgram(Event event){
        String title = "User confirmation";
        String message = "Operations are in progress. Are you sure ?";
        ConfirmationDialog confirmationDialog = new ConfirmationDialog(title, message);
        boolean answer = confirmationDialog.show();
        if(answer){
            System.out.println("File is saved...");
            stage.close();
        }

    }
}

/*  CONFIRMATION DIALOG
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Glavni prozor");
        Button button = new Button("Accept license agreement");
        EventHandler<ActionEvent> eventHandler = (e) ->{
            String title = "Licence agreement";
            String message = "Ovaj prozor sadrži neki uvredljivi sadržaj." +
                    "Da li ste sigurni da prihvatate naše uslove i license agreement.";
            ConfirmationDialog confirmationDialog = new ConfirmationDialog(title, message);
            boolean answer = confirmationDialog.show();
            if(answer){
                new MessageDialog("Info", "Prihvatio čovjek uvredljivi license...").display();
            }else{
                new MessageDialog("Info", "Izgleda da neko i čita license agreement...").display();
            }
        };
        button.setOnAction(eventHandler);

        StackPane stackPane  = new StackPane();
        ObservableList<Node> children = stackPane.getChildren();
        children.add(button);

        Scene scene = new Scene(stackPane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }
}


/*  MESSAGE DIALOG ...
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Glavni STAGE ili PROZOR");
        stage.setFullScreen(true);

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

