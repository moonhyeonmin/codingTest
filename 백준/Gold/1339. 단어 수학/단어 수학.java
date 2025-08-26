
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);


        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
            for (int j = 0; j < str[i].length(); j++) {
                alpha[str[i].charAt(j) - 'A'] += (int)Math.pow(10, str[i].length() - j - 1);
            }
        }

        Arrays.sort(alpha);
        int sum = 0;
        int num = 9;
        int idx = 25;

        while (alpha[idx] > 0) {
            sum += alpha[idx] * num;
            num--;
            idx--;
        }
        System.out.println(sum);
    }
}