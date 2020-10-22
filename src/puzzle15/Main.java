package puzzle15;
/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
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
import javafx.stage.Stage;


import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
List<Rectangle> tilesList=new ArrayList<Rectangle>();
  // List<ImageView>tilesCell=new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
     //  Parent tiles = FXMLLoader.load(getClass().getResource("puzzleBoard.fxml"));

       Pane tiles= new Pane();
       //Group tiles =new Group();

        for(int i=0;i<=3;i++){
            for(int j=0;j<=3;j++){
               Rectangle rect=new Rectangle(100*i,100*j,100,100);
                Image image = new Image("urazpin.jpg");

               // ImagePattern imagePattern = new ImagePattern(image);
                PixelReader px=image.getPixelReader();

                WritableImage newImage = new WritableImage(px,100*i,100*j,100,100);

                Image cropped=newImage;
                ImagePattern imagePattern2 = new ImagePattern(cropped);
                rect.setFill(imagePattern2);


                //rect.setFill(Color.BEIGE);
                rect.setArcHeight(10);
                rect.setArcWidth(10);
                tilesList.add(rect);
               tiles.getChildren().add(rect);
            }

        }

        Button abutton=new Button();
        abutton.setTranslateY(250);
        abutton.setTranslateX(0);
        abutton.setText("REPLAY");
        StackPane pn=new StackPane();
        pn.getChildren().add(tiles);
        pn.getChildren().add(abutton);

        //Parent root = FXMLLoader.load(getClass().getResource("puzzleBoard.fxml"));
        primaryStage.setTitle("Puzzle 15");



        primaryStage.setScene(new Scene(pn, 600, 600,Color.DARKBLUE));
        primaryStage.show();
    }
       // TextField test=new TextField("FDAKFDAMFLKA");


    public static void main(String[] args) {
        launch(args);
    }
}
*/