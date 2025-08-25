
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int down = Math.round(n * 0.15f);
        int up = n - down;
        Arrays.sort(arr);

        double sum = 0;
        for (int i = down; i < up; i++) {
            sum += arr[i];
        }
        System.out.println(Math.round(sum / (n - down * 2)));
    }
}