import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AOC2 {
    public static void main(String [] pArgs) throws IOException {
        FileInputStream fstream = new FileInputStream("src/main/resources/aoc2.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        Map<Character, Integer> myMap = new HashMap<>();
        myMap.put('X', 1);
        myMap.put('Y', 2);
        myMap.put('Z', 3);

        Map<Character, Integer> hisMap = new HashMap<>();
        hisMap.put('A', 1);
        hisMap.put('B', 2);
        hisMap.put('C', 3);
        int opponent = 0;
        int myself = 0;

        while ((strLine = br.readLine()) != null)   {
            char[] chr = strLine.toCharArray();

            // part 1 solution
            /*
             * 0 for a loss
             * 3 for a draw
             * 6 for a win
             *
             * Roc(A, X)k defeats scissors(C, Z)
             * Scissors(C, Z) defeats paper(B, Y)
             * Paper(B, Y) defeats Rock(A,X)
             * */
            //rock - scissor
//            if(chr[0]=='A' && chr[2]=='Z') {
//              opponent += hisMap.get(chr[0])+6;
//              myself += myMap.get(chr[2]);
//            } else if(chr[0]=='C' && chr[2]=='X') {
//                myself += myMap.get(chr[2])+6;
//                opponent += hisMap.get(chr[0]);
//            } else if((chr[0]=='A' && chr[2]=='X') || (chr[0]=='C' && chr[2]=='Z')){
//                opponent += hisMap.get(chr[0])+3;
//                myself += myMap.get(chr[2])+3;
//            }
//            // rock - paper
//            else if(chr[0]=='A' && chr[2]=='Y'){
//                opponent += hisMap.get(chr[0]);
//                myself += myMap.get(chr[2])+6;
//            }
//            else if(chr[0]=='B' && chr[2]=='X') {
//                opponent += hisMap.get(chr[0])+6;
//                myself += myMap.get(chr[2]);
//            } else if(chr[0] == 'B' && chr[2] == 'Y'){
//                myself += myMap.get(chr[2])+3;
//                opponent += hisMap.get(chr[0])+3;
//            }
//
//            //paper - scissor
//            else if(chr[0]=='B' && chr[2]=='Z') {
//                myself += myMap.get(chr[2])+6;
//                opponent += hisMap.get(chr[0]);
//            } else if(chr[0]=='C' && chr[2]=='Y') {
//                opponent += hisMap.get(chr[0])+6;
//                myself += myMap.get(chr[2]);
//            }

// Part two solution:             
            // X - Lose
            // Y - Draw
            // Z - Win

            //rock
            if(chr[0]=='A' && chr[2]=='Z') {
                chr[2] = 'Y';
                opponent += hisMap.get(chr[0]);
                myself += myMap.get(chr[2])+6;
                continue;
            } else if(chr[0]=='A' && chr[2]=='Y') {
                chr[2] = 'X';
                myself += myMap.get(chr[2])+3;
                opponent += hisMap.get(chr[0])+3;
                continue;
            } else if(chr[0]=='A' && chr[2]=='X'){
                chr[2] = 'Z';
                opponent += hisMap.get(chr[0])+6;
                myself += myMap.get(chr[2]);
                continue;
            }

            // paper
            if(chr[0]=='B' && chr[2]=='X') {
                opponent += hisMap.get(chr[0])+6;
                myself += myMap.get(chr[2]);
                continue;
            } else if(chr[0]=='B' && chr[2]=='Y') {
                myself += myMap.get(chr[2])+3;
                opponent += hisMap.get(chr[0])+3;
                continue;
            }
            else if(chr[0]=='B' && chr[2]=='Z'){
                opponent += hisMap.get(chr[0]);
                myself += myMap.get(chr[2])+6;
                continue;
            }

            // scissor
            if(chr[0]=='C' && chr[2]=='X') {
                chr[2]='Y';
                opponent += hisMap.get(chr[0])+6;
                myself += myMap.get(chr[2]);
            } else if(chr[0]=='C' && chr[2]=='Y') {
                chr[2]='Z';
                myself += myMap.get(chr[2])+3;
                opponent += hisMap.get(chr[0])+3;
            }
            else if(chr[0]=='C' && chr[2]=='Z'){
                chr[2] = 'X';
                opponent += hisMap.get(chr[0]);
                myself += myMap.get(chr[2])+6;
            }
        }

        System.out.println(myself);
        fstream.close();
    }
}
