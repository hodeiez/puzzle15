package puzzle15;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;

import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    List<Rectangle> tilesList = new ArrayList<>();
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

        //Image image = new Image("urazpin.jpg",400,400,false,false);

        Image image =new Image(String.valueOf(netImageJohan));
        PixelReader px = image.getPixelReader();



         //Pane tiles= new Pane();
        Group tiles = new Group();
          //GridPane tiles =new GridPane();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle rect = new Rectangle(100 * i, 100 * j, 100, 100);
                rect.setFill(new ImagePattern(new WritableImage(px, 100 * i, 100 * j, 100, 100)));

                if (i == columns - 1 && j == rows - 1)
                    rect.setFill(null);

                rect.setArcHeight(10);
                rect.setArcWidth(10);
                tilesList.add(rect);
            }


        }

        tiles.getChildren().addAll(tilesList);  //prints the List!!!



        Button abutton = new Button();
        abutton.setTranslateY(250);
        abutton.setTranslateX(0);

        //Fix style to print it!!
        abutton.setStyle("-fx-background-color: #d2d09d");
        abutton.setStyle("-fx-arc-height: 10;-fx-arc-width: 10");
        abutton.setStyle("-fx-border-color: #403e3e");
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
    // TextField test=new TextField("FDAKFDAMFLKA");


    public static void main(String[] args) {
        launch(args);
    }
}
