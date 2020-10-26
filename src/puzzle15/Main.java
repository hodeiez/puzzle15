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

        puzzle15.setRotate(-90);
        puzzle15.setTranslateY(200);
        rowNumber.setPrefSize(80, 20);
        columnNumber.setPrefSize(80, 20);
        puzzle15.setId("gameTitle");
        buttons.setId("buttonsBox");
        mainPane.getStyleClass().add("redpane");
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
//add stuff to main pane

        BorderPane.setAlignment(message, Pos.CENTER);

        mainPane.setCenter(tiles);
        mainPane.setBottom(buttons);
        mainPane.setTop(message);
        mainPane.setRight(spinners);
        mainPane.setLeft(gameName);

        primaryStage.setTitle("Puzzle 15");


        primaryStage.setScene(new Scene(mainPane, 600, 600));
        String stylesheet = getClass().getResource("stylePuzzle15.css").toExternalForm();
        primaryStage.getScene().getStylesheets().add(stylesheet);
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
