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
    public boolean addPiece(GamePiece piece){
        if(isAdded(piece.getType())){
            return false;
        }
        content.add(piece);
        if(piece.getType() == GamePiece.Type.PLAYER){
            ((Player) piece).action = this;
        }
        return true;
    }

    /**
     * checks to see if the parameter is already added to the list of content on the block
     * */
    private boolean isAdded(GamePiece.Type type) {
        boolean check = false;

        for (GamePiece gamePiece : content) {
            if(gamePiece.getType() == type){
                check = true;
                break;
            }
        }

        return check;
    }

    public boolean hasPit(){
        return isAdded(GamePiece.Type.PIT);
    }

    public boolean hasBreeze(){
        return isAdded(GamePiece.Type.BREEZE);
    }

    public boolean hasWumpus(){
        return isAdded(GamePiece.Type.WUMPUS);
    }

    public boolean hasStench(){
        return isAdded(GamePiece.Type.STENCH);
    }

    public boolean hasGold(){
        return isAdded(GamePiece.Type.GOLD);
    }

    public boolean hasGlitter(){
        return isAdded(GamePiece.Type.GLITTER);
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
        if(hasGold()){
            System.out.println("You win!");
        }
    }
}
