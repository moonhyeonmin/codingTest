
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] n = br.readLine().toCharArray();

        int count_0 = 0, count_1 = 0;
        for (char c : n) {
            if (c == '0') {
                count_0++;
            } else {
                count_1++;
            }
        }

        count_0 /= 2;
        count_1 /= 2;

        StringBuilder sb = new StringBuilder();
        for (char c : n) {
            if (c == '1' && count_1 > 0) {
                count_1--;
            } else {
                sb.append(c);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '0' && count_0 > 0) {
                count_0--;
            } else {
                res.append(c);
            }
        }

        System.out.println(res.reverse());


    }
}