//  귀찮아 (SIB)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        if (n == 1) {
            System.out.println(0);
            return;
        }
        long allSum = 0, eachSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            allSum += arr[i];
            eachSum += (long) arr[i] * arr[i];
        }

        allSum *= allSum;

        System.out.println((allSum - eachSum) / 2);


    }
}