package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = in.nextInt();
        int costMatrix[][] =  new int[n][n];
        System.out.println("Enter the elements of the matrix");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                costMatrix[i][j] = in.nextInt();

        Problem p = new Problem(costMatrix, n);
        p.Print();
    }
}
