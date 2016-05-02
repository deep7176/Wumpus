package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    private static Scanner inputScanner;
    private Scene scene;

    public static void main(String[] args) {
        inputScanner = new Scanner(System.in);
        launch(args);
        //GameMap map = GameMap.init();
        new Grids("Wumpus World", 300, 300, 4, 4).setVisible(true);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //primaryStage.set
    }
}
