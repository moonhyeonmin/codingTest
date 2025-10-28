import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int res = 0;
        Integer[] C = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(C, Collections.reverseOrder());
        
        for (int i = 0; i < A.length; i++) {
            res += A[i] * C[i];
        }
        
        return res;
    }
}