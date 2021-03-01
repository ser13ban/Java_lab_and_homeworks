package com.company;


import java.util.ArrayList;

public class Problem {
    public int[][] costMatrix;
    public int n;
    public ArrayList<Source> _sources = new ArrayList<Source>();
    public ArrayList<Destination> _destinations = new ArrayList<Destination>();

    /***
     * This method extracts from the matrix cost the supply and demmands values and creates the cost matrix
     * @param cost the matrix given by the user
     * @param n the size of the input matrix
     */
    public Problem(int[][] cost, int n) {
        this.costMatrix = new int[n-1][n-1];
        this.n = n;
        for(int i=0;i<n-1;++i){
            for(int j=0;j<n-1;++j){
                this.costMatrix[i][j] = cost[i][j];
            }
        }
        for (int j = 0; j < n-1; j++){
            Source aux = new Factory("S" + (j+1), cost[j][n-1]);
            _sources.add(aux);
            //we need to chek if the there are two similar sources (we can't allow that)
            for (int i = 0; i<j;++i){
                if(_sources.get(i).equals(_sources.get(j))){
                    System.out.println("We can't have two identical sources!");
                    System.exit(1);
                }
            }
            for (int i = j+1; i<_sources.size();++i){
                if(_sources.get(i).equals(_sources.get(j))){
                    System.out.println("We can't have two identical sources!");
                    System.exit(1);
                }
            }

            Destination daux = new Destination("D" + (j+1),cost[n-1][j]);
            _destinations.add(daux);
            for (int i = 0; i<j; ++i){
                if(_destinations.get(i).equals(_destinations.get(j))){
                    System.out.println("We can't have two indentical destinations");
                    System.exit(1);
                }
            }
            for (int i = j+1; i<_destinations.size(); ++i){
                if(_destinations.get(i).equals(_destinations.get(j))){
                    System.out.println("We can't have two indentical destinations");
                    System.exit(1);
                }
            }

        }
    }

    /***
     * This method prints the cost matrix and all of the supplies and demands values
     */
    public void Print(){
        System.out.println("The cost matrix: ");
        for (int i = 0; i< n-1; ++i){
            for(int j=0;j<n-1;++j){
                System.out.print(costMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nThe supplies:");
        for (Source i : _sources
             ) {
            System.out.println(i.getName() + " : " + i.getSupply());
        }
        System.out.println("\nThe demands:");
        for (Destination i: _destinations
             ) {
            System.out.println(i.getName() + " : " + i.getDemand());
        }
    }
}
