import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        int cnt_width = 0, cnt_height = 0;

        for (int i = 0; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < n; j++) {
                if (str[i].charAt(j) == '.') {
                    flag++;
                } else {
                    if (flag >= 2) {
                        cnt_width++;
                    }
                    flag = 0;
                }
            }
            if (flag >= 2) {
                cnt_width++;
            }
        }

        for (int i = 0; i < n; i++) {
            int flag = 0;
            for (int j = 0; j < n; j++) {
                if (str[j].charAt(i) == '.') {
                    flag++;
                } else {
                    if (flag >= 2) {
                        cnt_height++;
                    }
                    flag = 0;
                }
            }
            if (flag >= 2) {
                cnt_height++;
            }
        }

        System.out.print(cnt_width + " " + cnt_height);

    }
}