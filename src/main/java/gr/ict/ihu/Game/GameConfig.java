package gr.ict.ihu.Game;

import gr.ict.ihu.Model.Board;
import gr.ict.ihu.Model.Result;
import gr.ict.ihu.Model.Status;
import gr.ict.ihu.Square.Square;

import java.util.List;
import java.util.Map;

public interface GameConfig {

    Board getBoard();
    void setGameState(Result gameState, Board board);
    Status getGameStatus();
    String getMessageProgress();
    Board moveCurrentPlayer(int steps);
    List<Status> generatePowerSquares();
    int getNumberOfDice();
}
