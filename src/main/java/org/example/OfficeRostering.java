package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OfficeRostering {
    public static int officeRostering(int n, int m, List<int[]> friendships, int k) {
        // Build the adjacency list for friendships
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair : friendships) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        // Initial conditions
        int[] currentStatus = new int[n];
        Arrays.fill(currentStatus, 1); // All employees work from office on Day 1
        int cumulativeRoster = n; // Rostering value on Day 1
        int days = 1; // Start from Day 1

        while (cumulativeRoster < k) {
            int[] nextStatus = new int[n];
            for (int i = 0; i < n; i++) {
                int wfoFriends = 0;
                for (int friend : graph.get(i)) {
                    wfoFriends += currentStatus[friend];
                }

                if (currentStatus[i] == 1) { // Worked from office today
                    if (wfoFriends == 3) {
                        nextStatus[i] = 1; // Continue working from office
                    }
                } else { // Worked from home today
                    if (wfoFriends < 3) {
                        nextStatus[i] = 1; // Switch to working from office
                    }
                }
            }

            // Update the cumulative rostering value and status
            cumulativeRoster += Arrays.stream(nextStatus).sum();
            currentStatus = nextStatus;
            days++;
        }

        return days;
    }

    public static void main(String[] args) {
        // Input reading
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> friendships = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            friendships.add(new int[]{u, v});
        }
        int k = scanner.nextInt();

        // Solve and print the result
        System.out.println(officeRostering(n, m, friendships, k));
    }

}
