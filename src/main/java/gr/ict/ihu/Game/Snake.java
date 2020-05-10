package gr.ict.ihu.Game;


import gr.ict.ihu.Model.Board;
import gr.ict.ihu.Model.Result;
import gr.ict.ihu.Model.Status;
import gr.ict.ihu.Square.Square;
import java.util.*;

public class Snake implements GameConfig {

    private Result result;
    private int numberOfSquares=100;
    private int numberOfDice=2;
    private Board board;


    public Snake(int numberOfPlayers) {
        List<Status> squareMap = generatePowerSquares();
        board = new Board(numberOfPlayers, squareMap);
    }


    public Board getBoard() {
        return board;
    }

    @Override
    public void setGameState(Result gameState, Board board) {
        this.board = board;
        result = gameState;

    }

    @Override
    public Status getGameStatus() {
        return result.getStatus();
    }

    @Override
    public String getMessageProgress() {
        return result.getProgressMessage();
    }

    @Override
    public Board moveCurrentPlayer(int steps) {
        if(board.getPositionOfActivePlayer() + steps < numberOfSquares + 1){
            board.moveCurrentPlayer(steps);
            result = new Result(Status.CONTINUE,board.getNameOfActivePlayer() + " moved "+steps+" steps.... You are now on square: "+ board.getPositionOfActivePlayer());
        }
        else{
            result = new Result(Status.FINISH,"Game Finished "+board.getNameOfActivePlayer()+" is the winner");
        }
        return board;
    }

    @Override
    public List<Status> generatePowerSquares() {
        List<Status> squareList = new ArrayList();
        List<Square> moveForwardSquare = new ArrayList(Arrays.asList(5,10,20,23,34,50,73,77));
        List<Square> moveBackWardSquare = new ArrayList(Arrays.asList(13,30,43,55,63,83,90,94,97));
        for(int i =0;i<numberOfSquares;i++){
            if(moveForwardSquare.contains(i)){
                squareList.add(Status.FORWARD);
                continue;
            }
            else if(moveBackWardSquare.contains(i)){
                squareList.add(Status.BACK);
                continue;
            }
            squareList.add(Status.NONE);
        }
        return squareList;
    }

    @Override
    public int getNumberOfDice() {
        return numberOfDice;
    }
}
