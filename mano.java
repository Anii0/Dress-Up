// you can change avatar 1 name nicely on menu page
// you can change avatars clothes
// theres a picture of dokja

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;

/**
 *
 * @author zulfa
 */
public class mano extends Application {
    Avatar avatar1 = new Avatar("Rename Me!");
    Avatar avatar2 = new Avatar("Rename Me!");
    Avatar avatar3 = new Avatar("Rename Me!");
    private String avatar1putname = "";
    private Label name1Label = new Label("Avatar 1");
    Button editAvatar1;
    TextField avatar1text;
    Button setName;
    int setNameLoop = 0;


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
                
                
                //setting name
                TextField avatar1text = new TextField();
                Button setName = new Button("Edit Name");
                                            System.out.println(avatar1.getName());

                
                HBox avatar1box = new HBox(20, avatar1Name, editAvatar1, avatar1text, setName) {{setAlignment(Pos.CENTER);}};

                

                    setName.setOnAction(eo ->
                    {
                        setNameLoop++;
                        if(setNameLoop%2 == 0){
                            avatar1box.getChildren().removeAll(setName);
                            avatar1box.getChildren().addAll(avatar1text, setName);
                            avatar1box.getChildren().removeAll(name1Label);
                                                        System.out.println(avatar1.getName());

                        }else{
                            avatar1box.getChildren().removeAll(avatar1text, editAvatar1, setName);
                            avatar1box.getChildren().addAll(editAvatar1, setName);
                            avatar1putname = avatar1text.getText();
                            avatar1Name.setText(avatar1putname);
                            avatar1.setName(avatar1putname);
                            System.out.println(avatar1.getName());
                        }
                        
                    });
                
                Text avatar2Name = new Text(avatar2.getName());
                Button editAvatar2 = new Button("Avatar 2");

                Text avatar3Name = new Text(avatar3.getName());
                Button editAvatar3 = new Button("Avatar 3");

                Button back = new Button("Go Back");
                                      
            //vbox            
                VBox avatarSelection = new VBox(50, 
                avatar1box,
                new HBox(20, avatar2Name, editAvatar2) {{setAlignment(Pos.CENTER);}},
                new HBox(20, avatar3Name, editAvatar3) {{setAlignment(Pos.CENTER);}}, back);
                avatarSelection.setAlignment(Pos.CENTER);
            //scene
                Scene closet = new Scene(avatarSelection, 400, 350);
                play.setOnAction(er -> primaryStage.setScene(closet));
                back.setOnAction(er -> primaryStage.setScene(menuScene));
    
    // Avatar Editing Scene
        
        Image img = new Image(("/body/dokja.png"));
 
         if (img.isError()) {
             System.out.println("Error loading image!");
         } else {
             System.out.println("Image loaded successfully!");
         }
 
         ImageView imgView = new ImageView(img);
         imgView.setFitWidth(100);
         imgView.setFitHeight(120);
         
        avatarLabel = new Label("Select an avatar to start editing!");

        // Clothing navigation buttons
        Button prevShirt = new Button("←");
        Button nextShirt = new Button("→");
        Button prevPants = new Button("←");
        Button nextPants = new Button("→");
        Button prevHat = new Button("←");
        Button nextHat = new Button("→");

        Button done = new Button("Done");
        done.setOnAction(en -> primaryStage.setScene(closet));

        VBox avatarEditor = new VBox(30);
        avatarEditor.setAlignment(Pos.CENTER);
        avatarEditor.getChildren().addAll(
                avatarLabel,
                new HBox(20,
                new VBox(40, prevShirt, prevPants, prevHat),
                imgView, 
                new VBox(40, nextShirt, nextPants, nextHat)){{setAlignment(Pos.CENTER);}},
                done
        );

        Scene editor = new Scene(avatarEditor, 300, 350);

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
