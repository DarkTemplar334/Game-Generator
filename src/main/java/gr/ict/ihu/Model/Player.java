package gr.ict.ihu.Model;


public class Player {


    private int id;
    private int currentPosition;
    private String name;
    private boolean turn = true;

    public Player(int currentPosition, String name,int id) {
        this.currentPosition = currentPosition;
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getId() {
        return id;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isAbleToPlay() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
