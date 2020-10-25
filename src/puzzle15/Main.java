package puzzle15;


import javafx.application.Application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;

import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;

import javax.swing.text.Style;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    private int rows = 4;
    private int columns = 4;

    private boolean isSolved;


    Label message = new Label();
    Group tiles = new Group();

    Button restart = new Button("NEW GAME");
    Button solve = new Button("SOLVE");
    Spinner rowNumber=new Spinner();
    Spinner columnNumber=new Spinner();
    SpinnerValueFactory<Integer> rowAmount= new SpinnerValueFactory.IntegerSpinnerValueFactory(2,32,4);
    SpinnerValueFactory<Integer> colAmount= new SpinnerValueFactory.IntegerSpinnerValueFactory(2,32,4);
    ComboBox imageSelector =new ComboBox();
    Label puzzle15=new Label("PUZZLE15+");
    VBox spinners =new VBox();
    Pane gameName =new Pane();
    FlowPane buttons=new FlowPane();
    BorderPane mainPane = new BorderPane();
    List<String> listOfImages=new ArrayList<>();
    String baseImage="puzzle15draw.jpg";
    String countrySide="countryside.jpg";
    URL netImageHodei;

    {
        try {
            netImageHodei = new URL("https://media-exp1.licdn.com/dms/image/C4E03AQE88gdGS7iRcg/profile-displayphoto-shrink_400_400/0?e=1608768000&v=beta&t=vyTqYxYzmAYDrzkgQ5YBL6XyJejLI-vto7TK1SsEKz8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    URL netImageJohan;

    {
        try {
            netImageJohan = new URL("https://media-exp1.licdn.com/dms/image/C4E03AQFLn250WvzsqA/profile-displayphoto-shrink_400_400/0?e=1608768000&v=beta&t=C4nmzM628lxwWtCDGu-ifMaZoaKnsNLSY9kF8pW2B-g");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
//testing list
        listOfImages.add(baseImage);
        listOfImages.add(countrySide);
imageSelector.setItems(FXCollections.observableArrayList(listOfImages));
        Tiles tilesBoard = new Tiles();
        tilesBoard.setTiles(tiles);

//create the board and add to Group
        createBoard();

//setting values in components
        rowNumber.setValueFactory(rowAmount);
        columnNumber.setValueFactory(colAmount);
        tilesBoard.createBoard(rows, columns, netImageHodei.toString());

//setting in place
        spinners.getChildren().addAll(rowNumber,columnNumber);
        spinners.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(solve,restart, imageSelector);
       buttons.setAlignment(Pos.CENTER);
        message.setAlignment(Pos.CENTER);
        gameName.getChildren().add(puzzle15);

//Styling
        String styleShadow="-fx-border-color: transparent;" +
                "-fx-effect: dropshadow(three-pass-box,rgb(0,0,0),10,0,0,0)";
        String styleButtonFocus="-fx-faint-focus-color:transparent;-fx-focus-color: transparent;";

        puzzle15.setRotate(-90);
        puzzle15.setTranslateY(200);
        puzzle15.setStyle("-fx-font-size: 40;-fx-font-weight: BOLD;-fx-padding: -60;-fx-text-fill: #4f2a2a;-fx-effect: dropshadow(three-pass-box,rgb(0,0,0),2,0,0,0)");
        rowNumber.setPrefSize(80,20);
        columnNumber.setPrefSize(80,20);
        imageSelector.setStyle(styleButtonFocus);
        rowNumber.setStyle("-fx-padding: 10,10;-fx-background-color: transparent;"+styleButtonFocus + styleShadow);
        columnNumber.setStyle("-fx-padding: 10,10;-fx-background-color: transparent;" + styleButtonFocus + styleShadow);

        buttons.setStyle("-fx-padding: 30,30");
        message.setStyle("-fx-padding: 10,10;-fx-font-size: 40;-fx-font-weight: BOLD");

        restart.setStyle( styleButtonFocus+ styleShadow);
        solve.setStyle(styleButtonFocus +
                styleShadow);

        mainPane.setStyle("-fx-background-color: #864c4c;-fx-effect: innershadow(three-pass-box,rgb(0,0,0),10,0,0,0)");

//add action
        tiles.setOnMouseClicked(e -> {
            System.out.println(" x " + e.getX() + " y " + e.getY());
            tilesBoard.moveTiles(e);
            isSolved = tilesBoard.isSolved();
            message.setText((isSolved) ? "CONGRATS!! YOU WON" : null);
        });

        restart.setOnAction(actionEvent -> {
            tilesBoard.createBoard(rows, columns, netImageHodei.toString());
            tilesBoard.shuffle();
        });

        solve.setOnAction(event -> {
            tilesBoard.createBoard(rows, columns, netImageHodei.toString());
        });
//add stuff/

        BorderPane.setAlignment(message,Pos.CENTER);

        mainPane.setCenter(tiles);
        mainPane.setBottom(buttons);
        mainPane.setTop(message);
        mainPane.setRight(spinners);
        mainPane.setLeft(gameName);

        primaryStage.setTitle("Puzzle 15");


        primaryStage.setScene(new Scene(mainPane, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
