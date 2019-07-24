/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.JobAssignment;

import JobOptimizer.Staff.JobAssignee;
import JobOptimizer.Staff.Staff;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.shape.Circle;

/**
 *
 * @author PETER-PC
 */
public class JobToDo implements Comparable{
    private AssignableJob AssignableJob;
    private Staff jobAssigner;
    private Date timeOfAssignment,startTime, submissionTime,jobDeadline;
    private ArrayList<JobAssignee> jobAssigneeGroup;
    private int priorityNumber;
    private int[] jobAffinity;
    private Circle icon_jobAssignment;
    private static final ArrayList<JobToDo> ASSIGNEDJOBS = new ArrayList<>();
    private boolean isAssigned;

    public JobToDo(AssignableJob AssignableJob) {
        this.AssignableJob = AssignableJob;
        jobAssigner = null;
        timeOfAssignment = null;
        jobAssigneeGroup = new ArrayList<>();
        startTime = null;
        submissionTime = null;
        priorityNumber = 0;
        jobAffinity = null;
        jobDeadline = null;
        icon_jobAssignment = new Circle(5);
        isAssigned = false;
        
        if(!ASSIGNEDJOBS.contains(this))
            ASSIGNEDJOBS.add(this);
    }

    public void setJobAssigner(Staff jobAssigner) {
        this.jobAssigner = jobAssigner;
    }

    public void setTimeOfAssignment(Date timeOfAssignment) {
        this.timeOfAssignment = timeOfAssignment;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public void setIcon_jobAssignment(Circle icon_jobAssignment) {
        this.icon_jobAssignment = icon_jobAssignment;
    }

    public void generateJobAffinityOfAssigneeGroup() {
        jobAffinity = new int[jobAssigneeGroup.size()];
        
        jobAssigneeGroup.stream().forEach((j) -> {
            jobAffinity[jobAssigneeGroup.indexOf(j)] = (int) (1 + (Math.random() * 10));
        });
    }

    public void setIsAssigned(boolean isAssigned) {
        this.isAssigned = isAssigned;
    }
    
    public static ArrayList<JobToDo> getASSIGNEDJOBS() {
        return ASSIGNEDJOBS;
    }
    
    public void setJobAssignmentIconColor(){
        
    }
    
    public void generateJobAssigneeAffinities(){
        
    }
    
    public void generateDeadline(){
        
    }

    public void addAssigneeToJobAssigneeGroup(JobAssignee jobAssignee) {
        jobAssigneeGroup.add(jobAssignee);
    }

    public AssignableJob getAssignableJob() {
        return AssignableJob;
    }

    public Staff getJobAssigner() {
        return jobAssigner;
    }

    public Date getTimeOfAssignment() {
        return timeOfAssignment;
    }

    public ArrayList<JobAssignee> getJobAssigneeGroup() {
        return jobAssigneeGroup;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public int[] getJobAffinity() {
        return jobAffinity;
    }

    public Date getJobDeadline() {
        return jobDeadline;
    }

    public Circle getIcon_jobAssignment() {
        return icon_jobAssignment;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    @Override
    public boolean equals(Object obj) {
        return timeOfAssignment.getTime() == ((JobToDo)obj).timeOfAssignment.getTime(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        if(priorityNumber > ((JobToDo)o).priorityNumber)
            return -1;
        else if(priorityNumber < ((JobToDo)o).priorityNumber)
            return 1;
        else
            return 0;
    }
    
}