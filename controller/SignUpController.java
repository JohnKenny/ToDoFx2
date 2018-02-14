package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.Database.DatabaseHandler;
import sample.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpUsername;

    @FXML
    private TextField signUpLocation;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private TextField signUppassword;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {


        signUpButton.setOnAction(event -> {
            createUser();
        });
    }


    private void createUser(){
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String name = signUpFirstName.getText();
        String lastName = signUpLastName.getText();
        String userName = signUpUsername.getText();
        String password = signUppassword.getText();
        String location = signUpLocation.getText();

        String gender = "";
        if(signUpCheckBoxFemale.isSelected()){
            gender = "Female";
        } else gender = "Male";

        User user = new User(name, lastName, userName, password, location, gender);

        databaseHandler.signUpUser(user);
    }


    }
