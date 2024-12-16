package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
public class trainer implements Initializable {


  /*  private String name;
    private int age;
    private int phone_no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }
    public trainer() {

    }
    public trainer(String name,int age,int phone_no){
        this.name=name;
        this.age=age;
        this.phone_no=phone_no;
    }*/

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private Label userLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label advice;

    private String name;
    private int age;
    private int phone_no;
    @FXML
    private ListView<String> userList;

    @FXML
    private ObservableList<String> usernames = FXCollections.observableArrayList();
    @FXML
    private Button bt_press = new Button();
    private Map<String, Double> userWeights = new HashMap<>();
    private Map<String, Double> userHeights = new HashMap<>();


    public trainer() {

    }
    public trainer(String name,int age,int phone_no) {
        this.name = name;
        this.age = age;
        this.phone_no = phone_no;
    }
    /*public void loadUserData() {
        // Populate userWeights and userHeights maps with data from the database
        // You can use DBUtils.getWeight(username) and DBUtils.getHeight(username) methods

        // Clear existing data
        userWeights.clear();
        userHeights.clear();

        // Add sample data (replace this with your actual data retrieval logic)
        userWeights.put("user1", 70.5);
        userWeights.put("user2", 65.2);
        userWeights.put("user3", 75.0);
        userHeights.put("user1", 170.0);
        userHeights.put("user2", 165.0);
        userHeights.put("user3", 180.0);
    }*/

   /* public void showUserData(ActionEvent event) {
        String username = usernameTextField.getText().trim();

        if (username.isEmpty()) {
            showAlert("Error", "Username is required.");
            return;
        }

        if (!userWeights.containsKey(username) || !userHeights.containsKey(username)) {
            showAlert("Error", "User not found.");
            return;
        }

        double weight = userWeights.get(username);
        double height = userHeights.get(username);

        userLabel.setText(username);
        weightLabel.setText(String.valueOf(weight));
        heightLabel.setText(String.valueOf(height));
    }

    public void giveAdvice(ActionEvent event) {
        String username = usernameTextField.getText().trim();

        if (username.isEmpty()) {
            showAlert("Error", "Username is required.");
            return;
        }

        if (!userWeights.containsKey(username) || !userHeights.containsKey(username)) {
            showAlert("Error", "User not found.");
            return;
        }

        double weight = userWeights.get(username);
        double height = userHeights.get(username);

        // Perform advice giving based on the user's weight and height

        showAlert("Advice", "Advice given to " + username + ": [Insert advice here]");
    }*/

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    private void showUserData(ActionEvent event) {
        String selectedUsername = userList.getSelectionModel().getSelectedItem();

        if (selectedUsername == null) {
            showAlert("Error", "Please select a user.");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345")) {
            String sql = "SELECT weight, height FROM fitnessapp WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, selectedUsername);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double weight = resultSet.getDouble("weight");
                double height = resultSet.getDouble("height");

                if (weight > 100) {
                    advice.setText(selectedUsername + " extremely needs to do  more physical exercises. Moreover, he needs special focus!");
                } else if (weight > 85) {
                    advice.setText(selectedUsername + " needs to do physical exercises frequently. Moreover, you need to supervise him!");
                } else if (weight > 65) {
                    advice.setText(selectedUsername + " is on a good track and should continue his work.");
                } else {
                    advice.setText(selectedUsername + " is in perfect shape.");
                }

                userLabel.setText(selectedUsername);
                weightLabel.setText(String.valueOf(weight));
                heightLabel.setText(String.valueOf(height));
            } else {
                showAlert("Error", "User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to retrieve user data.");
        }
    }

    @FXML

    public void initialize(URL url, ResourceBundle resourceBundle) {

        userList.setItems(usernames);
        loadUsernames();
        bt_press.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "logged-in.fxml", "Welcome!", null);
                //  u=tf_username.getText();

            }


        });
    }
    private void loadUsernames() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345")) {
            String sql = "SELECT username FROM fitnessapp WHERE mode = 'user'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                usernames.add(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*private void handleUserSelection(MouseEvent event) {
        // Get the selected username
        String username = userList.getSelectionModel().getSelectedItem();

        // Check if a username is selected
        if (username != null) {
            // Retrieve the user data from the database
            retrieveUserData(username);
        }
    }

    private void retrieveUserData(String username) {
        // Establish a database connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345")) {
            // Prepare the SQL statement
            String sql = "SELECT weight, height FROM fitnessapp WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the weight and height from the result set
                String weight = resultSet.getString("weight");
                String height = resultSet.getString("height");

                // Display the data in the labels
                userLabel.setText(username);
                weightLabel.setText(weight);
                heightLabel.setText(height);
            } else {
                // User not found in the database
                userLabel.setText("User not found");
                weightLabel.setText("");
                heightLabel.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors
        }
    }*/
}



