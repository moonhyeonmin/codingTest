import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String[] str = s.split("\\.");

        for (int i = 0; i < str.length; i++) {
            String c = str[i];

            if (c.length() % 2 != 0) {
                sb = new StringBuilder("-1");
                break;
            } else if (c.length() % 4 == 0) {
                sb.append("AAAA".repeat(c.length() / 4));
            } else {
                sb.append("AAAA".repeat(c.length() / 4));
                sb.append("BB");
            }

            if (i != str.length - 1)
                sb.append(".");
        }

        String res = sb.toString();
        if (!res.equals("-1")) {
            sb.append(".".repeat(s.length() - sb.toString().length()));
        }

        System.out.println(sb);


    }
}