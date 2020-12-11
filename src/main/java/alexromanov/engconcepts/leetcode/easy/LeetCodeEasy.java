package alexromanov.engconcepts.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import alexromanov.engconcepts.algorithms.array.Array;
import alexromanov.engconcepts.leetcode.easy.data.ListNode;

public class LeetCodeEasy {

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

    // 125 - https://leetcode.com/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        if (s.isEmpty() || s.isBlank()) {
            return false;
        }
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) { i++; }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) { j--; }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 1290 - https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
    public int getDecimalValue(ListNode head) {
        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(String.valueOf(head.val));
            head = head.next;
        }
        return Integer.parseInt(s.toString(), 2);
    }

    // 905 - https://leetcode.com/problems/sort-array-by-parity/
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[j] = A[i];
                j++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                res[j] = A[i];
                j++;
            }
        }
        return res;
    }

    // 1351 - https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
    public int countNegatives(int[][] grid) {
        int n = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] < 0) {
                    n++;
                }
            }
        }
        return n;
    }

    // 344 - https://leetcode.com/problems/reverse-string/
    public void reverseString(char[] s) {
        int i = 0;
        char c;
        while (i < s.length / 2) {
            c = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = c;
            i++;
        }
    }

    // 1502 - https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) != d) {
                return false;
            }
        }
        return true;
    }

    // 509 - https://leetcode.com/problems/fibonacci-number/
    public int fib(int N) {
        if (N <= 1) {
            return N;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    // 1491 - https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        int sum = salary[0];
        for (int i = 1; i < salary.length; i++) {
            if (salary[i] > max) {
                max = salary[i];
            }
            if (salary[i] < min) {
                min = salary[i];
            }
            sum += salary[i];
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }

    // 876 - https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 237 - https://leetcode.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 83 - https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = curr;
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    // 326 - https://leetcode.com/problems/power-of-three/
    public static boolean powerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }

    // 1572 - https://leetcode.com/problems/matrix-diagonal-sum/
    public static int diagonalSum(int[][] mat) {
        int len = mat.length;
        int principal = 0, secondary = 0;
        for (int i = 0; i < len; i++){
            principal += mat[i][i];
        }
        int i = 0;
        int j = len - 1;
        while (i < mat.length) {
            secondary += mat[i][j];
            i++;
            j--;
        }
        if (len % 2 != 0){
            secondary -= mat[len / 2][len / 2];
        }
        return principal + secondary;
    }

    public String freqAlphabets(String s) {
        Map<String, String> sym = new HashMap<>();
        sym.put("1", "a");
        sym.put("2", "b");
        sym.put("3", "c");
        sym.put("4", "d");
        sym.put("5", "e");
        sym.put("6", "f");
        sym.put("7", "g");
        sym.put("8", "h");
        sym.put("9", "i");
        sym.put("10#", "j");
        sym.put("11#", "k");
        sym.put("12#", "l");
        sym.put("13#", "m");
        sym.put("14#", "n");
        sym.put("15#", "o");
        sym.put("16#", "p");
        sym.put("17#", "q");
        sym.put("18#", "r");
        sym.put("19#", "s");
        sym.put("20#", "t");
        sym.put("21#", "u");
        sym.put("22#", "v");
        sym.put("23#", "w");
        sym.put("24#", "x");
        sym.put("25#", "y");
        sym.put("26#", "z");

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i != s.length()){
            if (s.substring(i, i+3).contains("#")){
                sb.append(sym.get(s.substring(i, i+3)));
                i += 3;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    // 977 - https://leetcode.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
