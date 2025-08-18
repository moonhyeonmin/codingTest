import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        if (game == 'Y') {
            System.out.println(set.size());
        } else if (game == 'F') {
            System.out.println(set.size() / 2);
        } else {
            System.out.println(set.size() / 3);
        }
    }
}