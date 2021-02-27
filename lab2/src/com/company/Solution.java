package com.company;

public class Solution {
    public Problem p;
    public Solution(Problem p){
        this.p = p;
    }

    /***
     * find the colum index of the smalest cost available
     * a cost is available if at least the supply or the demand are greater than 0
     * @param j is the position in current poisition in the supply array
     * @return an integer representing the posution
     */
    public int getMinCostIndex(int j){
        int min = 100000, pos = 0;
        for( int i= 0; i <p.n-1; ++i ){
            if(p.costMatrix[j][i] <= min && (p._sources.get(j).getSupply() > 0 && p._destinations.get(i).getDemand() > 0)){
                min = p.costMatrix[j][i];
                pos = i;
            }
        }
        return pos;
    }

    /***
     * gives us a solution to an instance of the transport problem
     * outputes the choices and the cost attached to them
     * @return nothing
     */
    public int solve(){
        int totalCost = 0;
        for (int i = 0; i <p._sources.size(); ++i ){
            while(p._sources.get(i).getSupply() > 0){
                int minCostIndex = getMinCostIndex(i);

                if(p._destinations.get(i).getDemand() > 0 && p._sources.get(i).getSupply() > p._destinations.get(i).getDemand()){
                    p._sources.get(i).setSupply(p._sources.get(i).getSupply() - p._destinations.get(i).getDemand());
                    totalCost += (p._destinations.get(i).getDemand() * p.costMatrix[minCostIndex][i]);
                    System.out.println(p._sources.get(i).getName() + " -> " +p._destinations.get(minCostIndex).getName() + ": " +p._destinations.get(i).getDemand() + " units * cosst " + p.costMatrix[i][minCostIndex] + " = "  + p._destinations.get(i).getDemand() * p.costMatrix[i][minCostIndex]);
                    p._destinations.get(i).setDemand(0);
                   }else {
                    p._destinations.get(i).setDemand( p._destinations.get(i).getDemand() - p._sources.get(i).getSupply());
                    totalCost += (p._sources.get(i).getSupply() * p.costMatrix[i][minCostIndex]);
                    System.out.println(p._sources.get(i).getName() + " -> " +p._destinations.get(minCostIndex).getName() + ": " + p._sources.get(i).getSupply() + " units * cost " + p.costMatrix[i][minCostIndex] + " = " +  p._sources.get(i).getSupply() * p.costMatrix[i][minCostIndex]);
                    p._sources.get(i).setSupply(0);
                }
            }
        }

        return totalCost;
    }
}
