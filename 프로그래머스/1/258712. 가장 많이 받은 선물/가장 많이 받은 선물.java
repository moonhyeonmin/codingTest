import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        int n = friends.length;
        Map<String, Integer> map = new HashMap<>();
        int[][] arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        int a, b;
        for (int i = 0;i < gifts.length; i++) {
            
            a = map.get(gifts[i].split(" ")[0]);
            b = map.get(gifts[i].split(" ")[1]);
            
            arr[a][b]++;
        }
        
        int[] point = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                point[i] += arr[i][j];
                point[j] -= arr[i][j];
            }
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][j] > arr[j][i]) res[i]++;
                else if (arr[i][j] < arr[j][i]) res[j]++;
                else {
                    if (point[i] > point[j]) res[i]++;
                    else if (point[i] < point[j]) res[j]++;
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, res[i]);
        }
        
        return max;
    }
}