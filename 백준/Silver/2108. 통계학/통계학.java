import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[] arr = new int[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        System.out.println(Math.round(sum / n)); // 1번째 - 산술평균

        Arrays.sort(arr);
        System.out.println(arr[(n - 1) / 2]); // 2번째 - 중앙값

        int cnt = 0;
        int max = -1, flag = arr[0];
        boolean check = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (max < cnt) {
                max = cnt;
                flag = arr[i];
                check = true;
            } else if (max == cnt && check) {
                flag = arr[i];
                check = false;
            }
        }
        System.out.println(flag);

        System.out.println(arr[n - 1] - arr[0]);








    }
}