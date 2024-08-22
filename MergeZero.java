public class MergeZero {
    public static void moveZeroes(int[] arr, int left, int right) {
        if (left >= right) {
            return; // Base case: if the array has one or no elements
        }

        // Find the middle point
        int mid = left + (right - left) / 2;

        // Recursively solve for the left half and right half
        moveZeroes(arr, left, mid);
        moveZeroes(arr, mid + 1, right);

        // Merge the two halves
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Temporary arrays to hold the merged result
        int[] temp = new int[right - left + 1];
        int index = 0;

        // Pointers for both halves
        int i = left;
        int j = mid + 1;

        // Traverse both halves and merge non-zero elements first
        while (i <= mid && j <= right) {
            if (arr[i] != 0) {
                temp[index++] = arr[i++];
            } else if (arr[j] != 0) {
                temp[index++] = arr[j++];
            } else {
                i++;
                j++;
            }
        }

        // Copy remaining non-zero elements from the left half
        while (i <= mid) {
            if (arr[i] != 0) {
                temp[index++] = arr[i];
            }
            i++;
        }

        // Copy remaining non-zero elements from the right half
        while (j <= right) {
            if (arr[j] != 0) {
                temp[index++] = arr[j];
            }
            j++;
        }

        // Fill the remaining spaces with zeroes
        while (index < temp.length) {
            temp[index++] = 0;
        }

        // Copy the merged result back to the original array
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        moveZeroes(arr, 0, arr.length - 1);
        
        // Print the modified array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
