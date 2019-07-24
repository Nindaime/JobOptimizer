/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.JobAssignment;

import JobOptimizer.Graph.Branch;
import java.util.ArrayList;

/**
 *
 * @author PETER-PC
 */
public class JobObject {
    private String jobObjectName;
    private Branch jobObjectLocation;
    public final static ArrayList<JobObject> JOBOBJECTLIST = new ArrayList<>();

    public JobObject(String jobObjectName, Branch jobObjectLocation) {
        this.jobObjectName = jobObjectName;
        this.jobObjectLocation = jobObjectLocation;
        
        if(!JOBOBJECTLIST.contains(this))
            JOBOBJECTLIST.add(this);
    }

    public String getJobObjectName() {
        return jobObjectName;
    }

    public Branch getJobObjectLocation() {
        return jobObjectLocation;
    }

    public void setJobObjectName(String jobObjectName) {
        this.jobObjectName = jobObjectName;
    }

    public void setJobObjectLocation(Branch jobObjectLocation) {
        this.jobObjectLocation = jobObjectLocation;
    }
    
    public JobObject getJobObjectFromList(int index){
        return JOBOBJECTLIST.get(index);
    }

    @Override
    public boolean equals(Object obj) {
        return (jobObjectName.matches(((JobObject)obj).jobObjectName) && jobObjectLocation.equals(((JobObject)obj).jobObjectLocation)); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
