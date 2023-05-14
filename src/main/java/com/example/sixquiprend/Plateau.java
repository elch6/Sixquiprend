package com.example.sixquiprend;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Plateau {
    @FXML
    private Button carte1;

    @FXML
    public void setCarte1() {
        Image image = new Image("C:\\Users\\elena\\test\\Sixquiprend\\src\\main\\resources\\com\\example\\sixquiprend\\cartes\\carte1.png");
        ImageView imageView = new ImageView(image);
        carte1.setGraphic(imageView);
    }

}
