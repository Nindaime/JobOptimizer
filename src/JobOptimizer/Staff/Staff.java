/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.Staff;

import javafx.geometry.Point2D;
import JobOptimizer.Graph.Branch;

/**
 *
 * @author PETER-PC
 */
public class Staff {
    private int userID;
    private Branch branch;
    private byte skillLevel;
    private String jobTitle;
    private Point2D currentLocation;
    private String department;

    public Staff(int userID, Branch branch, byte skillLevel, String jobTitle, Point2D currentLocation, String department) {
        this.userID = userID;
        this.branch = branch;
        this.skillLevel = skillLevel;
        this.jobTitle = jobTitle;
        this.currentLocation = currentLocation;
        this.department = department;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public byte getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(byte skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Point2D getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point2D currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
}
