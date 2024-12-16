package com.example.oopproject;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main  extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),680,410);
            stage.setTitle("LOG IN!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }

