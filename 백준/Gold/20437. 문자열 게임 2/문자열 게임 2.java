
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            int k = Integer.parseInt(br.readLine());
            find(line, k);
        }
    }

    static void find(String line, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        ArrayList<Integer> [] list = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < line.length(); i++) {
            list[line.charAt(i) - 'a'].add(i);
        }

        for (int i = 0; i < 26; i++) {
            if (list[i].size() < k) {
                continue;
            }

            for (int j = 0; j <= list[i].size() - k; j++) {
                int start = list[i].get(j);
                int end = list[i].get(j + k - 1);
                int length = end - start + 1;

                min = Math.min(min, length);
                max = Math.max(max, length);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min + " " + max);
        }
    }
}