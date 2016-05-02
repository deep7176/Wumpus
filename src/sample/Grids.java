package sample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This is the demo class.
 */
public class Grids extends Frame {
    /*
     * Construct a GfxDemo2 given its title, width and height. Uses a
     * GridBagLayout to make the Canvas resize properly.
     */
    public Grids(String title, int w, int h, int rows, int cols) {
        setTitle(title);

        // Now create a Canvas and add it to the Frame.
        GridsCanvas xyz = new GridsCanvas(w, h, rows, cols);
        add(xyz);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        // Normal end ... pack it up!
        pack();
    }
}
