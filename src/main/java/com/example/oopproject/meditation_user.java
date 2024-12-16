package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class meditation_user extends user {
    @FXML
    private Label lb_1 = new Label();
    @FXML
    private Label lb_2 = new Label();
    @FXML
    private Label lb_3 = new Label();
    @FXML
    private Label lb_4 = new Label();

    @FXML
    private Button bt_1 = new Button();
    @FXML
    private Button bt_2 = new Button();
    @FXML
    private Button bt_3 = new Button();
    @FXML
    private Button bt_4 = new Button();

    @FXML
    private Button bt_press = new Button();

    private String meditationTechnique;
    private int meditationMinutesPerDay;
    private int meditationFrequency;

    private int meditationProgress;
    private String username;
    private double weight;
    private double height;

    public int getMeditationFrequency() { //how many times a week
        return meditationFrequency;
    }//in a week

    public void setMeditationFrequency(int meditationFrequency) {
        this.meditationFrequency = meditationFrequency;
    }

    public int getMeditationProgress() {          //no of sessions
        return meditationProgress;
    }

    public void setMeditationProgress(int meditationProgress) {
        this.meditationProgress = meditationProgress;
    }

    public void setMeditationTechnique(String meditationTechnique) {
        this.meditationTechnique = meditationTechnique;
    }

    public int getMeditationMinutesPerDay() {
        return meditationMinutesPerDay;
    }

    public void setMeditationMinutesPerDay(int meditationMinutesPerDay) {
        this.meditationMinutesPerDay = meditationMinutesPerDay;
    }

    public String getMeditationTechnique() {          //mindfulness, loving-kindness, transcendental meditation
        return meditationTechnique;
    }

    public void setMeditationBasedOnWeightAndHeight() {
        if (weight >= 80 && height >= 180) {
            setMeditationTechnique("Transcendental Meditation");
            setMeditationProgress(10);
            setMeditationMinutesPerDay(30);
            setMeditationFrequency(5);
        } else if (weight >= 70 && height >= 170) {
            setMeditationTechnique("Loving-Kindness Meditation");
            setMeditationProgress(8);
            setMeditationMinutesPerDay(20);
            setMeditationFrequency(4);
        } else {
            setMeditationTechnique("Mindfulness Meditation");
            setMeditationProgress(5);
            setMeditationMinutesPerDay(15);
            setMeditationFrequency(3);
        }
    }


    public meditation_user() {
        username = DBUtils.getName();

        weight = DBUtils.getWeight(username);
        height = DBUtils.getHeight(username);


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

        weight = DBUtils.getWeight(username);
        ;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight() {
        height = DBUtils.getHeight(username);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setMeditationBasedOnWeightAndHeight();

        bt_press.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "user.fxml", "USER SECTION!", null);
                //  u=tf_username.getText();

            }


        });
        bt_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_1.setText(String.valueOf(meditationMinutesPerDay));
                ;
            }


        });
        bt_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText(String.valueOf(meditationFrequency));
                ;
            }


        });
        bt_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_3.setText(meditationTechnique);
                ;
            }


        });
        bt_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_4.setText(String.valueOf(meditationProgress));
                ;
            }


        });

  /*  public meditation_user(String name, String gender, String dateOfBirth, int age, String meditationTechnique,
                           int meditationMinutesPerDay, int meditationFrequency, int meditationProgress) {
        super(name, gender, dateOfBirth, age);
        this.meditationTechnique = meditationTechnique;
        this.meditationMinutesPerDay = meditationMinutesPerDay;
        this.meditationFrequency=meditationFrequency;
        this.meditationProgress=meditationProgress;
    }*/


    }

}
