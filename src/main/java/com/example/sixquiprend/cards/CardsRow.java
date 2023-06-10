package com.example.sixquiprend.cards;

import com.example.sixquiprend.players.Players;
import lombok.Data;

import java.util.List;
@Data
public class CardsRow {

    private List<Card> cardsRow;

    public CardsRow(Card baseCard) {
        this.cardsRow.add(baseCard);
    }

    public List<Card> getCardsRow() {
        return cardsRow;
    }

    public void addCard(Card card) {
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
