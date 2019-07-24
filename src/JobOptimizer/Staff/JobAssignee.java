/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.Staff;

import JobOptimizer.Graph.Branch;
import java.util.ArrayList;
import javafx.geometry.Point2D;
import JobOptimizer.JobAssignment.JobToDo;
import java.util.PriorityQueue;
import javafx.scene.shape.Circle;

/**
 *
 * @author PETER-PC
 */
public class JobAssignee extends Staff{
    private Staff jobAssigner;
    private final ArrayList<Point2D> locationHistory;
    private final PriorityQueue<JobToDo> jobList;
    private boolean availbilityStatus;
    private byte fatigueValue;
    private final Circle icon_jobAssignee;

    public JobAssignee(int userID, Branch branch, byte skillLevel, String jobTitle, Point2D currentLocation, String department) {
        super(userID, branch, skillLevel, jobTitle, currentLocation, department);
        locationHistory = new ArrayList<>();
        locationHistory.add(currentLocation);
        jobList = new PriorityQueue<>();
        availbilityStatus = false;
        fatigueValue = 0;
        icon_jobAssignee = new Circle(15);
    }
    
    public Circle getJobAssigneeIcon(){
        return icon_jobAssignee;
    }
    
    public boolean addLocationHistory(Point2D location){
        return locationHistory.add(location);
    }
    
    public void addLocationHistory(int index, Point2D location){
        locationHistory.add(index, location);
    }
    
    public boolean removeLocationHistory(Point2D location){
        return locationHistory.remove(location);
    }
    
    public boolean addToJobList(JobToDo j){
        return jobList.offer(j);
    }
    
    public boolean removeFromJobList(JobToDo j){
        return jobList.remove(j);
    }
    
    public Staff getJobAssigner() {
        return jobAssigner;
    }

    public void setJobAssigner(Staff jobAssigner) {
        this.jobAssigner = jobAssigner;
    }

    public boolean isAvailbilityStatus() {
        return availbilityStatus;
    }

    public void setAvailbilityStatus(boolean availbilityStatus) {
        this.availbilityStatus = availbilityStatus;
    }

    public byte getFatigueValue() {
        return fatigueValue;
    }

    public void setFatigueValue(byte fatigueValue) {
        this.fatigueValue = fatigueValue;
    }
    
    
    
}
