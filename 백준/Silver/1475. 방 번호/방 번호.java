import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while (n > 0) {
            int rest = n % 10;
            n /= 10;

            arr[rest]++;
        }

        int max = -1;
        int cal = (arr[6] + arr[9]) / 2 + (arr[6] + arr[9]) % 2;
        arr[6] = cal;
        arr[9] = cal;
        for (int i = 0; i <= 9; i++) {
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);
    }
}