//change names so easier to understand
//add avatar name editing for avatars 2/3
//create the actual editing avatar scene

package com.mycompany.excersize;


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

/**
 *
 * @author zulfa
 */
public class mano extends Application {
    Avatar avatar1 = new Avatar("Billy Bob");
    Avatar avatar2 = new Avatar("Silly Susie");
    Avatar avatar3 = new Avatar("Jonny John");
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
                
                                HBox avatar1box = new HBox(20, /*avatar1Name,*/ editAvatar1, avatar1text, setName) {{setAlignment(Pos.CENTER);}};

                

                    setName.setOnAction(eo ->
                    {
                        setNameLoop++;
                        if(setNameLoop%2 == 0){
                            avatar1box.getChildren().removeAll(setName);
                            avatar1box.getChildren().addAll(avatar1text, setName);
                            avatar1box.getChildren().removeAll(name1Label);
                        }else{
                            avatar1box.getChildren().removeAll(avatar1text, editAvatar1, setName);
                            avatar1box.getChildren().addAll(name1Label, editAvatar1, setName);
                            avatar1putname = avatar1text.getText();
                            name1Label.setText(avatar1putname);
                        }
                        
                    });
              
                

                
                //making name set w button

                /*setName.setOnAction(e -> 
                {
                avatar1putname = avatar1text.getText();
                name1Label.setText(avatar1putname);
                avatar1box.getChildren().removeAll(setName,avatar1text);
                });
                */
                
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
