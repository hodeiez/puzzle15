package puzzle15Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Hodei Eceiza
 * Date: 10/22/2020
 * Time: 09:33
 * Project: puzzle15
 * Copyright: MIT
 */
public class puzzle15Logic {


    //metod som slumpar ut brickorna.
    public List<String> randomBricks () {
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
    public List<String> changePlace (List<String> brickArray, int indexOfChoosenBrick){

        //hitta index av X.
        int indexOfX = 0;
        for (int i = 0; i < brickArray.size(); i++)
            if (brickArray.get(i).equalsIgnoreCase("X"))
                indexOfX = i;
        System.out.println("index på X: " + indexOfX);


        //om godkänd plats så byter den plats.
        if (indexOfChoosenBrick == indexOfX - 1 || indexOfChoosenBrick == indexOfX + 1
            || indexOfChoosenBrick == indexOfX - 4 || indexOfChoosenBrick == indexOfX + 4) {
            brickArray.set(indexOfX, brickArray.get(indexOfChoosenBrick));
            brickArray.set(indexOfChoosenBrick, "X");
        }

        //test
        System.out.println("Array efter byte");
        for (int i = 0; i < brickArray.size(); i++) {
            System.out.print(brickArray.get(i) + " ");
        }
        System.out.println();

        return brickArray;

    }

    //metoden kollar om pusslet har lösts.
    public boolean isVictory (List<String> brickArray){

        String[] victoryLayout = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "X"};

        boolean isVicotory = false;
        int victoryCount = 0;

        for (int i = 0; i < brickArray.size(); i++) {
            if (brickArray.get(i) == victoryLayout[i])
                victoryCount += 1;
        }

        if (victoryCount == 16)
            return true;
        else
            return false;
    }






    public static void main(String[] args) {

        puzzle15Logic puzzle = new puzzle15Logic();
        List<String> randomBrickArray = puzzle.randomBricks();

        List<String> testArray = new ArrayList<>();
        testArray.add("1"); //index 0
        testArray.add("2");
        testArray.add("3");
        testArray.add("4");
        testArray.add("5");
        testArray.add("6"); //index 5
        testArray.add("7");
        testArray.add("8");
        testArray.add("9");
        testArray.add("10"); //index 10
        testArray.add("11");
        testArray.add("12");
        testArray.add("13");
        testArray.add("14");
        testArray.add("15"); //index// 15
        testArray.add("X");

        //test
        System.out.println("Array före byte");
        for (int i = 0; i < testArray.size(); i++)
            System.out.print (testArray.get(i) + " ");
        System.out.println();

        puzzle.changePlace(testArray, 3);

        //test
        boolean isVictory = puzzle.isVictory(testArray);
        if (isVictory)
            System.out.println("Seger!");
        else
            System.out.println("Inte seger!");





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