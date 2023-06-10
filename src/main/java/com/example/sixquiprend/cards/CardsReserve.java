package com.example.sixquiprend.cards;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class CardsReserve {
    private List<Card> cardsStack;
    public boolean isShowed = true;

    public CardsReserve() {
        cardsStack = new ArrayList<>();
        for (int i = 1; i <= 104; i++) {
            cardsStack.add(new Card(i));
        }
        Collections.shuffle(cardsStack);
    }

    public List<Card> getCards(Integer nbCards) {
        List<Card> cardsList = new ArrayList<>();
        for (int i = 0; i < nbCards; i++) {
            cardsList.add(cardsStack.remove(i));
        }
        return cardsList;
    }
}
