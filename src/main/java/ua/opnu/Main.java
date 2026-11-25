package ua.opnu;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("== Завдання 1 ==");

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        System.out.println();
        System.out.println("== Завдання 2 ==");

        BookData[] books = {
            new BookData("Кобзар", "Тарас Шевченко", 10, 40.0),
            new BookData("Лісова пісня", "Леся Українка", 4, 19.0),
            new BookData("Захар Беркут", "Іван Франко", 5, 20.0),
            new BookData("Тіні забутих предків", "Михайло Коцюбинський", 2, 10.0)
        };
        Arrays.sort(books);
        for (BookData book : books) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("== Завдання 3 ==");

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        System.out.println();
        System.out.println("== Завдання 4 ==");

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] even = GenericUtils.filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні числа: " + Arrays.toString(even));

        String[] words = {"Київ", "річка", "Одеса", "місто", "Львів"};
        String[] capitalized = GenericUtils.filter(words, s -> Character.isUpperCase(s.charAt(0)));
        System.out.println("Слова з великої літери: " + Arrays.toString(capitalized));

        System.out.println();
        System.out.println("== Завдання 5 ==");

        String[] fruits = {"яблуко", "банан", "вишня"};
        System.out.println("contains(fruits, \"банан\"): " + GenericUtils.contains(fruits, "банан"));
        System.out.println("contains(fruits, \"манго\"): " + GenericUtils.contains(fruits, "манго"));
        System.out.println("contains(numbers, 4): " + GenericUtils.contains(numbers, 4));
        System.out.println("contains(numbers, 25): " + GenericUtils.contains(numbers, 25));

        System.out.println();
        System.out.println("== Завдання 6 ==");

        GenericTwoTuple<String, Integer> student = new GenericTwoTuple<>("Іванов Петро Петрович", 87);
        System.out.println("Студент: " + student.first + ", рейтинг: " + student.second);
        System.out.println(student);

        GenericThreeTuple<String, Double, Boolean> product =
                new GenericThreeTuple<>("Ноутбук", 25999.99, true);
        System.out.println("Товар: " + product.getFirst()
                + ", ціна: " + product.getSecond()
                + ", в наявності: " + product.three);
        System.out.println(product);

        GenericThreeTuple<String, Integer, List<String>> group = new GenericThreeTuple<>(
                "АІ-231", 3, List.of("Іванов", "Петренко", "Сидоренко"));
        System.out.println("Група: " + group.getFirst()
                + ", кількість: " + group.getSecond()
                + ", студенти: " + group.getThree());
    }
}
