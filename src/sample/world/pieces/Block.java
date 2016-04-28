package sample.world.pieces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deep on 4/27/16.
 * represents a block on the game map
 */
public class Block {
    static List<GamePiece> content = new ArrayList<>();

    public void addPiece(GamePiece piece){
        content.add(piece);
    }
}
