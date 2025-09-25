class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curr = health;
        int attackIdx = 0;
        int cont = 0; // 회복 연속 성공
        
        int last = attacks[attacks.length - 1][0];
        for (int i = 1; i <= last; i++) {
            
            if (attacks[attackIdx][0] == i) { // 공격 받는 경우
                curr -= attacks[attackIdx][1];
                cont = 0;
                attackIdx++;
                
                if (curr <= 0) return -1;
            } else { // 공격 안 받는 경우
                curr += bandage[1];
                cont++;
                
                if (cont == bandage[0]) {
                    curr += bandage[2];
                    cont = 0;
                }
            }
            
            if (curr > health) {
                curr = health;
            }
        }
        return curr;
    }
}