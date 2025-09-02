
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] input = new char[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            input[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken()); // -1은 반시계, 1은 시계

            rotate(num - 1, direction);
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            if (input[i][0] == '1') {
                res += (int) Math.pow(2, i);
            }
        }
        System.out.println(res);
    }

    static void rotateOne(int num, int direction) {
        /**
         * 맞닿은 부분 : 2번, 6번 인덱스
         */

        switch (direction) {
            case 1: // 시계
                char temp = input[num][7];
                for (int i = 7; i > 0; i--) {
                    // 7 -> 0, 0 -> 1, 1 -> 2 ...
                    input[num][i] = input[num][i - 1];
                }
                input[num][0] = temp;
                break;
            case -1: // 반시계
                char temp2 = input[num][0];
                for (int i = 0; i < 7; i++) {
                    // 0 -> 7, 7 -> 6, 6 -> 5 ...
                    input[num][i] = input[num][i + 1];
                }
                input[num][7] = temp2;
                break;
        }
    }

    static void rotate(int num, int direction) {
        int[] dir = new int[4];
        dir[num] = direction;

        // 왼쪽
        for (int i = num; i > 0; i--) {
            if (input[i][6] != input[i - 1][2]) {
                dir[i - 1] = dir[i] * -1;
            } else {
                break;
            }
        }

        // 오른쪽
        for (int i = num; i < 3; i++) {
            if (input[i][2] != input[i + 1][6]) {
                dir[i + 1] = dir[i] * -1;
            } else {
                break;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (dir[i] != 0) {
                rotateOne(i, dir[i]);
            }
        }
    }
}