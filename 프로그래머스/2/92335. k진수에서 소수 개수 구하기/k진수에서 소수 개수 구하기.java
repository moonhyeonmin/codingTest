import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int remain = 0;
        while (n != 0) {
            remain = n % k;
            n /= k;
            stack.push(remain);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        for (String s : sb.toString().split("0")) {
            if (s.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        for (long i = 3; i * i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}