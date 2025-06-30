//  윷놀이

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[4];
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] == 0) {
                System.out.println("D");
            } else if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && arr[3] == 1) {
                System.out.println("E");
            } else {
                int count = 0;
                for (int j = 0; j < 4; j++) {
                    if (arr[j] == 1)
                        count++;
                }
                if (count == 1) {
                    System.out.println("C");
                } else if (count == 2) {
                    System.out.println("B");
                } else {
                    System.out.println("A");
                }
            }
        }
    }
}