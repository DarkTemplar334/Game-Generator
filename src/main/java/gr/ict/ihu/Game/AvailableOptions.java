package gr.ict.ihu.Game;

public enum AvailableOptions {
    SNAKE,
    LUDO,
    LOAD,
    NEW,
    EXIT,
    ROLL,
    SAVE,
    PUT;

    public static boolean contains(String game){
        for(AvailableOptions aGame:values()){
            if (aGame.name().equalsIgnoreCase(game)){
                return true;
            }
        }
        return false;
    }
}
