/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.JobAssignment;

import JobOptimizer.Staff.JobAssignee;
import java.util.ArrayList;

/**
 *
 * @author PETER-PC
 */
public class JobAssignment implements Cloneable{
    private ArrayList<JobAssignee> jobAssignees;
    private ArrayList<JobToDo> jobToDo;
    private int[][] jobAssignmentMatrix;
    
    public void generateAssignmentMatrixCostFunction(){
        
    }

    public JobAssignment(ArrayList<JobToDo> jobToDo) {
        this.jobAssignees = new ArrayList<>();
        jobToDo.stream().forEach((j) -> {
            for(JobAssignee jA: j.getAssignableJob().getAuthorisedJobAssignees())
                if(!jobAssignees.contains(jA))
                    jobAssignees.add(jA);
        });
        
        this.jobToDo = jobToDo;
        this.jobAssignmentMatrix = new int[jobAssignees.size()][jobToDo.size()];
    }

    public ArrayList<JobAssignee> getJobAssignees() {
        return jobAssignees;
    }

    public ArrayList<JobToDo> getToDoJobs() {
        return jobToDo;
    }

    public int[][] getJobAssignmentMatrix() {
        return jobAssignmentMatrix;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        JobAssignment clonedJobAssignment= null;
        clonedJobAssignment.jobAssignees = (ArrayList<JobAssignee>) (jobAssignees.clone());
        clonedJobAssignment.jobToDo = (ArrayList<JobToDo>) (jobToDo.clone());
        
        int rowIndex = 0;
        for(int[] row: jobAssignmentMatrix){
            int columIndex = 0;
            for(int assignmentCost: row)
                clonedJobAssignment.jobAssignmentMatrix[rowIndex][columIndex] = assignmentCost;
            
            rowIndex++;
        }
        
        return clonedJobAssignment; //To change body of generated methods, choose Tools | Templates.
    }
    
}
