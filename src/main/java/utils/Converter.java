package utils;

public interface Converter<From, To> {
    To convert(From object);
}
