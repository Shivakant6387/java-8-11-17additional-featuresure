package org.example.dsa.leetcode75;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Step 1: Find the maximum number of candies
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        // Step 2: Create the result list
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            // Step 3: Check if the kid will have the greatest number of candies
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;
        System.out.println("case 1: "+kidsWithCandies(candies1, extraCandies1));
        // Output: [true, true, true, false, true]

        // Example 2
        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;
        System.out.println("case 2: "+kidsWithCandies(candies2, extraCandies2));
        // Output: [true, false, false, false, false]

        // Example 3
        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;
        System.out.println("case 3: "+kidsWithCandies(candies3, extraCandies3));
        // Output: [true, false, true]
    }
}
