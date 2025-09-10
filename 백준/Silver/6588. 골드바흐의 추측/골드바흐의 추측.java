import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        prime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean flag = false;
            for (int i = 3; i <= n / 2; i += 2) {
                if (isPrime[i] && isPrime[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.print(sb);
    }

    static void prime() {
        for (int i = 2; i <= MAX; i++) isPrime[i] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}