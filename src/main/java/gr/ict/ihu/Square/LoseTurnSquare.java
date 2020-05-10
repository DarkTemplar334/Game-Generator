package gr.ict.ihu.Square;


import gr.ict.ihu.Model.Player;

public class LoseTurnSquare implements Square {
    private int id;
    private boolean hasPower;
    private String message = " stepped on a trap and loses next turn!";


    public LoseTurnSquare(int id, boolean hasPower) {
        this.id = id;
        this.hasPower = hasPower;
    }

    @Override
    public Player execute(Player currentPlayer) {
        currentPlayer.setTurn(false);
        return currentPlayer;
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

    public String getMessage() {
        return message;
    }
}
