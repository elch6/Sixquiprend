package com.example.sixquiprend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("plateau.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("6 qui prend!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        //setCards();
        Plateau plateau = new Plateau();
        plateau.setCarte1();

    }
    public static void setCards(){
        List<Cards> cartes = new ArrayList<>();
        for (int i = 1; i <= 104; i++) {
            Cards cards = new Cards(i);
            cartes.add(cards);
        }
    }
}