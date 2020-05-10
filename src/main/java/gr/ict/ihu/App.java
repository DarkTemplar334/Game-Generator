package gr.ict.ihu;



import gr.ict.ihu.GSON.GSonLoad;
import gr.ict.ihu.GSON.GSonSave;
import gr.ict.ihu.Game.AvailableOptions;
import gr.ict.ihu.Game.GameConfig;
import gr.ict.ihu.Game.Ludo;
import gr.ict.ihu.Game.Snake;
import gr.ict.ihu.Input.UserInput;
import gr.ict.ihu.Model.Board;
import gr.ict.ihu.Model.Dice;
import gr.ict.ihu.Model.Result;
import gr.ict.ihu.Model.Status;
import gr.ict.ihu.UI.Display;

import java.io.IOException;


public class App {
    static String chosenGame;
    static int numberOfPlayers;
    static Display display = new Display();
    static UserInput input = new UserInput();
    static String userChoice;
    static GameConfig state;
    static Board board;
    static String message = "";

    public static void main(String[] args) throws IOException {
        do {
            display.showAvailableGames();
            display.showCustomMessage("What to play:");
            chosenGame = input.getUserInputAsString().toUpperCase().trim();
        } while (!AvailableOptions.contains(chosenGame));

        display.showCustomMessage("Game Options:\n============================\n NEW GAME \n LOAD GAME\n============================\n");
        display.showCustomMessage("What to do: ");
        userChoice = input.getUserInputAsString().toUpperCase().trim();

        if(userChoice.equalsIgnoreCase("NEW GAME")){
            do {
                display.showCustomMessage("Give number of players: ");
                numberOfPlayers = input.getUserInputAsInteger();
            } while (numberOfPlayers == 0);
            if (chosenGame.equalsIgnoreCase("SNAKE")) {
                state = new Snake(numberOfPlayers);
            }
            if (chosenGame.equalsIgnoreCase("LUDO")) {
                state = new Ludo(numberOfPlayers);
            }

        }

        if(userChoice.equalsIgnoreCase("LOAD GAME")){
            GSonLoad loader = new GSonLoad();
            state = loader.loadGame(chosenGame);
            display.showCustomMessage(state.getMessageProgress());
            display.showCustomMessage("Active player is: "+state.getBoard().getNameOfActivePlayer()+"\n On Square: "+ state.getBoard().getActivePlayer().getCurrentPosition());
        }


        display.showCustomMessage("Game Playing: " + chosenGame);
        display.showCustomMessage(state.getMessageProgress());
        board = state.getBoard();



        do {
            state.setGameState(new Result(Status.CONTINUE,"Game Continues"),board);
            if(board.getActivePlayer().isAbleToPlay()){
                display.showGameChoices();
                display.showCustomMessage(board.getNameOfActivePlayer() + " what to do: ");
                userChoice = input.getUserInputAsString();
                if(userChoice.equalsIgnoreCase("save")){
                    GSonSave saver = new GSonSave();
                    message = saver.saveGame(state,chosenGame);
                    display.showCustomMessage(message);
                    display.showGameChoices();
                    display.showCustomMessage(board.getNameOfActivePlayer() + " what to do: ");
                    userChoice = input.getUserInputAsString();
                }
                if (userChoice.equalsIgnoreCase("roll")) {
                    board = state.moveCurrentPlayer(Dice.rollDice(state.getNumberOfDice()));
                }
                System.out.println(state.getMessageProgress());
                if(board.checkRoomForPower()){
                    message = board.ExecutePower();
                    display.showCustomMessage(message);
                }
            }
            else {
                board.getActivePlayer().setTurn(true);
            }
            board.changeToNextPlayer();
        } while (state.getGameStatus() != Status.FINISH);
    }
}
