package sample.world.pieces;

/**
 * Created by Deep on 4/27/16.
 * This abstract class represents pieces on the game map
 */
abstract class GamePiece {

    enum Type{
        PLAYER,
        PIT,
        BREEZE,
        WUMPUS,
        STENCH,
        GOLD
    }

    public abstract Type getType();
}
