//finished but super ugly


package com.mycompany.excersize;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Label;



/**
 *
 * @author zulfa
 */
public class menu extends Application {
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

        Scene menuScene = new Scene(main, 400, 500);

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

        VBox avatarSelection = new VBox(20);
        avatarSelection.setAlignment(Pos.CENTER);
        avatarSelection.getChildren().addAll(
            closetText, 
            avatar1Name, editAvatar1, 
            avatar2Name, editAvatar2, 
            avatar3Name, editAvatar3, 
            back
        );

        Scene closet = new Scene(avatarSelection, 400, 500);
        play.setOnAction(e -> primaryStage.setScene(closet));
        back.setOnAction(e -> primaryStage.setScene(menuScene));

        // Avatar Editing Scene
        avatarLabel = new Label("Select an avatar to start editing!");

        // Clothing navigation buttons
        Button prevShirt = new Button("←");
        Button nextShirt = new Button("→");
        Button prevPants = new Button("←");
        Button nextPants = new Button("→");
        Button prevHat = new Button("←");
        Button nextHat = new Button("→");

        Button done = new Button("Done");
        
        //new avatar editor scene
        HBox editAvatar = new HBox(20);
        editAvatar.setAlignment(Pos.CENTER);

        VBox leftButton = new VBox(60);
        leftButton.setAlignment(Pos.CENTER);
        leftButton.getChildren().addAll(prevShirt, prevPants, prevHat);

        VBox rightButton = new VBox(60);
        rightButton.setAlignment(Pos.CENTER);
        rightButton.getChildren().addAll(nextShirt, nextPants, nextHat);

        VBox avatarMiddle = new VBox();
        avatarMiddle.getChildren().add(avatarLabel); 

        editAvatar.getChildren().addAll(leftButton, avatarMiddle, rightButton);

        VBox withDone = new VBox(20);
        withDone.setAlignment(Pos.CENTER);
        withDone.getChildren().addAll(editAvatar, done);

        Scene editor = new Scene(withDone, 400, 500);

        //old vbox with all buttons
        /*VBox avatarEditor = new VBox(20);
        avatarEditor.setAlignment(Pos.CENTER);
        avatarEditor.getChildren().addAll(
            avatarLabel, 
            prevShirt, nextShirt, 
            prevPants, nextPants, 
            prevHat, nextHat, 
            done
        );

        Scene editor = new Scene(avatarEditor, 300, 350);
        */

        // Method to set up the avatar selection
        EventHandler<ActionEvent> avatarSelectionHandler = e -> {
            if (e.getSource() == editAvatar1) {
                currentAvatar = avatar1;
            } else if (e.getSource() == editAvatar2) {
                currentAvatar = avatar2;
            } else if (e.getSource() == editAvatar3) {
                currentAvatar = avatar3;
            }

            avatarLabel.setText(currentAvatar.getClothingText()); // Update label

            // Now set clothing button actions
            prevShirt.setOnAction(ev -> { 
                currentAvatar.previousClothing("shirt"); 
                avatarLabel.setText(currentAvatar.getClothingText()); 
            });
            nextShirt.setOnAction(ev -> { 
                currentAvatar.nextClothing("shirt"); 
                avatarLabel.setText(currentAvatar.getClothingText()); 
            });

            prevPants.setOnAction(ev -> { 
                currentAvatar.previousClothing("pants"); 
                avatarLabel.setText(currentAvatar.getClothingText()); 
            });
            nextPants.setOnAction(ev -> { 
                currentAvatar.nextClothing("pants"); 
                avatarLabel.setText(currentAvatar.getClothingText()); 
            });

            prevHat.setOnAction(ev -> { 
                currentAvatar.previousClothing("hat"); 
                avatarLabel.setText(currentAvatar.getClothingText()); 
            });
            nextHat.setOnAction(ev -> { 
                currentAvatar.nextClothing("hat"); 
                avatarLabel.setText(currentAvatar.getClothingText()); 
            });

            primaryStage.setScene(editor);
        };

        // Assign event handlers to avatar buttons
        editAvatar1.setOnAction(avatarSelectionHandler);
        editAvatar2.setOnAction(avatarSelectionHandler);
        editAvatar3.setOnAction(avatarSelectionHandler);

        done.setOnAction(e -> primaryStage.setScene(closet)); // Return to avatar selection

        primaryStage.setTitle("Dress Up Game!");
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
