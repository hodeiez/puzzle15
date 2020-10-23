package puzzle15;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Main extends Application {
    ArrayList<Rectangle> tilesList = new ArrayList<>();
    public final int tileSize=100;
    private int rows = 4;
    private int columns = 4;
    Group tiles = new Group();
    Button restart = new Button();
    StackPane mainPane = new StackPane();
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

//button for restart/shuffle

        restart.setTranslateY(250);
        restart.setTranslateX(0);



//Styling
        restart.setStyle("-fx-faint-focus-color:transparent;-fx-focus-color: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-effect: dropshadow(three-pass-box,rgb(0,0,0),10,0,0,0)");
        restart.setText("REPLAY");

        mainPane.setStyle("-fx-background-color: #864c4c");

//add action to pane
        tiles.setOnMouseClicked(e -> {
            System.out.println("Mouse Y coordinate= " + e.getSceneX());
            System.out.println("Mouse X coordinate= " + e.getSceneY());
            puzzle15Logic.isEmptyTileClose(tilesList, puzzle15Logic.whichIndexIsHere(tilesList, e.getSceneX(), e.getSceneY(),tileSize),tileSize);

        });
        //add action to button to shuffle
        restart.setOnAction(actionEvent -> {
            createBoard(); //make a new clean board before shuffle, so, we mantain the empty tile in its place
            puzzle15Logic.shuffleLocation(tilesList);
        });
//add stuff
        mainPane.getChildren().add(tiles);
        mainPane.getChildren().add(restart);

        primaryStage.setTitle("Puzzle 15");


        primaryStage.setScene(new Scene(mainPane,600, 600));
        primaryStage.show();
    }

    public void createBoard() {
        Image image = new Image(String.valueOf(netImageHodei), columns * tileSize, rows * tileSize, false, false);
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

    public static void main(String[] args) {
        launch(args);
    }
}
