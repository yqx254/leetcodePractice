package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // initializing unsorted long array
        long lArr[] = {1,2,5,6,9,8,4};

        // let us print all the elements available in list
        for (long number : lArr) {
            System.out.println("Number = " + number);
        }

        // sorting array from index 1 to 3
        Arrays.sort(lArr, 1, 6);

        // let us print all the elements available in list
        System.out.println("long array with some sorted values(1 to 3) is:");
        for (long number : lArr) {
            System.out.println("Number = " + number);
        }
    }

}
