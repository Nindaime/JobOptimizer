/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.Graph;

import JobOptimizer.JobOptimizer;
import JobOptimizer.GUI_Module.ScreenController;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author PETER-PC
 */
public class GraphPanel extends Pane{
        
    public GraphPanel(){     
        
        setStyle("-fx-background: gainsboro");
        
        //dispay edges and weights on the scenegraph
        for (WeightedEdge e : WeightedEdge.getEdgeList()) 
            getChildren().addAll(e, e.getWeightDisplay());
        
        //dispay edges and weights on the scenegraph
        for(Branch b: Branch.getBRANCHES())
            getChildren().add(b);

//      Print Graph in Console
        for(Branch b: Branch.getBRANCHES()){

            System.out.print(b.getBranchName() + "\t\t->");
            for (Branch n : b.getNeighboutBranches()) 
                System.out.print(n + " -> Weight "+ WeightedEdge.getWeightedEdge(b, n).getWeight() +" : ");
            
            System.out.println();
        }
        
        AnchorPane mainPageRoot = (AnchorPane) ScreenController.screens.get(JobOptimizer.mainPage);
        AnchorPane container = (AnchorPane) mainPageRoot.lookup("#container");
        Platform.runLater(() -> { container.getChildren().add(this); });
        
//        JobOptimizer.generateTCPs();
//        initSimulation();
    }
    
    
    public final void initSimulation(){
//        JobOptimizer.generateTCPs();
        
//        for(TCP t: TCP.TCPs){
//            int index = TCP.TCPs.indexOf(t);
//            Passenger.resetPassengers(index);
//            for (int i = 0; i < t.getTrainSet().length; i++) {
//                t.getTrainSet()[i].setVisible(false);
//                getChildren().add(t.getTrainSet()[i]);
//                t.getAnimation()[i].setRate(20);
//                pTs.getChildren().add(t.getAnimation()[i]);
//                System.out.println("Animation TCP "+t.getTrainSet()[i]+" is set");
//            }
//            System.out.println("Simulating Animation for TCP "+index);
//            Platform.runLater(() -> {pTs.playFromStart();});
//            t.setFitness(index);
//        }
//
//        int currentGBestIndex = TCP.TCPs.indexOf(TCP.gBests.get(0));
//        Passenger.resetPassengers(currentGBestIndex);
        
//        //animate only the first 6 TCPs
//        TCP animatedTCP = TCP.TCPs.get(0);
////        animatedTCP.setAnimation();
//
//        for (int i = 0; i < animatedTCP.getTrainSet().length; i++) {
//            getChildren().add(animatedTCP.getTrainSet()[i]);
//            pTs.getChildren().add(animatedTCP.getAnimation()[i]);
//            System.out.println("Animation TCP "+animatedTCP.getTrainSet()[i]+" is set");
//        }
    }
    
}