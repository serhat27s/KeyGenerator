package com.example.KeyNest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application
{
    public static Scene scene;
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException
    {
        stage.setTitle("KeyNest");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        App.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUImain.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        GeneratorController controller = loader.getController();
        controller.switchKeyGenerator(null); // needs to be here as no button works if its not reloaded
        stage.setResizable(false);
        stage.show();
    }

    public static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
