package gr.ict.ihu.GSON;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gr.ict.ihu.Game.GameConfig;
import gr.ict.ihu.Model.Board;
import gr.ict.ihu.Square.Square;

import java.io.FileWriter;
import java.io.IOException;


public class GSonSave {

    public String saveGame(GameConfig config, String gameName) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Square.class,new Adapter())
                .registerTypeAdapter(GameConfig.class,new Adapter())
                .setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter(gameName+".json",false);
        gson.toJson(config,GameConfig.class,fileWriter);
        fileWriter.close();
        return "Game saved....";
    }
}
