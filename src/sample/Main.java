package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.world.GameMap;

import java.util.Scanner;

public class Main extends Application {

    private static Scanner inputScanner;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

    }


    public static void main(String[] args) {
        inputScanner = new Scanner(System.in);
        //launch(args);
        GameMap map = GameMap.init();

    }
}
