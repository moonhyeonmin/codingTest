import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static char[] str;
    static boolean[] visited = new boolean[10];
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        str = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            str[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            func(i, 0, i + "");
            visited[i] = false;
        }
        System.out.println(res.get(res.size() - 1));
        System.out.println(res.get(0));

    }

    static void func(int now, int cnt, String num) {
        if (cnt == n) {
            res.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if ((str[cnt] == '<' && now < i) || (str[cnt] == '>' && now > i)) {
                    visited[i] = true;
                    func(i, cnt + 1, num + i);
                    visited[i] = false;
                }
            }
        }
    }

}