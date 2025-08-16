import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : set) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);



    }
}