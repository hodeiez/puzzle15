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

import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;

public class Main extends Application {
    ArrayList<Rectangle> tilesList = new ArrayList<>();
    private int rows = 8;
    private int columns = 8;
    Group tiles = new Group();
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
        //prints the List!!!

//button for restart/shuffle
        Button restart = new Button();
        restart.setTranslateY(250);
        restart.setTranslateX(0);


//add action to button to shuffle
        restart.setOnAction(actionEvent -> {
            createBoard(); //make a new clean board before shuffle, so, we mantain the empty tile in its place
            puzzle15Logic.shuffleLocation(tilesList);
            System.out.println("X location= " + tilesList.get(0).getX() + " Y location= " + tilesList.get(0).getY());
        });
//Styling
        restart.setStyle("-fx-border-color: #fa2241");
        restart.setText("REPLAY");
//create a pane
        StackPane mainPane = new StackPane();
        mainPane.setStyle("-fx-background-color: #4a2a2a");

//add action to pane
        tiles.setOnMouseClicked(e -> {
            System.out.println("Y coordinate= " + e.getSceneX());
            System.out.println("X coordinate= " + e.getSceneY());
           puzzle15Logic.isEmptyTileClose(tilesList,puzzle15Logic.whichIndexIsHere(tilesList,e.getSceneX(),e.getSceneY()));
           // puzzle15Logic.showWhichTileIsHere(tilesList,e.getSceneX(),e.getSceneY());
           // puzzle15Logic.swapLocation(tilesList.get(15), tilesList.get(3));
        });

        mainPane.getChildren().add(tiles);
        mainPane.getChildren().add(restart);

        primaryStage.setTitle("Puzzle 15");


        primaryStage.setScene(new Scene(mainPane, 600, 600));
        primaryStage.show();
    }

    public void createBoard() {
        Image image = new Image(String.valueOf(netImageJohan), rows * 100, columns * 100, false, false);
        PixelReader px = image.getPixelReader();
        if (tiles.getChildren().containsAll(tilesList)) {
            tiles.getChildren().removeAll(tilesList);
        }
        if (tilesList.size() > 0)
            tilesList.clear();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Rectangle rect = new Rectangle(100 * i, 100 * j, 100, 100);
                rect.setFill(new ImagePattern(new WritableImage(px, 100 * i, 100 * j, 100, 100)));

                if (i == rows - 1 && j == columns - 1)
                    rect.setFill(null);

                rect.setArcHeight(10);
                rect.setArcWidth(10);
                tilesList.add(rect);
            }
        }

        tiles.getChildren().addAll(tilesList);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
