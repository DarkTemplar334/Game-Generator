package gr.ict.ihu.Model;

import java.util.Random;

public class Dice {

    private Dice() {
    }

    static public int rollDice(int diceNumber){
        return new Random(System.currentTimeMillis()).nextInt(6*diceNumber)+1;
    }
}
