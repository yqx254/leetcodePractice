package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String s = "abcabcbb";
        for(int i = 0; i < s.length(); i ++){
            System.out.print(s.charAt(i));
            System.out.println(i);
        }

    }
}
