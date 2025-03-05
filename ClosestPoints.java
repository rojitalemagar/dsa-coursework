//QN 2b - Closest Points


// Step 1: Initialize the minimum distance to maximum possible value.
// Step 2: Create an array to store the result indices initialized with [-1, -1].
// Step 3: Use nested loops to iterate through all pairs of points.
// Step 4: Calculate the Manhattan distance between each pair of points.
// Step 5: If the calculated distance is smaller than the current minimum distance, update the minimum distance and result pair.
// Step 6: If the distance is equal to the minimum distance, update the result pair if the current pair is lexicographically smaller.
// Step 7: Continue the iteration until all pairs are checked.
// Step 8: Return the result array containing the indices of the closest pair.


import java.util.Arrays;

public class ClosestPoints {
    public static int[] findClosestPair(int[] x_coords, int[] y_coords) {
        int n = x_coords.length;
        int minDistance = Integer.MAX_VALUE; // Initialize to maximum possible value
        int[] result = new int[]{-1, -1};    // Array to store the result indices

        // Iterate over all possible pairs of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate Manhattan distance
                int distance = Math.abs(x_coords[i] - x_coords[j]) + 
                               Math.abs(y_coords[i] - y_coords[j]);
                
                // Update if this distance is smaller
                if (distance < minDistance) {
                    minDistance = distance;
                    result[0] = i;
                    result[1] = j;
                } 
                // If distance is equal, choose lexicographically smaller pair
                else if (distance == minDistance) {
                    if (i < result[0] || (i == result[0] && j < result[1])) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }

        return result;
    }

    public static int[] closestPair(int[] x_coords, int[] y_coords) {
        int n = x_coords.length;
        int minDistance = Integer.MAX_VALUE;
        int[] bestPair = new int[2];
        bestPair[0] = -1;
        bestPair[1] = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int currentDistance = Math.abs(x_coords[i] - x_coords[j]) + Math.abs(y_coords[i] - y_coords[j]);
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    bestPair[0] = i;
                    bestPair[1] = j;
                } else if (currentDistance == minDistance) {
                    // Check if (i,j) is lexicographically smaller than the current best pair
                    if (i < bestPair[0] || (i == bestPair[0] && j < bestPair[1])) {
                        bestPair[0] = i;
                        bestPair[1] = j;
                    }
                }
            }
        }
        return bestPair;
    }

    public static void main(String[] args) {
        // Example usage
        int[] x_coords = {1, 2, 3, 2, 4};
        int[] y_coords = {2, 3, 1, 2, 3};
        // int[] result = findClosestPair(x_coords, y_coords);
        int[] result = closestPair(x_coords, y_coords);
        System.out.println("Closest pair indices: " + Arrays.toString(result));
    }
} 
// Output: Closest pair indices: [0, 3]