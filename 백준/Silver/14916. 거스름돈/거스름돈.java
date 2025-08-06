import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (true) {
            if (n % 5 == 0) {
                cnt += n / 5;
                System.out.println(cnt);
                break;
            } else {
                n -= 2;
                cnt++;
            }

            if (n < 0) {
                System.out.println(-1);
                break;
            }
        }
    }
}