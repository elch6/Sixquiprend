package com.example.sixquiprend.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardsReserve {
    private List<Carte> cardsStack;
    public boolean isShowed = true;

    public CardsReserve() {
        for (int i = 1; i <= 104; i++) {
            cardsStack.add(new Carte(i));
        }
        Collections.shuffle(cardsStack);
    }

    public List<Carte> getCards(Integer nbCards) {
        List<Carte> cardsList = new ArrayList<>();
        for (int i = 0; i < nbCards; i++) {
            cardsList.add(cardsStack.remove(i));
        }
        return cardsList;
    }
}
