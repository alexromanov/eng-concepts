package alexromanov.engconcepts.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 709 - https://leetcode.com/problems/to-lower-case/
     */
    public String toLowerCase(String str) {
        char[] orig = str.toCharArray();
        int c;
        for (int i = 0; i < orig.length; i++) {
            c = orig[i];
            if (c >= 65 & c <= 90) {
                c += 32;
                orig[i] = (char) c;
            }
        }
        return new String(orig);
    }

    /**
     * 1450 - https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        int i = 0;
        while (i < startTime.length) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                res++;
            }
            i++;
        }
        return res;
    }


    public static String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int index : indices) {
            res[index] = s.charAt(index);
        }
        return new String(res);
    }

    // 1 - https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (map.containsKey(target - e)) {
                return new int[] {map.get(target - e), i};
            } else {
                map.put(e, i);
            }
        }
        return null;
    }

    // 167 - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int a = numbers[i] + numbers[j];
            if (a > target) {
                j--;
            } else if (a < target) {
                i++;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        return null;
    }
}
