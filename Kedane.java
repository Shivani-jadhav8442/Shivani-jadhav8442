class Kedane{

    // Function to find the maximum subarray sum
    static int findMaxSum(int[] arr) {
        int maxSum = arr[0];  // Start with the first element as the max sum
        int currentSum = arr[0];  // Current sum also starts from the first element

        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Either continue the subarray or start a new one with arr[i]
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update maxSum if currentSum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1};
        System.out.println(findMaxSum(arr));  // Output: 11
    }
}

// the time complexity is O(n)
// space complexity is O(1)