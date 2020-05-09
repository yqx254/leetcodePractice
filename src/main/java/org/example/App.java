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
        int [] nums2 = {2,3,4};
        List<Integer> list =  Arrays.stream(nums2).boxed().collect(Collectors.toList());
        System.out.println(1/2);


    }
}
