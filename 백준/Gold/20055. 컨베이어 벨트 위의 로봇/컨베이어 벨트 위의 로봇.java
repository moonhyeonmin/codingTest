
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] robot;
    static int n, k, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[2 * n];
        robot = new boolean[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        move();
        System.out.println(res);


    }

    static void move() {

        while (true) {
            res++;

            // 한 칸 회전
            int tmp = arr[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;

            //
            for (int i = n - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false;
            robot[n - 1] = false;

            // 로봇이 한 칸 이동
            for (int i = n - 1; i > 0; i--) {
                if (!robot[i] && robot[i - 1] && arr[i] > 0) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    arr[i]--;
                    robot[n - 1] = false;
                }
            }

            // 올리는 위치에 로봇 올림
            if (arr[0] > 0) {
                robot[0] = true;
                arr[0]--;
            }

            int cnt = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (arr[i] == 0) cnt++;
            }

            if (cnt >= k) {
                return;
            }
        }

    }
}