package sample.world;

import sample.world.pieces.*;

import java.util.Random;

/**
 * Created by Deep on 4/27/16.
 * class containing the Wumpus world map with various constants
 */
public class GameMap {

    private static final int X_COUNT = 4;
    private static final int Y_COUNT = 4;

    private static Block[][] grid;
    private static Random randomNumberGen;

    private Player player;
    private Gold gold;

    private GameMap() {
        grid = new Block[X_COUNT][Y_COUNT];
    }

    public static GameMap init(){
        randomNumberGen = new Random();

        GameMap map = new GameMap();
        map.loadPlayer();
        map.loadGold();
        map.loadPit();
        map.loadWumpus();

        return map;
    }

    /**
     * adds the Player to the map
     * */
    private void loadPlayer() {
        this.player = new Player();
        grid[0][0].addPiece(player);
    }

    /**
     * adds Gold to the map and also loads the Glitters to the map
     * */
    private void loadGold() {
        this.gold = new Gold();
        int randX = randomNumberGen.nextInt(4 - 2) + 2;
        int randY = randomNumberGen.nextInt(4 - 2) + 2;
        grid[randX][randY].addPiece(gold);

        //loads glitters items perpendicular to Gold
        loadPerpendicular(randX, randY, new Glitter());

    }

    /**
     * adds Pits to the map and also loads the breezes to the map
     * */
    private void loadPit() {
        for (int p = 0; p < 3; p++) {
            Pit pit = new Pit();
            int randX = randomNumberGen.nextInt(4 - 2) + 2;
            int randY = randomNumberGen.nextInt(4 - 2) + 2;
            grid[randX][randY].addPiece(pit);
            //load breeze items perpendicular to Pit
            loadPerpendicular(randX, randY, new Breeze());
        }
    }

    /**
     * adds Wumpus to the map and also loads the stenches to the map
     * */
    private void loadWumpus() {
        Wumpus wumpus = new Wumpus();
        int randX = randomNumberGen.nextInt(4 - 2) + 2;
        int randY = randomNumberGen.nextInt(4 - 2) + 2;
        grid[randX][randY].addPiece(wumpus);
        //load stench items perpendicular to Wumpus
        loadPerpendicular(randX, randY, new Stench());
    }

    /**
     * adds the items that are supposed to be perpendicular to a Pit, Wumpus, and Gold
     * @param centerX  x location of the Pit, Wumpus, and Gold
     * @param centerY  y location of the Pit, Wumpus, and Gold
     * @param piece    piece to add to the map
     * */
    private void loadPerpendicular(int centerX, int centerY, GamePiece piece) {
        int x = centerX;
        int y = centerY + 1;
        if(!isOutOfBounds(x) || !isOutOfBounds(y)){
            grid[x][y].addPiece(piece);
        }

        x = centerX;
        y = centerY - 1;
        if(!isOutOfBounds(x) || !isOutOfBounds(y)){
            grid[x][y].addPiece(piece);
        }

        x = centerX + 1;
        y = centerY;
        if(!isOutOfBounds(x) || !isOutOfBounds(y)){
            grid[x][y].addPiece(piece);
        }

        x = centerX - 1;
        y = centerY;
        if(!isOutOfBounds(x) || !isOutOfBounds(y)){
            grid[x][y].addPiece(piece);
        }
    }

    /**
     * checks if the int is between 0 and 4
     * @param value   value to check
     * @return true if value is 0 to 4
     */
    private boolean isOutOfBounds(int value){
        return value >= 0 && value <= 4;
    }

    public void readMap(){

    }

}
