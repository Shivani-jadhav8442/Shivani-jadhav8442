import java.io.*;
   
public class Stocks {
   
    // Function to find the maximum profit
    static int maximumProfit(int[] prices, int n)
    {
        int profit = 0, current_Day = n - 1;
    
        // Start from the last day
        while (current_Day > 0) 
        {
            int day = current_Day - 1;
    
            // Traverse and keep adding the
            // profit until a day with
            // price of stock higher
            // than currentDay is obtained
            while (day >= 0 &&  (prices[current_Day] > prices[day])) 
            {
                profit += (prices[current_Day] - 
                        prices[day]);
    
                day--;
            }
    
            // Set this day as currentDay
            // with maximum cost of stock
            // currently
            current_Day = day;
        }
        return profit;
    }

    public static void main(String[] args)
    {
        // Given array of prices
        int prices[] = { 2, 3, 2 };
    
        int N = prices.length;
        System.out.print(maximumProfit(prices, N));
    }
    }
    
   

