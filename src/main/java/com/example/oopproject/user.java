package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class user implements Initializable {
    @FXML
    private String username="";
   @FXML
   private double weight=0;
    @FXML
    private Button button_physical=new Button();
    @FXML
    private Button button_nutrition=new Button();
    @FXML
    private Button button_meditation=new Button();
    @FXML
    private Button button_press=new Button();
    @FXML
    private double height=0;
    @FXML
    private Label lb_name=new Label();
    @FXML
    private Label lb_weight=new Label();
    @FXML
    private Label lb_height=new Label();


    public user(){
        username=DBUtils.getName();

        weight=DBUtils.getWeight(username);
        height=DBUtils.getHeight(username);
    }
    public String getName() {
        return username;
    }

    public void setName() {
        username = DBUtils.getName();
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight() {

                weight=DBUtils.getWeight(username);;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight() {
        height = DBUtils.getHeight(username);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lb_name.setText(getName());
        lb_weight.setText(String.valueOf(getWeight()));

        lb_height.setText(String.valueOf(getHeight()));

        button_physical.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "physical_user.fxml", "Welcome!", null);
                //  u=tf_username.getText();

            }


        });
        button_nutrition.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "nutrition_user.fxml", "Welcome!", null);
                //  u=tf_username.getText();

            }


        });
         button_meditation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "meditation_user.fxml", "Welcome!", null);
                //  u=tf_username.getText();

            }


        });
        button_press.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "logged-in.fxml", "Welcome!", null);
                //  u=tf_username.getText();

            }


        });
    }
}
