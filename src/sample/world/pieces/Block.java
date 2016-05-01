package sample.world.pieces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deep on 4/27/16.
 * represents a block on the game map
 */
public class Block implements Player.PlayerAction {
    private final boolean IS_SAFE_BLOCK;

    static List<GamePiece> content = new ArrayList<>();

    public Block(boolean isSafeBlock){
        this.IS_SAFE_BLOCK = isSafeBlock;
    }

    /**
     * adds an item to the block returns false if the block has a pit, gold, or wumpus
     * @return  true if successfully added false if the piece cant be added because there is already a pit, gold, or wumpus
     * */
    public boolean addPiece(GamePiece piece){
        boolean status = true;
        if(isAdded(piece.getType())){
            status = false;
        }

        if(piece.getType() == GamePiece.Type.PIT ||
                piece.getType() == GamePiece.Type.GOLD ||
                    piece.getType() == GamePiece.Type.WUMPUS){
            status = hasGold() ||
                    hasPit() ||
                    hasWumpus();
        }

        if(status) {
            content.add(piece);
            if(piece.getType() == GamePiece.Type.PLAYER){
                ((Player) piece).action = this;
            }
        }

        return status;
    }

    /**
     * checks to see if the parameter is already added to the list of content on the block
     * @param type type to check
     * @return true if the type is already added to the block
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
        if(IS_SAFE_BLOCK){
            return false;
        }
        return isAdded(GamePiece.Type.PIT);
    }

    public boolean hasBreeze(){
        return isAdded(GamePiece.Type.BREEZE);
    }

    public boolean hasWumpus(){
        if(IS_SAFE_BLOCK){
            return false;
        }
        return isAdded(GamePiece.Type.WUMPUS);
    }

    public boolean hasStench(){
        return isAdded(GamePiece.Type.STENCH);
    }

    public boolean hasGold(){
        if(IS_SAFE_BLOCK){
            return false;
        }
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
