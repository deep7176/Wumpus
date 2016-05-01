package sample.world.pieces;

/**
 * Created by Deep on 4/27/16.
 * This abstract class represents pieces on the game map
 */
public abstract class GamePiece {

    public enum Type{
        PLAYER,
        PIT,
        BREEZE,
        WUMPUS,
        STENCH,
        GLITTER,
        GOLD
    }

    public abstract Type getType();
}
