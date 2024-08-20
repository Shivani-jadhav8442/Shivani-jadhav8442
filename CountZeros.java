
    class CountZeros 
    {
        /* if 0 is present in arr[] then returns the index of FIRST occurrence
        of 0 in arr[low..high], otherwise returns -1 */
        int firstZero(int ar[], int left, int right) 
        {
            if (right >= left) 
            {
                // Check if mid element is first 0
                int mid = left+ (right- left) / 2;
                if ((mid == 0 || ar[mid - 1] == 1) && ar[mid] == 0)
                    return mid;
    
                if (ar[mid] == 1) // If mid element is not 0
                    return firstZero(ar, (mid + 1), right);
                else // If mid element is 0, but not first 0
                    return firstZero(ar, left, (mid - 1));
            }
            return -1;
        }
    
        // A wrapper over recursive function firstZero()
        int countZeroes(int ar[], int N) 
        {
            // Find index of first zero in given array
            int first = firstZero(ar, 0, N- 1);
    
            // If 0 is not present at all, return 0
            if (first == -1)
                return 0;
    
            return (N - first);
        }
    
        // Driver program to test above functions
        public static void main(String[] args) 
        {
            CountZeros count = new CountZeros();
            int ar[] = {1, 1, 1, 0, 0, 0, 0, 0};
            int n = ar.length;
            System.out.println("Count of zeroes is " + count.countZeroes(ar, n));
        }
    }
    
    
/*class CountZerosAndOnes {
    // Find the first occurrence of 0 using binary search
    int firstZero(int arr[], int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2; // Find the middle index

            // Check if mid is the first 0
            if ((mid == 0 || arr[mid - 1] == 1) && arr[mid] == 0)
                return mid;

            // If mid element is 1, search the right half
            if (arr[mid] == 1)
                return firstZero(arr, mid + 1, high);

            // If mid is 0 but not the first, search the left half
            return firstZero(arr, low, mid - 1);
        }
        return -1; // No 0 found
    }

    // Count the number of zeroes and ones
    void countZeroesAndOnes(int arr[], int n) {
        int first = firstZero(arr, 0, n - 1); // Find the first zero index
       // set it low and high
        // If no zero is found, all elements are ones
        if (first == -1) {
            System.out.println("Count of ones is " + n);
            System.out.println("Count of zeroes is 0");
            return;
        }

        // Calculate the number of zeroes and ones
        int countZeroes = n - first;
        int countOnes = first;

        // Print the counts
        System.out.println("Count of ones is " + countOnes);
        System.out.println("Count of zeroes is " + countZeroes);
    }

    // Driver program to test the above function
    public static void main(String[] args) {
        CountZerosAndOnes count = new CountZerosAndOnes();
        int arr[] = {1, 1, 1, 0, 0, 0, 0, 0}; // Sample array
        int n = arr.length; // Length of the array
        count.countZeroesAndOnes(arr, n); // Output results
    }
}
 */