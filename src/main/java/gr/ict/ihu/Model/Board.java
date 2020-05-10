package gr.ict.ihu.Model;

import gr.ict.ihu.Square.*;
import java.util.*;

public class Board {


    private Player activePlayer;
    private List<Player> playerList = new ArrayList<>();
    private List<Square> squareList = new ArrayList<>();


    public Board(int numberOfPlayers,List<Status> powerSquareList) {
        SquareFactory sf = new SquareFactory();
        for (int i = 0; i < powerSquareList.size(); i++) {
            squareList.add(sf.getSquare(i,powerSquareList.get(i)));
            }
        for (int i = 0; i < numberOfPlayers; i++) {
            playerList.add(new Player(squareList.get(0).getId(), "Player" + (i + 1), i));
        }
        activePlayer = playerList.get(0);
    }


    public void changeToNextPlayer() {
            if(activePlayer.getId()+1< playerList.size()){
                activePlayer = playerList.get(activePlayer.getId()+1);
            }
            else{
                activePlayer = playerList.get(0);
            }
    }

    public void moveCurrentPlayer(int steps){
        activePlayer.setCurrentPosition(activePlayer.getCurrentPosition() + steps);
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

    public String getNameOfActivePlayer(){
        return activePlayer.getName();
    }

    public int getPositionOfActivePlayer(){
        return activePlayer.getCurrentPosition();
    }

    public boolean checkRoomForPower(){
        return squareList.get(activePlayer.getCurrentPosition()).hasPower();
    }

    public String ExecutePower(){
        Square square;
        square = squareList.get(activePlayer.getCurrentPosition());
        activePlayer = square.execute(activePlayer);
        return activePlayer.getName() + square.getSquareMessage();
    }

}
