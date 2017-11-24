package controllers.readers;

import controllers.UserInputController;
import lombok.Getter;
import utils.Displayable;

import java.io.InputStream;
import java.util.concurrent.Callable;


public abstract class ReadingController<T> extends UserInputController implements Callable<T> {
    @Getter
    T result;

    ReadingController(InputStream input, Displayable view, Displayable inputErrorView) {
        super(input, view, inputErrorView);
    }

    public T call() {
        resetResult();
        run();
        return result;
    }

    private void resetResult() {
        result = null;
    }
}
