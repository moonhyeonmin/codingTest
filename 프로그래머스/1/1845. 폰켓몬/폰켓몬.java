import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = nums.length / 2;
        
        for(int num : nums) {
            set.add(num);
        }
        
        int cnt = set.size();
        return Math.min(cnt, max);
    }
}