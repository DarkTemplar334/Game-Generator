package gr.ict.ihu.Square;

import gr.ict.ihu.Model.Status;

public class SquareFactory {

    public Square getSquare(int id, Status power) {
        switch (power) {
            case FORWARD:
                return new MoveForwardSquare(id, true);
            case BACK:
                return new MoveBackSquare(id, true);
            case LOSETURN:
                return new LoseTurnSquare(id,true);
            default:
                return new NormalSquare(id, false);
        }
    }
}
