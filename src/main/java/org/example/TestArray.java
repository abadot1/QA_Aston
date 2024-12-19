package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class TestArray {


    public TestArray() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("яблоко");
        words.add("клубника");
        words.add("груша");
        words.add("банан");
        words.add("яблоко");
        words.add("малина");
        words.add("ананас");
        words.add("банан");
        words.add("апельсин");
        words.add("ежевика");
        words.add("груша");
        words.add("яблоко");

        HashSet<String> uniqueWords = new HashSet<>(words);

        HashMap<String, Integer> countWord = new HashMap<>();
        for (String word : words){
            if (countWord.containsKey(word)){
                countWord.put(word, countWord.get(word) + 1);
            }
            else {
                countWord.put(word, 1);
            }
        }

        System.out.println("Начальный массив слов: " + words);
        System.out.println("Уникальный массив: " + uniqueWords);

        for (Map.Entry<String, Integer> printCountWord : countWord.entrySet()){
            System.out.println("Слово " + printCountWord.getKey() + " использовано " + printCountWord.getValue());
        }
    }
}
