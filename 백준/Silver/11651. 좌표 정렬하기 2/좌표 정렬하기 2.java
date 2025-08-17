import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//
//        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
//        entryList.sort((a, b) -> {
//            if (a.getValue().equals(b.getValue())) {
//                return a.getKey() - b.getKey();
//            }
//            return a.getValue() - b.getValue();
//        });
//
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<Integer, Integer> entry : entryList) {
//            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
//        }
//
//        System.out.println(sb);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}