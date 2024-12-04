package org.example.dsa.leetcode75;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            // Check if current plot is empty and adjacent plots (if any) are empty
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == length - 1 || flowerbed[i + 1] == 0)) {
                // Plant a flower
                flowerbed[i] = 1;
                n--;
                // If no more flowers to plant, return true
                if (n == 0) {
                    return true;
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        // Example 1
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println("Case 1: "+canPlaceFlowers(flowerbed1, n1)); // Output: true

        // Example 2
        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println("Case 2: "+canPlaceFlowers(flowerbed2, n2)); // Output: false
    }
}
