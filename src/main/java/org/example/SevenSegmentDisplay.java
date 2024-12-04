package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SevenSegmentDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the 7-segment representation of digits 0-9
        String[] digitDisplays = new String[3];
        for (int i = 0; i < 3; i++) {
            digitDisplays[i] = sc.nextLine();
        }

        // Parse the digit patterns for 0-9
        String[][] digitSegments = new String[10][3];
        for (int d = 0; d < 10; d++) {
            for (int i = 0; i < 3; i++) {
                digitSegments[d][i] = digitDisplays[i].substring(d * 3, d * 3 + 3);
            }
        }

        // Read the 7-segment representation of the input number
        String[] inputDisplays = new String[3];
        for (int i = 0; i < 3; i++) {
            inputDisplays[i] = sc.nextLine();
        }

        // Parse the input number segments
        int numDigits = inputDisplays[0].length() / 3;
        String[][] inputSegments = new String[numDigits][3];
        for (int d = 0; d < numDigits; d++) {
            for (int i = 0; i < 3; i++) {
                inputSegments[d][i] = inputDisplays[i].substring(d * 3, d * 3 + 3);
            }
        }

        // Validate each input segment and find all possible digits for each
        List<List<Integer>> possibleDigits = new ArrayList<>();
        for (String[] inputMatrix : inputSegments) {
            List<Integer> validDigits = findValidDigits(inputMatrix, digitSegments);
            if (validDigits.isEmpty()) {
                System.out.println("Invalid");
                return;
            }
            possibleDigits.add(validDigits);
        }

        // Generate all possible numbers and compute their sum
        long totalSum = generateAndSumNumbers(possibleDigits);
        System.out.println(totalSum);
    }

    // Check which digits the input matrix can represent
    private static List<Integer> findValidDigits(String[] inputMatrix, String[][] digitSegments) {
        List<Integer> validDigits = new ArrayList<>();

        for (int digit = 0; digit < 10; digit++) {
            String[] digitMatrix = digitSegments[digit];

            if (matchesExactly(inputMatrix, digitMatrix) || matchesWithToggle(inputMatrix, digitMatrix)) {
                validDigits.add(digit);
            }
        }

        return validDigits;
    }

    // Check for an exact match
    private static boolean matchesExactly(String[] inputMatrix, String[] digitMatrix) {
        for (int i = 0; i < 3; i++) {
            if (!inputMatrix[i].equals(digitMatrix[i])) {
                return false;
            }
        }
        return true;
    }

    // Check if toggling one LED makes the input matrix match the digit matrix
    private static boolean matchesWithToggle(String[] inputMatrix, String[] digitMatrix) {
        int toggleCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputMatrix[i].charAt(j) != digitMatrix[i].charAt(j)) {
                    toggleCount++;
                }
                if (toggleCount > 1) {
                    return false;
                }
            }
        }

        return toggleCount == 1;
    }

    // Generate all possible numbers and compute their sum
    private static long generateAndSumNumbers(List<List<Integer>> possibleDigits) {
        return generateAndSumNumbersHelper(possibleDigits, 0, 0, 1);
    }

    private static long generateAndSumNumbersHelper(List<List<Integer>> possibleDigits, int index, long currentNumber, long placeValue) {
        if (index == possibleDigits.size()) {
            return currentNumber;
        }

        long sum = 0;
        for (int digit : possibleDigits.get(index)) {
            sum += generateAndSumNumbersHelper(possibleDigits, index + 1, currentNumber * 10 + digit, placeValue);
        }
        return sum;
    }
}
