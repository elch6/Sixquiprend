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
import java.util.List;
import java.util.Objects;

public class Plateau extends Application {
    private List<String> players;
    @Override
    public void start(Stage plateau) throws Exception {
        HBox hboxCartes = new HBox();
        hboxCartes.setPadding(new Insets(10, 10, 10, 10));
        hboxCartes.setStyle("-fx-background-color: #D3D3D3; -fx-background-radius: 20;");

        for (int i = 0; i < 10; i++) {
            Button bouton = new Button();
            bouton.setStyle("-fx-background-color: #D3D3D3");
            hboxCartes.getChildren().add(bouton);
        }

        for (int i = 0; i < 10; i++) {
            Button bouton = (Button) hboxCartes.getChildren().get(i);
            Image image = new Image(
                    Objects.requireNonNull(
                            getClass().getResource(
                                    "cartes/carte1.png")
                    ).toExternalForm()
            );
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(70);
            imageView.setFitHeight(100);
            bouton.setGraphic(imageView);
        }
        afficherNomsJoueurs();
        Label labelJoueur = new Label("Les cartes de " + players.get(0));
        labelJoueur.setStyle("-fx-font-weight: bold; -fx-font-size: 16;");
        labelJoueur.setPadding(new Insets(10, 10, 10, 10));

        GridPane plateauGrid = new GridPane();
        plateauGrid.setPadding(new Insets(10, 10, 10, 10));
        plateauGrid.setHgap(10);
        plateauGrid.setVgap(10);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 6; col++) {
                Image image = new Image(
                        Objects.requireNonNull(
                                getClass().getResource(
                                        "cartes/carte1.png")
                        ).toExternalForm()
                );
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(70);
                imageView.setFitHeight(100);
                plateauGrid.add(imageView, col, row);
            }
        }

        VBox vboxPlateau = new VBox();
        vboxPlateau.setPadding(new Insets(10, 10, 10, 10));
        vboxPlateau.setSpacing(5);
        vboxPlateau.getChildren().addAll(labelJoueur, hboxCartes, plateauGrid);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vboxPlateau);

        Scene scene = new Scene(borderPane, 1280, 645);
        plateau.setTitle("Six qui prend");
        plateau.setScene(scene);
        plateau.show();
    }
    public void afficherNomsJoueurs() {
        // TODO (Elena) : finir cette fonction
        CreaPlayers creaPlayers = new CreaPlayers();
        players = creaPlayers.getNomsJoueurs();
        //joueur1 = nomsJoueurs.get(0);
        // joueur2 = nomsJoueurs.get(1);
    }
}