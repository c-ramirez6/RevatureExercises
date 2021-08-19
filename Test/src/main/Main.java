package main;
import java.lang.*;

import java.io.*;

import java.lang.Math;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        // INPUT [uncomment & modify if required]

        Scanner sc = new Scanner(System.in);

        String S = sc.next();

       

        // OUTPUT [uncomment & modify if required]

        System.out.print(cipher(S));

        sc.close();

    }

    public static String cipher(String S) {

        //this is default OUTPUT. You can change it

        String result="";

        

        //WRITE YOUR LOGIC HERE:

        // S.charAt(index)

        for(int i = 0; i < S.length(); i++) {

            S = S.toString();

            char c = S.charAt(i);

            int value = Character.getNumericValue(c);

            if(value < 19)  {

                result = result + "0" + (value - 9);

            }

            else if(value < 30 && value >=19) {

                result = result + "1" + (value - 19); 

            }

            else if(value < 40 && value >= 29)  {

                result = result + "2" + (value - 29); 

            }
            System.out.println(value);

        }

                

        //For optimizing code, You are free to make changes to "return type", "variables" and "Libraries".        

        return result;

    }

}