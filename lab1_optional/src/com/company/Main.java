package com.company;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void OutPutGraph(int n, int[][] graph) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void DFS(int start, boolean[] viz, int[][] graph){
        System.out.print(start + " ");
        viz[start] = true;
        for (int i = 0; i<graph.length; ++i){
            if(graph[start][i] == 1 && (!viz[i])){
                DFS(i,viz,graph);
            }
        }
    }

    public static void findNrOfComponnets(boolean[] viz, int[][] graph){
        int numberOfComponents = 0;
        for(int  i = 0; i<graph.length;++i){
            //we will start do dfs on every node in the graph
            if(!viz[i]){
                System.out.println();
                numberOfComponents++;
                DFS(i, viz, graph);
            }
        }
        if(numberOfComponents == 1){
            System.out.println("\nThe graph is connected");
        }
        else {
            System.out.print("\nThe graph has: " + numberOfComponents + " Components");
        }
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        //validating the input
        if (args.length < 1 || Integer.parseInt(args[0]) % 2 == 0 || Integer.parseInt(args[0]) < 0 || args[0] == null) {
            System.out.println("Invalid arguments");
            System.exit(0);
        }

        int n = Integer.parseInt(args[0]);
        System.out.println(n);

        //initializing the adjacency matrix and the vizited vector for each node
        int[][] graph = new int[n][n];
        boolean[] viz = new boolean[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                graph[i][j] = 0;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (Math.random() < 0.5) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
                graph[i][i] = 0;
            }
        }
        if(n>10_000){
            System.out.println();
            findNrOfComponnets(viz,graph);
        }
        else{
            OutPutGraph(n, graph);
            System.out.println();
            findNrOfComponnets(viz,graph);
        }

        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds  : " + timeElapsed);

    }
}
