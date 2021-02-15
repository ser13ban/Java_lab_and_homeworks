package com.company;

public class Main {

    public static void main(String[] args) {


        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        String binary = "10101";
        String hex = "FF";

        n*=3;
        n+=Integer.parseInt( binary,2);
        n+=Integer.parseInt(  hex, 16);
        n*=6;

        int result = 0;
        while(n>10){
            result += n%10;
            n/=10;
        }
        int result2 = 0;
        while(result>10){
            result2+= result%10;
            result/=10;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result2]);
        System.out.println(result2);
    }
}
