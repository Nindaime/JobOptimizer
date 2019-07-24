/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.GA_on_JAP;

import JobOptimizer.JobAssignment.JobAssignment;

/**
 *
 * @author PETER-PC
 */
public class Individual implements Comparable{
    private JobAssignment jobAssignment;
    private float costFunction;
    private float fitnessFunction;

    public Individual(JobAssignment jobAssignment) {
        this.jobAssignment = jobAssignment;
        costFunction = fitnessFunction = 0;
    }
    
    public float getCostFunction(){
        return costFunction;
    }
    
    public float getFitnessFunction(){
        return fitnessFunction;
    }
    
    public boolean setFitnessFunction(){
        //fatigue value affects rest time
        //accounts for duration of execution
        //fitness function is a factor of cost function
        return false;
    }
    
    public boolean setCostFunction(){
        //get the cummulative cost of a job assignment
        return false;
    }
    
    @Override
    public int compareTo(Object o){
        if(fitnessFunction > ((Individual)o).fitnessFunction)
            return 1;
        else if(fitnessFunction < ((Individual)o).fitnessFunction)
            return -1;
        else
            return 0;
    }
}
