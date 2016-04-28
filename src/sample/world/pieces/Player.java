package sample.world.pieces;

/**
 * Created by Deep on 4/27/16.
 * this represents the model for the player
 */
public class Player extends GamePiece{

    private int arrow = 1;

    @Override
    public Type getType() {
        return Type.PLAYER;
    }

    public void shoot(){
        arrow = arrow - 1;
    }

    public void grab(){
        //TODO
    }

    public void release(){
        //TODO
    }

}
