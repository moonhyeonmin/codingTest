import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> map = new TreeMap<>();
        int cnt = 0;
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }

            map.put(line, map.getOrDefault(line, 0) + 1);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            double percentage = (value * 100.0) / cnt;
            sb.append(String.format("%s %.4f%n", key, percentage));
        }

        System.out.println(sb.toString().trim());
    }
}