package gr.ict.ihu.Square;


import gr.ict.ihu.Model.Player;


public class NormalSquare implements Square{
    private int id;
    private boolean hasPower;



    public NormalSquare(int id, boolean hasPower) {
        this.id = id;
        this.hasPower = hasPower;
    }

    @Override
    public Player execute(Player currentPlayer) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException("Not supported");
    }

}
