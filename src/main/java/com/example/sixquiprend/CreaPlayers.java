package com.example.sixquiprend;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.List;

public class CreaPlayers extends Application {

    private TextField joueurField;
    private static ListView<String> listPlayer;
    @Override
    public void start(Stage stage) throws Exception {

        Label lblJoueur = new Label("Nom du joueur :");
        lblJoueur.setStyle("-fx-font-size: 40;");
        lblJoueur.setPadding(new Insets(30, 30, 30, 30));

        joueurField = new TextField();
        joueurField.setPromptText("Entrez un nom");
        joueurField.setPrefSize(200, 40);
        joueurField.setStyle("-fx-font-size: 20; -fx-background-radius: 20;");

        Button ajoutBouton = new Button("Ajouter");
        ajoutBouton.setStyle("-fx-background-color: #6d61a8; -fx-text-fill: white; -fx-font-size: 20; -fx-background-radius: 20;");
        ajoutBouton.setPrefSize(130, 30);
        ajoutBouton.setOnMouseEntered(event -> {
            ajoutBouton.setStyle("-fx-background-color: white; -fx-text-fill: #6d61a8; -fx-font-size: 20; -fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, #6d61a8, 5, 0, 0, 0);");
        });
        ajoutBouton.setOnMouseExited(event -> {
            ajoutBouton.setStyle("-fx-background-color: #6d61a8; -fx-text-fill: white;  -fx-font-size: 20; -fx-background-radius: 20;");
        });
        ajoutBouton.setOnAction(event -> {
            String nom = joueurField.getText();
            if (!nom.isEmpty()) {
                listPlayer.getItems().add(nom);
                joueurField.clear();
                if (listPlayer.getItems().size() >= 10) {
                    joueurField.setVisible(false);
                    ajoutBouton.setVisible(false);
                    lblJoueur.setText("Nombre maximum de\n      joueur atteint");
                }
            }
        });

        HBox hbox = new HBox(joueurField, ajoutBouton);
        hbox.setSpacing(30);
        hbox.setAlignment(Pos.CENTER);

        Button startBouton = new Button("Commencer ▶");
        startBouton.setStyle("-fx-background-color: #6d61a8; -fx-text-fill: white; -fx-font-size: 40; -fx-background-radius: 20;");
        startBouton.setPrefSize(300, 100);
        startBouton.setOnMouseEntered(event -> {
            startBouton.setStyle("-fx-background-color: white; -fx-text-fill: #6d61a8; -fx-font-size: 40; -fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, #6d61a8, 5, 0, 0, 0);");
        });
        startBouton.setOnMouseExited(event -> {
            startBouton.setStyle("-fx-background-color: #6d61a8; -fx-text-fill: white;  -fx-font-size: 40; -fx-background-radius: 20;");
        });
        startBouton.setOnAction(event -> {
            if (listPlayer.getItems().size() >= 1) {
                stage.close();
                Stage newStage = new Stage();
                Plateau plateau = new Plateau();
                try {
                    plateau.start(newStage);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Afficher un message d'erreur
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Aucun joueur inscrit");
                alert.setContentText("Veuillez ajouter au moins un joueur avant de commencer.");
                alert.showAndWait();
            }
        });

        HBox hboxCom = new HBox(startBouton);
        hboxCom.setPadding(new Insets(50, 30, 30, 30));
        hboxCom.setAlignment(Pos.CENTER);



        VBox inputBox = new VBox();
        inputBox.setSpacing(10);
        inputBox.setPadding(new Insets(10));
        inputBox.setPrefSize(500, 100);
        inputBox.getChildren().addAll(lblJoueur, hbox, hboxCom);
        inputBox.setAlignment(Pos.CENTER);

        listPlayer = new ListView<>();
        listPlayer.setPrefSize(200, 300);
        listPlayer.setStyle("-fx-font-size: 40; -fx-background-radius: 20; -fx-border-width: 0px; -fx-border-style: none;");

        VBox listBox = new VBox();
        listBox.setPrefSize(500, 50);
        listBox.getChildren().addAll(listPlayer);
        listBox.setAlignment(Pos.CENTER);
        listBox.setPadding(new Insets(0, 0, 0, 100));

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20, 20, 20, 20));
        borderPane.setRight(inputBox);
        borderPane.setLeft(listBox);
        borderPane.setStyle("-fx-background-color :white;");

        Scene scene = new Scene(borderPane, 1280, 645);
        stage.setTitle("Création des joueurs");
        stage.setScene(scene);
        stage.show();

    }
    public List<String> getNomsJoueurs() {
        ObservableList<String> joueurs = listPlayer.getItems();
        List<String> nomsJoueurs = new ArrayList<>();
        for (String joueur : joueurs) {
            nomsJoueurs.add(joueur);
        }
        return nomsJoueurs;
    }
}