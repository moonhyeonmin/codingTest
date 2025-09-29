import java.util.*;

class Solution {
    static List<int[]> res = new ArrayList<>();
    
    private int getFieldIndex(String fieldName) {
        if (fieldName.equals("code")) return 0;
        if (fieldName.equals("date")) return 1;
        if (fieldName.equals("maximum")) return 2;
        if (fieldName.equals("remain")) return 3;
        return 0;
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        checkExt(data, ext, val_ext);
        int Idx = getFieldIndex(sort_by);
        
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // a[sortIndex] - b[sortIndex]는 오름차순 정렬의 기본 공식입니다.
                // 양수: a가 b보다 큼 (a를 뒤로 보냄)
                // 음수: a가 b보다 작음 (a를 앞으로 보냄)
                return a[Idx] - b[Idx];
            }
        });
        int[][] answer = res.toArray(new int[res.size()][]);
        return answer;
    }
    
    static void checkExt(int[][] data, String ext, int val_ext) {
        for (int[] d : data) {
            if (ext.equals("code")) {
                if (d[0] < val_ext) {
                    res.add(d);
                }
            } else if (ext.equals("date")) {
                if (d[1] < val_ext) {
                    res.add(d);
                }
            } else if (ext.equals("maximum")) {
                if (d[2] < val_ext) {
                    res.add(d);
                }
            } else if (ext.equals("remain")) {
                if (d[3] < val_ext) {
                    res.add(d);
                }
            }
        }
    }
}