//  부분 문자열

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            String target = st.nextToken();
            String arr = st.nextToken();

            int target_idx = 0;
            for (int j = 0; j < arr.length(); j++) {
                if (target_idx < target.length() && arr.charAt(j) == target.charAt(target_idx)) {
                    target_idx++;
                }
            }

            if (target_idx == target.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}