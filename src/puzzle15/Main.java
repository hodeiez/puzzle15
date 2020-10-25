package puzzle15;


import javafx.application.Application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;


import javafx.stage.Stage;


public class Main extends Application {

    private int rows = 4;
    private int columns = 4;

    private boolean isSolved;

    Label message = new Label();
    Group tiles = new Group();

    Button restart = new Button("NEW GAME");
    Button solve = new Button("SOLVE");
    Spinner rowNumber = new Spinner();
    Spinner columnNumber = new Spinner();
    SpinnerValueFactory<Integer> rowAmount = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 32, 4);
    SpinnerValueFactory<Integer> colAmount = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 32, 4);
    ComboBox<ImagePath> imageSelector = new ComboBox();
    Label puzzle15 = new Label("PUZZLE15+");
    VBox spinners = new VBox();
    Pane gameName = new Pane();
    FlowPane buttons = new FlowPane();
    BorderPane mainPane = new BorderPane();

    String baseImage = "puzzle15Draw.jpg";


    @Override
    public void start(Stage primaryStage) {


//Setting imageslist in combobox
        ImageData imageData = new ImageData();
        ObservableList<ImagePath> imageList = FXCollections.observableArrayList(imageData.getImageList());
        imageSelector.itemsProperty().setValue(imageList);

//create tilesObject
        Tiles tilesBoard = new Tiles();
        tilesBoard.setTiles(tiles);

//create the board and add to Group
        tilesBoard.createBoard(rows, columns, baseImage);
        tilesBoard.shuffle();

//setting values in components
        rowNumber.setValueFactory(rowAmount);
        columnNumber.setValueFactory(colAmount);


//setting in place
        spinners.getChildren().addAll(rowNumber, columnNumber);
        spinners.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(solve, restart, imageSelector);
        buttons.setAlignment(Pos.CENTER);
        message.setAlignment(Pos.CENTER);
        gameName.getChildren().add(puzzle15);

//Styling
        String styleShadow = "-fx-border-color: transparent;" +
                "-fx-effect: dropshadow(three-pass-box,rgb(0,0,0),10,0,0,0)";
        String styleButtonFocus = "-fx-faint-focus-color:transparent;-fx-focus-color: transparent;";

        puzzle15.setRotate(-90);
        puzzle15.setTranslateY(200);
        puzzle15.setStyle("-fx-font-size: 40;-fx-font-weight: BOLD;-fx-padding: -60;-fx-text-fill: #4f2a2a;-fx-effect: dropshadow(three-pass-box,rgb(0,0,0),2,0,0,0)");
        rowNumber.setPrefSize(80, 20);
        columnNumber.setPrefSize(80, 20);
        imageSelector.setStyle(styleButtonFocus);
        rowNumber.setStyle("-fx-padding: 10,10;-fx-background-color: transparent;" + styleButtonFocus + styleShadow);
        columnNumber.setStyle("-fx-padding: 10,10;-fx-background-color: transparent;" + styleButtonFocus + styleShadow);

        buttons.setStyle("-fx-padding: 30,30");
        message.setStyle("-fx-padding: 10,10;-fx-font-size: 40;-fx-font-weight: BOLD");

        restart.setStyle(styleButtonFocus + styleShadow);
        solve.setStyle(styleButtonFocus +
                styleShadow);

        mainPane.setStyle("-fx-background-color: #864c4c;-fx-effect: innershadow(three-pass-box,rgb(0,0,0),10,0,0,0)");

//add action
        imageSelector.valueProperty().addListener((observableValue, imagePath, t1) ->
            baseImage = t1.getPathString());

        tiles.setOnMouseClicked(e -> {
            tilesBoard.moveTiles(e);
            isSolved = tilesBoard.isSolved();
            message.setText((isSolved) ? "CONGRATS!! YOU WON" : null);
        });

        restart.setOnAction(actionEvent -> {
            rowColumnsUpdate();
            tilesBoard.createBoard(rows, columns, baseImage);
            tilesBoard.shuffle();
        });

        solve.setOnAction(event -> {
            rowColumnsUpdate();
            tilesBoard.createBoard(rows, columns, baseImage);
        });
//add stuff/

        BorderPane.setAlignment(message, Pos.CENTER);

        mainPane.setCenter(tiles);
        mainPane.setBottom(buttons);
        mainPane.setTop(message);
        mainPane.setRight(spinners);
        mainPane.setLeft(gameName);

        primaryStage.setTitle("Puzzle 15");


        primaryStage.setScene(new Scene(mainPane, 600, 600));
        primaryStage.show();
    }

    public void rowColumnsUpdate() {
        rows = rowAmount.getValue();
        columns = colAmount.getValue();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
