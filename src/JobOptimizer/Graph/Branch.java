/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.Graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author PETER-PC
 */
public class Branch extends ImageView{
    private static final File[] ICONLIST = {new File("img/BankIcon1.png"), new File("img/BankIcon2.png"), new File("img/BankIcon3.png"), new File("img/BankIcon4.png")};
    private String branchName;
    private Point2D branchLocation;
    private final Label lblBranchName;
    private final static ArrayList<Branch> BRANCHES = new ArrayList<>();
    private final ArrayList<Branch> neighboutBranches = new ArrayList<>();

    public Branch(String branchName, String branchLocation) throws IOException {
        super(new Image(new FileInputStream(ICONLIST[BRANCHES.size() % 3].getCanonicalFile())));
        this.branchName = branchName;
        this.branchLocation = stringToPoint2D(branchLocation);
        lblBranchName = new Label(getLabelString(branchName));
        
        if(!BRANCHES.contains(this))
            BRANCHES.add(this);
    }

    public ArrayList<Branch> getNeighboutBranches() {
        return neighboutBranches;
    }
    
    public static Branch getBranchFromBRANCHES(int index){
        return BRANCHES.get(index);
    }
    
    public static Branch getBranchFromBRANCHES(String branchName){
        Branch outputBranch = null;
        for(Branch b: BRANCHES)
            if(b.branchName.matches(branchName))
                outputBranch = b;
        
        return outputBranch;
    }

    public static ArrayList<Branch> getBRANCHES() {
        return BRANCHES;
    }
    
    public static void buildGraphConnections(){
        int[][] neighbours = {  {},
                                {0,2,3},
                                {},
                                {3,5,6,8},
                                {8,9,11}, 
                                {},
                                {8,9,10},
                                {},
                                {9},
                                {},
                                {7,11},
                                {}};
        
        int counter = 0;
        for (int[] coords: neighbours) {
            if(coords.length > 0){
                System.out.println("Mapping Branch "+BRANCHES.get(counter).getBranchName());
                int i = 0;
                while (i < coords.length){
                    Branch thisBranch = BRANCHES.get(counter);
                    Branch neighbourBranch = BRANCHES.get(coords[1]);
                    
                    thisBranch.neighboutBranches.add(neighbourBranch);
                    neighbourBranch.neighboutBranches.add(thisBranch);
                    
                    new WeightedEdge(thisBranch, neighbourBranch);
                }
            }
            
            counter++;
        }
    }
    
    private Point2D stringToPoint2D(String coordinate){
        try(Scanner scanner = new Scanner(coordinate).useDelimiter("\\w:")){
            int x = Integer.parseInt(scanner.next());
            int y = Integer.parseInt(scanner.next());
            System.out.println("X: "+x+", Y: "+y);
            return new Point2D(x, y);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return branchName.equals(((Branch)obj).branchName); //To change body of generated methods, choose Tools | Templates.
    }

    public String getBranchName() {
        return branchName;
    }    
    
    public final String getLabelString(String labelString){
        Scanner scanner = new Scanner(labelString).useDelimiter("_");
        String output = "";
        
        while(scanner.hasNext()){
            String s = scanner.next();
                if(s.matches("[\\w]{1,}ST"))
                    output += s.substring(0, s.length() - 2)+ " Street, ";
                else if(s.matches("[\\w]{1,}RD"))
                    output += s.substring(0, s.length() - 2)+ " Road, ";
                else if(s.matches("[\\w]{1,}CL"))
                    output += s.substring(0, s.length() - 2)+ " Close, ";
                else if(s.matches("[\\w]{1,}Expy"))
                    output += s.substring(0, s.length() - 2)+ " Express Way, ";
                else if(s.matches("[\\w]{1,}e"))
                    output += s +", ";
                else
                    output += s;
        }
        
        return output;
    }
    
    public void setLblBranchName(String lblName){
        lblBranchName.setText(lblName);
    }
    
    public Label getLblBranchName(){
        return lblBranchName;
    }
    
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Point2D getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(Point2D branchLocation) {
        this.branchLocation = branchLocation;
    }
}
