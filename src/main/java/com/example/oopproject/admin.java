package com.example.oopproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class admin implements Initializable {
    @FXML
    private static int totalMembers;

    @FXML
    private Button bt_press;
    @FXML
    private ComboBox<String> cb_1;
    @FXML
    private Button btn_del;
    @FXML
    private static int totalTrainers;
    @FXML
    private static int totalUsers;
    @FXML
    private Label lb_1;
    @FXML
    private Label lb_2;
    @FXML
    private Label lb_3;
    @FXML
    private Label lb_4;
    @FXML
    private Button b1;

    private static ObservableList<String> membersList = FXCollections.observableArrayList();

    public static void deleteMember(String selectedMember) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
             Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM fitnessapp WHERE username = '" + selectedMember + "'";
            stmt.executeUpdate(sql);
            System.out.println("Deleted member: " + selectedMember);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayStatistics() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
             Statement stmt = conn.createStatement()) {
            // Get total number of members
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM fitnessapp");
            rs.next();
            totalMembers = rs.getInt(1) - 1;
            rs.close();

            // Get total number of trainers
            rs = stmt.executeQuery("SELECT COUNT(*) FROM fitnessapp WHERE mode = 'trainer'");
            rs.next();
            totalTrainers = rs.getInt(1);
            rs.close();

            // Get total number of users
            rs = stmt.executeQuery("SELECT COUNT(*) FROM fitnessapp WHERE mode = 'user'");
            rs.next();
            totalUsers = rs.getInt(1);
            rs.close();

            // Fetch the user and trainer names
            rs = stmt.executeQuery("SELECT username FROM fitnessapp WHERE mode = 'user' OR mode = 'trainer'");
            membersList.clear(); // Clear the list before populating it again
            while (rs.next()) {
                String userName = rs.getString("username");
                membersList.add(userName);
            }
            rs.close();

            // Print the statistics
            System.out.println("Total members: " + totalMembers);
            System.out.println("Total trainers: " + totalTrainers);
            System.out.println("Total users: " + totalUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void button(ActionEvent e) {
        displayStatistics();
        lb_1.setText(DBUtils.getName());
        lb_2.setText(String.valueOf(totalTrainers));
        lb_3.setText(String.valueOf(totalUsers));
        lb_4.setText(String.valueOf(totalMembers));
    }

    public void deleteUser(ActionEvent event) {
        String selectedMember = cb_1.getSelectionModel().getSelectedItem();
        if (selectedMember != null) {
            deleteMember(selectedMember);
            membersList.remove(selectedMember);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayStatistics();
        cb_1.setItems(membersList);

        btn_del.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteUser(event);
            }
        });

        bt_press.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "logged-in.fxml", "Welcome!", null);
            }
        });
    }
}