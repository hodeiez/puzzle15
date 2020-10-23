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
    public static void shuffleLocation(List<Rectangle> tiles) {

        Random rnd = new Random();

        for (int i = 0; i < tiles.size()*4; i++) {

            int tmp1 = rnd.nextInt(tiles.size());
            int tmp2 = rnd.nextInt(tiles.size());

            if ((tmp1 != tmp2) && (tiles.get(tmp1).getFill() != null && tiles.get(tmp2).getFill() != null)) {
                Rectangle temp = new Rectangle();
                temp.setX(tiles.get(tmp1).getX());
                temp.setY(tiles.get(tmp1).getY());
                tiles.get(tmp1).setX( tiles.get(tmp2).getX());
                tiles.get(tmp1).setY( tiles.get(tmp2).getY());
                tiles.get(tmp2).setX(temp.getX());
                tiles.get(tmp2).setY(temp.getY());
                // swap(tiles.get(tmp1), tiles.get(tmp2));
            }
        }

    }
    public static void shuffleImage(List<Rectangle> tiles) {

        Random rnd = new Random();

        for (int i = 0; i < tiles.size()*4; i++) {

            int tmp1 = rnd.nextInt(tiles.size());
            int tmp2 = rnd.nextInt(tiles.size());

            if ((tmp1 != tmp2) && (tiles.get(tmp1).getFill() != null && tiles.get(tmp2).getFill() != null)) {
                Rectangle temp = new Rectangle();
                temp.setFill(tiles.get(tmp1).getFill());
                tiles.get(tmp1).setFill( tiles.get(tmp2).getFill());
                tiles.get(tmp2).setFill(temp.getFill());
               // swap(tiles.get(tmp1), tiles.get(tmp2));
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
List<String>ar=new ArrayList<String>();
return ar;
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


}