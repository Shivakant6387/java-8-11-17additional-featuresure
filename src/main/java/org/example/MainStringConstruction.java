package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainStringConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of substrings
        int N = sc.nextInt();
        sc.nextLine(); // Consume newline after number input

        // Store substrings and their costs
        List<String> substrings = new ArrayList<>();
        List<Integer> costs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            substrings.add(sc.next());
            costs.add(sc.nextInt());
            sc.nextLine(); // Consume newline after cost
        }

        // Read the main string
        String mainString = sc.nextLine().trim();
        int M = mainString.length();

        // DP array to store minimum cost to form each prefix of the main string
        int[] dp = new int[M + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: no cost to form the empty string

        // Iterate over each position in the main string
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                String sub = substrings.get(j);
                int cost = costs.get(j);
                int subLength = sub.length();

                // Check if substring `sub` can end at position `i` in mainString
                if (i >= subLength && mainString.substring(i - subLength, i).equals(sub)) {
                    int prev = i - subLength;
                    // If we can form the string up to `prev` and use this substring
                    if (dp[prev] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[prev] + cost);
                    }
                }
            }
        }

        // The result is in dp[M], which is the minimum cost to form the entire main string
        if (dp[M] == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(dp[M]);
        }

        sc.close();
    }
}
