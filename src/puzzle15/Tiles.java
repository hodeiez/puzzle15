package puzzle15;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Hodei Eceiza
 * Date: 10/24/2020
 * Time: 23:38
 * Project: puzzle15
 * Copyright: MIT
 */
public class Tiles {
    private int rows;
    private int columns;
    private int tileSize;
    ArrayList<Rectangle> tilesList = new ArrayList<>();
    private Image baseImage;
    private URL imageURL;
    Group tiles;

    Tiles(){}

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public ArrayList<Rectangle> getTilesList() {
        return tilesList;
    }

    public void setTilesList(ArrayList<Rectangle> tilesList) {
        this.tilesList = tilesList;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(Image baseImage) {
        this.baseImage = baseImage;
    }

    public URL getImageURL() {
        return imageURL;
    }

    public void setImageURL(URL imageURL) {
        this.imageURL = imageURL;
    }

    public Group getTiles() {
        return tiles;
    }

    public void setTiles(Group tiles) {
        this.tiles = tiles;
    }

    public void createBoard() {
        Image image = new Image(String.valueOf(imageURL), columns * tileSize, rows * tileSize, false, false);
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
}
