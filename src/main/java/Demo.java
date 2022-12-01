import java.util.ArrayList;
import java.util.*;

public class Demo {
    public static void main(String[] args) {

        /*    max profit
        int[] arr = {7,1,5,3,6,4};
        [1,2,3,4,5,6,7]
        int result = maxProfit(arr);
        System.out.println(result);
        */
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(nums);


    }

    public static void rotate(int[] nums, int k) {
        if(nums.length <= 0) return;
        int[] temp = new int[nums.length];
        int val = 0;
        for(int i=k; i>0; i--) {
            temp[val++] = nums[nums.length-i];
        }

        for(int i = val, j=0 ; i< nums.length; i++) {
            temp[i] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, 0, nums.length);

//
//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]

        // if curr+k > len-1 --> curr = curr+k-len+1

    }
/*    max profit
        public static int maxProfit(int[] prices) {
            int buyDay = 0;
            int sellDay = 0;
            int profit = 0;

            for(int i=1; i< prices.length; i++) {
                if(prices[i]<prices[buyDay]) {
                    buyDay = i;
                }

                else if(prices[i]>prices[buyDay]) {
                    sellDay = i;
                    profit += prices[sellDay]-prices[buyDay];
                    buyDay = sellDay;
                }
            }
            return profit;
        }*/

}

/*


*/
 //Employee - fname, mname, lname, salary, designation


 //   select fname, mname, lname, salary, designation,
 //   rank() over(partition by salary order by salary desc) rank where rank = 5;



