import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int cnt_b = 0, cnt_r = 0;
        char before = '\0';
        for (int i = 0; i < n; i++) {
            if (before != str[i]) {
                if (str[i] == 'B') {
                    cnt_b++;
                } else {
                    cnt_r++;
                }
                before = str[i];
            }
        }

        System.out.println(Math.min(cnt_b, cnt_r) + 1);
    }
}