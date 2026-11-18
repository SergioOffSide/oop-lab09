package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java graphical interface";
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame(TITLE);

    /**
     * Draw the graphical interface and its components.
     */
    public SimpleGUIWithFileChooser() {
        /*
         * Creating new panels and setting its layout
         */
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel upper = new JPanel();
        /*
         * Adding upper panel inside canvas panel
         */
        upper.setLayout(new BorderLayout());
        canvas.add(upper, BorderLayout.NORTH);
        /*
         * Creating new button and putting it after line ends
         */
        final JButton browse = new JButton("Browse...");
        upper.add(browse, BorderLayout.AFTER_LINE_ENDS);
        /*
         * Creating new text area, disabling the editing and putting it in the center of upper's panel
         */
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        final Controller controller = new Controller();
        textArea.setText(controller.getPath());
        upper.add(textArea, BorderLayout.CENTER);
        /*
         * Setting visibility in the frame
         */
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handler
         */
        browse.addActionListener(
            new ActionListener() {
                private final JFileChooser chooser = new JFileChooser(controller.getFile());
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    final int res = chooser.showSaveDialog(canvas);
                    if (res == JFileChooser.APPROVE_OPTION) {
                        controller.setDefaultFile(chooser.getSelectedFile().getPath());
                        textArea.setText(controller.getPath());
                    } else if (res == JFileChooser.ERROR_OPTION) {
                        JOptionPane.showMessageDialog(
                            canvas,
                            "Impossible select the file (error coode:"
                            + res
                            + ").",
                            "File selection error",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        );
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very
         * method is enough for a single screen setup. In case of multiple
         * monitors, the primary is selected. In order to deal coherently with
         * multimonitor setups, other facilities exist (see the Java
         * documentation about this issue). It is MUCH better than manually
         * specify the size of a window in pixel: it takes into account the
         * current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * Resize the frame to minimum size
         */
        frame.pack();
        /*
         * OK, ready to pull the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     */
    public static void main() {
        new SimpleGUIWithFileChooser().display();
    }
}
