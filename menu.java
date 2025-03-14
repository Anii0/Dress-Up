package com.mycompany.excersize;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;



/**
 *
 * @author Anikah
 */
public class menu extends Application {    
    
    @Override
    public void start(Stage primaryStage) {
        Text firstPage = new Text("Dress Up");
        firstPage.setFont(new Font(50));
        firstPage.setFill(Color.RED);
        Button next1 = new Button("next");
        
        /*
        Pane pane1 = new Pane();
        pane1.getChildren().add(next1);
        pane1.setStyle("-fx-background-color: rgb(189, 224, 254)");
        Scene scene1 = new Scene(pane1, 400, 500);
        */
        /*
        double centerX = (scene1.getWidth() - next1.getWidth()) / 2;
        next1.setLayoutX(centerX);
        next1.setLayoutY(300);
        */
        
        /*
        StackPane pane1 = new StackPane(firstPage, next1);
        pane1.setStyle("-fx-background-color: rgb(189, 224, 254)");
        Scene scene1 = new Scene(pane1, 400, 500);
        */
        
        VBox pane1 = new VBox(20);
        pane1.setAlignment(Pos.CENTER);
        pane1.getChildren().addAll(firstPage, next1);
        pane1.setStyle("-fx-background-color: rgb(189, 224, 254)");
        Scene scene1 = new Scene(pane1, 400, 500);
        
        Button next2 = new Button("wow");
        
        /*
        next2.setLayoutX(150);
        next2.setLayoutY(200);
        */
        
        /*
        Pane pane2 = new Pane();
        pane2.getChildren().add(next2);
        Scene scene2 = new Scene(pane2, 400, 500);
        */
        
        /*
        StackPane pane2 = new StackPane(next2);
        Scene scene2 = new Scene(pane2, 400, 500);
        */
        
        VBox pane2 = new VBox(20);
        pane2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(next2);
        Scene scene2 = new Scene(pane2, 400, 500);
        
        next1.setOnAction(e -> primaryStage.setScene(scene2));
        next2.setOnAction(e -> primaryStage.setScene(scene1));
        
        primaryStage.setScene(scene1);
        primaryStage.setTitle("poop");
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
