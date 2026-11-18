package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    /**
     * Sets the next {@link String} to print.
     * 
     * @param text the next {@link String} to print.
     * @throws NullPointerException if {@code text} is {@code null}.
     */
    void setNextString(String text);

    /**
     * Gets the next {@link String} to print.
     * 
     * @return the next {@link String} to print.
     */
    String getNextString();

    /**
     * Gets a {@link List} of printed strings.
     * 
     * @return the {@link List} of printed strings.
     */
    List<String> getStringsPrintedHistory();

    /**
     * Prints the current {@link String}.
     * 
     * @throws IllegalStateException if the current {@link String} is not set.
     */
    void printCurrentString();
}
