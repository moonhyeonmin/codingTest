import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int count = 0;
        int res = 0;

        for (int i = 1; i <= end; i++) {
            for (int j = 1; j <= i; j++) {
                count++;

                if(start <= count && count <= end) {
                    res += i;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}