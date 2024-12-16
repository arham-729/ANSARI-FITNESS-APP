package com.example.oopproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class physicalActivity_User extends user implements Initializable {
    @FXML
    private Label lb_1=new Label();
    @FXML
    private Label lb_2=new Label();
    @FXML
    private Label lb_3=new Label();
    @FXML
    private Label lb_4=new Label();
    @FXML
    private Label lb_5=new Label();
    @FXML
    private Label lb_6=new Label();
    @FXML
    private Label lb_7=new Label();
    @FXML
    private Label lb_8=new Label();
    @FXML
    private Button bt_1=new Button();
    @FXML
    private Button bt_2=new Button();
    @FXML
    private Button bt_3=new Button();
    @FXML
    private Button bt_4=new Button();
    @FXML
    private Button bt_5=new Button();
    @FXML
    private Button bt_6=new Button();
    @FXML
    private Button bt_7=new Button();
    @FXML
    private Button bt_8=new Button();
    @FXML
    private Button bt_press=new Button();


    @FXML
    private String exerciseLevel="";
    @FXML
    private int targetStepCount=0;
    @FXML
    private String username="";
    @FXML
    private double bmi=0;
    @FXML
    private double idealBMI=0;
    @FXML
    private double weight=0;
    @FXML
    private double height=0;
    @FXML
    private int bodyLiftingWeight=0;
    @FXML
    private int pushUpsCount=0;
    @FXML
    private int targetedWeight=0;


//, int age, int bodyLiftingWeight,
//                                 int pushUpsCount, int targetedWeightweek,
//                                 String exerciseLevel, int targetStepCount, double weight, double height
    public physicalActivity_User() {
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
        int i=1;

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
                calculate2BMI();
                if (bmi >= 26 ) {
                    bodyLiftingWeight = 80;
                } else if (bmi >= 23) {
                    bodyLiftingWeight = 60;
                } else if (bmi < 23 ) {
                    bodyLiftingWeight = 40;
                } else if (bmi <= 18) {
                    bodyLiftingWeight = 30;

                }

                lb_1.setText(String.valueOf(bodyLiftingWeight));

            }



        });

        bt_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate2BMI();
                if (bmi >= 26 ) {
                    pushUpsCount=30;
                }
                else if (bmi >= 23 ) {
                    pushUpsCount=20;
                }
                else if (bmi < 23 ) {
                    pushUpsCount=15;
                }
                else if (bmi <= 18) {
                    pushUpsCount=10;
                }
                lb_2.setText(String.valueOf(pushUpsCount));

            }

        });

        bt_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate2BMI();
                if (bmi >= 26) {
                    exerciseLevel ="Very high";
                }
                else if (bmi >= 23) {
                    exerciseLevel ="High";
                }
                else if (bmi < 23) {
                    exerciseLevel ="Medium";
                }
                else if (bmi <= 18) {
                    exerciseLevel ="Low";
                }
                lb_4.setText(exerciseLevel);

            }

        });
        bt_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate2BMI();
                if (bmi >= 26) {
                    targetStepCount =3000;
                }
                else if (bmi >= 23) {
                    targetStepCount =2539;
                }
                else if (bmi < 23) {
                    targetStepCount =1600;
                }
                else if (bmi <= 18) {
                    targetStepCount =500;
                }
                lb_5.setText(String.valueOf(targetStepCount));

            }

        });
        bt_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_6.setText(String.valueOf(calculateBMI()));

            }

        });
        bt_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_7.setText(String.valueOf(displayBMIInfo()));

            }

        });
        bt_8.setOnAction(new EventHandler<ActionEvent>() {


            public void handle(ActionEvent event) {
                calculate2BMI();
                if (bmi >= 26 ) {
                    targetedWeight=85;
                }
                else if (bmi >= 23 ) {
                    targetedWeight =80;
                }
                else if (bmi < 23 ) {
                    targetedWeight =75;
                }
                else if (bmi <= 18) {
                    targetedWeight= 70;
                }
                lb_8.setText(String.valueOf(targetedWeight));

            }

        });

    }

    public int getBodyLiftingWeight() {
        return bodyLiftingWeight;
    }
    public void setBodyLiftingWeight() {
        if (bmi >= 26 ) {
           bodyLiftingWeight=80;
        }
        else if (bmi >= 23 ) {
          bodyLiftingWeight=60;
        }
        else if (bmi < 23 ) {
          bodyLiftingWeight=40;
        }
        else if (bmi <= 18) {
         bodyLiftingWeight=30;
        }
    }

    public int getPushUpsCount() {
        return pushUpsCount;
    }



    public int getTargetedWeight() {
        return targetedWeight;
    }






    public String getExerciseLevel() {    //low,medium,high
        return exerciseLevel;
    }

    public void setExerciseLevel() {
        if (bmi >= 26) {
            exerciseLevel ="Very high";
        }
        else if (bmi >= 23) {
            exerciseLevel ="High";
        }
        else if (bmi < 23) {
            exerciseLevel ="Medium";
        }
        else if (bmi <= 18) {
            exerciseLevel ="Low";
        }

    }

    public int getTargetStepCount() {
        return targetStepCount;
    }

    public void setTargetStepCount() {
        if (bmi >= 26) {
            targetStepCount =3000;
        }
        else if (bmi >= 23) {
            targetStepCount =2539;
        }
       else if (bmi < 23) {
            targetStepCount =1600;
        }
        else if (bmi <= 18) {
            targetStepCount =500;
        }

    }
    // Calculate BMI
    public double calculateBMI() {
         bmi = weight / (height * height);
        return bmi;
    }
    public void calculate2BMI() {
        bmi = weight / (height * height);

    }

    // Display Ideal BMI and BMI Range
    public double displayBMIInfo() {
if(bmi>30){
    idealBMI = 27.0;
}
        else if(bmi>25){
            idealBMI = 24.0;
        }
        else{
            idealBMI = 22.0;
        }
         // Assuming an ideal BMI of 22.0
         bmi = calculateBMI();
        double bmiRange = 2.0; // Assuming a BMI range of +/- 2.0

        System.out.println("Your current BMI: " + bmi);
        System.out.println("Ideal BMI: " + idealBMI);
        System.out.println("BMI Range: " + (idealBMI - bmiRange) + " - " + (idealBMI + bmiRange));

        return idealBMI;

    }

    public int displayTargetWeight() {
        double heightInMeter = getHeight() / 100.0; // Height in meter
        double minIdealBmi = 18.5;
        double maxIdealBmi = 24.9;
        double minTargetWeight = minIdealBmi * (heightInMeter * heightInMeter);
        double maxTargetWeight = maxIdealBmi * (heightInMeter * heightInMeter);
        return (int) ((minTargetWeight + maxTargetWeight) / 2);
    }
    public void setPushUpsCount() {
        if (bmi >= 26 ) {
            pushUpsCount=30;
        }
            else if (bmi >= 23 ) {
            pushUpsCount=20;
        }
        else if (bmi < 23) {
            pushUpsCount=15;
        }
        else if (bmi <= 18) {
            pushUpsCount=10;
        }
    }

    }