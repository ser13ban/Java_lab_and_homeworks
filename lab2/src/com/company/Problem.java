package com.company;


import java.util.ArrayList;

public class Problem {
    private int[][] costMatrix;
    private int n;
    private ArrayList<Source> _sources = new ArrayList<Source>();
    private ArrayList<Destination> _destinations = new ArrayList<Destination>();

    public Problem(int[][] costMatrix, int n) {
        this.costMatrix = new int[n-1][n-1];
        this.n = n;
        for(int i=0;i<n-1;++i){
            for(int j=0;j<n-1;++j){
                this.costMatrix[i][j] = costMatrix[i][j];
            }
        }
        for (int j = 0; j< n-1; j++){
            Source aux = new Source("S", SourceType.FACOTRY, costMatrix[n][j]);
            _sources.add(aux);
            Destination daux = new Destination("D",costMatrix[j][n]);
            _destinations.add(daux);
        }
    }

    public void Print(){
        System.out.println("The cost matrix: ");
        for (int i = 1; i < n-1; i++) {
            System.out.print(_sources.get(i-1) + " ");
            for (int j = 1; j < n-1; j++)
                System.out.print(costMatrix[i][j] + "  ");
            System.out.println();
        }
    }
}
