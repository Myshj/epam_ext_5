package controllers.readers;

import utils.Converter;
import utils.Displayable;

import java.io.InputStream;
import java.util.function.Predicate;


public class ValidatedReadingController<T> extends ReadingController<T> {

    private final Predicate<String> validator;

    private final Converter<String, T> converter;

    public ValidatedReadingController(
            InputStream input,
            Displayable view,
            Displayable inputErrorView,
            Predicate<String> validator,
            Converter<String, T> converter
    ) {
        super(input, view, inputErrorView);
        this.validator = validator;
        this.converter = converter;
    }

    @Override
    protected void onMessage(String message) {
        if (validator.test(message)) {
            result = converter.convert(message);
            stop();
            return;
        }

        displayErrorView();
        displayView();
    }
}
