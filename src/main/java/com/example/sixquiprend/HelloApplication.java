package com.example.sixquiprend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 20));

        VBox titleBox = new VBox();
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setSpacing(20);

        Label titleLabel = new Label("Bienvenue sur le jeu");
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 70; ");

        Label subtitleLabel = new Label("6 Qui Prend");
        subtitleLabel.setStyle("-fx-text-fill: #6d61a8; -fx-font-weight: bold; -fx-font-size: 80; -fx-effect: dropshadow(three-pass-box, #6d61a8, 5, 0, 0, 0);");

        Button startBouton = new Button("Start");
        startBouton.setStyle("-fx-background-color: #6d61a8; -fx-text-fill: white; -fx-font-size: 40; -fx-background-radius: 20;");
        startBouton.setPadding(new Insets(10, 20, 10, 20));
        startBouton.setPrefSize(160, 80);

        startBouton.setOnMouseEntered(event -> {
            startBouton.setStyle("-fx-background-color: white; -fx-text-fill: #6d61a8; -fx-font-size: 16px; -fx-font-size: 40; -fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, #6d61a8, 5, 0, 0, 0);");
        });

        startBouton.setOnMouseExited(event -> {
            startBouton.setStyle("-fx-background-color: #6d61a8; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-size: 40; -fx-background-radius: 20;");
        });

        startBouton.setOnAction(event -> {
            primaryStage.close();
            Stage newStage = new Stage();
            CreaPlayers creaPlayers = new CreaPlayers();
            try {
                creaPlayers.start(newStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        titleBox.getChildren().addAll(titleLabel, subtitleLabel, startBouton);

        borderPane.setCenter(titleBox);
        Scene scene = new Scene(borderPane, 1280, 645);
        primaryStage.setTitle("Six qui prend");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
        //setCards();

    }
    public static void setCards(){
        List<Carte> cartes = new ArrayList<>();
        for (int i = 1; i <= 104; i++) {
            Carte carte = new Carte(i);
            cartes.add(carte);
        }
    }
}