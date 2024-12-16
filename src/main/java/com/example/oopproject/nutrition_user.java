package com.example.oopproject;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class nutrition_user extends user implements Initializable {
            private String dietaryRestrictions;
            private String username;
            private double weight;
            private double height;
            private boolean hasAllergies;
            private String allergies;


           @FXML
           private RadioButton rb_1=new RadioButton();
    @FXML
    private RadioButton rb_2=new RadioButton();
    @FXML
    private RadioButton rb_3=new RadioButton();
    @FXML
    private RadioButton rb_4=new RadioButton();
    @FXML
    private RadioButton rb_5=new RadioButton();

    @FXML
    private RadioButton rb_6=new RadioButton();
    @FXML
    private RadioButton rb_7=new RadioButton();
    @FXML
    private RadioButton rb_8=new RadioButton();
    @FXML
    private RadioButton rb_9=new RadioButton();
    @FXML
    private RadioButton rb_10=new RadioButton();
    @FXML
    private RadioButton rb_11=new RadioButton();
    @FXML
    private RadioButton rb_12=new RadioButton();
    @FXML
    private RadioButton rb_13=new RadioButton();
    @FXML
    private RadioButton rb_14=new RadioButton();
    @FXML
 private Button bt_press=new Button();
    @FXML
    private Label lb_1=new Label();
    @FXML
    private Label lb_2=new Label();

            public String getAllergies() {
                return allergies;
            }

            public void setAllergies(String allergies) {
                this.allergies = allergies;
            }


          public nutrition_user(){
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
        ToggleGroup toggleGroup1=new ToggleGroup();

        rb_1.setToggleGroup(toggleGroup1);
        rb_1.setSelected(true);
        rb_2.setToggleGroup(toggleGroup1);
        rb_3.setToggleGroup(toggleGroup1);
        rb_4.setToggleGroup(toggleGroup1);
        rb_5.setToggleGroup(toggleGroup1);
        rb_6.setToggleGroup(toggleGroup1);
        rb_7.setToggleGroup(toggleGroup1);

        ToggleGroup toggleGroup2=new ToggleGroup();
        rb_8.setToggleGroup(toggleGroup2);
        rb_8.setSelected(true);
        rb_9.setToggleGroup(toggleGroup2);
        rb_10.setToggleGroup(toggleGroup2);
        rb_11.setToggleGroup(toggleGroup2);
        rb_12.setToggleGroup(toggleGroup2);
        rb_13.setToggleGroup(toggleGroup2);
        rb_14.setToggleGroup(toggleGroup2);
        bt_press.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "user.fxml", "USER SECTION!", null);
                //  u=tf_username.getText();

            }


        });
        rb_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              lb_1.setText("Choose gluten-free grains such as rice, quinoa, corn etc ");


            }


        });
        rb_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_1.setText("Use alternative protein sources such as beans, lentils, quinoa, and nuts.");


            }


        });
        rb_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_1.setText("Choose alternative sources of omega-3 fatty acids such as flaxseeds, chia seeds etc");


            }


        });
        rb_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_1.setText("Use alternative nut or seed butters like almond butter, sunflower seed butter, or tahini.");


            }


        });
        rb_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_1.setText("Avoid foods that contain mustard or mustard derivatives.");


            }


        });
        rb_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_1.setText("Look for egg-free alternatives in baked goods, sauces, and dressings.");


            }


        });
        rb_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_1.setText("Opt for dairy alternatives such as almond milk, soy milk, or coconut milk.");


            }


        });
        rb_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText("Include plant-based protein sources such as beans, lentils, tofu, tempeh, and quinoa.");


            }


        });
        rb_9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText("Choose foods that are low in carbohydrates such as non-starchy vegetables,poultry etc");


            }


        });
        rb_10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText("Choose whole, unprocessed foods such as meat, fish, eggs, vegetables, fruits etc");


            }


        });
        rb_11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText("Choose low-fiber foods such as white bread, white rice, refined grains, lean proteins etc");


            }


        });
        rb_12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText("Use alternative plant-based protein sources such as beans, lentils, peas, quinoa, tempeh etc");


            }


        });
        rb_13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText("Use alternative seasonings such as herbs, spices, and vinegar to add flavor to foods.");


            }


        });
        rb_14.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lb_2.setText("Choose alternative vegetables and fruits such as sweet potatoes, carrots, cucumbers");


            }


        });


     /*   bt_1.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
                if (bmi >= 26 && weight>=80) {
                    bodyLiftingWeight=80;
                }
                else if (bmi >= 23 && weight>=75) {
                    bodyLiftingWeight=60;
                }
                else if (bmi < 23 && weight<=65 && weight <=75) {
                    bodyLiftingWeight=40;
                }
                else if (bmi <= 18) {
                    bodyLiftingWeight=30;
                }
                lb_1.setText(String.valueOf(bodyLiftingWeight));

            }

        });

        bt_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (bmi >= 26 && weight>=80) {
                    pushUpsCount=30;
                }
                else if (bmi >= 23 && weight>=75) {
                    pushUpsCount=20;
                }
                else if (bmi < 23 && weight<=65 && weight <=75) {
                    pushUpsCount=15;
                }
                else if (bmi <= 18) {
                    pushUpsCount=10;
                }
                lb_2.setText(String.valueOf(pushUpsCount));

            }

        });*/}
            public String getDietaryRestrictions() {
                return dietaryRestrictions;
            }

            public void setDietaryRestrictions(String dietaryRestrictions) {
                this.dietaryRestrictions = dietaryRestrictions;
            }

            public boolean hasAllergies() {
                return hasAllergies;
            }

            public void setHasAllergies(boolean hasAllergies) {
                this.hasAllergies = hasAllergies;
            }

            public void solveAllergies() {
                // Method to solve user's problems related to allergies
                if (hasAllergies) {
                    System.out.println("Solving user's problems related to allergies...");

                    // Example logic to solve user's problems related to allergies
                    if (allergies.equals("Gluten")) {
                        System.out.println("Avoiding foods that contain gluten.\nSolution: Choose gluten-free grains such as rice, quinoa, corn, and gluten-free oats. Look for gluten-free versions of bread, pasta, cereals, and other grain-based products. Include naturally gluten-free foods like fruits, vegetables, legumes, nuts, seeds, and lean proteins.");
                        System.out.println("Solution: Choose gluten-free grains such as rice, quinoa, corn, and gluten-free oats. Look for gluten-free versions of bread, pasta, cereals, and other grain-based products. Include naturally gluten-free foods like fruits, vegetables, legumes, nuts, seeds, and lean proteins.");
                    }
                    if (allergies.equals("Soy")) {
                        System.out.println("Avoiding soy and soy products.");
                        System.out.println("Solution: Read food labels carefully to avoid foods that contain soy or soy derivatives. Use alternative protein sources such as beans, lentils, quinoa, and nuts. Be cautious of cross-contamination in food preparation and manufacturing processes.");
                    }

                    if (allergies.equals("Fish")) {
                        System.out.println("Avoiding fish.");
                        System.out.println("Solution: Avoid all forms of fish, including fresh, frozen, and canned fish. Choose alternative sources of omega-3 fatty acids such as flaxseeds, chia seeds, or algae-based supplements. Be cautious of cross-contamination in food preparation and manufacturing processes.");
                    }



                    if (allergies.equals("Mustard")) {
                        System.out.println("Avoiding mustard and mustard products.");
                        System.out.println("Solution: Read food labels carefully to avoid foods that contain mustard or mustard derivatives. Use alternative seasonings and condiments. Be cautious of cross-contamination in food preparation and manufacturing processes.");
                    }



                    if (allergies.equals("Lactose")) {
                        System.out.println("Avoiding foods that contain lactose.");
                        System.out.println("Solution: Choose lactose-free or lactose-reduced dairy products, or opt for dairy alternatives such as almond milk, soy milk, or coconut milk. Include other calcium-rich foods like leafy green vegetables, fortified foods, and supplements if needed.");
                    }

                    if (allergies.equals("Peanut")) {
                        System.out.println("Avoiding peanuts.");
                        System.out.println("Solution: Read food labels carefully to avoid foods that contain peanuts or peanut products. Use alternative nut or seed butters like almond butter, sunflower seed butter, or tahini. Be cautious of cross-contamination in food preparation and manufacturing processes.");
                    }




                    if (allergies.equals("Eggs")) {
                        System.out.println("Avoiding eggs.");
                        System.out.println("Solution: Avoid all forms of eggs, including egg yolks and egg whites. Look for egg-free alternatives in baked goods, sauces, and dressings. Use egg substitutes or replacers in recipes if needed.");
                    }

                    System.out.println("Allergies solved!");
                } else {
                    System.out.println("User does not have any allergies.");
                }
            }

            public void solveDietaryRestrictions() {
                // Method to solve user's problems related to dietary restrictions
                System.out.println("Solving user's problems related to dietary restrictions...");

                // Example logic to solve user's problems related to dietary restrictions
                if (dietaryRestrictions.contains("Vegan")) {
                    System.out.println("Avoiding all animal-based foods.");
                    System.out.println("Solution: Include plant-based protein sources such as beans, lentils, tofu, tempeh, and quinoa. Also, ensure adequate intake of essential nutrients like vitamin B12, iron, calcium, and omega-3 fatty acids through plant-based sources or supplements.");
                }

                if (dietaryRestrictions.contains("Low-carb")) {
                    System.out.println("Avoiding foods that are high in carbohydrates.");
                    System.out.println("Solution: Choose foods that are low in carbohydrates such as non-starchy vegetables, lean meats, poultry, fish, eggs, nuts, seeds, and healthy fats. Avoid or limit intake of foods high in refined carbohydrates and sugars.");
                }
                if (dietaryRestrictions.contains("Paleo")) {
                    System.out.println("Avoiding processed foods, grains, legumes, and dairy products.");
                    System.out.println("Solution: Choose whole, unprocessed foods such as meat, fish, eggs, vegetables, fruits, nuts, and seeds. Avoid foods that are processed, refined, or contain added sugars and artificial ingredients.");
                }

                if (dietaryRestrictions.contains("Allium-free")) {
                    System.out.println("Avoiding foods that contain allium vegetables such as onions, garlic, leeks, and shallots.");
                    System.out.println("Solution: Use alternative seasonings such as herbs, spices, and vinegar to add flavor to foods. Check food labels and avoid foods that contain allium vegetables as ingredients.");
                }

                if (dietaryRestrictions.contains("High-fiber")) {
                    System.out.println("Limiting intake of foods that are high in dietary fiber.");
                    System.out.println("Solution: Choose low-fiber foods such as white bread, white rice, refined grains, lean proteins, and cooked fruits and vegetables. Limit intake of high-fiber foods like whole grains, legumes, nuts, seeds, and raw fruits and vegetables.");
                }

                if (dietaryRestrictions.contains("Soy")) {
                    System.out.println("Avoiding foods that contain soy or soy-based products.");
                    System.out.println("Solution: Read food labels carefully to avoid foods that contain soy or soy derivatives. Use alternative plant-based protein sources such as beans, lentils, peas, quinoa, tempeh, or seitan.");
                }

                if (dietaryRestrictions.contains("Nightshade")) {
                    System.out.println("Avoiding foods that belong to the nightshade family such as tomatoes, potatoes, peppers, and eggplants.");
                    System.out.println("Solution: Choose alternative vegetables and fruits that do not belong to the nightshade family such as sweet potatoes, carrots, cucumbers, and zucchini. Be cautious of hidden nightshade ingredients in processed foods.");
                }
                if (dietaryRestrictions.contains("Lactose")) {
                    System.out.println("Avoiding foods that contain lactose.");
                    System.out.println("Solution: Choose lactose-free or lactose-reduced dairy products, or opt for dairy alternatives such as almond milk, soy milk, or coconut milk. Include other calcium-rich foods like leafy green vegetables, fortified foods, and supplements if needed.");
                }

                if (dietaryRestrictions.contains("Gluten")) {
                    System.out.println("Avoiding foods that contain gluten.");
                    System.out.println("Solution: Choose gluten-free grains such as rice, quinoa, corn, and gluten-free oats. Look for gluten-free versions of bread, pasta, cereals, and other grain-based products. Include naturally gluten-free foods like fruits, vegetables, legumes, nuts, seeds, and lean proteins.");
                }

                if (dietaryRestrictions.contains("Peanut")) {
                    System.out.println("Avoiding peanuts.");
                    System.out.println("Solution: Read food labels carefully to avoid foods that contain peanuts or peanut products. Use alternative nut or seed butters like almond butter, sunflower seed butter, or tahini. Be cautious of cross-contamination in food preparation and manufacturing processes.");
                }

                // Add more if-conditions to handle other dietary restrictions

                System.out.println("Dietary restrictions solved!");

            }
        }
