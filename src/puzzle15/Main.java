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

import java.util.Random;

public class Main extends Application {
    ArrayList<Rectangle> tilesList = new ArrayList<>();
    private int rows = 4;
    private int columns = 4;
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
        //  Parent tiles = FXMLLoader.load(getClass().getResource("puzzleBoard.fxml"));

        Image image = new Image(String.valueOf(netImageJohan),400,400,false,false);
        PixelReader px = image.getPixelReader();


        Group tiles = new Group();


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
        puzzle15Logic.shuffleLocation(tilesList);
        tiles.getChildren().addAll(tilesList);  //prints the List!!!


        Button abutton = new Button();
        abutton.setTranslateY(250);
        abutton.setTranslateX(0);
//add action to button to shuffle
        abutton.setOnAction(actionEvent -> {puzzle15Logic.shuffleLocation(tilesList);
            System.out.println("X location= " + tilesList.get(0).getX()+ " Y location= "+tilesList.get(0).getY());});

        abutton.setStyle("-fx-border-color: #fa2241");
        abutton.setText("REPLAY");

        StackPane pn = new StackPane();
        pn.setStyle("-fx-background-color: #4a2a2a");


        pn.getChildren().add(tiles);
        pn.getChildren().add(abutton);

        //Parent root = FXMLLoader.load(getClass().getResource("puzzleBoard.fxml"));
        primaryStage.setTitle("Puzzle 15");


        primaryStage.setScene(new Scene(pn, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
