package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    FileInputStream input2;
    Image image;
    Image image2;
    ImageView imageView1;
    ImageView imageView2;
    VBox Layout;
    Scene myscene;
    ToggleButton toggleButton1;
    RadioButton radioButton1;
    RadioButton radioButton2;
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
        imageView1 = new ImageView(image);
        imageArrayList.add(imageView1);
        imageView1.setFitWidth(60);
        imageView1.setFitHeight(60);

        input2= new FileInputStream("/Users/fudaylhopkins/Downloads/download.jpeg");
        image2= new Image(input2);
        imageView2 = new ImageView(image2);
        imageArrayList.add(imageView2);
        imageView2.setFitWidth(60);
        imageView2.setFitHeight(60);


        toggleButton1 = new ToggleButton("toggle");
        radioButton1 = new RadioButton("Left");
        radioButton2 = new RadioButton("Right");

         ToggleGroup radioGroup = new ToggleGroup();

         radioButton1.setToggleGroup(radioGroup);
         radioButton2.setToggleGroup(radioGroup);

         radioButton1.setOnAction(actionEvent -> {
             boolean iselected = radioButton1.isSelected();
             if (iselected) {
             imageView2.setImage(image2);
             }





          } );

        toggleButton1.setOnAction(actionEvent -> {
           boolean isSelected = toggleButton1.isSelected();
          for(ImageView imageView: imageArrayList) {
                 imageView.setVisible(isSelected);
          }

        });

        Layout = new VBox(mybutton, text, moretext, toggleButton1, imageView1, radioButton1, imageView2);

        FileChooser fileChooser = new FileChooser();
        Button button = new Button("Select File");
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            try {
                image= new Image(new FileInputStream(selectedFile)) ;
                    imageView1.setImage(image);
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
