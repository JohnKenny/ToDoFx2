package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.animations.Shaker;
import sample.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
        @FXML
        private URL location;

        @FXML
        private TextField loginUsername;

        @FXML
        private PasswordField loginPassword;

        @FXML
        private Button loginButton;

        @FXML
        private Button loginSignupButton;

        private DatabaseHandler databaseHandler;


        @FXML
        void initialize(){

                databaseHandler = new DatabaseHandler();


                loginButton.setOnAction(event -> {

                        String loginText = loginUsername.getText().trim();
                        String loginPwd = loginPassword.getText().trim();

                        User user = new User();
                        user.setUser_name(loginText);
                        user.setPassword(loginPwd);

                     ResultSet userRow = databaseHandler.getUser(user);

                     int counter = 0;
                     try {
                             while (userRow.next()) {
                                     counter+=1;
                                     String name = userRow.getString("first_name");
                                     System.out.println("Welcome " + name);

                             }
                             if(counter == 1){
                                     //System.out.println("Login successful ");
                                     showAddItemScreen();
                             } else {
                                     Shaker userNameShaker = new Shaker(loginUsername);
                                     Shaker passwordShaker = new Shaker(loginPassword);
                                     passwordShaker.shake();
                                     userNameShaker.shake();
                             }
                     } catch(SQLException se){
                             se.printStackTrace();
                     }
                });

                loginSignupButton.setOnAction(event -> {
                        // takes users to sign up screen
                        loginSignupButton.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/sample/view/signup.fxml"));

                        try {
                                loader.load();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();


                });

    }

        private void showAddItemScreen(){
                // takes users to AddItem screen
                loginSignupButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/view/additem.fxml"));

                try {
                        loader.load();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
        }


}
