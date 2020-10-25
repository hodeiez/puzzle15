package puzzle15;


import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;

import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;

import javax.swing.text.Style;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Main extends Application {
    ArrayList<Rectangle> tilesList = new ArrayList<>();
    private int rows = 4;
    private int columns = 4;
    public int tileSize = (((100/Math.max(rows,columns))*4+(100/Math.max(rows,columns))*4))/2;
    private boolean isSolved;
    Label message = new Label();
    Group tiles = new Group();

    Button restart = new Button("NEW GAME");
    Button solve = new Button("SOLVE");
    Spinner rowNumber=new Spinner();
    Spinner columnNumber=new Spinner();
    SpinnerValueFactory<Integer> rowAmount= new SpinnerValueFactory.IntegerSpinnerValueFactory(2,32,4);
    SpinnerValueFactory<Integer> colAmount= new SpinnerValueFactory.IntegerSpinnerValueFactory(2,32,4);
    VBox spinners =new VBox();
    Pane gameName =new Pane();
    Label puzzle15=new Label("PUZZLE15");
    FlowPane buttons=new FlowPane();
    BorderPane mainPane = new BorderPane();

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


//create the board and add to Group
        createBoard();
//setting values in components
        rowNumber.setValueFactory(rowAmount);
        columnNumber.setValueFactory(colAmount);
//setting in place
        spinners.getChildren().addAll(rowNumber,columnNumber);
        spinners.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(solve,restart);
       buttons.setAlignment(Pos.CENTER);
        message.setAlignment(Pos.CENTER);
        gameName.getChildren().add(puzzle15);

//Styling
        String styleShadow="-fx-border-color: transparent;" +
                "-fx-effect: dropshadow(three-pass-box,rgb(0,0,0),10,0,0,0)";
        String styleButtonFocus="-fx-faint-focus-color:transparent;-fx-focus-color: transparent;";

        puzzle15.setRotate(-90);
        puzzle15.setTranslateY(200);
        puzzle15.setStyle("-fx-font-size: 40;-fx-font-weight: BOLD;-fx-padding: -50;-fx-text-fill: #4f2a2a;-fx-effect: dropshadow(three-pass-box,rgb(0,0,0),2,0,0,0)");
        rowNumber.setPrefSize(80,20);
        columnNumber.setPrefSize(80,20);
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
            puzzle15Logic.isEmptyTileNear(tilesList, puzzle15Logic.whichIndexIsHere(tilesList, e.getX(), e.getY(), tileSize), tileSize);
            isSolved = puzzle15Logic.isSolved(tilesList, tileSize, columns, rows);
            message.setText((isSolved) ? "CONGRATS!! YOU WON" : null);
        });

        restart.setOnAction(actionEvent -> {
            rows=rowAmount.getValue();
            columns=colAmount.getValue();
            setTileSize();
            createBoard();
            puzzle15Logic.shuffleLocation(tilesList);
        });

        solve.setOnAction(event -> {
            rows=rowAmount.getValue();
            columns=colAmount.getValue();
            setTileSize();
            createBoard();
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

    public void createBoard() {
       Image image = new Image(String.valueOf(baseImage), columns * tileSize, rows * tileSize, false, false);

        PixelReader px = image.getPixelReader();

        if (tiles.getChildren().containsAll(tilesList)) {
            tiles.getChildren().removeAll(tilesList);
        }
        if (tilesList.size() > 0)
            tilesList.clear();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle rect = new Rectangle(tileSize * i, tileSize * j, tileSize, tileSize);
                rect.setFill(new ImagePattern(new WritableImage(px, tileSize * i, tileSize * j, tileSize, tileSize)));

                if (i == columns - 1 && j == rows - 1)
                    rect.setFill(null);

                rect.setArcHeight(10);
                rect.setArcWidth(10);


                rect.setStyle("-fx-effect: dropshadow(three-pass-box,rgb(45,40,40),10,0,0,0)");
                tilesList.add(rect);
            }
        }

        tiles.getChildren().addAll(tilesList);
    }
public void setTileSize(){
    tileSize=(((100/Math.max(rows,columns))*4+(100/Math.max(rows,columns))*4))/2;
}
    public static void main(String[] args) {
        launch(args);
    }
}
