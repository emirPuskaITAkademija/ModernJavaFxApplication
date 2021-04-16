import com.sun.source.tree.Tree;
import controller.ShowController;
import dao.ShowDao;
import dao.connection.ConnectionPool;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Show;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * <li>CheckBox</li>
 * <li>ChoiceBox</li>
 * <li>ComboBox</li>
 * <li>ListView</li>
 * <li>TreeView</li>
 * <li>TableView</li>
 * <li>Making Menus</li>
 * root
 *   branch
 *   leaf
 *  <li>Observer...ObservableProperties</li>
 *  <li>Binding</li>
 *  UI -> CILJ: TextField..Label
 *
 */
public class Main extends  Application{

    @Override
    public void start(Stage stage) throws Exception {

    }
}

/*
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx");
        TextField userInputTextField = new TextField();
        userInputTextField.setMaxWidth(200);
        userInputTextField.setPromptText("Unesi svoje ime...");
        Label welcomeLabel = new Label("Welcome: ");
        //Labelu ispod ćemo vezati za userInputTextField
        Label bindedLabel = new Label();
        HBox bottomeTextBox = new HBox();
        bottomeTextBox.getChildren().addAll(welcomeLabel, bindedLabel);
        bottomeTextBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll( userInputTextField, bottomeTextBox);
        vBox.setAlignment(Pos.CENTER);

        StringProperty bindedLabelProperty = bindedLabel.textProperty();
        StringProperty userInputTextFieldProperty = userInputTextField.textProperty();
        bindedLabelProperty.bind(userInputTextFieldProperty);

        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
/*
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx");
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setAlignment(Pos.CENTER);
        //Username
        Label usernameLabel = new Label("Username");
        usernameLabel.setStyle("-fx-text-fill:white;");
        //0 kolona 0 red
        GridPane.setConstraints(usernameLabel, 0, 0);
        //1 kolona 0 red
        TextField usernameField = new TextField();

        usernameField.setPromptText("Unesi username....");
        GridPane.setConstraints(usernameField, 1, 0);
        //Password
        Label passwordLabel = new Label("Password");
        passwordLabel.setId("bold-label");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Unesi lozinku..");
        GridPane.setConstraints(passwordField, 1, 1);

        //Login
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> setUserAgentStylesheet(STYLESHEET_CASPIAN));
        Button registerButton = new Button("Register");
        registerButton.getStyleClass().add("button-blue");
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.setHgap(20);
        flowPane.getChildren().addAll(loginButton, registerButton);
        GridPane.setConstraints(flowPane, 1, 2);
        gridPane.getChildren().addAll(usernameField, usernameLabel, passwordField, passwordLabel, flowPane);

        Scene scene = new Scene(gridPane, 600, 300);
        scene.getStylesheets().add("Dark.css");
        stage.setScene(scene);
        stage.show();



    }
}
/*
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    private BorderPane borderPane;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavFx MenuBar");
        borderPane = new BorderPane();
        //Menu: File
        Menu fileMenu = new Menu("_File");
        ObservableList<MenuItem> menuItemObservableList =fileMenu.getItems();
        MenuItem newProjectMenuItem = new MenuItem("New Project..");
        newProjectMenuItem.setOnAction(event -> {
            System.out.println("New project has just been created....");
        });
        menuItemObservableList.add(newProjectMenuItem);
        menuItemObservableList.add(new MenuItem("Open Project..."));
        menuItemObservableList.add(new MenuItem("Close Project"));
        menuItemObservableList.add(new SeparatorMenuItem());
        menuItemObservableList.add(new MenuItem("Settings"));
        menuItemObservableList.add(new MenuItem("Project structure"));
        menuItemObservableList.add(new SeparatorMenuItem());
        menuItemObservableList.add(new MenuItem("Exit"));
        //EDIT menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        MenuItem pasteMenuItem = new MenuItem("Paste");
        pasteMenuItem.setDisable(true);
        editMenu.getItems().add(pasteMenuItem);
        //Help menu
        Menu helpMenu = new Menu("_Help");
        CheckMenuItem showLineNumbers = new CheckMenuItem("Show line numbers");
        showLineNumbers.setOnAction(event -> {
            if(showLineNumbers.isSelected()){
                System.out.println("Program će prikazati brojeve linija..");
            }else{
                System.out.println("Program će sakriti brojeve linija...");
            }
        });
        helpMenu.getItems().add(showLineNumbers);

        //Level menu
        Menu levelMenu = new Menu("_Level");
        RadioMenuItem easyRadioMenuItem = new RadioMenuItem("Easy");
        RadioMenuItem mediumRadioMenuItem = new RadioMenuItem("Medium");
        RadioMenuItem hardRadioMenuItem = new RadioMenuItem("Hard");
        ToggleGroup toggleGroup = new ToggleGroup();
        easyRadioMenuItem.setToggleGroup(toggleGroup);
        mediumRadioMenuItem.setToggleGroup(toggleGroup);
        hardRadioMenuItem.setToggleGroup(toggleGroup);
        levelMenu.getItems().addAll(easyRadioMenuItem, mediumRadioMenuItem, hardRadioMenuItem);
        //MENU BAR
        MenuBar menuBar = new MenuBar();
        ObservableList<Menu> menuObservableList = menuBar.getMenus();
        menuObservableList.addAll(fileMenu, editMenu, levelMenu, helpMenu);
        borderPane.setTop(menuBar);

        Scene scene = new Scene(borderPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
/*
public class Main extends Application{


    private TableView<Show> showTableView;
    //forma -> kreiram jedan record u bazi..tabeli shows i da kreiram jedan record u table view
    private TextField showTitleTextField;
    private TextField numberOfSeasonField;
    private TextField initialYearField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Table inside JavaFx");
        //TABELA ->
        TableColumn<Show, Integer> showIdColumn = new TableColumn<>("Show ID");
        showIdColumn.setCellValueFactory(new PropertyValueFactory<>("showId"));

        TableColumn<Show, String> showTitleColumn = new TableColumn<>("Show Title");
        showTitleColumn.setCellValueFactory(new PropertyValueFactory<>("showTitle"));

        TableColumn<Show, Integer> numberOfSeasonsColumn = new TableColumn<>("Number of seasons");
        numberOfSeasonsColumn.setCellValueFactory(new PropertyValueFactory<>("numOfSeasons"));

        TableColumn<Show, Integer> initialYearColumn = new TableColumn<>("Initial Year");
        initialYearColumn.setCellValueFactory(new PropertyValueFactory<>("initialYear"));

        showTableView = new TableView<>();
        //veza između TableView<Show> i ObservableList<Show> unutar koje se nalaze podaci
        ObservableList<Show> dataList = new ShowController().loadShows();
        showTableView.getItems().addAll(dataList);
        //veza između TableView<Show> i prisutnih kolona TableColumn<Show, X>
        showTableView.getColumns().addAll(showIdColumn, showTitleColumn, numberOfSeasonsColumn, initialYearColumn);

        //FORMA
        showTitleTextField = new TextField();
        showTitleTextField.setPromptText("Enter show title...");
        numberOfSeasonField = new TextField();
        numberOfSeasonField.setPromptText("Enter num of seasons...");
        numberOfSeasonField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null && !newValue.matches("\\d*")){
                numberOfSeasonField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        initialYearField = new TextField();
        initialYearField.setPromptText("Enter initial year...");
        initialYearField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null && !newValue.matches("\\d*")){
                numberOfSeasonField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        Button addShowButton = new Button("Add");
        addShowButton.setOnAction(this::onAddShowButtonClick);
        Button deleteShowButton = new Button("Delete");
        deleteShowButton.setOnAction(this::onDeleteShowButtonClick);
        HBox forma = new HBox(10);
        forma.getChildren().addAll(showTitleTextField, numberOfSeasonField, initialYearField, addShowButton, deleteShowButton);
        forma.setPadding(new Insets(12, 12, 12, 12));


        VBox vBox = new VBox();
        vBox.getChildren().addAll(showTableView, forma);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    private void onDeleteShowButtonClick(ActionEvent event) {
        ObservableList<Show> selectedShows = showTableView.getSelectionModel().getSelectedItems();
        ObservableList<Show> allShows= showTableView.getItems();
        try{
            ConnectionPool connectionPool = new ConnectionPool();
            ShowDao showDao = new ShowDao(connectionPool);
            for(Show show : selectedShows){
                showDao.delete(show);
            }
        }catch (SQLException exception){
            System.err.println(exception.getMessage());
        }
        selectedShows.forEach(allShows::remove);
    }

    private void onAddShowButtonClick(Event event){
        try {
            ConnectionPool connectionPool = new ConnectionPool();
            ShowDao showDao = new ShowDao(connectionPool);//CRUD
            Show show = new Show();//showId ne
            //showTitle, numOfSeasons, initalYear
            show.setShowTitle(showTitleTextField.getText());
            show.setNumOfSeasons(Integer.parseInt(numberOfSeasonField.getText()));
            show.setInitialYear(Integer.parseInt(initialYearField.getText()));
            //INSERTUJE podatke iz show objekta u tabelu shows u bazi movies
            show = showDao.create(show);//sva osim showId
            showTableView.getItems().add(show);
            showTitleTextField.clear();
            numberOfSeasonField.clear();
            initialYearField.clear();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        //INSERT U TABELU U JavaFx
    }
}

/*
public class Main extends Application {

    private TreeView<String> treeView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx TreeView");
        //root
        TreeItem<String> rootItem = new TreeItem<>("Programski jezici");
        rootItem.setExpanded(true);
        //JavaBranch i JSBranch
        TreeItem<String> javaBranch = createBranch("Java", rootItem);
        createBranch("Ruby", javaBranch);
        createBranch("Scala", javaBranch);
        createBranch("Kotlin", javaBranch);
        TreeItem<String> jsBranch = createBranch("JavaScript", rootItem);
        createBranch("React.js", jsBranch);
        createBranch("Vue.js", jsBranch);
        createBranch("Angular", jsBranch);

        //IDEMO SLOŽITI STABLO
        treeView = new TreeView<>(rootItem);
        MultipleSelectionModel<TreeItem<String>> selectionModel = treeView.getSelectionModel();
        ReadOnlyObjectProperty<TreeItem<String>> property = selectionModel.selectedItemProperty();
        property.addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                System.out.println("OMILJENI jezik: " + newValue.getValue());
            }
        });
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(treeView);

        Scene scene = new Scene(stackPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    private TreeItem<String> createBranch(String title, TreeItem<String> parent){
        TreeItem<String> branchItem = new TreeItem<>(title);
        branchItem.setExpanded(true);
        parent.getChildren().add(branchItem);
        return branchItem;
    }
}



/*
public class Main extends  Application{

    private ListView<Person> personListView;

   public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx ListView");

        personListView = new ListView<>();
        ObservableList<Person> personObservableList = personListView.getItems();
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Benjamin", "Knežević"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amila", "Hasić"));
        personObservableList.add(new Person("Mitar", "Zirojević"));
        personObservableList.add(new Person("Aida", "Buza"));
        personObservableList.add(new Person("Amer", "Jahjaefendić"));
        MultipleSelectionModel<Person> selectionModel = personListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        Button choosePersonButton = new Button("Choose person");
        choosePersonButton.setOnAction(this::favouritePersonSelect);

        VBox vBox = new VBox(10);
        ObservableList<Node> children = vBox.getChildren();
        children.addAll(personListView, choosePersonButton);

        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void favouritePersonSelect(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Omiljene osobe:");
        sb.append(System.lineSeparator());
        ObservableList<Person> selectedPersons = personListView.getSelectionModel().getSelectedItems();
        for(Person person: selectedPersons){
            sb.append(person.toString());
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

    }
}
/*
public class Main extends Application {

    private ComboBox<String> movieComboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage stage) throws Exception {
        stage.setTitle("JavaFx UI");
        movieComboBox = new ComboBox<>();
        ObservableList<String> movieList = movieComboBox.getItems();
        movieList.addAll("Dead pool", "Djevojka iz kaveza", "Joker");
        movieList.add("Batman");
        movieList.addAll("Supermen", "Hitman", "Starwars");
        movieList.addAll("Lucy", "Godfather");
        movieComboBox.setPromptText("Odaberi film...");
        movieComboBox.setEditable(true);
        movieComboBox.setOnAction(this::handleMovieChoose);

        Button chooseButton = new Button("Odaberi");
        chooseButton.setOnAction(this::handleMovieChoose);

        VBox vBox = new VBox();
        ObservableList<Node> children = vBox.getChildren();
        children.addAll(movieComboBox, chooseButton);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(vBox, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void handleMovieChoose(Event e){
        System.out.println("Omiljeni film: " + movieComboBox.getValue());
    }
}


/*public class Main extends Application {

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
 */

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

