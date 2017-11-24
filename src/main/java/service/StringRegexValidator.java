package service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class StringRegexValidator implements Predicate<String> {
    private final Pattern pattern;

    public StringRegexValidator(String expectedTemplate) {
        pattern = Pattern.compile(expectedTemplate);

    }

    @Override
    public boolean test(String s) {
        return pattern.matcher(s).matches();
    }
}
