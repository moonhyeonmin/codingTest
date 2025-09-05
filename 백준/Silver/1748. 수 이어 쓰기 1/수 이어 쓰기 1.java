
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int res = 0;
        int num = 1;
        int divide = 10;
        for (int i = 1; i <= n; i++) {
            if (i % divide == 0) {
                num += 1;
                divide *= 10;
            }
            res += num;
        }

        System.out.println(res);
    }
}