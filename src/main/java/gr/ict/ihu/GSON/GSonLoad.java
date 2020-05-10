package gr.ict.ihu.GSON;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.ict.ihu.Game.GameConfig;

import gr.ict.ihu.Square.Square;


import java.io.*;


public class GSonLoad {

    public GameConfig loadGame(String game) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Square.class,new Adapter())
                .registerTypeAdapter(GameConfig.class,new Adapter())
                .setPrettyPrinting().create();
        Reader reader = new FileReader(game+".json");
        GameConfig state = gson.fromJson(reader, GameConfig.class);
        reader.close();
        return state;
    }
}
