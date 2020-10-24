package puzzle15;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hodei Eceiza
 * Date: 10/22/2020
 * Time: 09:33
 * Project: puzzle15
 * Copyright: MIT
 */

public class puzzle15Logic {
    public static boolean isSolved(List<Rectangle>tilesList, int tileSize,int columns,int rows){
        boolean check=false;
        int index=0;
        for(int x=0;x<tileSize*columns;x+=tileSize){
            for(int y=0;y<tileSize*rows;y+=tileSize){

                    if (tilesList.get(index).getX() == x && tilesList.get(index).getY() == y) {
                        if(tilesList.get(tilesList.size()-1).getFill()==null){
                        check = true;}
                    } else {
                        check = false;
                        break;
                    }
                index++;
            }


            }

        return check;
    }
    public static void isEmptyTileNear(List<Rectangle> tilesList, int tileIndex, int tileSize) {
        if (tileIndex >= 0) {
            Rectangle clickedTile = tilesList.get(tileIndex);
            Rectangle emptyTile = tilesList.get(tilesList.size() - 1);

            if ((clickedTile.getX() == emptyTile.getX()
                    && (clickedTile.getY() - tileSize == emptyTile.getY() || clickedTile.getY() + tileSize == emptyTile.getY())) ||
                    (clickedTile.getY() == emptyTile.getY()
                            && (clickedTile.getX() - tileSize == emptyTile.getX() || clickedTile.getX() + tileSize == emptyTile.getX()))){

            swapLocation(clickedTile, emptyTile);
        }
    }

}

    public static int whichIndexIsHere(List<Rectangle> tilesList, double x, double y, int tileSize) {
        //normalize values
        x -= (x % tileSize);
        y -= (y % tileSize);
        //check if a rectangle is there
        for (Rectangle r : tilesList) {
            if (r.getX() == x && r.getY() == y)
                return tilesList.indexOf(r);
        }
        return -1;
    }

    public static void shuffleLocation(List<Rectangle> tiles) {

        Random rnd = new Random();

        for (int i = 0; i < tiles.size() * 4; i++) {

            int tmp1 = rnd.nextInt(tiles.size());
            int tmp2 = rnd.nextInt(tiles.size());

            if ((tmp1 != tmp2) && (tiles.get(tmp1).getFill() != null && tiles.get(tmp2).getFill() != null)) {
                swapLocation(tiles.get(tmp1), tiles.get(tmp2));
            }
        }

    }

    public static void swapLocation(Rectangle tmp1, Rectangle tmp2) {
        Rectangle temp = new Rectangle();
        temp.setX(tmp1.getX());
        temp.setY(tmp1.getY());
        tmp1.setX(tmp2.getX());
        tmp1.setY(tmp2.getY());
        tmp2.setX(temp.getX());
        tmp2.setY(temp.getY());
    }

}