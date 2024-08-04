class Trailing
{
    // Return true if number's factorial contains
    // at least n trailing zero else false.
    static boolean check(int p, int n)
    {
        int temp = p, count = 0, f = 5;
        while (f <= temp)
        {
            count += temp / f;
            f = f * 5;
        }
        return (count >= n);
    } 

    // Return smallest number whose factorial
    // contains at least n trailing zeroes
    static int findNum(int n)
    {
        // If n equal to 1, return 5.
        // since 5! = 120.
        if (n == 1)
            return 5;

        // Initialising low and high for binary
        // search.
        int low=0;
        int high = 5 * n;

        // Binary Search.
        while (low < high)
        {
            int mid = (low + high) >> 1;  // Compute mid-point

            // Checking if mid's factorial 
            // contains n trailing zeroes.
            if (check(mid, n))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    // Driver code 
    public static void main (String[] args)
    {
        int n = 6;
        System.out.println(findNum(n));
    }
}

// This code is contributed by Anant Agarwal.
/*Execution for n = 6
Let's go through the code execution step-by-step to see why the output is 25 for n = 6.

Initial Setup
n = 6
low = 0, high = 30 (since 5 * 6 = 30)
Iteration Details
First Iteration:

Calculate mid: (0 + 30) / 2 = 15
Check 15!:
15 / 5 = 3 (3 factors of 5)
15 / 25 = 0 (0 additional factors of 25)
Total trailing zeros = 3
Result: 3 < 6, so set low = 16
Second Iteration:

Calculate mid: (16 + 30) / 2 = 23
Check 23!:
23 / 5 = 4 (4 factors of 5)
23 / 25 = 0 (0 additional factors of 25)
Total trailing zeros = 4
Result: 4 < 6, so set low = 24
Third Iteration:

Calculate mid: (24 + 30) / 2 = 27
Check 27!:
27 / 5 = 5 (5 factors of 5)
27 / 25 = 1 (1 additional factor of 25)
Total trailing zeros = 6
Result: 6 >= 6, so set high = 27
Fourth Iteration:

Calculate mid: (24 + 27) / 2 = 25
Check 25!:
25 / 5 = 5 (5 factors of 5)
25 / 25 = 1 (1 additional factor of 25)
Total trailing zeros = 6
Result: 6 >= 6, so set high = 25
Fifth Iteration:

Calculate mid: (24 + 25) / 2 = 24
Check 24!:
24 / 5 = 4 (4 factors of 5)
24 / 25 = 0 (0 additional factors of 25)
Total trailing zeros = 4
Result: 4 < 6, so set low = 25
Conclusion
The binary search loop exits when low equals high, which is 25 in this case. This is the smallest number whose factorial has at least 6 trailing zeros.

Thus, the output of the code for n = 6 is 25.

Summary
Binary Search Efficiency: The binary search efficiently narrows down the number by checking the condition for trailing zeros, adjusting the search range based on whether the midpoint meets the criteria.
Correctness: The check function accurately counts trailing zeros by counting factors of 5 and its powers in the factorial decomposition.





 */