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
                System.out.println(index + " " +" x "+ x + " y " + y + " real-->" + " x " +tilesList.get(index).getX() + " y "+ tilesList.get(index).getY());
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

                System.out.println("found");
            swapLocation(clickedTile, emptyTile);
        }
    }

}

    public static int whichIndexIsHere(List<Rectangle> tilesList, double x, double y, int tileSize) {
        //normalize values
        x -= (x % tileSize) + tileSize;
        y -= (y % tileSize) + tileSize;
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
/*
    public static void swapImage(Rectangle tmp1, Rectangle tmp2) {
        Rectangle temp = new Rectangle();
        temp.setFill(tmp1.getFill());

        tmp1.setFill(tmp2.getFill());
        tmp2.setFill(temp.getFill());
    }

    public static void shuffleImage(List<Rectangle> tiles) {

        Random rnd = new Random();

        for (int i = 0; i < tiles.size() * 4; i++) {

            int tmp1 = rnd.nextInt(tiles.size());
            int tmp2 = rnd.nextInt(tiles.size());

            if ((tmp1 != tmp2) && (tiles.get(tmp1).getFill() != null && tiles.get(tmp2).getFill() != null)) {
                swapImage(tiles.get(tmp1), tiles.get(tmp2));

            }
        }

    }

    //metod som slumpar ut brickorna.
    public List<String> randomBricks() {
        List<String> randomBricks = new ArrayList<>();
        int randomNum;
        randomNum = ThreadLocalRandom.current().nextInt(0, 16);
        randomBricks.add(String.valueOf(randomNum));

        while (randomBricks.size() < 16) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 16);
            Boolean check = false;
            System.out.println("random " + randomNum);

            for (int i = 0; i < randomBricks.size(); i++)
                if (randomNum == Integer.parseInt(randomBricks.get(i)))
                    check = true;

            if (check == false)
                randomBricks.add(String.valueOf(randomNum));
        }
        return randomBricks;
    }

    //metod som byter plats på vald bricka och tomma platsen.
    //inparameter: en plats i arrayen där en bricka finns placerad.
    public List<String> changePlace(List<String> brickArray, int indexOfChoosenBrick) {
        //1. Är det en godkänd bricka?

        //placering av 0
        int indexOfX;
        for (int i = 0; i < brickArray.size(); i++)
            if (brickArray.get(i).equalsIgnoreCase("0"))
                indexOfX = i;
        return brickArray;
    }


    public static void main(String[] args) {

        puzzle15Logic puzzle = new puzzle15Logic();
        List<String> brickArray = puzzle.randomBricks();


        String[] brickor = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "X"};
        int temp = 0;
        //for (int i = 0; i < 4; i++) {//råd 1 //0---1

        for (int j = 0; j < 4; j++) //elementet ino råd 0 =5 // 0,1,2,3//4,5,6,7//
            System.out.print(brickor[j]);
        System.out.println();
        for (int jj = 4; jj < 8; jj++) //elementet ino råd
            System.out.print(brickor[jj]);

        System.out.println();
        for (int f = 8; f < 12; f++) //elementet ino råd 0 =5 // 0,1,2,3//4,5,6,7//
            System.out.print(brickor[f]);
        System.out.println();
        for (int jj = 12; jj < 16; jj++) //elementet ino råd
            System.out.print(brickor[jj]);

        System.out.println();


    }

*/
}