
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] find = br.readLine().toCharArray();

        int res = 0, str_idx = 0, find_idx = 0, cnt = 0;
        while (str_idx < str.length && find_idx < find.length) {
            if (str[str_idx] == find[find_idx]) { // 두 글자가 같으면
                cnt++;
                find_idx++;
                if (cnt == find.length) {
                    res++;
                    cnt = 0;
                    find_idx = 0;
                }
            } else {
                if (cnt > 0) {
                    str_idx -= cnt;
                    find_idx = 0;
                    cnt = 0;
                } else {
                    find_idx = 0;
                    cnt = 0;
                }
            }

            str_idx++;
        }
        System.out.println(res);

    }
}