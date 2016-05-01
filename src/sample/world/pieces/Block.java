package sample.world.pieces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deep on 4/27/16.
 * represents a block on the game map
 */
public class Block implements Player.PlayerAction {
    static List<GamePiece> content = new ArrayList<>();

    /**
     * adds an item to the block
     * */
    public void addPiece(GamePiece piece){
        if(isAdded(piece)){
            return;
        }
        content.add(piece);
        if(piece.getType() == GamePiece.Type.PLAYER){
            ((Player) piece).action = this;
        }
    }

    /**
     * checks to see if the parameter is already added to the list of content on the block
     * */
    private boolean isAdded(GamePiece piece) {
        boolean check = false;

        for (GamePiece gamePiece : content) {
            if(piece.getType() == gamePiece.getType()){
                check = true;
                break;
            }
        }

        return check;
    }

    /**
     * returns a list of the game pieces
     * */
    public static List<GamePiece> getPieces() {
        return content;
    }

    @Override
    public void onPercept() {

    }

    @Override
    public void onGrab() {
        for (GamePiece gamePiece : content) {
            if(gamePiece instanceof Gold){
                Gold gold = ((Gold) gamePiece);


            }
        }
    }

    @Override
    public void onRelease() {

    }
}
