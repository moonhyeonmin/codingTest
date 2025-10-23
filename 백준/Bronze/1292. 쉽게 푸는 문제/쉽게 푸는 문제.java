import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[b];
        int cnt = 0, res = 0;
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= i; j++) {
                cnt++;

                if (a <= cnt && cnt <= b) {
                    res += i;
                }
            }
        }

        System.out.println(res);

    }
}