package com.example.KeyNest.popups;

import com.example.KeyNest.Account;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.MalformedURLException;


public class AddAccount
{
    public static Account account = null;

    public void display() throws MalformedURLException
    {
        Stage popupwindow=new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Add account");
        Image iconpopup = new Image("icon.png");
        popupwindow.getIcons().add(iconpopup);

        Label nameLabel = new Label("Insert the name:");
        nameLabel.setTextAlignment(TextAlignment.CENTER);
        TextField nameField = new TextField("");
        nameField.setMaxWidth(250);
        Label emailLabel = new Label("Insert the email:");
        emailLabel.setTextAlignment(TextAlignment.CENTER);
        TextField emailField = new TextField("");
        emailField.setMaxWidth(250);
        Label passwordLabel = new Label("Insert the password:");
        passwordLabel.setTextAlignment(TextAlignment.CENTER);
        TextField passwordField = new TextField("");
        passwordField.setMaxWidth(250);

        Region region = new Region();

        Button button = new Button("Add account");

        button.setOnAction(e ->
        {
            if(!nameField.getText().isBlank() && !emailField.getText().isBlank() && !passwordField.getText().isBlank())
            {
                account = new Account(nameField.getText(), emailField.getText(), passwordField.getText());
                popupwindow.close();
            }
        });

        button.setDefaultButton(true);

        VBox layout= new VBox(7);

        layout.getChildren().addAll(nameLabel, nameField, emailLabel, emailField, passwordLabel, passwordField, region, button);

        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 250);

        scene.getStylesheets().add(getClass().getResource("/com/example/KeyNest/popups.css").toExternalForm());

        popupwindow.setScene(scene);
        popupwindow.setX(660);
        popupwindow.setY(200);

        popupwindow.showAndWait();
    }
}