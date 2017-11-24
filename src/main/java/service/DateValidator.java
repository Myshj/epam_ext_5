package service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.function.Predicate;

public class DateValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        try {
            LocalDate.parse(s);
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }
}
