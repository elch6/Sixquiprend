package com.example.sixquiprend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Créer une grille de 10 boutons pour les cartes
        HBox hboxCartes = new HBox();
        hboxCartes.setPadding(new Insets(10, 10, 10, 10));
        hboxCartes.setStyle("-fx-background-color: #D3D3D3; -fx-background-radius: 20;");

        for (int i = 0; i < 10; i++) {
            Button bouton = new Button();
            bouton.setStyle("-fx-background-color: #D3D3D3");
            hboxCartes.getChildren().add(bouton);
        }

        // Modifier l'apparence des boutons pour les cartes
        for (int i = 0; i < 10; i++) {
            Button bouton = (Button) hboxCartes.getChildren().get(i);
            Image image = new Image("C:\\Users\\elena\\test\\Sixquiprend\\src\\main\\resources\\com\\example\\sixquiprend\\cartes\\carte1.png");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(70);
            imageView.setFitHeight(100);
            bouton.setGraphic(imageView);
        }

        // Créer le label pour le joueur
        Label labelJoueur = new Label("Les cartes appartiennent au joueur n°1");
        labelJoueur.setStyle("-fx-font-weight: bold; -fx-font-size: 16;");
        labelJoueur.setPadding(new Insets(10, 10, 10, 10));

        // Créer la grille pour le plateau de jeu
        GridPane plateauGrid = new GridPane();
        plateauGrid.setPadding(new Insets(10, 10, 10, 10));
        plateauGrid.setHgap(10);
        plateauGrid.setVgap(10);

        // Remplir la grille avec les cartes
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 6; col++) {
                Image image = new Image("C:\\Users\\elena\\test\\Sixquiprend\\src\\main\\resources\\com\\example\\sixquiprend\\cartes\\carte1.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(70);
                imageView.setFitHeight(100);
                plateauGrid.add(imageView, col, row);
            }
        }

        // Ajouter les éléments au VBox
        VBox vboxPlateau = new VBox();
        vboxPlateau.setPadding(new Insets(10, 10, 10, 10));
        vboxPlateau.setSpacing(5);
        vboxPlateau.getChildren().addAll(labelJoueur, hboxCartes, plateauGrid);

        // Créer le BorderPane et ajouter les éléments
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vboxPlateau);

        Scene scene = new Scene(borderPane, 800, 600);

        primaryStage.setTitle("Six qui prend");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}