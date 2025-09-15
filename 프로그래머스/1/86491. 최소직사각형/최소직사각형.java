class Solution {
    public int solution(int[][] sizes) {
        int max = 0, min = 0, width = 0, height = 0, res = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            max = Math.max(sizes[i][0], sizes[i][1]);
            min = Math.min(sizes[i][0], sizes[i][1]);
            
            width = Math.max(width, max);
            height = Math.max(height, min);
        }
        
        return width * height;
    }
}