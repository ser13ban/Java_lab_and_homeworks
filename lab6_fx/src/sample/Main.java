package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window =  primaryStage;
        window.setTitle("ShapesApp");



        HBox topMenu = new HBox();
        Label sizeLabel = new Label("Enter the size");
        topMenu.getChildren().addAll(sizeLabel);

        HBox bottomMenu = new HBox();
        Button saveButton = new Button("Save");
        Button loadButton = new Button("load");
        Button resetButton = new Button("Reset");
        Button exitButton = new Button("Exit");
        topMenu.getChildren().addAll(saveButton,loadButton,resetButton,exitButton);


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);
        borderPane.setCenter();

        borderPane.setAlignment(topMenu, Pos.TOP_CENTER);
        borderPane.setAlignment(bottomMenu, Pos.BOTTOM_CENTER);

        Scene scene = new Scene(borderPane,600,600);
        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
