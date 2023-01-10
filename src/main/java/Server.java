import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    int[] tempArray;
    private int oddCount;
    private int max;
    int mean;



    public Server() {
        tempArray = new int[50];
        oddCount = 0;
        max = Integer.MIN_VALUE;
        mean = 0;
    }

    public void addToArray(int value) {
        tempArray[oddCount] = value;
        if (value % 2 == 1) {
            oddCount++;
        }
        if (value > max) {
            max = value;
        }
        if (oddCount > 0) {
            mean = ((mean * oddCount) + value) / (oddCount + 1);
        } else {
            mean = value;
        }
    }

    public int countOdds() {
        return oddCount;
    }

    public int maximum() {
        int max = Integer.MIN_VALUE;
        for (int value : tempArray) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public int mean() {
        return mean;
    }

    public int mode() {
        // Return -1 if the array is empty or has fewer than 2 elements
        if (tempArray.length < 2) {
            return -1;
        }

        // Create a map to store the frequency of each number in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Iterate through the array and increment the count for each number in the map
        for (int num : tempArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the number(s) with the highest frequency in the map
        int maxFrequency = 0;
        List<Integer> mode = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mode.clear();
                mode.add(entry.getKey());
            } else if (entry.getValue() == maxFrequency) {
                mode.add(entry.getKey());
            }
        }

        // Return the mode(s)
        if (mode.size() == 1) {
            return mode.get(0);
        } else {
            return -1;
        }
    }

    public int[] quartile() {
        // Return an array with -1 for both quartiles if the array is empty or has fewer than 4 elements
        if (tempArray.length < 4) {
            return new int[]{-1, -1};
        }

        // Sort the array in ascending order
        Arrays.sort(tempArray);

        // Calculate the length of the array
        int length = tempArray.length;

        // Calculate the indices of Q1 and Q3
        int q1Index = length / 4;
        int q3Index = 3 * length / 4;

        // Return the values of Q1 and Q3
        return new int[]{tempArray[q1Index], tempArray[q3Index]};
    }

    public String toString() {
        int[] quartiles = quartile();
        System.out.println("Number of odd numbers: " + oddCount + "\nMaximum: " + max + "\nMean: " + mean + "\nMode: " + mode() + "\nQ1: " + quartiles[0] + "\nQ3: " + quartiles[1]);
        return "";
    }
}