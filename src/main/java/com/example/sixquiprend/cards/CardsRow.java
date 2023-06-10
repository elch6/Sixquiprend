package com.example.sixquiprend.cards;

import com.example.sixquiprend.players.Players;

import java.util.List;

public class CardsRow {

    private List<Carte> cardsRow;

    public CardsRow(Carte baseCard) {
        this.cardsRow.add(baseCard);
    }

    public List<Carte> getCardsRow() {
        return cardsRow;
    }

    public void addCard(Carte card) {
        cardsRow.add(card);

        if (cardsRow.size() == 6) {
            // then the row is full, and we need to remove the row and add the cards to the player
            return;
        }
        if (card.getValue() < cardsRow.get(cardsRow.size() - 2).getValue()) {
            // If the card just added is lower than the previous one, we need to remove the row and add the cards to the player
            return;
        }

    }

    public void removeRow(Players player) {
        // remove the row and add the cards to the player
    }

    public Integer getValueOfLastCard() {
        return cardsRow.get(cardsRow.size() - 1).getValue();
    }

    public Integer getNumberOfCards() {
        return cardsRow.size();
    }
}
