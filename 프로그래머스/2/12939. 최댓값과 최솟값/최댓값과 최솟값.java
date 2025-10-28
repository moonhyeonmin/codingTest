class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String c : str) {
            int num = Integer.parseInt(c);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + " " + max;
    }
}