package org.example;

import java.util.*;

class FenceVoltage {
    static class Wire {
        int x1, y1, x2, y2;

        Wire(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine()); // number of wires
        List<Wire> wires = new ArrayList<>();

        // Reading wire coordinates
        for (int i = 0; i < N; i++) {
            String[] wireData = scanner.nextLine().split(" ");
            wires.add(new Wire(
                    Integer.parseInt(wireData[0]), Integer.parseInt(wireData[1]),
                    Integer.parseInt(wireData[2]), Integer.parseInt(wireData[3])
            ));
        }

        // Reading animals and their voltage resistance thresholds
        Map<String, Integer> animalResistances = new HashMap<>();
        String[] animalData = scanner.nextLine().split(" ");
        for (String data : animalData) {
            String[] animal = data.split(":");
            animalResistances.put(animal[0], Integer.parseInt(animal[1]));
        }

        // Animal that touched the fence
        String animalTouched = scanner.nextLine();

        // Compute all intersections and voltages
        Map<String, Integer> intersectionVoltages = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Wire wire1 = wires.get(i);
                Wire wire2 = wires.get(j);

                // Find intersection between wire1 and wire2
                int[] intersection = findIntersection(wire1, wire2);

                if (intersection != null) {
                    int voltage = calculateVoltageAtIntersection(wire1, wire2, intersection);
                    String point = intersection[0] + "," + intersection[1];
                    intersectionVoltages.put(point, intersectionVoltages.getOrDefault(point, 0) + voltage);
                }
            }
        }

        // Determine if the animal died
        int voltageAtTouchedPoint = intersectionVoltages.getOrDefault("2,2", 0);
        boolean animalDied = voltageAtTouchedPoint >= animalResistances.get(animalTouched);

        // Output the result
        System.out.println(animalDied ? "Yes" : "No");

        // Calculate the probability of animal dying
        long diedCount = animalResistances.entrySet().stream()
                .filter(entry -> intersectionVoltages.getOrDefault("2,2", 0) >= entry.getValue())
                .count();
        double probability = (double) diedCount / animalResistances.size();
        System.out.printf("%.2f\n", probability);
    }

    private static int[] findIntersection(Wire wire1, Wire wire2) {
        // Logic for checking if wire1 and wire2 intersect
        // Return the intersection point (x, y) or null if they don't intersect
        return null; // Implement this logic
    }

    private static int calculateVoltageAtIntersection(Wire wire1, Wire wire2, int[] intersection) {
        // Calculate the voltage at the intersection based on the touching cells logic
        return 0; // Implement this logic
    }
}
