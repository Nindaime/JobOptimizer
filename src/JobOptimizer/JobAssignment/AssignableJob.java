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
public class AssignableJob {
    private byte jobDifficulty;
//    private final ArrayList<String> authorisedJobTitles;
    private ArrayList<JobAssignee> authorisedJobAssignees;
    private JobObject jobObject;
    private float restTime;
    private float estimatedExecutionDuration;
    public String jobType;
    public String jobName;
    public final static ArrayList<AssignableJob> ASSIGNABLEJOBS = new ArrayList<>();

    public AssignableJob(String jobName, JobObject jobObject, byte jobDifficulty, float restTime, float estimatedExecutionDuration, String jobType) {
            this.jobDifficulty = jobDifficulty;
            this.jobObject = jobObject;
            this.restTime = restTime;
            this.estimatedExecutionDuration = estimatedExecutionDuration;
            this.jobType = jobType;
            this.jobName = jobName;
//            authorisedJobTitles = new ArrayList<>();
            authorisedJobAssignees = new ArrayList<>();
            
        if(!ASSIGNABLEJOBS.contains(this))
            ASSIGNABLEJOBS.add(this);
        
    }

    public void addAssigneeToAuthorisedJobAssigneeGroup(JobAssignee jobAssignee) {
        authorisedJobAssignees.add(jobAssignee);
    }

    public ArrayList<JobAssignee> getAuthorisedJobAssignees() {
        return authorisedJobAssignees;
    }

    public static ArrayList<AssignableJob> getASSIGNABLEJOBS() {
        return ASSIGNABLEJOBS;
    }
    
    public byte getJobDifficulty() {
        return jobDifficulty;
    }

    public void setJobDifficulty(byte jobDifficulty) {
        this.jobDifficulty = jobDifficulty;
    }

//    public ArrayList<String> getAuthorisedJobTitles() {
//        return authorisedJobTitles;
//    }
//
//    public void addToAuthorisedJobTitles(String authorisedJobTitle) {
//        authorisedJobTitles.add(authorisedJobTitle);
//    }

    public JobObject getJobObject() {
        return jobObject;
    }

    public void setJobObject(JobObject jobObject) {
        this.jobObject = jobObject;
    }

    public float getRestTime() {
        return restTime;
    }

    public void setRestTime(float restTime) {
        this.restTime = restTime;
    }

    public float getEstimatedExecutionDuration() {
        return estimatedExecutionDuration;
    }

    public void setEstimatedExecutionDuration(float estimatedExecutionDuration) {
        this.estimatedExecutionDuration = estimatedExecutionDuration;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
}
