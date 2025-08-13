import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        List<Integer> height = new ArrayList<>();
        List<Integer> width = new ArrayList<>();

        height.add(0);
        width.add(0);
        height.add(h);
        width.add(w);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (x == 1) {
                width.add(num);
            } else {
                height.add(num);
            }
        }

        Collections.sort(height);
        Collections.sort(width);
        int maxHeight = 0;
        int maxWidth = 0;

        for (int i = 1; i < width.size(); i++) {
            maxWidth = Math.max(maxWidth, width.get(i) - width.get(i - 1));
        }

        for (int i = 1; i < height.size(); i++) {
            maxHeight = Math.max(maxHeight, height.get(i) - height.get(i - 1));
        }

        int result = maxHeight * maxWidth;
        System.out.println(result);

    }
}