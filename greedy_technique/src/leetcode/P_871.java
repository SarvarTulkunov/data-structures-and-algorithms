package leetcode;

import java.util.PriorityQueue;

/**
 * 871. Minimum Number of Refueling Stops
 */
public class P_871 {

    /**
     * Solution - 1
     */
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (startFuel >= target) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int numberOfStops = 0, currentDistance = 0;

        for (int[] station : stations) {
            int stationDistance = station[0];
            int stationFuel = station[1];

            // Check if we need to refuel to reach this station
            while (startFuel < stationDistance - currentDistance) {
                if (maxHeap.isEmpty()) {
                    return -1; // Can't reach the station or target
                }
                startFuel += maxHeap.poll();
                numberOfStops++;
            }

            // Move to the current station
            startFuel -= (stationDistance - currentDistance);
            currentDistance = stationDistance;

            // Add this station's fuel to the heap
            maxHeap.add(stationFuel);
        }

        // Handle the distance from the last station to the target
        while (startFuel < target - currentDistance) {
            if (maxHeap.isEmpty()) {
                return -1; // Can't reach the target
            }
            startFuel += maxHeap.poll();
            numberOfStops++;
        }

        return numberOfStops;
    }

    /**
     * Optimal Solution
     */
     /*
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;

        while (maxDistance < target) {
            if (i < n && stations[i][0] <= maxDistance) {
                maxHeap.add(stations[i][1]);
                i++;
            } else if (maxHeap.isEmpty()) {
                return -1;
            } else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }

        return stops;
    }
    */

}
