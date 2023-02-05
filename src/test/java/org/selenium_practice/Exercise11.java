package org.selenium_practice;


import java.util.*;
import java.util.stream.Collectors;

public class Exercise11 {
    public static void main(String[] args) {

        // 1. Given a list of integers, use a Stream to find the sum of the even numbers in the list.
        List<Integer> numbers = Arrays.asList(5, 5, 2, 8, 10, 1);
        int sum = numbers.stream().filter(a -> (new Integer(a%2)).equals(0)).reduce(1, (a, b)->a+b);

        //System.out.println("sum = " + sum);


        // 2. Given a list of strings, use a Stream to create a new list that consists of the strings that start with the letter 'a'.
        List<String> words = Arrays.asList("Edwin", "Mildred", "action", "east", "1:1 Meeting", "ant");
        List<String> wordsWithA = words.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());

        //System.out.println("words = " + words);
        //System.out.println("wordsWithA = " + wordsWithA);


        // 3. Given a list of people, use a Stream to create a map that maps each person's name to their age.
        List<Person> people = Arrays.asList(new Person("Edwin", 27), new Person("Mildred", 25), new Person("José", 18));
        Map<String, Integer> personMap = people.stream().collect(Collectors.toMap(Person::getName, Person::getAge));

        //System.out.println("personMap = " + personMap);
        //System.out.println("personMap = " + personMap.keySet());



        // Given a list of numbers, use a Stream to find the product of the numbers that are greater than 5.
        List<Integer> numbers2 = Arrays.asList(3, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int product = numbers2.stream()
                .filter(s -> s > 5)
                .reduce(1, (a,b) -> a*b);
        //System.out.println("product = " + product);

        // Given a list of strings, use a Stream to create a new list that consists of the strings that are palindromes
        // (strings that are the same forwards and backwards).
        String anita = "Anita lava la tina";

        List<String> words2 = Arrays.asList("Ana", "Mildred", "action", "Ohio", "rotator", "noon", anita, "Anitalavalatina");
        List<String> palindromes = words2.stream().filter(s -> {
            String promptString = s.replace(" ", "");
            StringBuilder stringBuilder = new StringBuilder(promptString);
            String reverseString = stringBuilder.reverse().toString().trim();
            return promptString.equalsIgnoreCase(reverseString);
        }).collect(Collectors.toList());
        System.out.println("palindromes = " + palindromes);


        // Convert a word backwards. Example: Edwin -> niwdE
        String name = "Edwin";
        StringBuilder stringBuilder  = new StringBuilder(name);
        System.out.println("stringBuilder.reverse() = " + stringBuilder.reverse());


        // Given a list of people, use a Stream to find the oldest person in the list.
        List<Person> people2 = Arrays.asList(new Person("Edwin", 22), new Person("Mildred", 22), new Person("José", 22));
        Person oldest = people2.stream().max(Comparator.comparingInt(Person::getAge)).orElse(null);
        System.out.println("oldest.getName() = " + oldest.getName());

    }




}

class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}