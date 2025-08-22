
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> word = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            word.put(input, word.getOrDefault(input, 0) + 1);
        }


        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(",");

            for (String s : str) {
                if (word.containsKey(s) && word.get(s) > 0) {
                    n--;
                    word.remove(s);
                }
            }

            System.out.println(n);
        }


    }
}