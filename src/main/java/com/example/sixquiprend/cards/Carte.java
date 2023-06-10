package com.example.sixquiprend.cards;

import lombok.Data;

@Data
public class Carte {
    private int cardNumber;
    private int PenalityPoints;
    private String cardPath;
    public Carte(int cardNumber) {
        this.cardNumber = cardNumber;
        this.PenalityPoints = calculateTetesDeBoeuf(cardNumber);
        this.cardPath = "src/main/resources/com/example/sixquiprend/cartes/carte" + cardNumber + ".png";
    }
    public int getValue() {
        return cardNumber;
    }
    public int getPenalityPoints() {
        return PenalityPoints;
    }
    public static int calculateTetesDeBoeuf(int number) {
        if (number == 55) {
            return 7;
        } else if (number % 11 == 0) {
            return 5;
        } else if (number % 10 == 0) {
            return 3;
        } else if (number % 5 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    public String getCardPath() {
        return cardPath;
    }
}
