package puzzle15;

import javafx.application.Application;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    List<Rectangle> tilesList = new ArrayList<Rectangle>();
    int rows = 4;
    int columns = 4;

    @Override
    public void start(Stage primaryStage) {
        //  Parent tiles = FXMLLoader.load(getClass().getResource("puzzleBoard.fxml"));

        Image image = new Image("urazpin.jpg",400,400,false,false);

        PixelReader px = image.getPixelReader();
        // Pane tiles= new Pane();
        Group tiles = new Group();
        //  GridPane tiles =new GridPane();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle rect = new Rectangle(100 * i, 100 * j, 100, 100);

                WritableImage newImage = new WritableImage(px, 100 * i, 100 * j, 100, 100);

                Image cropped = newImage;
                ImagePattern imagePattern2 = new ImagePattern(cropped);


                rect.setFill(imagePattern2);
                if (i == columns - 1 && j == rows - 1)
                    rect.setFill(null);


                rect.setArcHeight(10);
                rect.setArcWidth(10);
                tilesList.add(rect);
                tiles.getChildren().add(rect);
            }
            //print List!!!
        }

        Button abutton = new Button();
        abutton.setTranslateY(250);
        abutton.setTranslateX(0);
        abutton.setText("REPLAY");
        StackPane pn = new StackPane();
        pn.getChildren().add(tiles);
        pn.getChildren().add(abutton);

        //Parent root = FXMLLoader.load(getClass().getResource("puzzleBoard.fxml"));
        primaryStage.setTitle("Puzzle 15");


        primaryStage.setScene(new Scene(pn, 600, 600, Color.DARKBLUE));
        primaryStage.show();
    }
    // TextField test=new TextField("FDAKFDAMFLKA");


    public static void main(String[] args) {
        launch(args);
    }
}
