package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoggedinController implements Initializable {
    @FXML
    Controller j=new Controller();
    @FXML
    private Controller controller=new Controller();

    @FXML
    private Label label_1=new Label();

    @FXML
    private Label label_2=new Label();
    @FXML
    private Button button_logout=new Button();
    @FXML
    private Button button_admin=new Button();
    @FXML
    private Button button_trainer=new Button();
    @FXML
    private Button button_user=new Button();
    @FXML
    private Button bt_update=new Button();
    @FXML
private String username;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // get the existing instance of the Controller class

        bt_update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "update.fxml", "Welcome!", null);
            }
        });
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "hello-view.fxml", "LOG IN!", null);
            }
        });

          button_admin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (button_admin.getText().equals("ADMIN")) {
                    DBUtils.mode_admin(event,username);

                } else {
                    System.out.println("Member is not an admin");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Log in with your required account, you are not an admin");
                    alert.show();
                }
            }
        });
        button_trainer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (button_trainer.getText().equals("TRAINER")) {
                    DBUtils.mode_trainer(event,username);

                } else {
                    System.out.println("Member is not a trainer");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Log in with your required account, you are not a trainer");
                    alert.show();
                }
            }
        });
        button_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (button_user.getText().equals("USER")) {
                    DBUtils.mode_user(event,username);

                } else {
                    System.out.println("Member is not a user");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Log in with your required account, you are a user");
                    alert.show();
                }
            }
        });


    }
}