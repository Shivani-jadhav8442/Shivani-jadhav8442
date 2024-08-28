// JAVA code to implement the approach
import java.util.*;
class Work
{

// Function to check if
// all the task can be
// completed by 'per_day'
// number of task per day
public static boolean
	valid(int per_day, ArrayList<Integer> task, int d)
{

	// Variable to store days required
	// to done all tasks
	int cur_day = 0;
	for (int index = 0; index < task.size(); index++) {

	double day_req
		= (Math.ceil((double)task.get(index)
					/ (double)(per_day)));

	cur_day += day_req;

	// If more days required
	// than 'd' days so invalid

	if (cur_day > d) {
		return false;
	}
	}

	// Valid if days are less
	// than or equal to 'd'
	return cur_day <= d;
}

// Function to find minimum
// task done each day
public static int min_Task(ArrayList<Integer> task,
								int d)
{

	int left = 1;
	int right = Integer.MAX_VALUE;

	for (int index = 0; index < task.size(); index++) {
	right = Math.max(right, task.get(index));
	}

	// Variable to store answer
	int per_day_task = 0;

	while (left <= right) {

	int mid = left + (right - left) / 2;

	// If 'mid' number of task per day
	// is valid so store as answer and
	// more to first half
	if (valid(mid, task, d)) {
		per_day_task = mid;
		right = mid - 1;
	}
	else {
		left = mid + 1;
	}
	}

	// Print answer
	return per_day_task;
}
 public static void main(String[] args)
{
	ArrayList<Integer> task = new ArrayList<Integer>(
	Arrays.asList(3, 4, 7, 15));
	int D = 10;

	System.out.println(min_Task(task, D));
}
}

