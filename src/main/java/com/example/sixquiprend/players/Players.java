package com.example.sixquiprend.players;

import com.example.sixquiprend.cards.Card;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Players {

    private String nom;
    private List<Card> cartes;

    public Players(String nom) {
        this.nom = nom;
        this.cartes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Card> getCartes() {
        return cartes;
    }

    public void addCarte(Card carte) {
        cartes.add(carte);
    }
}
