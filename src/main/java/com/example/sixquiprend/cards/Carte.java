package com.example.sixquiprend.cards;

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
    private int calculateTetesDeBoeuf(int num) {
        String numStr = String.valueOf(num);
        if (numStr.charAt(0) == numStr.charAt(1)) {
            return 5;
        }
        if (num % 10 == 0) {
            return 3;
        }
        if (num % 10 == 5) {
            return 2;
        }
        return 1;
    }

    public String getCardPath() {
        return cardPath;
    }
}
