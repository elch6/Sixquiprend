module com.example.sixquiprend {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.sixquiprend to javafx.fxml;
    exports com.example.sixquiprend;
    exports com.example.sixquiprend.cards;
    opens com.example.sixquiprend.cards to javafx.fxml;
    exports com.example.sixquiprend.players;
    opens com.example.sixquiprend.players to javafx.fxml;
}