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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1,1);
        map2.put(2,0);
        map2.remove(2);
        System.out.println(map.equals(map2));

    }
}
