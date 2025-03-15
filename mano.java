//looks beter but its only up until uhhhhhhhhhhh scene1 and scene2 no cant edit

package com.mycompany.dressup;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author zulfa
 */
public class mano extends Application {
    Avatar avatar1 = new Avatar("Billy Bob");
    Avatar avatar2 = new Avatar("Silly Susie");
    Avatar avatar3 = new Avatar("Jonny John");

    Avatar currentAvatar = null;
    Label avatarLabel; // Label for displaying clothing text
    
    
    @Override
    public void start(Stage primaryStage) {
        // Menu Scene
            Text title = new Text("Play Dress Up!");
            title.setFont(new Font(30));
            title.setFill(Color.CORAL);

            Button play = new Button("Play!");

            VBox main = new VBox(50);
            main.setAlignment(Pos.CENTER);
            main.getChildren().addAll(title, play);

            Scene menuScene = new Scene(main, 300, 250);
            
        // Closet Scene
        Text closetText = new Text("Select An Avatar to Edit!");

            // Avatar selection buttons
                Text avatar1Name = new Text(avatar1.getName());
                Button editAvatar1 = new Button("Avatar 1");

                Text avatar2Name = new Text(avatar2.getName());
                Button editAvatar2 = new Button("Avatar 2");

                Text avatar3Name = new Text(avatar3.getName());
                Button editAvatar3 = new Button("Avatar 3");

                Button back = new Button("Go Back");
                
            //vbox
                VBox avatarSelection = new VBox(50, 
                new HBox(20, avatar1Name, editAvatar1) {{setAlignment(Pos.CENTER);}},
                new HBox(20, avatar2Name, editAvatar2) {{setAlignment(Pos.CENTER);}},
                new HBox(20, avatar3Name, editAvatar3) {{setAlignment(Pos.CENTER);}}, back);
                avatarSelection.setAlignment(Pos.CENTER);
            //scene
                Scene closet = new Scene(avatarSelection, 300, 350);
                play.setOnAction(e -> primaryStage.setScene(closet));
                back.setOnAction(e -> primaryStage.setScene(menuScene));
    
    
        primaryStage.setTitle("Dress Up Game!");
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
