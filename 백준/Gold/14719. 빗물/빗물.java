import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int i = 1; i < w - 1; i++) {
            int curr = arr[i];
            int leftMax = curr;
            int rightMax = curr;

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > curr) {
                    leftMax = Math.max(leftMax, arr[j]);
                }
            }

            for (int j = i + 1; j < w; j++) {
                if (arr[j] > curr) {
                    rightMax = Math.max(rightMax, arr[j]);
                }
            }

            if (Math.min(leftMax, rightMax) > curr) {
                res += (Math.min(leftMax, rightMax) - arr[i]);
            }
        }

        System.out.println(res);

    }
}