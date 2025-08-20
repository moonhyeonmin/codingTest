import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (x == 1) { // 남자인 경우
                for (int j = position; j <= n; j++) {
                    if (j % position == 0) {
                        arr[j] = (arr[j] == 0) ? 1 : 0; // 0이면 1로, 1이면 0으로 토글
                    }
                }
            } else { // 여자인 경우
                int left = position - 1;
                int right = position + 1;
                while (left >= 1 && right <= n && arr[left] == arr[right]) {
                    arr[left] = (arr[left] == 0) ? 1 : 0;
                    arr[right] = (arr[right] == 0) ? 1 : 0;
                    left--;
                    right++;
                }

                arr[position] = (arr[position] == 0) ? 1 : 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]);
            if (i % 20 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }

        System.out.println(sb);

    }
}