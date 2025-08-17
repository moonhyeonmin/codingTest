import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Integer.parseInt(st.nextToken());

            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for (int j = 19; j >= 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (arr[k] > arr[j]) {
                        cnt++;
                    }
                }
            }

            System.out.println(i + 1 + " " + cnt);
        }

    }
}