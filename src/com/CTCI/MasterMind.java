package com.CTCI;

import java.io.*;
import java.util.*;

public class MasterMind{
    private static int hit = 0;
    private static int pseudoHit = 0;
    public static void main(String[] args) throws IOException{
             
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Enter the guess");
         String guess = br.readLine();   
         estimate("RGBY",guess);
         System.out.println("Hit: " + hit + "PseudoHit: " + pseudoHit);
    }
    public static void estimate(String answer, String guess){
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>(4);
        for(int i = 0;i < 4;i++){
            if(hash.containsKey(answer.charAt(i)))
                hash.put(answer.charAt(i),hash.get(answer.charAt(i)) + 1);
            else
                hash.put(answer.charAt(i),1);
        }
       
        for(int i = 0;i < 4;i++){
            if(answer.charAt(i) == guess.charAt(i)){
                hit++;
                hash.put(guess.charAt(i),hash.get(guess.charAt(i)) - 1);
            }
            else if (hash.containsKey(guess.charAt(i))){
                if(hash.get(guess.charAt(i)) > 0){
                    pseudoHit++;
                    hash.put(guess.charAt(i),hash.get(guess.charAt(i)) - 1);
                }
            }
            
        }
    }
}
