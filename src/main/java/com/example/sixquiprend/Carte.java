package com.example.sixquiprend;

public class Carte {
    private int num;
    private int tetesDeBoeuf;
    public Carte(int num) {
        this.num = num;
        this.tetesDeBoeuf = calculateTetesDeBoeuf(num);
    }
    public int getNum() {
        return num;
    }
    public int getTetesDeBoeuf() {
        return tetesDeBoeuf;
    }
    private int calculateTetesDeBoeuf(int num) {
        int tetesDeBoeuf = 0;
        String numStr = String.valueOf(num);
        if (numStr.charAt(0) == numStr.charAt(1)) {
            tetesDeBoeuf += 5;
        }
        if (num % 10 == 0) {
            tetesDeBoeuf += 3;
        }
        if (num % 10 == 5) {
            tetesDeBoeuf += 2;
        }
        return tetesDeBoeuf;
    }
}
