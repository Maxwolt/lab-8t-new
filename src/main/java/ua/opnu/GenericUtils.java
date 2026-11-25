package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public final class GenericUtils {

    private GenericUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T element : input) {
            if (p.test(element)) {
                result[counter] = element;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter, (Class<T[]>) input.getClass());
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}
