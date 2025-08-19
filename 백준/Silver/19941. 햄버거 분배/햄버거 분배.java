import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        char[] arr = line.toCharArray();

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < n && arr[j] == 'H') {
                        arr[j] = '0';
                        res++;
                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}