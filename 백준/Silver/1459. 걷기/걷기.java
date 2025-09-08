
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long res = 0;
        if (s >= w * 2) { // 좌 - 우 < 대각선
            res = (x + y) * w;
        } else if (s >= w){ // 좌 - 우 > 대각선
            long min = Math.min(x, y);
            long diff = Math.abs(x - y);
            res = min * s + diff * w;
        } else {
            long max = Math.max(x, y);
            long diff = Math.abs(x - y);

            if ((x + y) % 2 == 0) { // 짝수인 경우
                res = max * s;
            } else { // 홀수인 경우
                res = (max - 1) * s + w;
            }
        }

        System.out.println(res);
    }
}