package puzzle15Logic;

import java.util.Arrays;

/**
 * Created by Hodei Eceiza
 * Date: 10/22/2020
 * Time: 09:33
 * Project: puzzle15
 * Copyright: MIT
 */
public class puzzle15Logic {


    public static void main(String[] args) {
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