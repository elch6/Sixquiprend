package com.example.sixquiprend.board;

import com.example.sixquiprend.cards.CardsReserve;
import com.example.sixquiprend.cards.CardsRow;
import com.example.sixquiprend.cards.Carte;
import com.example.sixquiprend.players.PlayerQueue;
import com.example.sixquiprend.players.Players;

import java.util.*;

public class gameboard {

    private PlayerQueue playerQueue;
    private CardsReserve cardsReserve;
    private List<CardsRow> cardsRows;
    private Integer turn ;

    private Players currentPlayer;

    //creating game board with players and cards
    public gameboard(List<Players> players) {
        this.playerQueue = new PlayerQueue(players);
        this.cardsReserve = new CardsReserve();
        this.turn = 10;

        // distributing 10 cards to players
        for (Players player : players) {
            player.addCarte((Carte) cardsReserve.getCards(10));
        }

        // creating 4 rows with 1 card each
        for (int i = 0; i < 4; i++) {
            cardsRows.add(new CardsRow((Carte) cardsReserve.getCards(1)));
        }

    }

    public void nextTurn(List<Carte> cardsPlayed ) {
        if (turn == 0) {
            // the game is over
            return;
        }

        // sorting cards by lowest to the highest value to determine the order of the players
        cardsPlayed.sort(Comparator.comparingInt(Carte::getValue));

        // iterating over the cards played to add them to the rows
        for (Carte card : cardsPlayed) {

            // creating a copy of the rows
            List<CardsRow> copyCardsRows = new ArrayList<>(cardsRows);

            // removing the rows that have a value higher than the card played
            for (CardsRow row : cardsRows) {
                if (row.getValueOfLastCard() > card.getValue()) {
                    copyCardsRows.remove(row);
                }
            }

            // if there is no row left, the card cannot be added automatically and the player will have to choose a row
            if (copyCardsRows.size() == 0) {
                // the player will have to choose a row
                return;
            }

            // if there is only one row left, the card is automatically added to the row
            if (copyCardsRows.size() == 1) {
                copyCardsRows.get(0).addCard(card);
                continue;
            }

            // if there is more than one row left, the card will be added to the row with the lowest difference between the value of the last card and the value of the card played
            copyCardsRows.sort(Comparator.comparingInt(row -> row.getValueOfLastCard() - card.getValue()));
            copyCardsRows.get(0).addCard(card);

        }

        turn--;
    }
}
