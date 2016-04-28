package sample.world;

import sample.world.pieces.Block;
import sample.world.pieces.Player;

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

    private GameMap() {
        grid = new Block[X_COUNT][Y_COUNT];
    }

    public static GameMap init(){
        randomNumberGen = new Random();

        GameMap map = new GameMap();
        map.loadPlayer();
        map.loadGold();
        map.loadPit();
        map.loadBreeze();
        map.loadWumpus();
        map.loadStench();

        return map;
    }

    private void loadPlayer() {
        this.player = new Player();
        grid[0][0].addPiece(player);
    }

    private void loadGold() {


    }

    private void loadPit() {

    }

    private void loadBreeze() {

    }

    private void loadWumpus() {

    }

    private void loadStench() {

    }

}
