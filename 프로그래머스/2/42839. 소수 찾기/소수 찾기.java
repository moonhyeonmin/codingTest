import java.util.*;

class Solution {
    
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    static int res = 0;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        char[] number = numbers.toCharArray();
        permutation(numbers, 0, 0);
        
        return res;
    }
    
    static void permutation (String numbers, int now, int depth) {
        
        if (isDecimal(now)) {
            if (!set.contains(now)) {
                set.add(now);
                res++;
            }
        }
        
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(numbers, now*10 + (numbers.charAt(i) - 48), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    static boolean isDecimal(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}