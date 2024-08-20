class Trailing
{
    // Return true if number's factorial contains
    // at least n trailing zero else false.
    static boolean checkFun(int s, int n)
    {
        int temp = s, count = 0, f = 5;
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
            int mid = (low + high) / 2;  // Compute mid-point

            // Checking if mid's factorial 
            // contains n trailing zeroes.
            if (checkFun(mid, n))
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
    public static void main (String[] args)
    {
        int n = 2;
        System.out.println(findNum(n));
    }
}


