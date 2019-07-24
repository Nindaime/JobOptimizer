/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.DBModule;

import JobOptimizer.Graph.Branch;
import JobOptimizer.JobAssignment.JobObject;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PETER-PC
 */
public class DBUtilityClass {
    private final Connection dbConnection;
    private boolean operationSuccessful;
    
    public DBUtilityClass(){
        dbConnection = new DBConnection().getConnection();
        operationSuccessful = false;
    }
    
    public boolean uploadDataset(){
        operationSuccessful = false;
        
        return operationSuccessful;
    }
    
    public boolean buildAssignableJobs(){
        operationSuccessful = false;
        
        return operationSuccessful;
    }
    
    public boolean buildBranchObjects(){
        operationSuccessful = false;
        String QueryString = "SELECT BranchName, BranchLocation FROM Branch";
        try(
                PreparedStatement prepapredStatement = dbConnection.prepareStatement(QueryString);
                ResultSet resultSet = prepapredStatement.executeQuery();){
                while(resultSet.next()){
                    String BRANCHNAME = resultSet.getString("BranchName");
                    String BRANCHLOCATION = resultSet.getString("BranchLocation");

                    new Branch(BRANCHNAME, BRANCHLOCATION);
                }
                Branch.buildGraphConnections();
                operationSuccessful = true;
        }catch(SQLException | IOException ex){operationSuccessful = false;}
        
        
        return operationSuccessful;
    }
    
    public boolean buildJobObjects(){
        operationSuccessful = false;

        String QueryString = "SELECT JobObjectName, JobObjectlocation FROM AssignableJob";
        try (
                PreparedStatement preparedStatement = dbConnection.prepareStatement(QueryString);
                ResultSet JobObject_resultSet = preparedStatement.executeQuery();) {
            while (JobObject_resultSet.next()) {
                Branch jobObjectLocation = Branch.getBranchFromBRANCHES(JobObject_resultSet.getString("JobObjectlocation"));
                String jobObjectName = JobObject_resultSet.getString("JobObjectName");
                
                new JobObject(jobObjectName, jobObjectLocation);
            }

        } catch (SQLException ex) {
        }

        return operationSuccessful;
    }
    
    public boolean buildAssignableJobObjects(){
        operationSuccessful = false;
        
        String QueryString = "SELECT FROM AssignableJob";
        try(
                PreparedStatement preparedStatement = dbConnection.prepareStatement(QueryString);
                ResultSet AssgnableJob_resultSet = preparedStatement.executeQuery();
                ResultSet AuthorisedJobAssignees_resultSet = preparedStatement.executeQuery();
                ){
                while(AssgnableJob_resultSet.next()){
                    
                }
            
        }catch(SQLException ex){}
        
        return operationSuccessful;
    }

}
