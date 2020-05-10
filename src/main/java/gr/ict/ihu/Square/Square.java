package gr.ict.ihu.Square;

import gr.ict.ihu.Model.Player;

public interface Square {

    Player execute(Player currentPlayer);
    int getId();
    boolean hasPower();
    String getSquareMessage();
}
