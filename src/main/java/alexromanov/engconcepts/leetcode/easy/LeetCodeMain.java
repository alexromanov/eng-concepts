package alexromanov.engconcepts.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCodeMain {

    public static void main(String[] args) {
    }

    /**
     * 1480
     * https://leetcode.com/problems/running-sum-of-1d-array
     */
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }

    /**
     * 1431
     * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
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
     * 1470
     * https://leetcode.com/problems/shuffle-the-array/
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = n;
        int c = 0;
        while (i != n) {
            result[c] = nums[i];
            c++;
            result[c] = nums[j];
            c++;
            i++;
            j++;
        }
        return result;
    }

    /**
     * 1108
     * https://leetcode.com/problems/defanging-an-ip-address/
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    /**
     * 1342
     * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
     */
    public int numberOfSteps(int num) {
        int steps = 0;
        if (num == 0) {
            return steps;
        } else {
            while (num != 0) {
                if (num % 2 == 0) {
                    num = num / 2;
                } else {
                    num -= 1;
                }
                steps++;
            }
        }
        return steps;
    }

    /**
     * 1281
     * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
     */
    public int subtractProductAndSum(int n) {
        int pr = 1;
        int sum = 0;
        int i;
        while (n > 0) {
            i = n % 10;
            pr *= i;
            sum += i;
            n = n / 10;
        }
        return pr - sum;
    }

    /**
     * 1295
     * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
     */
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
