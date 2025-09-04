
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new ArrayDeque<>();
        int time = 0, sum = 0, idx = 0;
        while (idx < n || sum > 0) {
            time++; // 시간 증가

            if (bridge.size() == w) // 맨 앞칸 뺀다
                sum -= bridge.poll();

            if (idx < n && sum + truck[idx] <= L) { // 무게 L보다 작고 w보다 적게 있음
                bridge.offer(truck[idx]);
                sum += truck[idx];
                idx++;
            } else { // 다리에 새로운 차 못들어가는 경우 (이동만 시켜야 함)
                bridge.offer(0);
            }
        }

        System.out.println(time);
    }
}