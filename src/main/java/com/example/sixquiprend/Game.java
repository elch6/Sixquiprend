package com.example.sixquiprend;

import com.example.sixquiprend.cards.CardsReserve;
import com.example.sixquiprend.cards.Card;
import com.example.sixquiprend.players.Players;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game extends Application {
    private List<Players> players;
    private CardsReserve cardsReserve;
    @Override
    public void start(Stage plateau) {
        cardsReserve = new CardsReserve();
        //System.out.println(cardsReserve);

        VBox vboxPlateau = new VBox();
        vboxPlateau.setPadding(new Insets(10, 10, 10, 10));
        vboxPlateau.setSpacing(5);

        afficherNomsJoueurs();
        for (Players player : players) {
            HBox hboxCartes = new HBox();
            hboxCartes.setPadding(new Insets(10, 10, 10, 10));
            hboxCartes.setStyle("-fx-background-color: #D3D3D3; -fx-background-radius: 20;");

            Label labelJoueur = new Label("Les cartes de " + player.getNom());
            labelJoueur.setStyle("-fx-font-weight: bold; -fx-font-size: 16;");
            labelJoueur.setPadding(new Insets(10, 10, 10, 10));

            for (int i = 0; i < 10; i++) {
                Button bouton = new Button();
                bouton.setStyle("-fx-background-color: #D3D3D3");
                hboxCartes.getChildren().add(bouton);
            }

            for (int i = 0; i < 10; i++) {
                Button bouton = (Button) hboxCartes.getChildren().get(i);
                Card carte = cardsReserve.getCardsStack().remove(0);
                String imagepath = "cartes/carte" + carte.getValue() + ".png";
                //System.out.println(imagepath);
                Image image = new Image(
                        Objects.requireNonNull(
                                getClass().getResource(
                                        imagepath)
                        ).toExternalForm()
                );
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(140);
                imageView.setFitHeight(200);
                bouton.setGraphic(imageView);
            }
            vboxPlateau.getChildren().addAll(labelJoueur, hboxCartes);
        }

        GridPane plateauGrid = new GridPane();
        plateauGrid.setPadding(new Insets(10, 10, 10, 10));
        plateauGrid.setHgap(10);
        plateauGrid.setVgap(10);

        for (int row = 0; row < 4; row++) {
            Card carte = cardsReserve.getCardsStack().remove(0);
            String imagepath = "cartes/carte" + carte.getValue() + ".png";
            Image image = new Image(
                    Objects.requireNonNull(
                            getClass().getResource(
                                    imagepath)
                    ).toExternalForm()
            );
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(70);
            imageView.setFitHeight(100);
            plateauGrid.add(imageView, 0, row);
        }

        vboxPlateau.getChildren().add(plateauGrid);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vboxPlateau);

        Scene scene = new Scene(borderPane, 1280, 645);
        plateau.setTitle("Six qui prend");
        plateau.setScene(scene);
        plateau.show();
    }

    public void afficherNomsJoueurs() {
        CreaPlayers creaPlayers = new CreaPlayers();
        List<String> nomsJoueurs = creaPlayers.getNomsJoueurs();
        players = new ArrayList<>();
        for (String nom : nomsJoueurs) {
            players.add(new Players(nom));
        }
    }
}