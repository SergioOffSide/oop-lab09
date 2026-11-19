package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String STD_PATH = System.getProperty("user.home")
        + File.separator
        + "output.txt";

    private File file;

    /**
     * Create or open an axisting file.
     * 
     * @param path the file's path
     */
    public Controller(final String path) {
        file = new File(path);
    }

    /**
     * Create or open the standard file located in user directory and called "output.txt".
     */
    public Controller() {
        this(STD_PATH);
    }

    /**
     * Set the new default file.
     * 
     * @param path the file's path.
     * @throws NullPointerException if path is null
     */
    public void setDefaultFile(final String path) {
        Objects.requireNonNull(path);
        file = new File(path);
    }

    /**
     * Return the file's name.
     * 
     * @return file's name
     */
    public String getFile() {
        return file.getName();
    }

    /**
     * Return the file's path.
     * 
     * @return the file's path
     */
    public String getPath() {
        return file.getPath();
    }

    /**
     * Writes on defualt file.
     * 
     * @param text the text that will be written in the file
     * @return true if the text is correctly written, false either
     * @throws NullPointerException if text is null
     */
    public boolean writeOnFile(final String text) {
        Objects.requireNonNull(text);
        try (
            PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)
        ) {
            ps.print(text);
        } catch (final IOException e) {
            return false;
        }
        return true;
    }
}
