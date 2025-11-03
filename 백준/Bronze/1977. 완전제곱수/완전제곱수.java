import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        int res = 0, min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            for (int j = 0; j <= i; j++) {
                if (Math.pow(j, 2) == i) {
                    res += i;
                    min = Math.min(min, res);
                }
            }
        }

        if (res == 0) System.out.println(-1);
        else System.out.println(res + "\n" + min);
    }
}