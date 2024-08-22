import java.util.*;

class Work
     {

    // Function to calculate the total number of days required to complete all tasks
    // if we complete 'tasksPerDay' number of tasks per day
    public static int daysRequired(int tasksPerDay, int[] tasks) {
        int totalDays = 0;

        for (int task : tasks) {
            // Calculate days needed for the current task and add to total days
            totalDays += (int) Math.ceil((double) task / tasksPerDay);
        }

        return totalDays;
    }

    // Function to find the minimum number of tasks per day required to complete all tasks in 'd' days
    public static int minimumTask(int[] tasks, int d) {
        int left = 1;  // Minimum possible tasks per day
        int right = Arrays.stream(tasks).max().getAsInt();  // Maximum task size (starting upper bound)
        
        // Perform binary search to find the minimum valid 'tasksPerDay'
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if it's possible to complete all tasks in 'd' days with 'mid' tasks per day
            if (daysRequired(mid, tasks) <= d) {
                right = mid;  // Try for a smaller number of tasks per day
            } else {
                left = mid + 1;  // Increase the number of tasks per day
            }
        }

        return left;  // The minimum valid number of tasks per day
    }

    // Driver Code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of tasks
        System.out.println("Enter the number of tasks:");
        int n = sc.nextInt();

        // Input tasks array
        int[] tasks = new int[n];
        System.out.println("Enter the task values:");
        for (int i = 0; i < n; i++) {
            tasks[i] = sc.nextInt();
        }

        // Input the number of days
        System.out.println("Enter the number of days:");
        int D = sc.nextInt();

        // Calculate and print the minimum number of tasks per day required
        System.out.println("Minimum tasks per day required: " + minimumTask(tasks, D));
    }
}
