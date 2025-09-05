
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int max_idx = 0, min_idx = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.size(); j++) {
                if (max < arr.get(j)) {
                    max = arr.get(j);
                    max_idx = j;
                }
                if (min > arr.get(j)) {
                    min = arr.get(j);
                    min_idx = j;
                }
            }

            res = Math.min(max + min, res);
            arr.remove(max_idx);
            if (max_idx < min_idx)
                arr.remove(min_idx - 1);
            else
                arr.remove(min_idx);
        }

        System.out.println(res);
    }
}