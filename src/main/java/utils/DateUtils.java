package utils;

public class DateUtils {

    public static boolean isIsoDate(String value) {
        return value.matches("\\d{4}-\\d{2}-\\d{2}T.*");
    }
}