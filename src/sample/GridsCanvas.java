package sample;

import java.awt.*;

/**
 * Created by Deep on 5/1/16.
 */
public class GridsCanvas extends Canvas {
    int width, height;

    int rows;
    int cols;

    public GridsCanvas(int w, int h, int r, int c) {
        setSize(width = w, height = h);
        rows = r;
        cols = c;
    }

    public void paint(Graphics g) {
        int i;
        width = getSize().width;
        height = getSize().height;

        // draw the rows
        int rowHt = height / (rows);
        for (i = 0; i < rows; i++)
            g.drawLine(0, i * rowHt, width, i * rowHt);

        // draw the columns
        int rowWid = width / (cols);
        for (i = 0; i < cols; i++)
            g.drawLine(i * rowWid, 0, i * rowWid, height);
    }
}
