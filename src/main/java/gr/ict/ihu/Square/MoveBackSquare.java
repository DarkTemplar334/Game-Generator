package gr.ict.ihu.Square;


import gr.ict.ihu.Model.Player;


public class MoveBackSquare implements Square {

    private int id;
    private boolean hasPower;
    private int steps= -3;
    private String message = " stepped on a trap and now moves " + -1*steps+" squares back!";


    public MoveBackSquare(int id, boolean hasPower) {
        this.id = id;
        this.hasPower = hasPower;
        this.steps = steps;
    }


    @Override
    public Player execute(Player currentPlayer) {
        Player nextPlayer = currentPlayer;
        nextPlayer.setCurrentPosition(currentPlayer.getCurrentPosition()-3);
        return nextPlayer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean hasPower() {
        return hasPower;
    }

    @Override
    public String getSquareMessage() {
        return message;
    }
}
