package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Update implements Initializable {
    @FXML
    private TextField tfWeight=new TextField();
    @FXML
    private TextField tfHeight=new TextField();
    @FXML
    private Button btnUpdate=new Button();
    @FXML
    private Button bt_press=new Button();

    private static final String DB_URL = "jdbc:mysql://localhost:3306/oop_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "airboom12345";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bt_press.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "logged-in.fxml", "Welcome!", null);
            }
        });
        btnUpdate.setOnAction(this::updateWeightAndHeight);
    }


    private void updateWeightAndHeight(ActionEvent event) {
        String weight = tfWeight.getText().trim();
        String height = tfHeight.getText().trim();

        if (weight.isEmpty() || height.isEmpty()) {
            showAlert("Error", "Please enter weight and height.");
            return;
        }

        double weightValue;
        double heightValue;

        try {
            weightValue = Double.parseDouble(weight);
            heightValue = Double.parseDouble(height);
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid weight or height. Please enter numeric values.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("UPDATE fitnessapp SET weight = ?, height = ? WHERE username = ?")) {
            stmt.setDouble(1, weightValue);
            stmt.setDouble(2, heightValue);
            stmt.setString(3, (DBUtils.getName()));


            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                showAlert("Success", "Weight and height updated successfully.");
            } else {
                showAlert("Error", "Failed to update weight and height.");
            }
        } catch (SQLException e) {
            showAlert("Error", "An error occurred while updating weight and height.");
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}