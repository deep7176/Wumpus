package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    private static Scanner inputScanner;
    private Scene scene;
    private GridDisplay gridDisplay;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Represents the grid with Rectangles
        gridDisplay = new GridDisplay(400, 200);

        //Fields to specify number of rows/columns
        TextField rowField = new TextField();
        TextField columnField = new TextField();
        //Function to set an action when text field loses focus
        //buildTextFieldActions(rowField, columnField);
        HBox fields = new HBox();
        fields.getChildren().add(rowField);
        fields.getChildren().add(new Label("x"));
        fields.getChildren().add(columnField);

        BorderPane mainPanel = new BorderPane();
        mainPanel.setLeft(gridDisplay.getDisplay());
        mainPanel.setBottom(fields);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        inputScanner = new Scanner(System.in);
        launch(args);
    }

    //Class responsible for displaying the grid containing the Rectangles
    public class GridDisplay {

        private GridPane gridPane;
        private int nbRow;
        private int nbColumn;
        private int width;
        private int height;
        private double hGap;
        private double vGap;

        public GridDisplay(int width, int height) {
            this.gridPane = new GridPane();
            this.width = width;
            this.height = height;
            build();
        }

        private void build() {
            this.hGap = 0.1 * width;
            this.vGap = 0.1 * height;
            gridPane.setVgap(vGap);
            gridPane.setHgap(hGap);
            gridPane.setPrefSize(width, height);
            initializeDisplay(width, height);
        }

        //Builds the first display (correctly) : adds a Rectangle for the number
        //of rows and columns
        private void initializeDisplay(int width, int height) {
            nbRow = height / 100;
            nbColumn = width / 100;

            for (int i = 0; i < nbColumn; i++) {
                for (int j = 0; j < nbRow; j++) {
                    Rectangle rectangle = new Rectangle(100, 100);
                    rectangle.setStroke(Paint.valueOf("orange"));
                    rectangle.setFill(Paint.valueOf("steelblue"));
                    gridPane.add(rectangle, i, j);

                }
            }
        }

        //Function detailed in post
        //Called in updateDisplay()
        public void refreshConstraints() {
            gridPane.getRowConstraints().clear();
            gridPane.getColumnConstraints().clear();
            for (int i = 0; i < nbRow; i++) {
                RowConstraints rConstraint = new RowConstraints();
                rConstraint.setPercentHeight(100 / nbRow - ((nbRow - 1) * 10 / nbRow));
                gridPane.getRowConstraints().add(rConstraint);
            }

            for (int i = 0; i < nbColumn; i++) {
                ColumnConstraints cConstraint = new ColumnConstraints();
                cConstraint.setPercentWidth(100 / nbColumn - ((nbColumn - 1) * 10 / nbColumn));
                gridPane.getColumnConstraints().add(cConstraint);
            }

        }

        public void setColumns(int newColumns) {
            nbColumn = newColumns;
        }

        public void setRows(int newRows) {
            nbRow = newRows;
        }

        public GridPane getDisplay() {
            return gridPane;
        }

        //Function called when refreshing the display
        public void updateDisplay() {
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    //The gridpane is cleared of the previous children
                    gridPane.getChildren().clear();

                    //A new rectangle is added for row*column
                    for (int i = 0; i < nbColumn; i++) {
                        for (int j = 0; j < nbRow; j++) {
                            Rectangle rectangle = new Rectangle(100, 100);
                            rectangle.setStroke(Paint.valueOf("orange"));
                            rectangle.setFill(Paint.valueOf("steelblue"));
                            gridPane.add(rectangle, i, j);
                        }
                    }
                    //Call to this function to update the grid's constraints
                    refreshConstraints();
                }
            });

        }

    }
}
