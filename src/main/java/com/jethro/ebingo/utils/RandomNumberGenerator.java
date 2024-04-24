package com.jethro.ebingo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    public static List<Integer> generateRandomNumbers(int min, int max) {
        java.util.List<Integer> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < 5) {
            int randomNumber = generateRandomNumber(min, max);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }

        return uniqueNumbers;
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
}
