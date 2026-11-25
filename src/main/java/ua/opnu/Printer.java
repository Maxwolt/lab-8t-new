package ua.opnu;

public class Printer {

    public <T> void printArray(T[] array) {
        StringBuilder line = new StringBuilder();
        for (T element : array) {
            if (!line.isEmpty()) {
                line.append(' ');
            }
            line.append(element);
        }
        System.out.println(line);
    }
}
