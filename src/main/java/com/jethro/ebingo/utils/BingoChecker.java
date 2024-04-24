package com.jethro.ebingo.utils;

import java.util.ArrayList;
import java.util.List;

public class BingoChecker {
    public static int checkForWin(List<List<Integer>> bingoCard) {
        // Check rows for patterns
        for (List<Integer> row : bingoCard) {
            if (checkForRowPatterns(row)) {
                return 1;
            }
        }

        // Check columns for patterns
        for (int col = 0; col < bingoCard.get(0).size(); col++) {
            List<Integer> column = new ArrayList<>();
            for (List<Integer> row : bingoCard) {
                column.add(row.get(col));
            }
            if (checkForRowPatterns(column)) {
                return 1;
            }
        }

        // Check diagonal patterns
        if (checkForDiagonalPattern(bingoCard)) {
            return 1;
        }

        return 0;
    }

    private static boolean checkForRowPatterns(List<Integer> row) {
        // Check for 1***1 pattern
        if (row.get(0) == -1 && row.get(1) == -1 && row.get(2) == -1 && row.get(3) == -1 && row.get(4) == -1) {
            return true;
        }
        // Check for 11111 pattern
        if (row.get(0) == -1 && row.get(1) == -1 && row.get(2) == -1 && row.get(3) == -1 && row.get(4) == -1) {
            return true;
        }
        // Check for 1**** pattern
        if (row.get(0) == -1 && row.get(1) == -1 && row.get(2) == -1 && row.get(3) == -1 && row.get(4) == -1) {
            return true;
        }
        // Check for **1** pattern
        if (row.get(0) == -1 && row.get(1) == -1 && row.get(2) == -1 && row.get(3) == -1 && row.get(4) == -1) {
            return true;
        }
        // Check for ***1* pattern
        if (row.get(0) == -1 && row.get(1) == -1 && row.get(2) == -1 && row.get(3) == -1 && row.get(4) == -1) {
            return true;
        }
        // Check for ****1 pattern
        if (row.get(0) == -1 && row.get(1) == -1 && row.get(2) == -1 && row.get(3) == -1 && row.get(4) == -1) {
            return true;
        }
        // Check for 11*** pattern
        if (row.get(0) == -1 && row.get(1) == -1 && row.get(2) == -1 && row.get(3) == -1 && row.get(4) == -1) {
            return true;
        }

        return false;
    }

    private static boolean checkForDiagonalPattern(List<List<Integer>> bingoCard) {
        // Implement diagonal pattern checks
        // For example, you can check for / or \ diagonals

        // Check for diagonal pattern /
        if (bingoCard.get(0).get(0) == -1 && bingoCard.get(1).get(1) == -1 && bingoCard.get(2).get(2) == -1 && bingoCard.get(3).get(3) == -1 && bingoCard.get(4).get(4) == -1) {
            return true;
        }
        // Check for diagonal pattern \
        if (bingoCard.get(0).get(4) == -1 && bingoCard.get(1).get(3) == -1 && bingoCard.get(2).get(2) == -1 && bingoCard.get(3).get(1) == -1 && bingoCard.get(4).get(0) == -1) {
            return true;
        }

        return false;
    }
}


// public class BingoChecker {
//     public static int checkForWin(List<List<Integer>> bingoCard) {
//         //1***1
//         //*****
//         //*****
//         //*****
//         //1***1

//         //11111
//         //*****
//         //*****
//         //*****
//         //*****

//         //1****
//         //1****
//         //1****
//         //1****
//         //1****

//         //**1**
//         //*1***
//         //1****
//         //*****
//         //*****

//         //***1*
//         //**1**
//         //*1***
//         //1****
//         //*****
        
//         //****1
//         //***1*
//         //**1**
//         //*1***
//         //1****

//         //11***
//         //11***
//         //*****
//         //*****
//         //*****

//         // Check rows for 4-ball square patterns
//         for (List<Integer> row : bingoCard) {
//             if (checkForRowSquares(row)) {
//                 return 1;
//             }
//         }

//         // Check columns for 4-ball square patterns
//         for (int col = 0; col < bingoCard.get(0).size(); col++) {
//             List<Integer> column = new ArrayList<>();
//             for (List<Integer> row : bingoCard) {
//                 column.add(row.get(col));
//             }
//             if (checkForRowSquares(column)) {
//                 return 1;
//             }
//         }

//         return 0;
//     }

//     private static boolean checkForRowSquares(List<Integer> row) {
//         for (int i = 0; i <= row.size() - 4; i++) {
//             if (row.get(i) == -1 && row.get(i + 1) == -1 && row.get(i + 2) == -1 && row.get(i + 3) == -1) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
