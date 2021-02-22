package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

public class Main extends Application {
    ArrayList <ImageView> imageArrayList=new ArrayList<>();
    Button mybutton;
    Label text;
    Label moretext;
    FileInputStream input;
    Image image;
    ImageView imageView;
    VBox Layout;
    Scene myscene;
    ToggleButton toggleButton1;
    public static void main(String[] args) {
	// write your code here
        Application.launch(args);
    }
    public void start(Stage stage) throws FileNotFoundException {



        stage.setTitle("Hello");

        mybutton = new Button("Press me");
        text = new Label("My name is Fudayl");
        moretext = new Label("How are you today");
         input = new FileInputStream("/Users/fudaylhopkins/Downloads/crying Jordan.jpg");
        image = new Image(input);
        imageView = new ImageView(image);
        imageArrayList.add(imageView);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        toggleButton1 = new ToggleButton("toggle");

       
        toggleButton1.setOnAction(actionEvent -> {
           boolean isSelected = toggleButton1.isSelected();
          for(ImageView imageView: imageArrayList) {
                 imageView.setVisible(isSelected);
          }

        });

        Layout = new VBox(mybutton, text, moretext, toggleButton1, imageView);

        FileChooser fileChooser = new FileChooser();
        Button button = new Button("Select File");
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            try {
                image= new Image(new FileInputStream(selectedFile)) ;
             
               ImageView imagine = new ImageView(image);
                    imagine.setFitHeight(60);
                    imagine.setFitWidth(60);
                    imageArrayList.add(imagine);
               Layout.getChildren().add(imagine);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

         Layout.getChildren().add(button);


        myscene = new Scene(Layout);

        stage.setScene(myscene);

        stage.setWidth(800);
        stage.setHeight(800);


        stage.show();
    }
}
