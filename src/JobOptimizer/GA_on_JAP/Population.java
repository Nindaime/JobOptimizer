/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.GA_on_JAP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author PETER-PC
 */
public class Population {

    private final ArrayList<Individual> population;
    private int generationIterationID;

    public Population() {
        this.population = new ArrayList<>();
        this.generationIterationID = 0;
    }

    public Population(ArrayList<Individual> population) {
        this.population = population;
        this.generationIterationID = 0;
    }
    
    public int getGenerationIterationID() {
        return generationIterationID;
    }

    public void setGenerationIterationID(int generationIterationID) {
        this.generationIterationID = generationIterationID;
    }
    
    public ArrayList<Individual> getPopulation(){
        return population;
    }
    
    public boolean addIndividualToPopulation(Individual i){
        return population.add(i);
    }
    
    public boolean removeIndividualFromPopulation(Individual i){
        return population.remove(i);
    }
    
    public ArrayList<Individual> getCrossoverPopulation(){
        //apply the diversity function of splitting the population into 4 groups
        Individual[] generationToArray = (Individual[]) population.toArray();
        Arrays.parallelSort(generationToArray);

        
        ArrayList<Individual> outputPopulation = new ArrayList<>();
        int populationSeperationCoefficient = (generationToArray.length >= 4 ? generationToArray.length / 4 : 1);
        int individualIndex = 0;
        for(Individual i: generationToArray){
            if(individualIndex % populationSeperationCoefficient == 0)
                outputPopulation.add(i);
            individualIndex++;
        }
        
        return outputPopulation;
    }
}