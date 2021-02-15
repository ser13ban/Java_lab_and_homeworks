package com.company;

public class Main {
    public static void OutPutGraph(int n, int[][] graph){
        for(int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                System.out.print(String.valueOf(graph[i][j])+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //validating the imput
        if(args.length<1 || Integer.parseInt(args[0])%2==0 || Integer.parseInt(args[0])<0 ||args[0] == null){
            System.out.println("Invalid arguments");
            System.exit(0);
        }

        int n = Integer.parseInt(args[0]);
        System.out.println(n);

        //initializing the ajacency matrix
        int[][] graph = new int[n][n];
        for (int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                graph[i][j]=0;
            }
        }
        for (int i=0;i<n;++i) {
            for (int j = 0; j < n; ++j) {
                if(Math.random() < 0.5) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
                graph[i][i]=0;
            }
        }
        OutPutGraph(n,graph);
    }
}
