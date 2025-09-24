import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        mats = Arrays.stream(mats)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

        for (int mat : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length; j++) {
                    if (park[i][j].equals("-1")) {
                        if (match(i, j, mat, park))
                            answer = Math.max(answer, mat);
                    }
                }   
            }
        }
        return answer;
    }
    
    static boolean match(int x, int y, int mat, String[][] park) {
        if (x + mat - 1 >= park.length || y + mat - 1 >= park[x].length) return false;
        for (int i = 0; i < mat; i++) {
            for (int j = 0; j < mat; j++) {
                String s = park[x + i][y + j];
                if (!s.equals("-1")) return false;
            }
        }
        return true;
    }
}