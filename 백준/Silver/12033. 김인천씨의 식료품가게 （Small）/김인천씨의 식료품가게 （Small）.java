import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[2 * n];
            List<Integer> res = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2 * n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2 * n - 1; j >= 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (arr[j] * 0.75 == arr[k]) {
                        res.add(arr[k]);
                        arr[k] = -1;
                        break;
                    }
                }
            }

            res.sort(null);
            System.out.print("Case #" + (i + 1) + ":");
            for (int j = 0; j < res.size(); j++) {
                System.out.print(" " + res.get(j));
            }

            System.out.println();
        }
    }
}