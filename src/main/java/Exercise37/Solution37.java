/*
 *  UCF COP3330 Fall 2021 Assignment 37 Solution
 *  Copyright 2021 Ihosvany Marquez
 */

package Exercise37;

import java.util.Random;
import java.util.Scanner;

public class Solution37
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        int length,specialCharacter, numbers, randomizer;
        int specialCharacterAmount = 0, numberAmount = 0, letterAmount = 0;
        String digits = "0123456789";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxzy";
        String special = "!@#$%&*()?";
        String password = "";

        System.out.print( "What is the minimum length? " );
        length = scan.nextInt();
        System.out.print("How many special characters? ");
        specialCharacter = scan.nextInt();
        System.out.print("How many numbers? ");
        numbers = scan.nextInt();

        while (password.length() < length || specialCharacterAmount < specialCharacter || numberAmount < numbers || letterAmount < (specialCharacterAmount + numberAmount) )
        {
            randomizer = randomFunction(2);
            if (randomizer==0 && specialCharacterAmount < specialCharacter){
                password = characterFunction(password, special);
                specialCharacterAmount++;
            }
            if (randomizer == 1 && numberAmount < numbers){
                password = characterFunction(password, digits);
                numberAmount++;
            }
            else{
                password = characterFunction(password, abc);
                letterAmount++;
            }
        }

        System.out.println("Your password is " + password);
    }
    public static int randomFunction (int length)
    {
        Random r = new Random();
        return r.nextInt((length)) ;
    }
    public static String characterFunction(String password, String chars)
    {
        return password + chars.charAt(randomFunction(chars.length()));
    }
}