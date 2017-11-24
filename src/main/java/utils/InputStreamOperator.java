package utils;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Base class for all objects that use Input streams as data/command source.
 */
public abstract class InputStreamOperator implements Runnable {


    private final Scanner reader;

    /**
     * Current state of operator.
     */
    private boolean working;

    /**
     * Parametrized constructor.
     *
     * @param input Stream to read data/commands from.
     */
    public InputStreamOperator(InputStream input) {
        reader = new Scanner(input).useDelimiter("\n");
    }

    /**
     * Runs this operator.
     */
    public final void run() {
        working = true;
        onStarted();
        while (working) {
            onMessage(reader.next());
        }
    }

    /**
     * Called every times operator started.
     */
    protected abstract void onStarted();

    /**
     * Called when operator receives message.
     *
     * @param message Received message.
     */
    protected abstract void onMessage(String message);

    /**
     * Stops operator.
     */
    public void stop() {
        working = false;
    }
}
