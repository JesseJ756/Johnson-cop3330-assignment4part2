/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TodoList extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        Parent root; // = null

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TodoGUI.fxml")));
        primaryStage.setTitle("To-Do List");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
