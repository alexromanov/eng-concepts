package alexromanov.engconcepts.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeMain {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode.com/problems/running-sum-of-1d-array
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    /**
     * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = candies[0];
        for (int i = 1; i < candies.length; i++){
            if (candies[i] > max){
                max = candies[i];
            }
        }
        for (int candy : candies) {
            if ((candy + extraCandies) >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    /**
     * https://leetcode.com/problems/shuffle-the-array/
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = n;
        int c = 0;
        while (i != n){
            result[c] = nums[i];
            c++;
            result[c] = nums[j];
            c++;
            i++;
            j++;
        }
        return result;
    }
}
