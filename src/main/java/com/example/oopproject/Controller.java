package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {
    @FXML
    private TextField tf_username=new TextField();
    @FXML
    private PasswordField ps_password=new PasswordField();
    @FXML
    private Button button_login;
    @FXML
    private Button button_sign_up;
    @FXML


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.logInUser(event, tf_username.getText(), ps_password.getText());
              //  u=tf_username.getText();

            }




        });
    button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.changeScene(event,"sign-up.fxml","SIGN_UP",null);
        }
    });




    }

}