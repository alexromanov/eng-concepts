package alexromanov.engconcepts.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents Interview preparation kit challenges from Hackerrank
 * @link https://www.hackerrank.com/interview/interview-preparation-kit/warmup/challenges
 */
public class WarmUpChallenges {
    public static void main(String[] args) {
    }

    public static long repeatedString(String s, long n) {
        if (s.length() == n){
            return numOfA(s);
        } else {
            long num = numOfA(s);
            long r = n % s.length();
            return (n / s.length()) * num +
                    numOfA(s.substring(0, (int) r));
        }
    }

    public static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        Map<Integer, Integer> socks = new HashMap<>();
        for (int i = 0; i < n; i++){
            if (socks.containsKey(ar[i])){
                socks.put(ar[i], socks.get(ar[i])+1);
            } else {
                socks.put(ar[i], 1);
            }
            if (socks.get(ar[i]) % 2 == 0){
                pairs++;
            }
        }
        return pairs;
    }

    private static long numOfA(String s){
        return s.chars().filter(c -> c == 'a').count();
    }
}
