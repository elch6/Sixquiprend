package com.example.sixquiprend.players;

import java.util.List;
import java.util.Map;

public class PlayerQueue { // this class manage the queue of players and the current player

    private List<Players> playersQueue;
    private Players currentPlayer ;

    public PlayerQueue(List<Players> players) {
        this.playersQueue = players;
        this.currentPlayer = players.get(Math.toIntExact(Math.round(Math.random() * (players.size() - 1))));
    }

    public Players getCurrentPlayer() {
        return currentPlayer;
    }

    public List<Players> getPlayersQueue() {
        return playersQueue;
    }



}
