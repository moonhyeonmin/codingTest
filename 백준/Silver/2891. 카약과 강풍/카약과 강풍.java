import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[n]; // 0은 아무것도 아님, 1은 부서진, 2는 여분, 3은 부서졌는데 여분도 있음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            arr[Integer.parseInt(st.nextToken()) - 1] = 1;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken()) - 1;
            if (arr[num] == 1) {
                arr[num] = 3;
            } else {
                arr[num] = 2;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                if (i == 0) {
                    if (arr[i + 1] == 2) {
                        arr[i] = 0;
                        arr[i + 1] = 0;
                    }
                } else if (i == n - 1) {
                    if (arr[i - 1] == 2) {
                        arr[i] = 0;
                        arr[i - 1] = 0;
                    }
                } else {
                    if (arr[i - 1] == 2) {
                        arr[i] = 0;
                        arr[i - 1] = 0;
                        continue;
                    }
                    if (arr[i + 1] == 2) {
                        arr[i] = 0;
                        arr[i + 1] = 0;
                        continue;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) res++;
        }

        System.out.println(res);
    }
}