package com.example.sixquiprend;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private String nom;
    private List<Carte> cartes;

    public Players(String nom) {
        this.nom = nom;
        this.cartes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void addCarte(Carte carte) {
        cartes.add(carte);
    }
}
