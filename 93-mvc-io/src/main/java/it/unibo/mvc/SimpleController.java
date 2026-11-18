package it.unibo.mvc;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String nextString;

    /**
     * Creates a new {@link SimpleController}.
     */
    public SimpleController() {
        /*
         * Just for Java-doc
         */
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextString() {
        return nextString;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getStringsPrintedHistory() {
        return new ArrayList<>(history);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printCurrentString() {
        if (nextString == null) {
            throw new IllegalStateException("No string setted");
        }
        history.add(nextString);
        IO.println(nextString);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextString(final String text) {
        Objects.requireNonNull(text, "The text to set cannot be null");
        nextString = text;
    }
}
