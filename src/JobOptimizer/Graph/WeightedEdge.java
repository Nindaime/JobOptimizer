/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobOptimizer.Graph;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author PETER-PC
 */
public class WeightedEdge extends Line {
    private final static ArrayList<WeightedEdge> EDGES = new ArrayList<>();
    Branch startV, endV;
    double weight;
    Label weightDisplay;


    public WeightedEdge(Branch startV, Branch endV) {
        super(startV.getBoundsInParent().getWidth()/2.0, 
                startV.getBoundsInParent().getHeight()/2.0, 
                endV.getBoundsInParent().getWidth()/2.0, 
                endV.getBoundsInParent().getHeight()/2.0);
        setStrokeWidth(1.25);
//        setOpacity(1);
        setBlendMode(BlendMode.SRC_OVER);
        setStroke(Color.web("#E7D19F"));
        setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 3, 0, 0, 0));
        this.startV = startV;
        this.endV = endV;
        weight = new Point2D(startV.getBoundsInParent().getWidth()/2.0, startV.getBoundsInParent().getHeight()/2.0)
                .distance(new Point2D(endV.getBoundsInParent().getWidth()/2.0, endV.getBoundsInParent().getHeight()/2.0));
        setWeight();
        
        if(!EDGES.contains(this))
            EDGES.add(this);
    }
    
    public static ArrayList<WeightedEdge> getEdgeList(){
        return EDGES;
    }
    
    public static WeightedEdge getWeightedEdge(Branch startV, Branch endV){
        for(WeightedEdge w: EDGES){
            if(w.equals(new WeightedEdge(startV, endV)))
                return w;
        }
        return null;
    }

    public final void setWeight() {
        Point2D startVCoordinate = new Point2D(startV.getBoundsInParent().getWidth()/2.0, startV.getBoundsInParent().getHeight()/2.0);
        Point2D endVCoordinate = new Point2D(endV.getBoundsInParent().getWidth()/2.0, endV.getBoundsInParent().getHeight()/2.0);
        
        weight = startVCoordinate.distance(endVCoordinate);
        
        weightDisplay = new Label(String.format("%.2f", weight));
        weightDisplay.setLabelFor(this);
        
        Point2D midPoint = startVCoordinate.midpoint(endVCoordinate);
        
        weightDisplay.setLayoutX(midPoint.getX());
        weightDisplay.setLayoutY(midPoint.getY());
        weightDisplay.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 5, 0, 0, 0));
        weightDisplay.setTextFill(Color.WHITE);
        weightDisplay.setFont(Font.font(14));
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Label getWeightDisplay() {
        return weightDisplay;
    }
    
    @Override
    public boolean equals(Object o) {
        return weight == ((WeightedEdge) o).weight;
    }
}
