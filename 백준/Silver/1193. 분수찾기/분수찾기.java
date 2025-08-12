import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int cnt = 0, line = 1;

        while (true) {
            if (x <= cnt + line) {

                if (line % 2 == 0) {
                    System.out.println((x - cnt) + "/" + (line - (x - cnt - 1)));
                    break;
                } else {
                    System.out.println((line - (x - cnt - 1)) + "/" + (x - cnt));
                    break;
                }
            } else {
                cnt += line;
                line++;
            }
        }


    }
}