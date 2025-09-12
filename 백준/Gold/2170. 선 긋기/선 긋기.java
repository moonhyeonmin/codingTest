import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static class line implements Comparable<line> {
        int x, y;

        public line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(line o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        line[] lines = new line[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i] = new line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lines);

        int res = 0;
        int min = lines[0].x;
        int max = lines[0].y;
        for (int i = 1; i < n; i++) {
            if (lines[i].x <= max) {
                max = Math.max(max, lines[i].y);
            } else {
                res += (max - min);
                min = lines[i].x;
                max = lines[i].y;
            }
        }

        res += (max - min);
        System.out.println(res);
    }
}