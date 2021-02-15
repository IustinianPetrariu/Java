package com.company;

public class Main {

    public static void main(String[] args) {
        ///cerinta 1
        System.out.println("Hello World!");
        //cerinta 2
        String[] languages= new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //cerinta  3
        int n = (int) (Math.random() * 1_000_000);
               //  System.out.println(n);
        //cerinta 4
        n=n*3;
              //  System.out.println(n);
        //cerinta  5
        int result=0;
        result = n + 0b10101 ;
              // System.out.println(n);
        //cerinta  6
        result=result+ 0xFF;
        //cerinta 7
        result=result * 6;
        ///cerinta  8
        result=result % 9 ; ///sum of the digits in the result
         if(result == 0 )
              result = 9 ;
        ///cerinta 9
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);


	// write your code here
    }
}
