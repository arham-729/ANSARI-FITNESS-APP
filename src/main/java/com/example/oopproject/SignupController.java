package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.reflect.AccessFlag;
import java.net.URL;
import java.sql.*;

import java.util.ResourceBundle;

import static com.example.oopproject.DBUtils.changeScene;
public class SignupController implements Initializable {
    @FXML
    private Button button_signup;
    @FXML
    private Button button_log_in=new Button();
    @FXML
    private RadioButton rb_user=new RadioButton();;

    @FXML
    private RadioButton rb_trainer=new RadioButton();;


    @FXML
    private TextField tf_username= new TextField();;
    @FXML
    private TextField tf_weight= new TextField();;
    @FXML
    private TextField tf_height= new TextField();;
    @FXML
    private PasswordField ps_password=new PasswordField();;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup toggleGroup=new ToggleGroup();

        rb_user.setToggleGroup(toggleGroup);
        rb_user.setSelected(true);
        rb_trainer.setToggleGroup(toggleGroup);

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                String username = tf_username.getText().trim();
                String password = ps_password.getText().trim();

                if (username.isEmpty() || password.isEmpty() || tf_weight.getText().trim().isEmpty() || tf_height.getText().trim().isEmpty()) {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up!");
                    alert.show();
                } else if (username.contains(" ") || password.contains(" ")) {
                    tf_username.clear();
                    ps_password.clear();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid username or password. Spaces are not allowed.");
                    alert.show();
                } else {
                    try {
                        double x = Double.parseDouble(tf_height.getText());
                        double y = Double.parseDouble(tf_weight.getText());
                        DBUtils.signUpUser(event, username, password, toggleName, y, x);
                    } catch (NumberFormatException e) {
                        tf_height.clear();
                        tf_weight.clear();
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Invalid height or weight. Please enter numeric values.");
                        alert.show();
                    }
                }
            }
        });
        button_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"hello-view.fxml","LOG IN!",null);
            }
        });
    }
}
