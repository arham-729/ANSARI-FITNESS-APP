package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;


public class DBUtils {


private static String u;
    private static double w;
    private static double h;

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username) {
        Parent root = null;

        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
               // LoggedinController loggedinController = loader.getController();


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load((DBUtils.class.getResource(fxmlFile)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene((new Scene(root, 680, 410)));
        stage.show();
    }

    public static void signUpUser(ActionEvent event, String username, String password, String mode,Double weight,Double height) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM fitnessapp WHERE username = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You can not use this username.");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO fitnessapp (username,password, mode,weight,height) VALUES (?, ?, ?,?,?)"); // added comma after each ?
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.setString(3, mode);
                psInsert.setString(4, String.valueOf(weight));
                psInsert.setString(5, String.valueOf(height));

                psInsert.executeUpdate();
                psInsert.close();

                changeScene(event, "logged-in.fxml", "Welcome!", username);
                u=username;
                w=weight;
               h=height;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
            preparedStatement = connection.prepareStatement("SELECT password,mode FROM fitnessapp WHERE username = ?");
            preparedStatement.setString(1, username);
            u=username;

            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The Provided credentials are incorrrect.");
                alert.show();
            } else {
                do {
                    String retrievedpassword = resultSet.getString("password");
                    String retrievedmode = resultSet.getString("mode");
                    if (retrievedpassword.equals(password)) {
                        changeScene(event, "logged-in.fxml", "Welcome!", username);
                    } else {
                        System.out.println("Passwords did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("The provided credentials are incorrrect.");
                        alert.show();
                    }

                } while (resultSet.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static void mode_admin(ActionEvent event,String username) {

        username=u;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
            preparedStatement = connection.prepareStatement("SELECT mode FROM fitnessapp WHERE username = ?");
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The Provided credentials are incorrrect.");
                alert.show();
            }

            do {

                    String retrievedmode = resultSet.getString("mode");
                    if (retrievedmode.equals("ADMIN")) {
                        changeScene(event, "admin.fxml", "Admin Section!", username);
                    } else {
                        System.out.println("Member is not an admin");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Login in with your required account,you are not an admin");
                        alert.show();
                    }

                } while (resultSet.next());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    public static void mode_trainer(ActionEvent event,String username) {

        username=u;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
            preparedStatement = connection.prepareStatement("SELECT mode FROM fitnessapp WHERE username = ?");
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The Provided credentials are incorrrect.");
                alert.show();
            }
            do {

                String retrievedmode = resultSet.getString("mode");
                if (retrievedmode.equals("TRAINER")) {
                    changeScene(event, "trainer.fxml", "TRAINER Section!", username);
                } else {
                    System.out.println("Member is not a trainer");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Login in with your required account,you are not a trainer");
                    alert.show();
                }

            } while (resultSet.next());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    public static void mode_user(ActionEvent event,String username) {

        username=u;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
            preparedStatement = connection.prepareStatement("SELECT mode FROM fitnessapp WHERE username = ?");
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The Provided credentials are incorrrect.");
                alert.show();
            }

            do {

                String retrievedmode = resultSet.getString("mode");
                if (retrievedmode.equals("USER")) {
                    changeScene(event, "user.fxml", "USER Section!", username);
                } else {
                    System.out.println("Member is not a user");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Login in with your required account,you are not a user");
                    alert.show();
                }

            } while (resultSet.next());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    public static String getName(){
        return u;
    }

    public static double getWeight(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345")) {
            String sql = "SELECT weight FROM fitnessapp WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("weight");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static double getHeight(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345")) {
            String sql = "SELECT height FROM fitnessapp WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("height");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}

   /* public static void displayStatistics() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_project", "root", "airboom12345");
             Statement stmt = conn.createStatement()) {
            // Get total number of members
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM fitnesapp");
            rs.next();
            int totalMembers = rs.getInt(1);
            rs.close();

            // Get total number of trainers
            rs = stmt.executeQuery("SELECT COUNT(*) FROM fitnesapp WHERE mode = 'trainer'");
            rs.next();
           int totalTrainers = rs.getInt(1);
            rs.close();
            // Get total number of users
            rs = stmt.executeQuery("SELECT COUNT(*) FROM fitnesapp WHERE mode = 'user'");
            rs.next();
           int  totalUsers = rs.getInt(1);
            rs.close();
            // Print the statistics
            System.out.println("Total members: " + totalMembers);
            System.out.println("Total trainers: " + totalTrainers);
            System.out.println("Total users: " + totalUsers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

