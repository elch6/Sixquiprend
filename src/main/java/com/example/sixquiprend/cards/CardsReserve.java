package com.example.sixquiprend.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardsReserve {
    private List<Carte> cardsStack;
    private Map<String, List<Carte>> playerCards;

    public CardsReserve() {
        cardsStack = new ArrayList<>();
        playerCards = new HashMap<>();

        for (int i = 1; i <= 104; i++) {
            cardsStack.add(new Carte(i));
        }
        Collections.shuffle(cardsStack);
    }

    public List<Carte> getCards(Integer nbCards) {
        List<Carte> cardsList = new ArrayList<>();
        for (int i = 0; i < nbCards; i++) {
            cardsList.add(cardsStack.remove(0));
        }
        return cardsList;
    }

    public void distributeCards(List<String> players) {
        for (String player : players) {
            List<Carte> playerHand = getCards(10);
            playerCards.put(player, playerHand);
        }
    }

    public List<Carte> getPlayerCards(String player) {
        return playerCards.get(player);
    }
}
