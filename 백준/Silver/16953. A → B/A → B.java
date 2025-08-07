import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int cnt = 0;
        while (a != b) {
            if (a > b) {
                System.out.println(-1);
                return;
            }
            if (b % 10 == 1) {
                b = b / 10;
            } else if (b % 2 == 0){
                b /= 2;
            } else {
                System.out.println(-1);
                return;
            }
            cnt++;
        }


        System.out.println(cnt + 1);
    }
}