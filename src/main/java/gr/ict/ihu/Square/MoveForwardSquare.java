package gr.ict.ihu.Square;


import gr.ict.ihu.Model.Player;


public class MoveForwardSquare implements Square {

    private int id;
    private boolean hasPower;
    private int steps= 3;
    private String message= " stepped on powersquare(!) and moved "+steps+" squares!";



    public MoveForwardSquare(int id, boolean hasPower) {
        this.id = id;
        this.hasPower = hasPower;
        this.steps = steps;
    }

    @Override
    public Player execute(Player currentPlayer) {
        Player nextPlayer = currentPlayer;
        nextPlayer.setCurrentPosition(currentPlayer.getCurrentPosition()+steps);
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
